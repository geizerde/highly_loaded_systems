package ru.hpclab.hl.module1.repository.inMemory;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.hpclab.hl.module1.api.repository.ICustomerRepository;
import ru.hpclab.hl.module1.model.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Primary
@Repository
public class InMemoryCustomerRepository
        extends AbstractInMemoryRepository<Customer>
        implements ICustomerRepository {
    private static final Map<UUID, Customer> customerStorage = new HashMap<>();

    @Override
    protected Map<UUID, Customer> getStorage() {
        return customerStorage;
    }
}

