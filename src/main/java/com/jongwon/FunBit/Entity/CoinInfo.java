package com.jongwon.FunBit.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CoinInfo {

    @Id
    String market;  // coin code
    @Column(length = 1000)
    String introduction;    // coin introduction
    @Column(length = 1000)
    String tech;    // coin tech
    @Column(length = 1000)
    String nowFuture;   // coin nowFutuer

    public CoinInfo() {
        super();
    }

    public CoinInfo(String market, String introduction, String tech, String nowFuture) {
        this.market = market;
        this.introduction = introduction;
        this.tech = tech;
        this.nowFuture = nowFuture;
    }

}
