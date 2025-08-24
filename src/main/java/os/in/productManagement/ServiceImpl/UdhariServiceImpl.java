package os.in.productManagement.ServiceImpl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import os.in.productManagement.Entity.Customer;
import os.in.productManagement.Entity.UdhariRecord;
import os.in.productManagement.Repository.CustomerRepo;
import os.in.productManagement.Repository.UdhariRecordRepo;
import os.in.productManagement.Services.UdhariService;

@Service
public class UdhariServiceImpl implements UdhariService{

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    UdhariRecordRepo udhariRecordRepo;

     @Override
    public List<UdhariRecord> getAllRecord(Customer customer) {
      
      return udhariRecordRepo.findByCustomer(customer);
      
    }

     @Override
     public void addUdhari(UdhariRecord udhariRecord) {
     
      udhariRecordRepo.save(udhariRecord);

     }

    
}
