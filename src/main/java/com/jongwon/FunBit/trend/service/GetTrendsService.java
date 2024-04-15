package com.jongwon.FunBit.trend.service;

import com.jongwon.FunBit.coinInfo.CoinInfo;
import com.jongwon.FunBit.trend.Trend;
import io.github.bonigarcia.wdm.WebDriverManager;
import jakarta.transaction.Transactional;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        Actions actions = new Actions(driver);
        WebElement todayElement;
        WebElement selectElement;
        WebElement imgElement;
        String onlyTrendPath = "/html/body/div[3]/div[2]/div/div[2]/div/div[1]/ng-include/div/div/div/div[1]/md-list/feed-item/ng-include";
        todayElement = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div/div[1]/ng-include/div/div/div/div[1]"));
        List<Trend> trends = new ArrayList<>();
        int size = todayElement.getText().split("keyboard_arrow_down").length;
        for (int i = 0; i < size; i++) {
            List<String> trendOption = new ArrayList<>();
            int j = 0;
            if (size == 1) {
                selectElement = todayElement.findElement(By.xpath(onlyTrendPath));
            } else {
                selectElement = todayElement.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div/div[1]/ng-include/div/div/div/div[1]/md-list[" + (i + 1) + "]/feed-item/ng-include"));

            }
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
            String imgLink;
            String articleLink;
            String quot;
            String findLink;
            if (trendOption.get(2).contains("\'")) {
                quot = "\"";
            } else if(trendOption.get(2).contains("\"")){
                quot = "\'";
            }else{
                quot = "\"";

            }
            findLink = quot + trendOption.get(2) + quot;
            if(trendOption.get(2).contains("\"") && trendOption.get(2).contains("\'")){
                quot = "\'";
                findLink = quot+ trendOption.get(2).split("\"")[0]+quot;
            }

            try {
                imgLink = todayElement
                        .findElement(By.xpath("//a[contains(@title, "+findLink+")]"))
                        .findElement(By.xpath("//div[@class='carousel-image-wrapper']"))
                        .findElement(By.tagName("img"))
                        .getAttribute("src");
            } catch (NoSuchElementException e) {
                imgLink = "noimg";
                System.out.println("이미지가 없습니다..");
            }
            articleLink = todayElement
                    .findElement(By.xpath("//a[contains(@title, "+findLink+")]"))
                    .getAttribute("href");
            Trend trend = new Trend();
            LocalDate currentDate = LocalDate.now();

            // 년, 월, 일 한 번에 얻기
            int year = currentDate.getYear();
            int month = currentDate.getMonthValue();
            int day = currentDate.getDayOfMonth();

            // 원하는 형식으로 조합하여 문자열 만들기
            String formattedDate = String.format("%04d-%02d-%02d", year, month, day);

            trend.setSeq(Integer.parseInt(trendOption.get(0)));
            trend.setKeyword(trendOption.get(1));
            trend.setArticle(trendOption.get(2));
            trend.setAgoTime(trendOption.get(3));
            trend.setVolume(trendOption.get(4));
            trend.setDate(formattedDate);
            trend.setArticleLink(articleLink);
            trend.setImgLink(imgLink);
            System.out.println(trend.toString());
            trends.add(trend);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 100);");
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
