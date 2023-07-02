package com.mukul.leetcode.config;

import java.io.File;
import java.net.URL;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

@Configuration
public class DriverConfig {
	private final String driverName = "chromedriver";
	@Bean
	public void configDriver() throws Exception{
        URL resource = ResourceUtils.getURL("classpath:drivers/"+driverName);
        File f = new File("Driver");
        if (!f.exists()) {
            f.mkdirs();
        }
        File chromeDriver = new File("Driver" + File.separator + driverName);
        if (chromeDriver.exists()) {
        	chromeDriver.delete();
        }
        if (!chromeDriver.exists()) {
            chromeDriver.createNewFile();
            org.apache.commons.io.FileUtils.copyURLToFile(resource, chromeDriver);
        }
        System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
        System.out.println("Created driver at ::"+chromeDriver.getAbsolutePath());
	}
}
