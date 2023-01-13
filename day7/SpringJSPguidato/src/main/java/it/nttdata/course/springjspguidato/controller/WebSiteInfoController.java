package it.nttdata.course.springjspguidato.controller;

import it.nttdata.course.springjspguidato.business.interf.WebSiteInfoBO;
import it.nttdata.course.springjspguidato.model.WebSiteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebSiteInfoController {
    @Autowired
    WebSiteInfoBO webSiteInfoBO;

    @GetMapping(path={"/","/index"})
    public ModelAndView home(){
        try{
            WebSiteInfo webSiteInfo = webSiteInfoBO.getWebSiteInfo();
            return new ModelAndView("/index.jsp","info",webSiteInfo);
        } catch (Exception e){
            return new ModelAndView();
        }
    }
}
