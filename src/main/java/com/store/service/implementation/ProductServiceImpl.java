package com.store.service.implementation;

import com.store.dao.ProductRepository;
import com.store.dao.UserRepository;
import com.store.dto.ProductDto;
import com.store.entity.Product;
import com.store.entity.User;
import com.store.exception.ProductNotFoundException;
import com.store.exception.UserNotAllowedException;
import com.store.mapper.ProductMapper;
import com.store.service.ProductService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;
  private final UserRepository userRepository;

  public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository) {
    this.productRepository = productRepository;
    this.userRepository = userRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<ProductDto> findById(Long id) {
    Optional<Product> optionalProduct = productRepository.findById(id);

    if (optionalProduct.isPresent()) {
      return Optional.of(ProductMapper.INSTANCE.productToProductDto(optionalProduct.get()));
    } else {
      throw new ProductNotFoundException("Product with id <" + id + "> not found");
    }
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<List<ProductDto>> findAll(String username) {
    return Optional.of(productRepository.findProductsForUser(username));
  }

  @Override
  public void save(ProductDto productDto, String username) {
    Product product = ProductMapper.INSTANCE.productDtoToProduct(productDto);
    Optional<User> optionalUser = userRepository.findByUsername(username);

    if (optionalUser.isPresent()) {
      product.setUser(optionalUser.get());
      productRepository.save(product);
      log.info("New product is saved: " + product);
    } else {
      throw new UserNotAllowedException("User <" + username + "> is not allowed for the operation");
    }
  }

  @Override
  public void changePrice(Long id, Double price, String username) {
    Optional<Product> optionalProduct = productRepository.findById(id);

    if (optionalProduct.isPresent()) {
      Product product = optionalProduct.get();

      if (!username.equals(product.getUser().getUsername())) {
        throw new UserNotAllowedException(
            "User <" + username + "> is not allowed for the operation");
      }

      product.setPrice(price);
      productRepository.save(product);

      log.info("Price was changed for product with id <" + id + ">");
    } else {
      throw new ProductNotFoundException("Product with id <" + id + "> not found");
    }
  }
}
