package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static java.time.Duration.*;
import static org.example.Input.song;

public class Base {

    public  static void initiateBrowser() throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(15));

        driver.get("https://music.youtube.com/");
        driver.findElement(By.id("icon")).click(); //search button
        driver.findElement(By.xpath("//input[@id='input']")).sendKeys(song); // enters song
        driver.findElement(By.xpath("//input[@id='input']")).sendKeys(Keys.ENTER); // press enter key
        driver.findElement(By.cssSelector("div[id=actions]>:nth-child(1)")).click(); //play button

        List<WebElement> dynamicElement = driver.findElements(By.xpath("//*[@id='ad-text:6']"));
        if(dynamicElement.size() != 0){
            //If list size is non-zero, element is present
            System.out.println("Ad Skipped");
            Thread.sleep(5000); // add wait time
            driver.findElement(By.xpath("//*[@id='ad-text:6']")).click(); // ads button

        }
        else{
            //Else if size is 0, then element is not present
            System.out.println("No ads played or Unskippable ads");
        }

        driver.manage().window().minimize();

    }

}
