package com.confrenseroom.service;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author MCDAVE MAKHUBELE
 * @param <T>
 */
public interface CRUDService<T> {
    boolean create(T t);
    T readById(T t);
    boolean update(T t);
    boolean delete(T t);
    List<T> getAll();
    LinkedList<T> getlist();
}
