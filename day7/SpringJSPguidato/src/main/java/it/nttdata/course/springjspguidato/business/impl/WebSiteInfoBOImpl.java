package it.nttdata.course.springjspguidato.business.impl;

import it.nttdata.course.springjspguidato.business.interf.WebSiteInfoBO;
import it.nttdata.course.springjspguidato.model.WebSiteInfo;
import it.nttdata.course.springjspguidato.repository.WebSiteInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebSiteInfoBOImpl implements WebSiteInfoBO {
    @Autowired
    WebSiteInfoRepository webSiteInfoRepository;


    public WebSiteInfo getWebSiteInfo() throws DataAccessException{
        return webSiteInfoRepository.findFirstByOrderByIdDesc();
        // return webSiteInfoRepository.findFirstByIdOrderByIdDesc();
    }

    public List<WebSiteInfo> getAll() throws DataAccessException{
        return webSiteInfoRepository.findAll();
    }

    public void insertWebSiteInfo(String name, String description) throws DataAccessException{
        WebSiteInfo currInfo = new WebSiteInfo();
        currInfo.setName(name);
        currInfo.setDescription(description);
        webSiteInfoRepository.save(currInfo);
        return;
    }



}
