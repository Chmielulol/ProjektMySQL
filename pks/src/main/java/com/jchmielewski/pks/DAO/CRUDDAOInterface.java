package com.jchmielewski.pks.DAO;

import java.util.List;

public interface CRUDDAOInterface <Type> {

    public Type getById(int id);
    public List<Type> getAll();
    public void saveOrUpdate(Type type);
    public void delete(int id);
}
