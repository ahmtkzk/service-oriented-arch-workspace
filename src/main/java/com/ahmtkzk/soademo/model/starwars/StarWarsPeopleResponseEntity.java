package com.ahmtkzk.soademo.model.starwars;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "starwars")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StarWarsPeopleResponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private Date created;
    private Date edited;
    private String url;

}
