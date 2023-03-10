package it.corso.spb01.services;

import it.corso.spb01.model.Esame;

import java.util.List;

public interface EsameService {

    public List<Esame> getAll();
    public List<Esame> getAllbyValutazione(int val);
    public boolean insertExam(Esame e_, Long courseId);
    public boolean updateExam(Esame e_);
    public void deleteEsame(Long id);
}
