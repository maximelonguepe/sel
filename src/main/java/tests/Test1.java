package tests;

import entities.E_TCategorieEntity;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;
import java.io.File;
import java.io.Serializable;
import java.util.Map;

public class Test1 {
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

            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            categorieEntity = session.get(E_TCategorieEntity.class, 13);
            System.out.println(categorieEntity);
            E_TCategorieEntity categorieEntity2 = new E_TCategorieEntity("tutu");
            Serializable numeroInsertion;
            System.out.println("insertion nouvelle categorie tutu");
            numeroInsertion = session.save(categorieEntity2);
            tx.commit();
            System.out.println("recherche de la categorie créée");
            categorieEntity = session.get(E_TCategorieEntity.class, numeroInsertion);
            System.out.println(categorieEntity);
            tx = session.beginTransaction();

            System.out.println("suppression de la categorie créee");
            session.remove(categorieEntity);
            tx.commit();


        } finally {
            session.close();
        }
    }
}