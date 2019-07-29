package com.github.rkhusainov.bashsongs.model;

import javax.persistence.*;

@Entity
@Table(name = "SINGER")
public class Singer {
    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "INFO")
    private String info;

    @Column(name = "IMG_URL")
    private String img_url;
}
