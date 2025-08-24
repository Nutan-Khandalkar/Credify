package os.in.productManagement.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "customer")
public class UdhariRecord {

    @Id()
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private double amount;
    private double paid=0;
    private double remain=0;
    private LocalDate givenDate;
    List<String> productList=new ArrayList<>();
   
    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
}
