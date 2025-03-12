package ru.hpclab.hl.module1.api.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IRestFullRepository<T>  {
    List<T> findAll();
    T findById(UUID id);
    void delete(UUID id);
    T save(T entity);
    T update(T entity);
    void clear();
}
