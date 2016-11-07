package com.kruchon.musicmap.domain;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER")
public class User implements Serializable {
 
 private static final long serialVersionUID = -5527566248002296042L;
  
 @Id
 @Column(name = "ID")
 @GeneratedValue
 private Integer id;

 @Column(name = "VK_ID_LINE")

 private String vkIdLine;

 public String getvkIdLine() {
  return vkIdLine;
 }

 public void setvkIdLine(String vkIdLine) {
  this.vkIdLine = vkIdLine;
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