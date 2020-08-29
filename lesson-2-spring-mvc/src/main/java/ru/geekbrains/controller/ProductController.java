package ru.geekbrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.persistance.Product;
import ru.geekbrains.persistance.ProductRepository;
import ru.geekbrains.persistance.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String allProduct(Model model) throws SQLException {
        List<Product> allProduct = productRepository.getAllProduct();
        model.addAttribute("product", allProduct);
        return "products";
    }

    @GetMapping("/{id}")
    public String editUser(@PathVariable("id") String id, Model model) throws SQLException {
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(l -> model.addAttribute("product", product));
        return "product";
    }
}
