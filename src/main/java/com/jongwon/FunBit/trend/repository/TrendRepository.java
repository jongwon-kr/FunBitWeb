package com.jongwon.FunBit.trend.repository;

import com.jongwon.FunBit.trend.Trend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrendRepository extends JpaRepository<Trend, Integer> {
    List<Trend> findByDate(String date);
}
