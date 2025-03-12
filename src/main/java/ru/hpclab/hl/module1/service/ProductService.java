package ru.hpclab.hl.module1.service;

import org.springframework.stereotype.Service;
import ru.hpclab.hl.module1.api.repository.IProductRepository;
import ru.hpclab.hl.module1.api.service.IRestFullService;
import ru.hpclab.hl.module1.model.Product;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService implements IRestFullService<Product> {
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(UUID id) {
        return productRepository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        productRepository.delete(id);
    }
}