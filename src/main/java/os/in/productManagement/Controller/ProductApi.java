package os.in.productManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import os.in.productManagement.Entity.Product;
import os.in.productManagement.Services.ProductService;



@RequestMapping("/api")
@RestController
public class ProductApi {

        @Autowired
        private ProductService productService;

        @RequestMapping("/view/{id}")
        public Product requestMethodName(@PathVariable String id) {
            Long productId=Long.parseLong(id);

            return productService.getProductById(productId);
        }
        

}
