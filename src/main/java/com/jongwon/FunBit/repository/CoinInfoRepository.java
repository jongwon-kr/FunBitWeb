package com.jongwon.FunBit.repository;

import com.jongwon.FunBit.Entity.CoinInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CoinInfoRepository extends JpaRepository<CoinInfo,String> {
}
