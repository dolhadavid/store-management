package com.store.configuration;

import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** Web configuration to enable CORS. */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {


  @Value("${format.date.iso}")
  private String dateTimeFormat;

  @Configuration
  public class RequestLoggingFilterConfig {

    @Bean
    public CommonsRequestLoggingFilter logFilter() {
      CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
      filter.setIncludeQueryString(true);
      filter.setIncludePayload(true);
      filter.setMaxPayloadLength(1000);
      filter.setIncludeHeaders(false);
      filter.setAfterMessagePrefix("REQUEST DATA : ");
      return filter;
    }
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
        .addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS");
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    Jackson2ObjectMapperBuilder builder =
        new Jackson2ObjectMapperBuilder()
            .indentOutput(true)
            .dateFormat(new SimpleDateFormat(dateTimeFormat));
    converters.add(new StringHttpMessageConverter());
    converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    converters.add(new ByteArrayHttpMessageConverter());
  }
}
