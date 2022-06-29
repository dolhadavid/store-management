package com.store;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Hidden
public class SwaggerApi {

  @SuppressWarnings("SameReturnValue")
  @RequestMapping("/swagger")
  public String home() {
    return "redirect:/swagger-ui.html";
  }
}
