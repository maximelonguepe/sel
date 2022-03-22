package jsondao;

import dao.Dao;

import java.util.List;

public abstract class JsonDao<T> implements Dao<T> {

    public JsonDao() {
    }

    @Override
    public boolean create(T obj) {
        return false;
    }

    @Override
    public T find(Integer id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public boolean update(T obj) {
        return false;
    }

    @Override
    public boolean delete(T obj) {
        return false;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public void close() {

    }
}
