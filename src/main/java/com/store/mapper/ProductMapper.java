package com.store.mapper;

import com.store.dto.ProductDto;
import com.store.entity.Product;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

  ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

  @Named(value = "productToProductDto")
  ProductDto productToProductDto(Product product);

  @IterableMapping(qualifiedByName = "productToProductDto")
  List<ProductDto> productListToProductDtoList(List<Product> productList);

  Product productDtoToProduct(ProductDto productDto);
}
