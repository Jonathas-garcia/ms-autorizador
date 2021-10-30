package br.com.jonathas.msautorizador.config;

import br.com.jonathas.msautorizador.receiver.ComprasListener;
import br.com.jonathas.msautorizador.service.CompraService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    private final CompraService service;

    public RabbitConfig(CompraService service) {
        this.service = service;
    }

    @Bean
    public ComprasListener receiver() {
        return new ComprasListener(service);
    }
}
