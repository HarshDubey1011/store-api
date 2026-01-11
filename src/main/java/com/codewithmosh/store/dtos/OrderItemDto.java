package com.codewithmosh.store.dtos;

import java.math.BigDecimal;

public class OrderItemDto {
    private OrderProductDto orderProductDto;
    private int  quantity;
    private BigDecimal totalPrice;
}
