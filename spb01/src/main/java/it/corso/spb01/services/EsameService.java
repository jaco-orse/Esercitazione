package it.corso.spb01.services;

import it.corso.spb01.model.Course;
import it.corso.spb01.model.Esame;
import it.corso.spb01.repository.CourseRepository;
import it.corso.spb01.repository.EsameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EsameService {
    @Autowired
    EsameRepository esameRepository;

    @Autowired
    CourseRepository courseRepository;

    public List<Esame> getAll(){
        return esameRepository.findAll();
    }

    public List<Esame> getAllbyValutazione(int val){
        return esameRepository.findByValutazione(val).orElse(null);
    }



    public boolean insertExam(Esame e_, Long courseId){

        Course c = courseRepository.findById(courseId).orElse(null);
        if(c == null){
            return false;
        }

        Esame e = new Esame();
        e.setValutazione(e_.getValutazione());
        e.setGiorno(e_.getGiorno());
        e.setMese(e_.getMese());
        e.setAnno(e_.getAnno());
        e.setCourse(c);

        esameRepository.save(e);
        return true;
    }

    public boolean updateExam(Esame e_){
        Esame e = esameRepository.findById(e_.getId()).orElse(null);
        if(e == null){
            return false;
        }
        return true;
    }


    public void deleteEsame(Long id){
        esameRepository.deleteById(id);
        return;
    }
}
