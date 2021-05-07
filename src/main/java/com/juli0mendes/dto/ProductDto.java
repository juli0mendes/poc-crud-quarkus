package com.juli0mendes.dto;

import java.math.BigDecimal;

public class ProductDto {

    private String name;

    private BigDecimal value;

    public ProductDto() {
    }

    public ProductDto(String name, BigDecimal value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public ProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public ProductDto setValue(BigDecimal value) {
        this.value = value;
        return this;
    }
}
