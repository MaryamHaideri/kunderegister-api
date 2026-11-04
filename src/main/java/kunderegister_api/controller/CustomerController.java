package kunderegister_api.controller;

import kunderegister_api.model.Customer;
import kunderegister_api.service.CustomerService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // GET /api/customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // GET /api/customers/1
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {

        if (id <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Kunde-ID må være større enn 0"
            );
        }

        return customerService.getCustomerById(id);
    }

    // legger til kunder
    @PostMapping
    public Customer addCustomer(@Valid @RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    // GET /api/customers/search?name=Ola
    @GetMapping("/search")
    public List<Customer> findCustomersByName(@RequestParam String name) {

        if (name == null || name.isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Søkenavnet kan ikke være tomt"
            );
        }

        return customerService.findCustomersByName(name.trim());
    }

    // DELETE /api/customers/1
    @DeleteMapping("/{id}")
    public boolean deleteCustomer(@PathVariable int id) {

        if (id <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Kunde-ID må være større enn 0"
            );
        }

        return customerService.deleteCustomer(id);
    }
}
