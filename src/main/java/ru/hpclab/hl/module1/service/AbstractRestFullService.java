package ru.hpclab.hl.module1.service;

import ru.hpclab.hl.module1.api.repository.IRestFullRepository;
import ru.hpclab.hl.module1.api.service.IRestFullService;

import java.util.List;
import java.util.UUID;

public abstract class AbstractRestFullService<T> implements IRestFullService<T> {
    protected final IRestFullRepository<T> repository;

    public AbstractRestFullService(IRestFullRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public T create(T entity) {
        return repository.save(entity);
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public T getById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        repository.delete(id);
    }

    @Override
    public T update(UUID id, T updatedEntity) {
        return repository.update(updatedEntity);
    }

    @Override
    public void clear() {
        repository.clear();
    }
}

