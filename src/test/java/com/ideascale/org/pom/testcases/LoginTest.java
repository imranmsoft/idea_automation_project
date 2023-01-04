package com.ideascale.org.pom.testcases;

import com.ideascale.org.pom.basetest.BaseClass;
import com.ideascale.org.pom.pages.LoginPage;
import com.ideascale.org.pom.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseClass {
    //instance variables
    LoginPage loginPage;
    HomePage homepage;
    public LoginTest() throws IOException {
        super();
    }
    @BeforeMethod
    public void initialization() throws IOException {
        setUp();
        loginPage=new LoginPage();
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
    public void loginWithValidCredentials(String userEmail, String pass) throws IOException, InterruptedException {
        homepage = loginPage
                .login(userEmail, pass);
        Assert.assertTrue(homepage.homeTitleIsShown());
        System.out.println("Login Passed");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
