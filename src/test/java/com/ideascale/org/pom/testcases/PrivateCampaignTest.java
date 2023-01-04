package com.ideascale.org.pom.testcases;

import com.ideascale.org.pom.basetest.BaseClass;
import com.ideascale.org.pom.pages.HomePage;
import com.ideascale.org.pom.pages.LoginPage;
import com.ideascale.org.pom.pages.PrivateCampaignCrossCheck;
import com.ideascale.org.pom.pages.ProfilePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class PrivateCampaignTest extends BaseClass {
    @FindBy(xpath="//input[@id='login-email']")
    WebElement usernameEl;

    @FindBy(xpath="//input[@id='login-password']")
    WebElement passwordEl;

    @FindBy(xpath="//button[normalize-space()='Log in']")
    WebElement loginBtn;

    @FindBy(xpath="//button[@class='btn btn-primary flex-fill json-link']")
    WebElement acceptCookies;
    ProfilePage profPage;

    LoginPage loginPage;
    HomePage homepage;
    PrivateCampaignCrossCheck pcampaign;

    // create constructor
    public PrivateCampaignTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void initialization() throws IOException, InterruptedException {
        setUp();
        pcampaign = new PrivateCampaignCrossCheck();
        loginPage = new LoginPage();
    }

    @DataProvider(name = "credentials")
    public Object[][] getData() {
        return new Object[][]
                {
                        {"trialqa.ideascale@gmail.com", "brewski01"},
                        {"trialqa1.ideascale@gmail.com", "brewski01"}
                };
    }

    @Test(dataProvider = "credentials")
    // write TEst Case
    public void privateCampaignAnotherAccount(String userEmail, String pass) throws IOException, InterruptedException {
        homepage = loginPage
                .login(userEmail, pass);
        Assert.assertTrue(homepage.homeTitleIsShown());
        System.out.println("Login Passed");

        if ("trialqa.ideascale@gmail.com".equals(userEmail)) {
            pcampaign = pcampaign
                    .clickexpandLink();
            Assert.assertTrue(pcampaign.verifySubmissionForm());
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            System.out.println("List items displayed");
            pcampaign = pcampaign.dropdownPrivate();
            // wait = new WebDriverWait(driver,Duration.ofSeconds(30));
            pcampaign = pcampaign.privatelinkPagefillUp(getTitleName(), getDescription());
            System.out.println("Executed success");
            pcampaign = pcampaign
                    .searchPrivate();
            Assert.assertTrue(pcampaign.verifyCampaign());
        } else {
            Assert.assertFalse(pcampaign.verifyCampaign());
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}