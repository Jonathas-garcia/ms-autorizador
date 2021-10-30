package br.com.jonathas.msautorizador.receiver;

import br.com.jonathas.msautorizador.model.Compra;
import br.com.jonathas.msautorizador.model.StatusCompra;
import br.com.jonathas.msautorizador.service.CompraService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
@RabbitListener(queues = "${queue.name}")
public class ComprasListener {

    private final CompraService service;
    private final ObjectMapper mapper;

    public ComprasListener(CompraService service) {
        this.service = service;
        this.mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.findAndRegisterModules();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @RabbitHandler
    public void receive(String in) {
        try {
            log.info("Recebido " + in);
            Compra compra = mapper.readValue(in, Compra.class);
            compra.setStatusCompra(StatusCompra.CONFIRMADA);
            service.create(compra);
        } catch (JsonProcessingException e) {
            log.error("Error ao salvar compra", e);
        }
    }

}
