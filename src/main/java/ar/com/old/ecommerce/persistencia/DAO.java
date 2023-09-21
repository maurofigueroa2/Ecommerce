package ar.com.old.ecommerce.persistencia;

import java.util.List;

public interface DAO<T> {

    void create(T object);
    T getOneById(Long id);
    List<T> getAll();
    void update(T object);
    void deleteById(Long id);
    void close();

}
