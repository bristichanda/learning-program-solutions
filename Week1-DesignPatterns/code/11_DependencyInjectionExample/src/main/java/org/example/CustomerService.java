package org.example;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void printCustomerDetails(String customerId) {
        Customer customer = customerRepository.findCustomerById(customerId);
        if (customer != null) {
            System.out.println("Customer Found:");
            System.out.println("ID   : " + customer.getId());
            System.out.println("Name : " + customer.getName());
        } else {
            System.out.println("Customer with ID " + customerId + " not found.");
        }
    }
}
