package dao;

import entities.E_TCategorieEntity;
import entities.E_TCompetenceEntity;

public class DaoFactoryJpa extends DaoFactory {


    @Override
    public E_TCategorieEntity getDaoCategorie() {
        return null;
    }

    @Override
    public E_TCompetenceEntity getDaoCompetence() {
        return null;
    }
}
