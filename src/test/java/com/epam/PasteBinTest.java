package com.epam;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PasteBinTest {
 WebDriver driver;

 @Before
 public void setUp() {
  WebDriverManager.chromedriver().setup();
  driver = new ChromeDriver();
  driver.manage().window().maximize();
 }

 @Test
 public void newPaste() throws InterruptedException {
  driver.get("https://pastebin.com");
  Thread.sleep(1000);

  String title = driver.getTitle();
  System.out.println(title);

  WebElement newPaste = driver.findElement(By.id("postform-text"));
  newPaste.sendKeys("Hello from WebDriver");


  JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
  javascriptExecutor.executeScript("window.scrollBy(0,350)", "");

  WebElement pasteExpiration = driver.findElement(By.id("select2-postform-expiration-container"));
  pasteExpiration.click();

  driver.findElement(By.xpath("//span[@class='select2-results']/ul/li[3]")).click();
  //driver.findElement(By.xpath("//*[@id=\"select2-postform-expiration-result-iwwa-10M\"]")).click();


  WebElement pasteName = driver.findElement(By.id("postform-name"));
  pasteName.sendKeys("hello web");

 }

}


