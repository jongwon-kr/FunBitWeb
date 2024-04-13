package com.jongwon.FunBit.trend.service;

import com.jongwon.FunBit.coinInfo.CoinInfo;
import com.jongwon.FunBit.trend.Trend;
import io.github.bonigarcia.wdm.WebDriverManager;
import jakarta.transaction.Transactional;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GetTrendsService {

    private static int todosCount = 0;

    @Transactional
    public List<Trend> getTrends() {
        ChromeDriver driver;
        WebDriverManager.chromedriver().setup();

        CoinInfo coinInfo;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");            // 전체화면으로 실행
        options.addArguments("--disable-popup-blocking");    // 팝업 무시
        options.addArguments("--disable-default-apps");     // 기본앱 사용안함
        options.addArguments("--lang=ko-KR");
        driver = new ChromeDriver(options);

        driver.get("https://trends.google.co.kr/trends/trendingsearches/daily?geo=KR&hl=ko");
        WebElement todayElement;
        WebElement selectElement;
        WebElement imgElement;
        todayElement = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div/div[1]/ng-include/div/div/div/div[1]"));
        String date = todayElement.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div/div[1]/ng-include/div/div/div/div[1]/div")).getText().split("\n")[0];
        List<Trend> trends = new ArrayList<>();
        int size = todayElement.getText().split("keyboard_arrow_down").length;
        for (int i = 0; i < size; i++) {
            List<String> trendOption = new ArrayList<>();
            int j = 0;
            selectElement = todayElement.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div/div[1]/ng-include/div/div/div/div[1]/md-list[" + (i + 1) + "]/feed-item/ng-include"));
            for (String s : selectElement.getText().split("\n")) {
                if (j < 5) {
                    trendOption.add(s);
                }
                j++;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            selectElement.click();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String imgLink = todayElement
                    .findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div/div[1]/ng-include/div/div/div/div[1]/md-list["
                            + (i + 1)
                            + "]/feed-item/ng-include/div/ng-include/div/feed-item-carousel/div/div[2]/div/ng-transclude/a[1]/div/div[1]/img"))
                    .getAttribute("src");
            trendOption.add(imgLink);
            String articleLink = todayElement
                    .findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div/div[1]/ng-include/div/div/div/div[1]/md-list["
                            + (i + 1)
                            + "]/feed-item/ng-include/div/ng-include/div/feed-item-carousel/div/div[2]/div/ng-transclude/a[1]\n"))
                    .getAttribute("href");
            trendOption.add(articleLink);
            for (String s : trendOption) {
                System.out.println("ssssssss = " + s);
            }
            trends.add(new Trend(todosCount++, Integer.parseInt(trendOption.get(0)), date, trendOption.get(1), trendOption.get(2), trendOption.get(3),
                    trendOption.get(4), trendOption.get(5), trendOption.get(6)));
            selectElement.click();
        }


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //페이지 이동
        driver.quit();
        return trends;
    }
}
