package com.kruchon.musicmap.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LOCATION", uniqueConstraints = {
        @UniqueConstraint(columnNames={"ID","TITLE","POINTS"})})
public class Location implements Serializable {

    private static final long serialVersionUID = -5527566248002296042L;

    @Id
    @Column(name = "ID")
    Integer id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "POINTS")
    private String points; //Here may be points in JSON or XML format

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title= title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoints() {
        return points;
    }

    public void setId(String points) {
        this.points = points;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

}
