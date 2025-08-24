package os.in.productManagement.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import os.in.productManagement.Entity.Product;
import os.in.productManagement.Repository.ProductRepo;
import os.in.productManagement.Services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product addProduct(Product productEntity) {
       
        return productRepo.save(productEntity);
    }

    @Override
    public List<Product> getAllProduct() {
       return productRepo.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        var product=productRepo.findById(id).orElseThrow();

        productRepo.delete(product);

    }

    @Override
    public List<Product> searchProduct(String key) {
       return productRepo.findByNameContainingOrBrandContainingOrCategoryContaining(key, key, key);
    }

    @Override
    public Product updateProduct(Product productEntity) {
       var oldProduct=productRepo.findById(productEntity.getId()).orElseThrow();

        oldProduct.setName(productEntity.getName());
        oldProduct.setBrand(productEntity.getBrand());
        oldProduct.setCategory(productEntity.getCategory());
        oldProduct.setDiscription(productEntity.getDiscription());
        oldProduct.setQuntity(productEntity.getQuntity());
        oldProduct.setUnit(productEntity.getUnit());
        oldProduct.setPrice(productEntity.getPrice());

        return productRepo.save(oldProduct);

    }

    @Override
    public Product getProductById(Long id) {
    
        return productRepo.findById(id).orElseThrow();
    }

    

}
