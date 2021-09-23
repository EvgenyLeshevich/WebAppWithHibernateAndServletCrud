package com.evgeniy.web.crud.hibernate.services;

import java.io.Serializable;
import java.util.List;

public interface Services <T, Id extends Serializable>{
    public void add(T entity);

    public void update(T entity);

    public T searchById(Id id);

    public void deleteById(Id id);

    public List<T> searchAll();

    public void deleteAll();
}
