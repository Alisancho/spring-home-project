package ru.geekbrains;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "user_product")
public class UserProduct {

    @Id
    @Column
    private String session_id;

    @ManyToOne
    private User user_id;
    @ManyToOne
    private Product product_id;
    @Column
    private BigDecimal price;
    @Column
    private Integer count;
    @Column
    private String status;

    public UserProduct() {
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getCount() {
        return count;
    }

    public String getStatus() {
        return status;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "UserProduct{" +
                "user_id=" + user_id +
                ", product_id='" + product_id + '\'' +
                ", price='" + price + '\'' +
                ", count='" + count + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
