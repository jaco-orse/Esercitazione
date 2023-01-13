package it.nttdata.course.springjspguidato.business.impl;

import it.nttdata.course.springjspguidato.business.interf.WebSiteInfoBO;
import it.nttdata.course.springjspguidato.model.WebSiteInfo;
import it.nttdata.course.springjspguidato.repository.WebSiteInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class WebSiteInfoBOImpl implements WebSiteInfoBO {
    @Autowired
    WebSiteInfoRepository webSiteInfoRepository;

    @Override
    public WebSiteInfo getWebSiteInfo() throws DataAccessException{
        return webSiteInfoRepository.findFirstByOrderByIdDesc();
        // return webSiteInfoRepository.findFirstByIdOrderByIdDesc();
    }

}
