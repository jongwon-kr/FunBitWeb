package com.jongwon.FunBit.repository;

import com.jongwon.FunBit.Entity.Trend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrendRepository extends JpaRepository<Trend, Integer> {
    List<Trend> findByDate(String date);
}
