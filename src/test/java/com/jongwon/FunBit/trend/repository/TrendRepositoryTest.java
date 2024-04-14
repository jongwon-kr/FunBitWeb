package com.jongwon.FunBit.trend.repository;

import com.jongwon.FunBit.trend.Trend;
import com.jongwon.FunBit.trend.service.GetTrendsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
public class TrendRepositoryTest {

    @Autowired
    private TrendRepository repository;

    @Autowired
    private GetTrendsService service;

    @Test
    public void getTrends(){
        repository.deleteAll();
        List<Trend> trends = service.getTrends();
        for (Trend trend : trends) {
            repository.save(trend);
        }
    }
}