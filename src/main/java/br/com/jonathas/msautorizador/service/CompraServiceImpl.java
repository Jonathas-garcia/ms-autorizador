package br.com.jonathas.msautorizador.service;

import br.com.jonathas.msautorizador.model.Compra;
import br.com.jonathas.msautorizador.repository.CompraRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CompraServiceImpl implements CompraService {

    private final CompraRepository repository;

    public CompraServiceImpl(CompraRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Compra> findAll() {
        return repository.findAll();
    }

    @Override
    public Compra findById(String id) {
        return getCompraById(id);
    }

    @Override
    public Compra create(Compra compra) {
        return repository.save(compra);
    }

    @Override
    public Compra update(Compra compra) {
        return repository.save(compra);
    }

    @Override
    public void delete(Compra compra) {
        repository.delete(compra);
    }

    private Compra getCompraById(String id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
