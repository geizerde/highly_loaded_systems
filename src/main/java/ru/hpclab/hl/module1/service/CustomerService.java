package ru.hpclab.hl.module1.service;

import org.springframework.stereotype.Service;
import ru.hpclab.hl.module1.api.repository.ICustomerRepository;
import ru.hpclab.hl.module1.api.service.IRestFullService;
import ru.hpclab.hl.module1.model.Customer;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService implements IRestFullService<Customer> {
    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(UUID id) {
        return customerRepository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        customerRepository.delete(id);
    }

    @Override
    public Customer update(UUID id, Customer updatedCustomer) {
        Customer existingCustomer = getById(id);
        updatedCustomer.setId(existingCustomer.getId());
        return customerRepository.update(updatedCustomer);
    }

    @Override
    public void clear() {
        customerRepository.clear();
    }
}
