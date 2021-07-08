package com.darkhouse.test_shop.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @SequenceGenerator(name = "orders_sequence", sequenceName = "orders_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_sequence")
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
            name = "order_goods",
            joinColumns = { @JoinColumn(name = "order_id") },
            inverseJoinColumns = { @JoinColumn(name = "goods_id") }
    )
    private List<GoodsEntity> goods;

    public OrderEntity() {
        this.orderDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                '}';
    }

    public List<GoodsEntity> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsEntity> goods) {
        this.goods = goods;
    }
}
