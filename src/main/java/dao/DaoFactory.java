package dao;

import entities.E_TCategorieEntity;
import entities.E_TCompetenceEntity;
import enums.PersistenceType;

public abstract class DaoFactory {
    public abstract E_TCategorieEntity getDaoCategorie();
    public abstract E_TCompetenceEntity getDaoCompetence();
    public static DaoFactory getDaoFactory(PersistenceType type){
        DaoFactoryJpa dao;
        if(type.equals(PersistenceType.JPA)){
            dao=new DaoFactoryJpa();
            return dao;
        }
        else if (type.equals(PersistenceType.JSON)){

        }
        return null;
    }


}
