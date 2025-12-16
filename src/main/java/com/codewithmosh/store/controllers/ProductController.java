package com.codewithmosh.store.controllers;


import com.codewithmosh.store.dtos.ProductDto;
import com.codewithmosh.store.mappers.ProductMapper;
import com.codewithmosh.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductDto> getAllProducts(@RequestParam(name = "categoryId",required = false) Byte categoryId) {

        if(categoryId == null) {
            return productRepository.findAll().stream().map(productMapper::toDto).toList();
        }

        return productRepository.findByCategoryId(categoryId).stream().map(productMapper::toDto).toList();
    }

    @GetMapping("/{categoryId}")
    public List<ProductDto> getProductById(@PathVariable Byte categoryId) {
        return productRepository.findByCategoryId(categoryId).stream().map(productMapper::toDto).toList();
    }
}
