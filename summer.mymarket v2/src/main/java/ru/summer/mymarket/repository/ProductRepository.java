package ru.summer.mymarket.repository;

import org.springframework.stereotype.Component;
import ru.summer.mymarket.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> productList;

      @PostConstruct
    public void init() {
        productList = new ArrayList<>();

    }


    public void addToProductList(Product product){
        productList.add(product);
    }

    public Product removeProductFromList(int index){
        productList.remove(index);
        return productList.get(index);
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    public Product findById(int id){
        for (Product product: productList) {
            if(product.getId()==id){
                return product;
            }
        }
        throw new RuntimeException("Product not found");
    }
}