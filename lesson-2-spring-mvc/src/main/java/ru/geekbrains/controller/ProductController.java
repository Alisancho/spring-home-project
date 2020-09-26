package ru.geekbrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.persist.entity.Product;
import ru.geekbrains.persist.entity.User;
import ru.geekbrains.repo.ProductRepository;
import ru.geekbrains.repo.ProductSpecification;
import ru.geekbrains.repo.UserSpecification;

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
                             @RequestParam(value = "page") Optional<Integer> page,
                             @RequestParam(value = "size") Optional<Integer> size,
                             @RequestParam(value = "min") Optional<BigDecimal> min,
                             @RequestParam(value = "max") Optional<BigDecimal> max) {
        PageRequest pageRequest = PageRequest.of(page.orElse(1) - 1, size.orElse(5));
        Specification<Product> spec = ProductSpecification.trueLiteral();
        if (min.isPresent()) {
            spec = spec.and(ProductSpecification.min(min.get()));
        }
        if (max.isPresent()) {
            spec = spec.and(ProductSpecification.max(max.get()));
        }
        model.addAttribute("product", productRepository.findAll(spec, pageRequest));
        return "products";
    }


    @GetMapping("/{id}")
    public String editUser(@PathVariable("id") String id, Model model) throws SQLException {
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(l -> model.addAttribute("product", product));
        return "product";
    }
}
