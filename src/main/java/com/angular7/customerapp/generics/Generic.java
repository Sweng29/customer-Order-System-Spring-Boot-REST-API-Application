package com.angular7.customerapp.generics;

import java.util.List;

public interface Generic<T> {

    public List<T> getAll();
    public T saveOrUpdate(T entity);
    public boolean deleteById(Long id);
    public T findById(Long id);
}
