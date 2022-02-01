package tests;

import entities.*;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import javax.persistence.metamodel.EntityType;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Test4 {
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

            //test insertion pro
            tx = session.beginTransaction();
            E_TProEntity e_tProEntity = new E_TProEntity("TestinsertionPro", "Max", "max@test.com", "V", "000");
            Serializable id = session.save(e_tProEntity);
            tx.commit();

            //suppression pro
            tx = session.beginTransaction();
            session.remove(e_tProEntity);
            tx.commit();

            // on recupere un pro
            E_TMembreEntity e_tProEntity1 = session.find(E_TMembreEntity.class, 244);
            // System.out.println(e_tProEntity1);

            //on crée un particulier
            tx = session.beginTransaction();
            E_TPrtEntity e_tPrtEntity = new E_TPrtEntity("TestinsertionPro", "Max", "max@test.com", "V", true);
            session.save(e_tPrtEntity);
            tx.commit();

            //on supprime particulier
            tx = session.beginTransaction();
            session.remove(e_tPrtEntity);
            tx.commit();

            //on créé un nouveau vacancier
            tx = session.beginTransaction();
            E_TVacEntity e_tVacEntity = new E_TVacEntity("TestinsertionPro", "Max", "max@test.com", "V", "Caravane");
            session.save(e_tVacEntity);
            tx.commit();


            //suppression
            tx = session.beginTransaction();
            session.remove(e_tVacEntity);
            tx.commit();
            System.out.println(e_tVacEntity);


            Query query = session.createNamedQuery("Find_cotisation_user");
            List<E_TCotisationsEntity> e_tMembreEntities = new ArrayList<E_TCotisationsEntity>();
            query.setParameter(1,"Lash");
            query.setParameter(2,"Max");
            e_tMembreEntities =  query.getResultList();
            System.out.println("a");

        } finally {
            session.close();
        }
    }
}
