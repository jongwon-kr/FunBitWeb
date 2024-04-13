package com.jongwon.FunBit.trend;

import com.jongwon.FunBit.trend.repository.TrendRepository;
import com.jongwon.FunBit.trend.service.GetTrendsService;
import com.jongwon.FunBit.trend.service.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrendJpaController {

    private TrendRepository trendRepository;
    private GetTrendsService getTrendsService;
    private TrendService trendService;

    @Autowired
    public TrendJpaController(TrendRepository trendRepository, GetTrendsService getTrendsService, TrendService trendService) {
        this.trendRepository = trendRepository;
        this.getTrendsService = getTrendsService;
        this.trendService = trendService;
    }

    @GetMapping("/fetch/get-trends")
    public String getTrends() {
        List<Trend> trends = getTrendsService.getTrends();
        for (Trend trend : trends) {
            trendRepository.save(trend);
        }
        return "Trends 불러오기 완료";
    }

    @GetMapping("/get-trends/{date}")
    public List<Trend> getTodayTrends(@PathVariable String date) {
        return trendRepository.findByDate(date);
    }
}
