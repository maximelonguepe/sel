package dao;

import entities.E_TCategorieEntity;
import entities.E_TCompetenceEntity;

public interface DaoCategorie extends Dao<E_TCategorieEntity> {
    int nombreDeCompetences(E_TCompetenceEntity e_tCompetenceEntity);


}
