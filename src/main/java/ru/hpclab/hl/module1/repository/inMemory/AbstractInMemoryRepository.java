package ru.hpclab.hl.module1.repository.inMemory;

import java.util.*;

abstract class AbstractInMemoryRepository<T> {
    protected abstract Map<UUID, T> getStorage();

    public List<T> findAll() {
        return new ArrayList<>(getStorage().values());
    }

    public T findById(UUID id) {
        if (!getStorage().containsKey(id)) {
            throw new NoSuchElementException("Entity not found: " + id);
        }
        return getStorage().get(id);
    }

    public void delete(UUID id) {
        if (getStorage().remove(id) == null) {
            throw new NoSuchElementException("Entity not found: " + id);
        }
    }

    public T save(T entity) {
        UUID id = UUID.randomUUID();
        try {
            var field = entity.getClass().getDeclaredField("id");
            field.setAccessible(true);
            field.set(entity, id);
        } catch (Exception e) {
            throw new RuntimeException("Unable to set ID", e);
        }
        getStorage().put(id, entity);
        return entity;
    }

    public T update(T entity) {
        try {
            var field = entity.getClass().getDeclaredField("id");
            field.setAccessible(true);
            UUID id = (UUID) field.get(entity);
            if (!getStorage().containsKey(id)) {
                throw new NoSuchElementException("Entity not found: " + id);
            }
            getStorage().put(id, entity);
            return entity;
        } catch (Exception e) {
            throw new RuntimeException("Unable to update entity", e);
        }
    }

    public void clear() {
        getStorage().clear();
    }
}
