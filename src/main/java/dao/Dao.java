package dao;

import java.util.List;

public interface Dao<T>{
    public boolean create(T obj) ;
    public T find (Integer id) ;
    public List<T> findAll();
    public boolean update (T obj) ;
    public boolean delete (T obj) ;
    public boolean deleteAll() ;
    public void close(); /* qui permet de fermer la connexion à la base de données ou le fichier. */
}
