package os.in.productManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import os.in.productManagement.Entity.Customer;
import os.in.productManagement.Entity.UdhariRecord;

public interface UdhariRecordRepo extends JpaRepository<UdhariRecord,String>{

    List<UdhariRecord> findByCustomer(Customer customer);
}
