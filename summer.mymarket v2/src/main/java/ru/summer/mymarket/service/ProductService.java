package ru.summer.mymarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.summer.mymarket.model.Product;
import ru.summer.mymarket.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product findById(int id){
       return productRepository.findById(id);
    }

    public void addToProductList(Product product){
        productRepository.addToProductList(product);
    }

    public List<Product> getProductList(){
        return productRepository.getProductList();
    }

    public Product removeProductFromList(int index){
        return productRepository.removeProductFromList(index);
    }

}
