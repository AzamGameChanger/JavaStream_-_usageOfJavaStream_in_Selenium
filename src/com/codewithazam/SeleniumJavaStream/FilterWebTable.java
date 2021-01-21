package com.codewithazam.SeleniumJavaStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class FilterWebTable {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/codewithazam/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.id("search-field")).sendKeys("Beans");

        List<WebElement> elements =  driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> element = elements.stream().filter(product-> product.getText().contains("Beans")).collect(Collectors.toList());
        Assert.assertEquals(elements.size(),element.size());
    }
}
