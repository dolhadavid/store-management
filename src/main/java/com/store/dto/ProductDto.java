package com.store.dto;

import java.io.Serial;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {

  @Serial
  private static final long serialVersionUID = -2793387071879961220L;
  @NotNull(message = "Price mandatory")
  private Double price;

  @NotBlank(message = "Description cannot be empty")
  @Size(max = 200)
  private String description;
}
