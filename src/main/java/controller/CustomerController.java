package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.customer.ICustomerService;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/home")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("home");
        List<Customer> customers = customerService.showAll();
        modelAndView.addObject("list", customers);
        return modelAndView;
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("update");
        Customer customer = customerService.findById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public ModelAndView editCustomer(@PathVariable int id, @RequestParam String name, String email, String address){
        Customer customer = new Customer(id, name, email, address);
        customerService.save(customer,id);
//        ModelAndView modelAndView = new ModelAndView("redirect:/customers/home");
//        return modelAndView;
        return showList();
    }

}
