package com.ideascale.org.pom.pages;


import com.ideascale.org.pom.basetest.BaseClass;
import com.ideascale.org.pom.utils.TimeOut;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;

import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class ProfilePage extends BaseClass {
    protected static final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);

    @FindBy(xpath="//button[@class='btn-profile-menu shadow-none d-flex align-items-center btn btn-default']")
    WebElement profileLink;
    @FindBy(xpath="//div[@class='slick-slide slick-active slick-current']//div//div[@class='w-100 px-5 fw-bold h1 d-block text-truncate text-center'][normalize-space()='cleaner-dhaka']")
    WebElement cleanerDhaka;

    @FindBy(xpath="//button[normalize-space()='Community Settings']")
    WebElement communitySettingsLink;
    @FindBy(xpath="//h1[normalize-space()='Community Info']")
    WebElement communityInfoPage;
    @FindBy(xpath ="//span[@class='btn btn-submission-entry position-absolute ']")
    WebElement expandlink;
    @FindBy(xpath="//h1[@id='idea-submission-form']")
    WebElement submissionForm;
    @FindBy(xpath="(//span[@class='triangle triangle-down'])[2]")
    WebElement dlink;
    @FindBy(xpath="//div[contains(text(),'Private Campaign')]")
    WebElement privateLink;
    @FindBy(xpath ="//input[@id='title']")
    WebElement titlename;
    @FindBy(xpath ="//div[@id='text']//div[@class='ql-editor ql-blank']")
    WebElement descrip;
    @FindBy(xpath="//i[@data-checked-text='ON']")
    WebElement blinkOn;
    @FindBy(xpath="//button[normalize-space()='Submit']")
    WebElement submitBtnpvtLink;
    @FindBy(xpath="//button[@title='Moderate Idea']")
    WebElement moderateIcon;
    @FindBy(xpath="//button[normalize-space()='Change Stage']")
    WebElement changeStg;
    @FindBy(xpath="//button[@title='Set Idea State to Refine']")
    WebElement refinebtn;
    @FindBy(xpath="//h2[normalize-space()='Refine']")
    WebElement refinetxtVerify;
    @FindBy(xpath="//a[normalize-space()='view Refine']")
    WebElement viewRefineLink;
    //@FindBy(xpath="(//header/h2/a[@title='privateCam'])[1]")
    @FindBy(xpath="(//span[@aria-hidden='true'][normalize-space()='Refine'])[1]")
    WebElement refinelink;
    @FindBy(xpath="//div[@data-placeholder=\"Enter text\"]")
    WebElement refinetxtbox;
    @FindBy(xpath="(//button[contains(@type,'submit')][normalize-space()='Save Answer'])[1]")
    WebElement submittitle;
    @FindBy(xpath="(//input[@class='form-control form-control input'])[1]")
    WebElement dateinput;
    @FindBy(xpath="//div[@class='dayContainer']/span[contains(text(),'10')][1]")
    WebElement dateactive;
    @FindBy(xpath="(//button[@type='submit'][normalize-space()='Save Answer'])[1]")
    WebElement dateSave;
    @FindBy(xpath="(//div[contains(@class,'ideascale-select__indicator ideascale-select__dropdown-indicator css-tlfecz-indicatorContainer')])[2]")
    WebElement singlechoicedlink;
    @FindBy(xpath="//div[contains(text(),'Chattogram')]")
    WebElement singlechoicectg;
    @FindBy(xpath="(//input[@placeholder='Search'])[1]")
    WebElement searchtext;
    @FindBy(xpath="//button[@class=\"btn btn-primary px-1 btn-search-with-icon\"]")
    WebElement searchIcon;
    @FindBy(xpath="//button[@title='Sort By']")
    WebElement recentCampaignDown;
    @FindBy(xpath="//div[@class=\"dropdown-menu show\"]/button[contains(text(),'Recent')]")
    WebElement recentListShow;
    @FindBy(xpath="(//button[@type='submit'][normalize-space()='Save Answer'])[3]")
    WebElement singleChoiseSave;

    //create construction and initiate
    public ProfilePage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }


    //click on Profile Link
    public ProfilePage clickProfileLink(){
        try {
            fluentwait.until(ExpectedConditions.elementToBeClickable(profileLink));
            profileLink.click();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SkipException("Element not found or ready for clicking...", e);
        }
        return this;
    }

    public void clickCommunitySettingsLink() throws InterruptedException {
        try {
            fluentwait.until(ExpectedConditions.elementToBeClickable(communitySettingsLink));
            communitySettingsLink.click();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SkipException("Element not found or ready for clicking...", e);
        }

        Set<String> windows = driver.getWindowHandles();

        int counter = 1;
        for (String childwindow : windows) {
            if(!windows.equals(childwindow)){
                driver.switchTo().window(childwindow);
                break;
            }
            counter++;
        }


    }

    public ProfilePage clickexpandLink(){
        try {
            fluentwait.until(ExpectedConditions.elementToBeClickable(expandlink));
            expandlink.click();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SkipException("Element not found or ready for clicking...", e);
        }
        return this;
    }

    public boolean verifySubmissionForm(){
        try {
            fluentwait.until(ExpectedConditions.visibilityOf(submissionForm));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public ProfilePage dropdownPrivate() throws InterruptedException {
        try {
            fluentwait.until(ExpectedConditions.elementToBeClickable(dlink));
            dlink.click();
            fluentwait.until(ExpectedConditions.elementToBeClickable(privateLink));
            privateLink.click();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SkipException("Element not found or ready for clicking...", e);
        }
        return this;
    }

    public ProfilePage privatelinkPagefillUp(String title, String des) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(titlename));
        titlename.clear();
        titlename.sendKeys(title);
        wait.until(ExpectedConditions.elementToBeClickable(descrip));
        descrip.clear();
        descrip.sendKeys(des);
       try {
           fluentwait.until(ExpectedConditions.elementToBeClickable(blinkOn));
            blinkOn.click();
       } catch (Exception e) {
            e.printStackTrace();
           throw new SkipException("Element not found or ready for clicking...", e);
       }
        wait.until(ExpectedConditions.elementToBeClickable(submitBtnpvtLink));
        submitBtnpvtLink.click();
        return this;

    }

    public ProfilePage searchPrivate(){
        wait.until(ExpectedConditions.elementToBeClickable(recentCampaignDown));
        recentCampaignDown.click();
        try {
            fluentwait.until(ExpectedConditions.elementToBeClickable(recentListShow));
            recentListShow.click();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SkipException("Element not found or ready for clicking...", e);
        }
        driver.navigate().refresh();
        return this;

    }
    //click on Moderate Link
    public ProfilePage clickModerateIdea(){
        try {
            fluentwait.until(ExpectedConditions.elementToBeClickable(moderateIcon));
            moderateIcon.click();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SkipException("Element not found or ready for clicking...", e);
        }

        wait.until(ExpectedConditions.elementToBeClickable(changeStg));
        changeStg.click();
        wait.until(ExpectedConditions.elementToBeClickable(refinebtn));
        refinebtn.click();
        return this;
    }

      //refine Stage Activities
      public boolean refinePageActivities() throws InterruptedException {
          wait.until(ExpectedConditions.elementToBeClickable(viewRefineLink));
          viewRefineLink.click();
          searchPrivate();
          wait.until(ExpectedConditions.elementToBeClickable(refinelink));
          refinelink.click();

              return false;

      }

      public ProfilePage refineBoxFillUp() throws InterruptedException {
         driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).click();
          wait.until(ExpectedConditions.elementToBeClickable(refinetxtbox));
          refinetxtbox.sendKeys("Idea title-1");
          wait.until(ExpectedConditions.elementToBeClickable(submittitle));
          submittitle.click();
          wait.until(ExpectedConditions.elementToBeClickable(dateinput));
          dateinput.click();
          wait.until(ExpectedConditions.elementToBeClickable(dateactive));
          dateactive.click();
          wait.until(ExpectedConditions.elementToBeClickable(dateSave));
          dateSave.click();
          wait.until(ExpectedConditions.elementToBeClickable(singlechoicedlink));
          singlechoicedlink.click();
          wait.until(ExpectedConditions.elementToBeClickable(singlechoicectg));
          singlechoicectg.click();
          TimeOut.waitForDomStable();
          driver.findElement(By.xpath("//div[@class=\"text-end\"]/button[@type='submit']")).click();
          return  this;


      }


}