package os.in.productManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import os.in.productManagement.Entity.Product;

public interface ProductRepo extends JpaRepository<Product,Long>{
        List<Product> findByNameContainingOrBrandContainingOrCategoryContaining(String key1,String key2,String key3);
}
