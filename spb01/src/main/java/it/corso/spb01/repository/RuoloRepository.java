package it.corso.spb01.repository;

import it.corso.spb01.model.Ruolo;
import it.corso.spb01.model.enumRuolo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuoloRepository extends JpaRepository<Ruolo, Long> {
}
