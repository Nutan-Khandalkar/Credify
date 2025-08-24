package os.in.productManagement.Forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductForm {

            private Long productId;
            private String name;
            private String price;
            private String brand;
            private String quntity;
            private String unit;
            private String category;
            private String discription;
}
