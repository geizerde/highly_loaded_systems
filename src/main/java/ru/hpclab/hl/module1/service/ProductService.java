package ru.hpclab.hl.module1.service;

import org.springframework.stereotype.Service;
import ru.hpclab.hl.module1.api.repository.IProductRepository;
import ru.hpclab.hl.module1.model.Product;

@Service
public class ProductService extends AbstractRestFullService<Product> {
    public ProductService(IProductRepository productRepository) {
        super(productRepository);
    }
}

