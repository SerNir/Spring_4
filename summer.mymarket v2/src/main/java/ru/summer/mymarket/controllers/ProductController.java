package ru.summer.mymarket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.summer.mymarket.model.Product;
import ru.summer.mymarket.service.ProductService;

@Controller
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //  http://localhost:8088/summer/add_product
    @GetMapping("/add_product")
    public String showAddProductForm() {
        return "add_product";
    }

    @PostMapping("/add_product_list")
    public String addProductToList( @RequestParam int id, @RequestParam String title, @RequestParam float cost) {
        Product product = new Product(id, title, cost);
        productService.addToProductList(product);

        return "redirect:/add_product";
    }

    //  http://localhost:8088/summer/get_product_list
    @GetMapping("/get_product_list")
    public String getProductList(Model model) {

        model.addAttribute("list", productService.getProductList());
        return "products";
    }

    @GetMapping("/products/{id}")
    public String showInfo(Model model, @PathVariable int id) {
        model.addAttribute(productService.findById(id));
        return "info_product";
    }

    @PostMapping("/remove_product")
    public String removeProductFromList(Model model,@RequestParam int index){
        model.addAttribute(productService.removeProductFromList(index));
        return "redirect:/get_product_list";
    }

}
