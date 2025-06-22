package org.example;


import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {

    private final Map<String, Customer> customerDB = new HashMap<>();

    public CustomerRepositoryImpl() {
        customerDB.put("C001", new Customer("C001", "Alice"));
        customerDB.put("C002", new Customer("C002", "Bob"));
    }

    @Override
    public Customer findCustomerById(String id) {
        return customerDB.get(id);
    }
}
