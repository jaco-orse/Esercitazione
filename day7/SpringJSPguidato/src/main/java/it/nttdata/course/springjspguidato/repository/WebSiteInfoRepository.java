package it.nttdata.course.springjspguidato.repository;

import it.nttdata.course.springjspguidato.model.WebSiteInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebSiteInfoRepository extends JpaRepository<WebSiteInfo, Long> {
    WebSiteInfo findFirstByOrderByIdDesc();
    //WebSiteInfo findFirstByIdOrderByIdDesc();
}