package br.com.jonathas.msautorizador.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document
public class Compra {

    @Id
    private String idCompra;
    private BigDecimal valorCompra;
    private String descricao;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime data;
    private StatusCompra statusCompra;
}
