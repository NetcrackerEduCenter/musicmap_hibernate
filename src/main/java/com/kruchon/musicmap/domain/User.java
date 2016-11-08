package com.kruchon.musicmap.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User implements Serializable {

    private static final long serialVersionUID = -5527566248002296042L;

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "VK_ID_LINE")

    private String vkIdLine;

    public String getVkIdLine() {
        return vkIdLine;
    }

    public void setVkIdLine(String vkIdLine) {
        this.vkIdLine = vkIdLine;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}