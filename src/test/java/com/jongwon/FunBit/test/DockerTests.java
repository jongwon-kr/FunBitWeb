package com.jongwon.FunBit.test;

import com.jongwon.FunBit.trend.Trend;
import com.jongwon.FunBit.trend.service.GetTrendsService;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DockerTests {

    @Autowired
    private GetTrendsService service;

    @Test
    public void nameTest() throws RuntimeException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");


        WebDriver driver = new RemoteWebDriver(new URL(" http://localhost:4444"), capabilities);

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
        }
    }

}

