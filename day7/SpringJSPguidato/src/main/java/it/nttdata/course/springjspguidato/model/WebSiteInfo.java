package it.nttdata.course.springjspguidato.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "web_site_info")
public class WebSiteInfo extends BaseEntity {
    private String name;
    private String description;
}