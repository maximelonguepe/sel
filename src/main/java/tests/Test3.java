package tests;

import entities.E_TCategorieEntity;
import entities.E_TCompetenceEntity;
import entities.E_TExCascadeFkEntity;
import entities.E_TExCascadeRefEntity;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class Test3 {
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
            // test insertion dans la base
            /*
            Transaction tx = null;
            tx = session.beginTransaction();
            E_TExCascadeRefEntity tExCascadeRefEntity;
            tExCascadeRefEntity=new E_TExCascadeRefEntity("toto");
            E_TExCascadeFkEntity e_tExCascadeFkEntity = new E_TExCascadeFkEntity("aa",tExCascadeRefEntity);
            tExCascadeRefEntity.ajouteFK(e_tExCascadeFkEntity);
            Serializable id=session.save(tExCascadeRefEntity);
            //tx.commit();*/

            // test refresh
            /*Transaction tx = null;
            tx = session.beginTransaction();
            E_TExCascadeFkEntity e_tExCascadeFkEntity = session.get(E_TExCascadeFkEntity.class, 1);
            tx.commit();
            tx = session.beginTransaction();
            session.refresh(e_tExCascadeFkEntity);
            System.out.println(e_tExCascadeFkEntity);
            */


            //test delete ref
            /*
            Transaction tx = null;
            tx = session.beginTransaction();
            E_TExCascadeRefEntity ref;
            ref=session.get(E_TExCascadeRefEntity.class,2);
            session.remove(ref);
            tx.commit();
            */

            //test delete fk
            Transaction tx = null;
            tx = session.beginTransaction();
            E_TExCascadeFkEntity fk;
            fk=session.get(E_TExCascadeFkEntity.class,21);
            session.remove(fk);
            tx.commit();



        } finally {
            session.close();
        }
    }
}
