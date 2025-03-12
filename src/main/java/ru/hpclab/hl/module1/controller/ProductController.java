package ru.hpclab.hl.module1.controller;

import org.springframework.web.bind.annotation.*;
import ru.hpclab.hl.module1.model.Product;
import ru.hpclab.hl.module1.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController extends AbstractRestController<Product> {
    public ProductController(ProductService productService) {
        super(productService);
    }
}
