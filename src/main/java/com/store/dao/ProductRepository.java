package com.store.dao;

import com.store.dto.ProductDto;
import com.store.entity.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
  @Query(
      value = """
        SELECT new com.store.dto.ProductDto(p.price, p.description)
        FROM Product p
        WHERE p.user.username = :username
      """
  )
  List<ProductDto> findProductsForUser(String username);

}
