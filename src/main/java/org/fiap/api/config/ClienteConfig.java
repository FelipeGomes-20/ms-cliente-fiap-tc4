package org.fiap.api.config;

import org.fiap.api.gateway.ClienteGateway;
import org.fiap.api.usecase.CadastrarClienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteConfig {

    @Bean
    CadastrarClienteUseCase cadastrarClienteUseCase(ClienteGateway cliente) {
        return new CadastrarClienteUseCase(cliente);
    }

}
