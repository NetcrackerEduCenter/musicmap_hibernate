package com.kruchon.musicmap.domain;

public class UserData {

    private String vkIdLine;
    private String songs;
    private float x, y;

    public void setId(String id) {
        this.vkIdLine = id;
    }

    public void setSongs(String songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "vkIdLine='" + vkIdLine + '\'' +
                ", songs='" + songs + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String getId() {
        return vkIdLine;
    }

    public String getSongs() {
        return songs;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String getVkIdLine() {
        return vkIdLine;
    }

    public void setVkIdLine(String vkIdLine) {
        this.vkIdLine = vkIdLine;
    }

}
