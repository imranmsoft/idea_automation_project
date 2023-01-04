package com.ideascale.org.pom.pages;

import com.ideascale.org.pom.basetest.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class LoginPage extends BaseClass {
    protected static final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    @FindBy(xpath="//input[@id='login-email']")
    WebElement usernameEl;

    @FindBy(xpath="//input[@id='login-password']")
    WebElement passwordEl;

    @FindBy(xpath="//button[normalize-space()='Log in']")
    WebElement loginBtn;

    @FindBy(xpath="//button[@class='btn btn-primary flex-fill json-link']")
    WebElement acceptCookies;


    //create constructor
    public LoginPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);

    }
    //login parameters
    public HomePage login(String username, String password) throws IOException, InterruptedException {
//       Thread.sleep(10000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary flex-fill json-link']")));
        WebElement cookies=driver.findElement(By.xpath("//button[@class='btn btn-primary flex-fill json-link']"));
        Actions actions=new Actions(driver);
        actions.click(cookies).build().perform();
        Thread.sleep(5000);
        usernameEl.isDisplayed();
        usernameEl.sendKeys(username);
        passwordEl.sendKeys(password);
        loginBtn.click();
        return new HomePage();
    }
}
