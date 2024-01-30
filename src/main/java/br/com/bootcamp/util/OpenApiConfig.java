package br.com.bootcamp.util;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
    title = "Transactions API - Bernmp-dev",
    version = "1.0",
    description = "Open Api documentation for transactions API",
    summary = "transactions management system",
    contact = @Contact(
      name = "Bernmp-dev",
      email = "bernardomp.dev@gmail.com",
      url = "https://github.com/Bernmp-dev"
    ))
)
public class OpenApiConfig {
}

