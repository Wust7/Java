package com.wust.demoproject.domain;

public class Chapter {
    private int id;
    private int videoId;
    private String title;

    public Chapter() {
    }

    public Chapter(int id, int videoId, String title) {
        this.id = id;
        this.videoId = videoId;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", videoId=" + videoId +
                ", title='" + title + '\'' +
                '}';
    }
}
