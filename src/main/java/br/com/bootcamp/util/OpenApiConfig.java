package br.com.bootcamp.util;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

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
    )),
    servers = { @Server(url = "https://transactions-api.fly.dev") }
)
public class OpenApiConfig {
}

