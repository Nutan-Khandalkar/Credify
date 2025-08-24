package os.in.productManagement.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import os.in.productManagement.Entity.Customer;


@Service
public interface CustomerService {

        public void addCustomer(Customer customer);

        List<Customer> getAllCustomer();

        Customer getCustomerById(Long id);

        void deleteCostomerById(Long id);

        List<Customer> searchCustomer(String key);

}
