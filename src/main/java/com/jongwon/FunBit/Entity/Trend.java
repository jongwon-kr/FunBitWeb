package com.jongwon.FunBit.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Trend {

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

    public Trend() {

    }
}
