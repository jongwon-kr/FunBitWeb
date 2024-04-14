package com.jongwon.FunBit.trend.repository;

import com.jongwon.FunBit.trend.Trend;
import com.jongwon.FunBit.trend.service.GetTrendsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@EnableScheduling
public class TrendRepositoryTest {

    @Autowired
    private TrendRepository repository;

    @Autowired
    private GetTrendsService service;

    @Test
    public void getTrends(){
        List<Trend> trends = service.getTrends();
        repository.deleteAll();
        for (Trend trend : trends) {
            repository.save(trend);
        }
    }
}