package it.corso.spb01.repository;

import it.corso.spb01.model.Esame;
import it.corso.spb01.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EsameRepository  extends JpaRepository<Esame, Long> {

    Optional<List<Esame>> findByValutazione(int valutazione);

}
