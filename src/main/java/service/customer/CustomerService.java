package service.customer;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService{
    private static List<Customer> customers = new ArrayList<>();
    static {
        customers.add(new Customer(0,"Hung","hungmq@gmail.com","Ninh Binh"));
        customers.add(new Customer(1,"Hung1","hungmq@gmail.com","Ninh Binh"));
        customers.add(new Customer(2,"Hung2","hungmq@gmail.com","Ninh Binh"));
        customers.add(new Customer(3,"Hung3","hungmq@gmail.com","Ninh Binh"));
        customers.add(new Customer(4,"Hung4","hungmq@gmail.com","Ninh Binh"));
    }
    @Override
    public List<Customer> showAll() {
        return customers;
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public boolean update(Customer customer) {

        return false;
    }

    @Override
    public boolean save(Customer customer, int id) {
        customers.set(id,customer);
        return false;
    }
}
