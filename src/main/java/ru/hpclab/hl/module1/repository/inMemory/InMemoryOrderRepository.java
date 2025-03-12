package ru.hpclab.hl.module1.repository.inMemory;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.hpclab.hl.module1.api.repository.IOrderRepository;
import ru.hpclab.hl.module1.model.order.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Primary
@Repository
public class InMemoryOrderRepository extends AbstractInMemoryRepository<Order>
        implements IOrderRepository {
    private static final Map<UUID, Order> orderStorage = new HashMap<>();

    @Override
    protected Map<UUID, Order> getStorage() {
        return orderStorage;
    }
}
