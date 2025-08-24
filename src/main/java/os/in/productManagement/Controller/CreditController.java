package os.in.productManagement.Controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import os.in.productManagement.Entity.Customer;
import os.in.productManagement.Entity.UdhariRecord;
import os.in.productManagement.Services.CustomerService;
import os.in.productManagement.Services.UdhariService;



@Controller
public class CreditController {

    @Autowired
    UdhariService udhariService;

    @Autowired
    CustomerService customerService;


    @RequestMapping("/viewCustomer")
    public String requestMethodName(Model model) {
        return new String();
    }
    


     @RequestMapping("/costomerCredit/{id}")
        public String requestMethodName(@PathVariable String id,Model model) {
            

          Long customerId=Long.parseLong(id);

          Customer customer=  customerService.getCustomerById(customerId);
          List<UdhariRecord> udhariList= customer.getUdhariRecords();
         
          model.addAttribute("customer", customer);
          model.addAttribute("udhariList", udhariList);

          model.addAttribute("udhariRecord", new UdhariRecord());         

          return "viewCustomer";
        }


        @RequestMapping("/costomerCredit/addRecord/{id}")
        public String requestMethodName(@ModelAttribute UdhariRecord udhariRecord,@ModelAttribute Customer customer,Model model,@PathVariable String id) {
          Long customerId=Long.parseLong(id);
          Customer customer1=  customerService.getCustomerById(customerId);

          UdhariRecord udhariRecord2=new UdhariRecord();
          udhariRecord2.setAmount(udhariRecord.getAmount());
          udhariRecord2.setProductList(udhariRecord.getProductList());
          udhariRecord2.setGivenDate(LocalDate.now());
          udhariRecord2.setCustomer(customer1);
          
          udhariService.addUdhari(udhariRecord2);


          
            return "redirect:/costomerCredit/"+id;
        }
        
}
