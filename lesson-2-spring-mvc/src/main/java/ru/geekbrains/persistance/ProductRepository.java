package ru.geekbrains.persistance;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class ProductRepository {

    private final Connection conn;

    @Autowired
    public ProductRepository(DataSource dataSource) throws SQLException {
        this(dataSource.getConnection());
    }

    public ProductRepository(Connection conn) throws SQLException {
        this.conn = conn;
        createTableIfNotExists(conn);
    }

    public List<Product> getAllProduct() throws SQLException {
        List<Product> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select id, title, cost from product");

            while (rs.next()) {
                res.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        }
        return res;
    }

    public Optional<Product> findById(String id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "select id, title, cost from product where id = ?")) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(new Product(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        }
        return Optional.empty();
    }

    private void createTableIfNotExists(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("create table if not exists product (\n" +
                    "\tid int auto_increment primary key,\n" +
                    "    id varchar(25),\n" +
                    "    title varchar(25),\n" +
                    "    cost varchar(25)\n" +
                    ");");
        }
    }
}
