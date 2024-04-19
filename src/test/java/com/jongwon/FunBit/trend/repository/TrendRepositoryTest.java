package com.jongwon.FunBit.trend.repository;

import com.jongwon.FunBit.repository.TrendRepository;
import com.jongwon.FunBit.Entity.Trend;
import com.jongwon.FunBit.service.GetTrendsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.MalformedURLException;
import java.util.List;

@SpringBootTest
@EnableScheduling
public class TrendRepositoryTest {

    @Autowired
    private TrendRepository repository;

    @Autowired
    private GetTrendsService service;

    @Test
    public void getTrends() throws MalformedURLException {
        List<Trend> trends = service.getTrends();
        repository.deleteAll();
        for (Trend trend : trends) {
            repository.save(trend);
        }
    }
}