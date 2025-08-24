package os.in.productManagement.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import os.in.productManagement.Entity.Product;

@Service
public interface ProductService {
        Product addProduct(Product productEntity);

        List<Product> getAllProduct();

        void deleteProduct(Long id);

        List<Product> searchProduct(String key);

        Product updateProduct(Product productEntity);

        Product getProductById(Long id);
}
