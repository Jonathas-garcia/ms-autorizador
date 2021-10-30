package br.com.jonathas.msautorizador.controller;

import br.com.jonathas.msautorizador.model.Compra;
import br.com.jonathas.msautorizador.service.CompraService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("compras")
public class ComprasController {

    private final CompraService service;

    public ComprasController(CompraService service) {
        this.service = service;
    }

    @GetMapping
    public List<Compra> findAll() {
        return service.findAll();
    }

}
