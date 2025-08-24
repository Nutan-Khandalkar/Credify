package os.in.productManagement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;


@Entity
@Data
@ToString
public class User {

    @Id
    private Long id;
    private String name;
    private String password;
}
