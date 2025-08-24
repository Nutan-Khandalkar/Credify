package os.in.productManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import os.in.productManagement.Entity.Product;
import os.in.productManagement.Forms.ProductForm;
import os.in.productManagement.Forms.ProductSearchForm;
import os.in.productManagement.Services.ProductService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;







@Controller
public class productController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/productList")
    public String getProductList(Model model ) {

        List<Product> productList=productService.getAllProduct();

        model.addAttribute("productList", productList);

        model.addAttribute("productForm", new ProductForm());
        model.addAttribute("productSearchForm", new ProductSearchForm());
        return "productList";
    }
    
    @RequestMapping("/product/delete/{id}")
    public String requestMethodName(@PathVariable String id) {

        Long productId=Long.parseLong(id);

        productService.deleteProduct(productId);

        return "redirect:/productList";
    }
    


    @PostMapping("/product/add")
    public String postMethodName(@ModelAttribute ProductForm productForm) {
        
        Product productEntity=new Product();
        
        productEntity.setName(productForm.getName());
        productEntity.setBrand(productForm.getBrand());
        productEntity.setPrice(productForm.getPrice());
        productEntity.setDiscription(productForm.getDiscription());
        productEntity.setCategory(productForm.getCategory());
        productEntity.setQuntity(productForm.getQuntity());
        productEntity.setUnit(productForm.getUnit());

        productService.addProduct(productEntity);
        return "redirect:/productList";
    }
    

    @RequestMapping("/product/search")
    public String getSearchContact(@ModelAttribute ProductSearchForm productSearchForm ,Model model) {


        List<Product> productList=productService.searchProduct(productSearchForm.getKey());

        model.addAttribute("productList", productList);
        model.addAttribute("productForm", new ProductForm());
        model.addAttribute("productSearchForm", productSearchForm);
        return "productList";
    }


    @RequestMapping("/product/view/{id}")
    public String viewProduct(@PathVariable String id,Model model) {

        Long productId=Long.parseLong(id);
        var productEntity=productService.getProductById(productId);
        ProductForm productForm=new ProductForm();
        productForm.setProductId(productEntity.getId());
        productForm.setName(productEntity.getName());
        productForm.setBrand(productEntity.getBrand());
        productForm.setCategory(productEntity.getCategory());
        productForm.setPrice(productEntity.getPrice());
        productForm.setQuntity(productEntity.getQuntity());
        productForm.setDiscription(productEntity.getDiscription());

        model.addAttribute("productForm", productForm);        

        return new String();
    }
    

    @RequestMapping("/product/update/{id}")
    public String updateProductDetails(@ModelAttribute ProductForm productForm,Model model,@PathVariable String id) {
        

        Product productEntity=new Product();
        Long productId=Long.parseLong(id);
        productEntity.setId(productId);
        productEntity.setName(productForm.getName());
        productEntity.setBrand(productForm.getBrand());
        productEntity.setPrice(productForm.getPrice());
        productEntity.setDiscription(productForm.getDiscription());
        productEntity.setCategory(productForm.getCategory());
        productEntity.setQuntity(productForm.getQuntity());
        productEntity.setUnit(productForm.getUnit());
        
        productService.updateProduct(productEntity);

        
        return "redirect:/productList";
    }
    
    
}
