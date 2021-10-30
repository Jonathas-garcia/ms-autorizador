package br.com.jonathas.msautorizador.repository;

import br.com.jonathas.msautorizador.model.Compra;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface CompraRepository extends MongoRepository<Compra, String> {

}
