package tests;

import entities.E_TCategorieEntity;
import entities.E_TCompetenceEntity;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class Test2 {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure(new File("src/main/java/hibernate.cfg.xml"));

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            Transaction tx = null;
            E_TCategorieEntity categorieEntity;
            tx = session.beginTransaction();
            categorieEntity = new E_TCategorieEntity("dons surnaturels");

            if (categorieEntity.gettCompetencesByIdCategorie() != null) {
                categorieEntity.ajouteCompetence("magie");
                categorieEntity.ajouteCompetence("voyance");
                System.out.println("Résultat de insertion doublon " + categorieEntity.ajouteCompetence("voyance"));
                categorieEntity.ajouteCompetence("telekisesie");

            } else {

                // ancienne version
                /*ArrayList list=new ArrayList<E_TCompetenceEntity>();
                list.add(new E_TCompetenceEntity("magie",categorieEntity));
                list.add(new E_TCompetenceEntity("voyance",categorieEntity));
                list.add(new E_TCompetenceEntity("tele-kinesie",categorieEntity));

                categorieEntity.settCompetencesByIdCategorie(list);
                */
            }
            session.save(categorieEntity);
            tx.commit();
            tx = session.beginTransaction();
            session.remove(categorieEntity);
            tx.commit();
            E_TCategorieEntity categorieEntity1;
            categorieEntity1=session.find(E_TCategorieEntity.class,13);
            System.out.println(categorieEntity1);

        } finally {
            session.close();
        }
    }
}
