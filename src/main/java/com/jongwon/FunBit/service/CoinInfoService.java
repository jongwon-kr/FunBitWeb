package com.jongwon.FunBit.service;

import com.jongwon.FunBit.Entity.CoinInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class CoinInfoService {

    private static List<CoinInfo> coinInfoList = new ArrayList<>();

    public List<CoinInfo> findByMarkets(String market) {
        Predicate<? super CoinInfo> predicate = coinInfo -> coinInfo.getMarket().equalsIgnoreCase(market);
        return coinInfoList.stream().filter(predicate).toList();
    }

    public void deleteByMarket(String market) {
        Predicate<? super CoinInfo> predicate = coinInfo -> coinInfo.getMarket().equals(market);
        coinInfoList.removeIf(predicate);
    }

    public CoinInfo findByMarket(String market) {
        Predicate<? super CoinInfo> predicate = coinInfo -> coinInfo.getMarket().equals(market);
        CoinInfo coinInfo = coinInfoList.stream().filter(predicate).findFirst().get();
        return coinInfo;
    }
}
