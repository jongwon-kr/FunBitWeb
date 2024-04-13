package com.jongwon.FunBit.coinInfo.service;

import com.jongwon.FunBit.coinInfo.CoinInfo;
import com.jongwon.FunBit.coinInfo.repository.CoinInfoRepository;
import io.github.bonigarcia.wdm.WebDriverManager;

import jakarta.transaction.Transactional;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Service
public class GetCoinInfoService {

    private CoinInfoRepository coinInfoRepository;

    private static List<CoinInfo> coinInfos = new ArrayList<>();

    // 거래소 코인 리스트
    public static JSONArray getCoinList() throws IOException {
        URL url = new URL("https://api.upbit.com/v1/market/all");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestProperty("Content-Type", "application/json");

        con.setRequestMethod("GET");
        con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(response.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

    @Transactional
    // 코인 정보 리스트
    public static List<CoinInfo> getCoinInfos() {
        ChromeDriver driver;
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");            // 전체화면으로 실행
        options.addArguments("--disable-popup-blocking");    // 팝업 무시
        options.addArguments("--disable-default-apps");     // 기본앱 사용안함
        options.addArguments("--lang=ko-KR");
        driver = new ChromeDriver(options);

        try {
            JSONArray coinList = getCoinList();
            int size = coinList.length();
            for (int i = 0; i < size; i++) {

                JSONObject jsonObject = coinList.getJSONObject(i);
                String market = jsonObject.getString("market");

                driver.get("https://upbit.com/exchange?code=CRIX.UPBIT." + market);
                String title = driver.getTitle();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                List<WebElement> webElementList = new ArrayList<>();
                webElementList = driver.findElements(By.partialLinkText("정보"));

                WebElement element = webElementList.get(0);
                element.click();
                //페이지 이동

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                List<WebElement> titleList = new ArrayList<>();
                List<String> infos = new ArrayList<>();
                titleList = driver.findElements(By.className("coinInfo__info__desc"));

                if (titleList == null) {
                    System.out.println("null");
                } else {
                    for (WebElement tele : titleList) {
                        if (tele == null) {
                            System.out.println("null");
                        } else {
                            System.out.println("webElement.getText() = " + tele.getText());
                            infos.add(tele.getText());
                        }
                    }
                }
                coinInfos.add(new CoinInfo(market, infos.get(0), infos.get(1), infos.get(2)));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        return coinInfos;
    }

    @Transactional
    public CoinInfo getCoinInfo(String market) {
        ChromeDriver driver;
        WebDriverManager.chromedriver().setup();

        CoinInfo coinInfo;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");            // 전체화면으로 실행
        options.addArguments("--disable-popup-blocking");    // 팝업 무시
        options.addArguments("--disable-default-apps");     // 기본앱 사용안함
        options.addArguments("--lang=ko-KR");
        driver = new ChromeDriver(options);

        driver.get("https://upbit.com/exchange?code=CRIX.UPBIT." + market);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> webElementList = new ArrayList<>();
        webElementList = driver.findElements(By.partialLinkText("정보"));

        WebElement element = webElementList.get(0);
        element.click();
        //페이지 이동

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<WebElement> titleList = new ArrayList<>();
        List<String> infos = new ArrayList<>();
        titleList = driver.findElements(By.className("coinInfo__info__desc"));

        if (titleList == null) {
            System.out.println("null");
        } else {
            for (WebElement tele : titleList) {
                if (tele == null) {
                    System.out.println("null");
                } else {
                    System.out.println("webElement.getText() = " + tele.getText());
                    infos.add(tele.getText());
                }
            }
        }
        coinInfo = new CoinInfo(market, infos.get(0), infos.get(1), infos.get(2));
        driver.quit();
        return coinInfo;
    }
}