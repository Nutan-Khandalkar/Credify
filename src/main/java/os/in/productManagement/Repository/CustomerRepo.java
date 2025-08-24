package os.in.productManagement.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import os.in.productManagement.Entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long>{
        
    Customer findByCustomername(String name);

    List<Customer> findByCustomernameContainingOrPhoneNoContaining(String key1,String key2);

}
