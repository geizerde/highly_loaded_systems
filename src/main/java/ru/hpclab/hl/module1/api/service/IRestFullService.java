package ru.hpclab.hl.module1.api.service;

import java.util.List;
import java.util.UUID;

public interface IRestFullService<T> {
    T create(T entity);
    List<T> getAll();
    T getById(UUID id);
    void delete(UUID id);
}