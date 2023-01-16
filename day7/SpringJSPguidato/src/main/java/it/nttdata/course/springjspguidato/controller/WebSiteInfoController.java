package it.nttdata.course.springjspguidato.controller;

import it.nttdata.course.springjspguidato.business.interf.WebSiteInfoBO;
import it.nttdata.course.springjspguidato.model.WebSiteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(path={"/createSite"})
    public ModelAndView getCreatePage(){
        return new ModelAndView("/createSite.jsp");
    }

    @PostMapping(path={"/createSite"})
    public ModelAndView addSite(@RequestParam(name = "name") String name, @RequestParam(name = "description") String description ){
        // no try and catch perchè gestito da ExcemptionController
        webSiteInfoBO.insertWebSiteInfo(name,description);
        return new ModelAndView("/index.jsp");
    }

    @GetMapping(path={"/deleteInfo"})
    public ModelAndView deleteInfo(@RequestParam(name="id") String id){
        Long l_id = Long.parseLong(id);
        webSiteInfoBO.deleteWebSiteInfo(l_id);
        return getSites();
    }

    @GetMapping(path={"/updateInfo"})
    public ModelAndView getSiteInfo(@RequestParam(name = "id") String id){
        Long l_id = Long.parseLong(id);
        WebSiteInfo currInfo = webSiteInfoBO.getById(l_id);
        return new ModelAndView("/updateInfo.jsp","currInfo",currInfo);
    }

    @PostMapping(path={"/updateInfo"})
    public ModelAndView updateSiteInfo(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "id") String id){
        Long l_id = Long.parseLong(id);
        webSiteInfoBO.updateInfo(name,description,l_id);
        return getSites();
    }

}
