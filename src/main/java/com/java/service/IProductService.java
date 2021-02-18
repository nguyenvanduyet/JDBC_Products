package com.java.service;

import com.java.model.Products;

import java.util.List;

public interface IProductService extends IGenaricService<Products>{
    List<Products> findByName(String name);
}
