package com.store.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import java.util.Comparator;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Store management API", version = "1.0.0"))
public class SwaggerConfig {

  /**
   * Starts Spring application adding swagger information
   *
   * @return openApi
   */
  @Bean
  public OpenApiCustomiser api() {
    return openApi ->
        openApi.setTags(
            openApi.getTags().stream()
                .sorted(Comparator.comparing(tag -> StringUtils.stripAccents(tag.getName())))
                .collect(Collectors.toList()));
  }
}
