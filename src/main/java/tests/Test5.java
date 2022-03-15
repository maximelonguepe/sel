package tests;

import dao.DaoCategorie;
import entities.E_TCategorieEntity;
import jpadao.JpaDaoCategorie;

public class Test5 {



    public static void main(String[] args) {
        try
        {

            DaoCategorie categorieManager = new JpaDaoCategorie();
            E_TCategorieEntity maCategorie = new E_TCategorieEntity("Cours d'informatique");
            categorieManager.create(maCategorie);
            maCategorie.setCategorie("Cours de Geek");
            categorieManager.update(maCategorie);


            DaoCategorie categorieManager2 = new JpaDaoCategorie();
            categorieManager2.create(maCategorie);
            categorieManager.create(maCategorie);
            System.out.println(categorieManager.findAll().size());
            System.out.println(categorieManager2.findAll().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
