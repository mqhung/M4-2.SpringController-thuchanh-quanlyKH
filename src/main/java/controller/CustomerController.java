package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.customer.ICustomerService;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;


    @GetMapping("")
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("home");
        List<Customer> list = customerService.showAll();
        modelAndView.addObject("customersList", list);
        return modelAndView;
    }

    //create
    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Customer customer) {
        int id = (int) (Math.random() * 10000);
        customer.setId(id);
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("create", "customer", new Customer());
        modelAndView.addObject("mess", "Create Successful Customer" + customer.getName());
        return modelAndView;
    }

    //edit
    @GetMapping("/edit")
    public ModelAndView showFormEdit(@RequestParam Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Customer customer = customerService.findById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("edit")
    public ModelAndView edit(@RequestParam Integer id, @ModelAttribute Customer customer) {
        customer.setId(id);
        customerService.update(id, customer);
        return new ModelAndView("redirect:/customers");
    }

    //delete
    @GetMapping("/delete")
    public ModelAndView showFormDelete(@RequestParam Integer id) {
        customerService.remove(id);
        return new ModelAndView("redirect:/customers");
    }

    //detail
    @GetMapping("/view")
    public String view(@RequestParam Integer id, ModelMap modelMap) {
        modelMap.addAttribute("customer", customerService.findById(id));
        return "/view";
    }
}
