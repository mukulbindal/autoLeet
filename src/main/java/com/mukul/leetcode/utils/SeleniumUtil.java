package com.mukul.leetcode.utils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SeleniumUtil {
//	public static void main(String[] args) {
//		try{
//			submit();
//		} catch(Exception e) {
//			
//		}
//	}
	@Scheduled(cron = "0 0 10,15/12 * * ?")
	public static void submit() throws Exception{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		
		driver.get("https://leetcode.com/");
		
		driver.findElement(By.xpath("//*[@id=\"landing-page-app\"]/div/div[1]/div[3]/div[1]/div/div/div[2]/div/a[5]/span")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"id_login\"]"))
		.sendKeys("mukul_bindal");
		driver.findElement(By.xpath("//*[@id=\"id_password\"]"))
		.sendKeys("Mukul@123");
		
		driver.findElement(By.xpath("//*[@id=\"signin_btn\"]/div"))
		.click();
		Thread.sleep(5000);
		
		WebElement fire = 
		driver.findElement(By.xpath("//*[@id=\"navbar-right-container\"]/div[3]/a"));//.click();
		
		System.out.println(fire.getAttribute("href"));
		if(fire.getAttribute("href")==null) {
			System.out.println("Already submitted, hence breaking");
			return ;
		}
		Thread.sleep(10000);
		
//		WebElement codeArea = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div/div[3]/div/div[1]/div/div[2]/div[1]/div/div[6]/div[1]/div/div"));
//		codeArea.click();
//		codeArea.sendKeys(Keys.CONTROL + "A");
//		codeArea.sendKeys(Keys.BACK_SPACE);
		
		driver.get("https://leetcode.com/praknew01/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/div[5]/div/div/div[2]/a[1]"))
		.click();
		Thread.sleep(10000);
		ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
	      //switch to active tab
	      driver.switchTo().window(wid.get(1));
		driver.findElement(By.xpath("//*[@id=\"edit-code-btn\"]")).click();
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div/div[3]/div/div[3]/div[2]/div/button/span")).click();
		Thread.sleep(20000);
		driver.close();
																																							
		
	}
}
