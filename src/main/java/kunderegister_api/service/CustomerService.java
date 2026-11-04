package kunderegister_api.service;

import kunderegister_api.model.Customer;
import org.springframework.stereotype.Service;
import kunderegister_api.exception.CustomerNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final List<Customer> customers = new ArrayList<>();
    private int nextId = 1;

    // Hent alle kunder
    public List<Customer> getAllCustomers() {
        return customers;
    }

    // Finn kunde etter ID
    public Customer getCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }

        throw new CustomerNotFoundException(
                "Kunde med ID " + id + " ble ikke funnet"
        );
    }

    // Legg til ny kunde
    public Customer addCustomer(Customer customer) {

        customer.setId(nextId);
        nextId++;

        customers.add(customer);

        return customer;
    }

    // Finn kunder etter navn
    public List<Customer> findCustomersByName(String name) {

        List<Customer> result = new ArrayList<>();

        for (Customer customer : customers) {
            if (customer.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(customer);
            }
        }

        return result;
    }

    // Slett kunde
    public boolean deleteCustomer(int id) {
        Customer customer = getCustomerById(id);
        customers.remove(customer);
        return true;
    }
}