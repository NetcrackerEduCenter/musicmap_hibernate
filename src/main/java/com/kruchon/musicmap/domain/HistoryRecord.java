package com.kruchon.musicmap.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "HISTORY_RECORD", uniqueConstraints = {
    @UniqueConstraint(columnNames={"USER_ID","SONG_ID","LOCATION_ID"})})
public class HistoryRecord implements Serializable {

    private static final long serialVersionUID = -5527566248002296042L;

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SONG_ID")
    private Song song;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name="LOCATION_ID")
    private Location location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
