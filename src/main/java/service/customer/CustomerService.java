package service.customer;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private static Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "Hung", "hungmq@gmail.com", "Ninh Binh"));
        customers.put(2, new Customer(2, "Hung1", "hungmq@gmail.com", "Ninh Binh"));
        customers.put(3, new Customer(3, "Hung2", "hungmq@gmail.com", "Ninh Binh"));
        customers.put(4, new Customer(4, "Hung3", "hungmq@gmail.com", "Ninh Binh"));
        customers.put(5, new Customer(5, "Hung4", "hungmq@gmail.com", "Ninh Binh"));
    }

    @Override
    public List<Customer> showAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id, customer);
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
