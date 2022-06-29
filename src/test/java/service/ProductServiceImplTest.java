package service;

import com.store.dao.ProductRepository;
import com.store.dto.ProductDto;
import com.store.entity.Product;
import com.store.exception.ProductNotFoundException;
import com.store.service.implementation.ProductServiceImpl;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

  @Mock private ProductRepository productRepository;

  @InjectMocks private ProductServiceImpl productService;

  @Test
  public void findByIdTest() {
    Product product = Product.builder().id(1L).price(2.0D).description("Description").build();
    Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));

    ProductDto productDto = productService.findById(1L).get();

    Assertions.assertNotNull(productDto);
    Assertions.assertEquals("Description", productDto.getDescription());
    Assertions.assertEquals(2.0D, productDto.getPrice());
  }

  @Test
  public void findByIdTest_whenProductNotFoundException() {
    Mockito.when(productRepository.findById(1L)).thenReturn(Optional.empty());

    Exception exception =
        Assertions.assertThrows(
            ProductNotFoundException.class,
            () -> {
              productService.findById(1L);
            });

    Assertions.assertEquals("Product with id <1> not found", exception.getMessage());
  }
}
