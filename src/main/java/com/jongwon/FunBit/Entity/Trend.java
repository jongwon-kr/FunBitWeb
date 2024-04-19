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
}
