package ru.hpclab.hl.module1.controller;

import org.springframework.web.bind.annotation.*;
import ru.hpclab.hl.module1.api.service.IRestFullService;

import java.util.List;
import java.util.UUID;

public abstract class AbstractRestController<T> {
    protected final IRestFullService<T> service;

    protected AbstractRestController(IRestFullService<T> service) {
        this.service = service;
    }

    @PostMapping
    public T create(@RequestBody T entity) {
        return service.create(entity);
    }

    @GetMapping
    public List<T> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public T update(@PathVariable UUID id, @RequestBody T entity) {
        return service.update(id, entity);
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @DeleteMapping("/clear")
    public void clear() {
        service.clear();
    }
}
