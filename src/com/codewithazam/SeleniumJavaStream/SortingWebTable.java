package com.codewithazam.SeleniumJavaStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class SortingWebTable {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/codewithazam/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.xpath("//tr/th[1]")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> originalList = elements.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<String> newList = originalList.stream().sorted().collect(Collectors.toList());

        Assert.assertTrue(originalList.equals(newList));

        List<String> price;
        do {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPrice(s)).collect(Collectors.toList());
            price.forEach(System.out::println);
            if (price.size() < 1) {
                driver.findElement(By.xpath("//*[@id='root']/div/div/div/div/div/div/div/div[2]/ul/li[6]/a")).click();
            }
        } while (price.size() < 1);
    }

    private static String getPrice(WebElement s) {
        String tag = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return tag;
    }
}
