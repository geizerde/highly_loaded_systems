package ru.hpclab.hl.module1.service;

import org.springframework.stereotype.Service;
import ru.hpclab.hl.module1.api.repository.ICustomerRepository;
import ru.hpclab.hl.module1.model.Customer;

@Service
public class CustomerService extends AbstractRestFullService<Customer> {
    public CustomerService(ICustomerRepository customerRepository) {
        super(customerRepository);
    }
}
