package jpadao;

import dao.DaoCategorie;
import entities.E_TCategorieEntity;
import entities.E_TCompetenceEntity;

public class JpaDaoCategorie extends JpaDao<E_TCategorieEntity> implements DaoCategorie {
    @Override
    public int nombreDeCompetences(E_TCompetenceEntity e_tCompetenceEntity) {
        return 0;
    }


}
