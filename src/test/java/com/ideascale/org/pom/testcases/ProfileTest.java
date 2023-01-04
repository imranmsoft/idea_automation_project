package com.ideascale.org.pom.testcases;

import com.ideascale.org.pom.basetest.BaseClass;
import com.ideascale.org.pom.pages.HomePage;
import com.ideascale.org.pom.pages.LoginPage;
import com.ideascale.org.pom.pages.ProfilePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

public class ProfileTest extends BaseClass {
    ProfilePage profPage;

    LoginPage loginPage;
    HomePage homepage;

    // create constructor
    public ProfileTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void initialization() throws IOException, InterruptedException {

        setUp();
        homepage = new LoginPage()
                .login(getUserName(), getPassword());
        profPage = new ProfilePage();

    }


    @Test()
    // write TEst Case
    public void verifyCommunitySettingsPage() throws IOException, InterruptedException {
        profPage = profPage.clickexpandLink();
        Assert.assertTrue(profPage.verifySubmissionForm());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        System.out.println("List items displayed");
        profPage = profPage.dropdownPrivate();
        // wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        profPage = profPage.privatelinkPagefillUp(getTitleName(), getDescription());

        System.out.println("Executed success");

        profPage=profPage
                .searchPrivate();

        profPage=profPage
                .clickModerateIdea();

        profPage
                .refinePageActivities();

        profPage=profPage
                .refineBoxFillUp();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}