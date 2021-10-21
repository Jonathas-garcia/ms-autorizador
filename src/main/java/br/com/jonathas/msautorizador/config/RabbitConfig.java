package br.com.jonathas.msautorizador.config;

import br.com.jonathas.msautorizador.receiver.ComprasListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public ComprasListener receiver() {
        return new ComprasListener();
    }
}
