package it.nttdata.course.springjspguidato.controller;

import it.nttdata.course.springjspguidato.business.interf.WebSiteInfoBO;
import it.nttdata.course.springjspguidato.model.WebSiteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WebSiteInfoController {
    @Autowired
    WebSiteInfoBO webSiteInfoBO;

    @GetMapping(path={"/","/index"})
    public ModelAndView home(){
        // no try and catch perchè gestito da ExcemptionController
        WebSiteInfo webSiteInfo = webSiteInfoBO.getWebSiteInfo();
        return new ModelAndView("/index.jsp","info",webSiteInfo);
    }

    @GetMapping(path={"/sites"})
    public ModelAndView getSites(){
        // no try and catch perchè gestito da ExcemptionController
        List<WebSiteInfo> sites = webSiteInfoBO.getAll();
        return new ModelAndView("/sites.jsp","sites",sites);
    }
}
