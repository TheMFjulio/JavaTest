package me.mateus.cd2test.service;

import me.mateus.cd2test.models.Encomenda;
import me.mateus.cd2test.repository.EncomendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncomendaService {

    private final EncomendaRepository repository;

    @Autowired
    public EncomendaService(EncomendaRepository repository) {
        this.repository = repository;
    }

    public void addNewEncomenda(Encomenda encomenda) {
        repository.save(encomenda);
    }
}
