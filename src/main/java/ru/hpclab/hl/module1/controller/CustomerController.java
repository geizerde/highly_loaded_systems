package ru.hpclab.hl.module1.controller;

import org.springframework.web.bind.annotation.*;
import ru.hpclab.hl.module1.model.Customer;
import ru.hpclab.hl.module1.service.CustomerService;

import java.util.*;

@RestController
@RequestMapping("/customers")
public class CustomerController extends AbstractRestController<Customer> {
    public CustomerController(CustomerService customerService) {
        super(customerService);
    }
}