package com.ideascale.org.pom.basetest;

import com.ideascale.org.pom.utils.TimeOut;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {

    protected static WebDriver driver;
    private Properties properties;


    //create constructor

    public BaseClass() throws IOException {
        try {
            properties = new Properties();
            String filePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
            FileInputStream inputStream = null;
            inputStream = new FileInputStream(filePath);
            properties.load(inputStream);


        }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }catch(IOException e){
            throw new RuntimeException();
        }
    }

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //get url from properties file
        driver.get(properties.getProperty("baseUrl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeOut.PAGE_WAIT_TIME));
    }

    //properties file private so getter method
    public String getUserName(){return properties.getProperty("username");}
    public String getPassword(){return properties.getProperty("password");}
    public String getTitleName(){return properties.getProperty("title");}
    public String getDescription(){return properties.getProperty("desc");}
    public String getIdeatitleBox(){return properties.getProperty("titlebox");}
    public String getSearchText(){return properties.getProperty("stext");}
    public String getUserName1(){return properties.getProperty("username1");}

    }
