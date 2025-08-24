package os.in.productManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import os.in.productManagement.Entity.Customer;
import os.in.productManagement.Forms.CustomerForm;
import os.in.productManagement.Forms.CustumerSearch;
import os.in.productManagement.Services.CustomerService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customer")
    public String customerPage(Model model) {

         List<Customer> customerList=customerService.getAllCustomer();

        model.addAttribute("customerList", customerList);
        model.addAttribute("customerForm", new CustomerForm());
        model.addAttribute("customerSearch", new CustumerSearch());

        return "customer";
    }
    


    @RequestMapping("/customer/add")
    public String requestMethodName(@ModelAttribute CustomerForm customerForm) {
       
        Customer customer=new Customer();
        customer.setCustomername(customerForm.getCustomername());
        customer.setAddress(customerForm.getAddress());
        customer.setPhoneNo(customerForm.getPhoneNo());

        customerService.addCustomer(customer);

        return "redirect:/customer";
    }
    
    
      @RequestMapping("/customer/delete/{id}")
      public String deleteAcount(@PathVariable String id){
        Long customerId=Long.parseLong(id);

        customerService.deleteCostomerById(customerId);

        return "redirect:/customer";
      }   

      @RequestMapping("/customer/search")
      public String requestMethodName(@ModelAttribute CustumerSearch customerSearch,Model model) {
       List<Customer> customerList= customerService.searchCustomer(customerSearch.getKey());
       model.addAttribute("customerList", customerList);
       model.addAttribute("customerForm", new CustomerForm());
        model.addAttribute("customerSearch", new CustumerSearch());

          return "customer";
      }
      
}
