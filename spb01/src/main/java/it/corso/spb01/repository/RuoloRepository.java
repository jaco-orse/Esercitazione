package it.corso.spb01.repository;

import it.corso.spb01.model.Ruolo;
import it.corso.spb01.model.enumRuolo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RuoloRepository extends JpaRepository<Ruolo, Long> {
    Optional<Ruolo> findByName(enumRuolo name);
}
