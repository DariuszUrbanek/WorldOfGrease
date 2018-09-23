package com.example.du.shop.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.du.shop.generated.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

	Product findByPrName(String prName);

}
