package os.in.productManagement.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import os.in.productManagement.Entity.Customer;
import os.in.productManagement.Entity.UdhariRecord;

@Service
public interface UdhariService {
                List<UdhariRecord> getAllRecord(Customer customer);
                
                public void addUdhari(UdhariRecord udhariRecord);


}
