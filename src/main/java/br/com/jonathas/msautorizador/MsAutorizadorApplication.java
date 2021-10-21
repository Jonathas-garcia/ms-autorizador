package br.com.jonathas.msautorizador;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class MsAutorizadorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsAutorizadorApplication.class, args);
    }

}
