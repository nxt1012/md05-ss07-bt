package com.ra.md05ss06miniprojectorderapi.repository;

import com.ra.md05ss06miniprojectorderapi.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p " +
            "WHERE lower(p.productName) LIKE %:searchTerm% " +
            "OR lower(p.imageUrl) LIKE %:searchTerm% " +
            "OR lower(p.price) LIKE %:searchTerm% " +
            "OR lower(p.quantity) LIKE %:searchTerm%")
    Page<Product> findProductsByKeyword(String searchTerm, Pageable pageable);
}
