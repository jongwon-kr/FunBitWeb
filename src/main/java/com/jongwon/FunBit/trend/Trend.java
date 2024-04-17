package com.jongwon.FunBit.trend;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Getter
@Setter
public class Trend {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getAgoTime() {
        return agoTime;
    }

    public void setAgoTime(String agoTime) {
        this.agoTime = agoTime;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getArticleLink() {
        return articleLink;
    }

    public void setArticleLink(String articleLink) {
        this.articleLink = articleLink;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int seq;
    String keyword;
    String article;
    String agoTime;
    String volume;
    String date;
    String articleLink;
    String imgLink;

    public Trend() {

    }

    @Autowired
    public Trend(int id, int seq, String keyword, String article, String agoTime, String volume, String date, String articleLink, String imgLink) {
        this.id = id;
        this.seq = seq;
        this.keyword = keyword;
        this.article = article;
        this.agoTime = agoTime;
        this.volume = volume;
        this.date = date;
        this.articleLink = articleLink;
        this.imgLink = imgLink;
    }

    @Override
    public String toString() {
        return "Trend{" +
                "id=" + id +
                ", seq=" + seq +
                ", date='" + date + '\'' +
                ", keyword='" + keyword + '\'' +
                ", article='" + article + '\'' +
                ", volume='" + volume + '\'' +
                ", agoTime='" + agoTime + '\'' +
                ", articleLink='" + articleLink + '\'' +
                ", imgLink='" + imgLink + '\'' +
                '}';
    }
}
