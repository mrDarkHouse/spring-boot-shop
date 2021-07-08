package com.darkhouse.test_shop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @SequenceGenerator(name = "customers_sequence", sequenceName = "customers_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customers_sequence")
    private Long id;
    @Column(name = "name", unique = true)
    private String username;
    @Column(name = "pass")
    private String password;
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orders;

    public CustomerEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
