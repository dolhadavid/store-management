package com.store.controller;

import com.store.dto.ProductDto;
import com.store.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product API", description = "Api used to handle products")
public class ProductApi {

  private final ProductService productService;

  public ProductApi(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/{id}")
  public ProductDto getProductById(@PathVariable Long id) {
    Optional<ProductDto> optionalProductDto = productService.findById(id);

    return optionalProductDto.get();
  }

  @GetMapping("/")
  public List<ProductDto> getProducts() {
    // TODO: Handle the logic to take data for specific user after authorization is done
    // TODO: for the moment we will use the default user with ID 1
    String defaultUsername = "john1";
    Optional<List<ProductDto>> optionalProductDtoList = productService.findAll(defaultUsername);

    return optionalProductDtoList.get();
  }

  @PostMapping("/save")
  @ResponseStatus(HttpStatus.OK)
  public void save(@RequestBody @Valid ProductDto productDto) {
    // TODO: Handle the logic to take data for specific user after authorization is done
    // TODO: for the moment we will use the default user with ID 1
    String defaultUsername = "john1";
    productService.save(productDto, defaultUsername);
  }

  @PatchMapping("/{id}/change-price/{price}")
  @ResponseStatus(HttpStatus.OK)
  public void changePrice(@PathVariable Long id, @PathVariable Double price) {
    // TODO: Handle the logic to take data for specific user after authorization is done
    // TODO: for the moment we will use the default user with ID 1
    String defaultUsername = "john1";
    productService.changePrice(id, price, defaultUsername);
  }
}
