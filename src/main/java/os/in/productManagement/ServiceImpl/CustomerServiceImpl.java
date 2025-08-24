package os.in.productManagement.ServiceImpl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import os.in.productManagement.Entity.Customer;
import os.in.productManagement.Repository.CustomerRepo;
import os.in.productManagement.Services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepo customerRepo;

  
    
    @Override
    public void addCustomer(Customer customer) {
       
       customerRepo.save(customer);

    }

   

    @Override
    public List<Customer> getAllCustomer() {
      
        List<Customer> customers= customerRepo.findAll();

      return customers;
    }



    @Override
    public Customer getCustomerById(Long id) {
     
      return customerRepo.findById(id).orElseThrow();
    }



    @Override
    public void deleteCostomerById(Long id) {
     
      customerRepo.deleteById(id);
    }



    @Override
    public List<Customer> searchCustomer(String key) {
     
      return customerRepo.findByCustomernameContainingOrPhoneNoContaining(key, key);
    }

   
    
    
}
