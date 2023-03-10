package it.nttdata.course.springjspguidato.business.interf;

import it.nttdata.course.springjspguidato.model.WebSiteInfo;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface WebSiteInfoBO {
    public WebSiteInfo getWebSiteInfo() throws DataAccessException;
    public List<WebSiteInfo> getAll() throws DataAccessException;
    public void insertWebSiteInfo(String name, String description) throws DataAccessException;
    public void deleteWebSiteInfo(Long id) throws DataAccessException;
    public WebSiteInfo getById(Long id);
    public void updateInfo(String name, String description, Long id);
}
