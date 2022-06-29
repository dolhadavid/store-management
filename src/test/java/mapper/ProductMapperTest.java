package mapper;

import com.store.dto.ProductDto;
import com.store.entity.Product;
import com.store.mapper.ProductMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductMapperTest {

  @Test
  public void productToProductDtoTest() {
    Product product = Product.builder().price(2.0D).description("Description").build();

    ProductDto productDto = ProductMapper.INSTANCE.productToProductDto(product);

    Assertions.assertEquals(product.getPrice(), productDto.getPrice());
    Assertions.assertEquals(product.getDescription(), productDto.getDescription());
  }

  @Test
  public void productDtoToProductTest() {
    ProductDto productDto = ProductDto.builder().price(2.0D).description("Description").build();

    Product product = ProductMapper.INSTANCE.productDtoToProduct(productDto);

    Assertions.assertEquals(product.getPrice(), productDto.getPrice());
    Assertions.assertEquals(product.getDescription(), productDto.getDescription());
    Assertions.assertEquals(null, product.getId());
  }
}
