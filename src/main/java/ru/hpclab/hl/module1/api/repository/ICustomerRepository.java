package ru.hpclab.hl.module1.api.repository;

import org.springframework.stereotype.Repository;
import ru.hpclab.hl.module1.model.Customer;

import java.util.List;
import java.util.UUID;

@Repository
public interface ICustomerRepository extends IRestFullRepository<Customer> {}