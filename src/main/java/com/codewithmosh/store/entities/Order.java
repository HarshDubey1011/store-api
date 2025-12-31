package com.codewithmosh.store.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;


    @Column(name = "created_at", updatable = false,insertable = false)
    private Instant createdAt;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @OneToMany(mappedBy = "order")
    private Set<OrderItem> items = new LinkedHashSet<>();

}