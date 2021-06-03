package com.expleo.hello.jdbc.dao;

import java.util.List;

public interface Idao<T> {

    public List<T> findAll();

    public T findById(int id);

    public boolean removeById(int id);

    public int create(T newObj);

    public boolean update(T modObj);
}
