package com.ahmtkzk.soademo.model.placeholder;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "placeholder")
@Data
public class PlaceholderPostResponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tableId;
    private int id;
    private int userId;
    private String title;
    private String body;

}
