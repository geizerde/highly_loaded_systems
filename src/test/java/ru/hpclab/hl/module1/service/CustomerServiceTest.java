package ru.hpclab.hl.module1.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.hpclab.hl.module1.api.repository.ICustomerRepository;
import ru.hpclab.hl.module1.model.Customer;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CustomerServiceTest.CustomerServiceTestConfiguration.class})
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ICustomerRepository customerRepository;

    @Test
    public void testRegisterAndGetCustomer() {
        Customer customer = new Customer(UUID.randomUUID(), "John Doe", "john@example.com", "123456789", LocalDate.now());

        Customer savedCustomer = customerService.create(customer);

        Assertions.assertEquals(customer.getFullName(), savedCustomer.getFullName());
        verify(customerRepository, times(1)).save(customer);

        List<Customer> customers = customerService.getAll();

        Assertions.assertEquals(2, customers.size());
        Assertions.assertEquals("Alice Smith", customers.get(0).getFullName());
        Assertions.assertEquals("Bob Johnson", customers.get(1).getFullName());
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    public void testFindCustomerById() {
        UUID id = UUID.randomUUID();
        Customer customer = new Customer(id, "Test User", "test@example.com", "987654321", LocalDate.now());

        when(customerRepository.findById(id)).thenReturn(customer);

        Customer foundCustomer = customerService.getById(id);
        Assertions.assertEquals("Test User", foundCustomer.getFullName());
        verify(customerRepository, times(1)).findById(id);
    }

    @Test
    public void testFindCustomerById_NotFound() {
        UUID id = UUID.randomUUID();
        when(customerRepository.findById(id)).thenThrow(new NoSuchElementException("Customer not found"));

        Assertions.assertThrows(NoSuchElementException.class, () -> customerService.getById(id));
        verify(customerRepository, times(1)).findById(id);
    }

    @Test
    public void testDeleteCustomer() {
        UUID id = UUID.randomUUID();

        customerService.delete(id);
        verify(customerRepository, times(1)).delete(id);
    }

    @Configuration
    static class CustomerServiceTestConfiguration {

        @Bean
        ICustomerRepository customerRepository() {
            ICustomerRepository customerRepository = mock(ICustomerRepository.class);

            when(customerRepository.save(any())).thenReturn(new Customer(UUID.randomUUID(), "John Doe", "john@example.com", "123456789", LocalDate.now()));

            when(customerRepository.findAll()).thenReturn(Arrays.asList(
                    new Customer(UUID.randomUUID(), "Alice Smith", "alice@example.com", "111222333", LocalDate.now()),
                    new Customer(UUID.randomUUID(), "Bob Johnson", "bob@example.com", "444555666", LocalDate.now())
            ));

            return customerRepository;
        }

        @Bean
        CustomerService customerService(ICustomerRepository customerRepository) {
            return new CustomerService(customerRepository);
        }
    }
}