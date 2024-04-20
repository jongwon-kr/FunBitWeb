package com.jongwon.FunBit.controller;

import com.jongwon.FunBit.Entity.Trend;
import com.jongwon.FunBit.repository.TrendRepository;
import com.jongwon.FunBit.service.GetTrendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.util.List;

@RestController
@EnableScheduling
public class TrendJpaController {

    private TrendRepository trendRepository;
    private GetTrendsService getTrendsService;

    @Autowired
    public TrendJpaController(TrendRepository trendRepository, GetTrendsService getTrendsService) {
        this.trendRepository = trendRepository;
        this.getTrendsService = getTrendsService;
    }

    @GetMapping("/trend/fetch")
    @Scheduled(cron = "0 10 0/1 * * *")
    public String getTrends() throws MalformedURLException {
        List<Trend> trends = getTrendsService.getTrends();
        trendRepository.deleteAll();
        for (Trend trend : trends) {
            trendRepository.save(trend);
        }
        return "Trends 불러오기 완료";
    }

    @GetMapping("/trend/{date}")
    public List<Trend> getTodayTrends(@PathVariable String date) {
        return trendRepository.findByDate(date);
    }
}
