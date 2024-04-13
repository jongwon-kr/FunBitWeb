package com.jongwon.FunBit.coinInfo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
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


    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getNowFuture() {
        return nowFuture;
    }

    public void setNowFuture(String nowFuture) {
        this.nowFuture = nowFuture;
    }

    @Override
    public String toString() {
        return "coinInfo{" +
                "market='" + market + '\'' +
                ", introduction='" + introduction + '\'' +
                ", tech='" + tech + '\'' +
                ", nowFuture='" + nowFuture + '\'' +
                '}';
    }
}
