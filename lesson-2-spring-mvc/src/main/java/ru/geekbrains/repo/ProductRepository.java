package ru.geekbrains.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import ru.geekbrains.persist.entity.Product;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> getAllProduct();

    Optional<Product> findById(String id);

    List<Product> findByСostLessThan(BigDecimal cost);

    List<Product> findByСostGreaterThan(BigDecimal cost);

    List<Product> findByСostGreaterThanAndСostLessThan(BigDecimal cost,BigDecimal cost2);
}
