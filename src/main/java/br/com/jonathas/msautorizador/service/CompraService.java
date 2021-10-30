package br.com.jonathas.msautorizador.service;

import br.com.jonathas.msautorizador.model.Compra;

import java.util.List;

public interface CompraService {

    List<Compra> findAll();

    Compra findById(String id);

    Compra create(Compra compra);

    Compra update(Compra compra);

    void delete(Compra compra);

}
