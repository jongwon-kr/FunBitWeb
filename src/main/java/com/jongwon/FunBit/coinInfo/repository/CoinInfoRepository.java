package com.jongwon.FunBit.coinInfo.repository;

import com.jongwon.FunBit.coinInfo.model.CoinInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CoinInfoRepository extends JpaRepository<CoinInfo,String> {
}
