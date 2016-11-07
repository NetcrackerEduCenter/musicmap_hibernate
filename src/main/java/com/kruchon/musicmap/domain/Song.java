package com.kruchon.musicmap.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SONG", uniqueConstraints = {
        @UniqueConstraint(columnNames={"ID","SINGER"})})
public class Song implements Serializable {

    private static final long serialVersionUID = -5527566248002296042L;

    @Id
    @Column(name = "ID")
    Integer id;

    @Column(name = "SINGER")
    private String singer;

    public String getSinger() {
        return singer;
    }
    public void setSinger(String singer) {
        this.singer= singer;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}