package ru.geekbrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.persist.entity.Product;
import ru.geekbrains.persist.entity.User;
import ru.geekbrains.repo.ProductRepository;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String allProduct(Model model,
                             @RequestParam(value = "min", required = false) BigDecimal min,
                             @RequestParam(value = "max", required = false) BigDecimal max) {

        List<Product> allProduct;
        if (min == null && max == null) {
            allProduct = productRepository.findAll();
        } else if (min != null && max == null) {
            allProduct = productRepository.findByСostGreaterThan(min);
        } else if (min == null && max != null) {
            allProduct = productRepository.findByСostLessThan(max);
        } else {
            allProduct = productRepository.findByСostGreaterThanAndСostLessThan(min, max);
        }
//        model.addAttribute("users", allUsers);
//        return "users";

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
