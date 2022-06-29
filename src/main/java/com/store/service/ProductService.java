package com.store.service;

import com.store.dto.ProductDto;
import java.util.List;
import java.util.Optional;

public interface ProductService {

  public Optional<ProductDto> findById(Long id);

  public Optional<List<ProductDto>> findAll(String username);

  public void save(ProductDto productDto, String username);

  public void changePrice(Long id, Double price, String username);
}
