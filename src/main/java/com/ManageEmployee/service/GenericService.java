package com.ManageEmployee.service;

import java.util.ArrayList;
import java.util.List;

public interface GenericService<T> {
    List<T> findAll();
    T findById(Integer id);
    void deleteById(Integer id);
    T save(T t);
    T update(T t);
}
