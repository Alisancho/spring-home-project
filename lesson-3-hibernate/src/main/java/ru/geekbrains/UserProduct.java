package ru.geekbrains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_product")
public class UserProduct {

    @Id
    @Column
    private Integer user_id;
    @Id
    @Column
    private Integer product_id;
    @Column
    private String price;
    @Column
    private Integer count;
    @Column
    private String status;

    public UserProduct() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public String getPrice() {
        return price;
    }

    public Integer getCount() {
        return count;
    }

    public String getStatus() {
        return status;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setStatus(String status) {
        this.status = status;
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
