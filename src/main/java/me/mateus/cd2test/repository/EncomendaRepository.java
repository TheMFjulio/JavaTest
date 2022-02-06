package me.mateus.cd2test.repository;

import me.mateus.cd2test.models.Encomenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncomendaRepository extends JpaRepository<Encomenda, Long> {
}
