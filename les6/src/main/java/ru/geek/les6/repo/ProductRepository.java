package ru.geek.les6.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.geek.les6.entity.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
    List<Product> getAllProduct();

    Optional<Product> findById(String id);

    List<Product> findByСostLessThan(BigDecimal cost);

    List<Product> findByСostGreaterThan(BigDecimal cost);

    List<Product> findByСostGreaterThanAndСostLessThan(BigDecimal cost,BigDecimal cost2);
}
