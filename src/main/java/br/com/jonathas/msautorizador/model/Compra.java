package br.com.jonathas.msautorizador.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Compra {

    private String idCompra;
    private BigDecimal valorCompra;
    private String descricao;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate data;
    private StatusCompra statusCompra;
}
