
package com.confrenseroom.dboa;

import java.util.List;

/**
 *
 * @author MCDAVE MAKHUBELE
 * @param <T>
 */
public interface CRUD<T> {
     boolean create(T t);
    T read(String name);
    T update(String name);
    boolean delete(String name);
    List<T> list();
}
