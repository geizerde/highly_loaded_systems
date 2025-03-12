package ru.hpclab.hl.module1.controller;

import org.springframework.web.bind.annotation.*;
import ru.hpclab.hl.module1.api.model.Identifiable;
import ru.hpclab.hl.module1.api.service.IRestFullService;

import java.util.List;

public abstract class AbstractRestController<T extends Identifiable> {
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
    public T update(@PathVariable Long id, @RequestBody T entity) {
        return service.update(id, entity);
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @DeleteMapping("/clear")
    public void clear() {
        service.clear();
    }
}
