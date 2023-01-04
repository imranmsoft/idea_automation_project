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

public class PrivateCampaignCrossCheck extends BaseClass {
    protected static final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);

    @FindBy(xpath = "//button[@class='btn-profile-menu shadow-none d-flex align-items-center btn btn-default']")
    WebElement profileLink;
    @FindBy(xpath = "//div[@class='slick-slide slick-active slick-current']//div//div[@class='w-100 px-5 fw-bold h1 d-block text-truncate text-center'][normalize-space()='cleaner-dhaka']")
    WebElement cleanerDhaka;

    @FindBy(xpath = "//button[normalize-space()='Community Settings']")
    WebElement communitySettingsLink;
    @FindBy(xpath = "//h1[normalize-space()='Community Info']")
    WebElement communityInfoPage;
    @FindBy(xpath = "//span[@class='btn btn-submission-entry position-absolute ']")
    WebElement expandlink;
    @FindBy(xpath = "//h1[@id='idea-submission-form']")
    WebElement submissionForm;
    @FindBy(xpath = "(//span[@class='triangle triangle-down'])[2]")
    WebElement dlink;
    @FindBy(xpath = "//div[contains(text(),'Private Campaign')]")
    WebElement privateLink;
    @FindBy(xpath = "//input[@id='title']")
    WebElement titlename;
    @FindBy(xpath = "//div[@id='text']//div[@class='ql-editor ql-blank']")
    WebElement descrip;
    @FindBy(xpath = "//i[@data-checked-text='ON']")
    WebElement blinkOn;
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement submitBtnpvtLink;
    @FindBy(xpath = "//button[@title='Moderate Idea']")
    WebElement moderateIcon;
    @FindBy(xpath = "//button[normalize-space()='Change Stage']")
    WebElement changeStg;
    @FindBy(xpath = "//button[@title='Set Idea State to Refine']")
    WebElement refinebtn;
    @FindBy(xpath = "//h2[normalize-space()='Refine']")
    WebElement refinetxtVerify;
    @FindBy(xpath = "//a[normalize-space()='view Refine']")
    WebElement viewRefineLink;
    //@FindBy(xpath="(//header/h2/a[@title='privateCam'])[1]")
    @FindBy(xpath = "(//span[@aria-hidden='true'][normalize-space()='Refine'])[1]")
    WebElement refinelink;
    @FindBy(xpath = "//div[@data-placeholder=\"Enter text\"]")
    WebElement refinetxtbox;
    @FindBy(xpath = "(//button[contains(@type,'submit')][normalize-space()='Save Answer'])[1]")
    WebElement submittitle;
    @FindBy(xpath = "(//input[@class='form-control form-control input'])[1]")
    WebElement dateinput;
    @FindBy(xpath = "//div[@class='dayContainer']/span[contains(text(),'10')][1]")
    WebElement dateactive;
    @FindBy(xpath = "(//button[@type='submit'][normalize-space()='Save Answer'])[1]")
    WebElement dateSave;
    @FindBy(xpath = "(//div[contains(@class,'ideascale-select__indicator ideascale-select__dropdown-indicator css-tlfecz-indicatorContainer')])[2]")
    WebElement singlechoicedlink;
    @FindBy(xpath = "//div[contains(text(),'Chattogram')]")
    WebElement singlechoicectg;
    @FindBy(xpath = "(//input[@placeholder='Search'])[1]")
    WebElement searchtext;
    @FindBy(xpath = "//button[@class=\"btn btn-primary px-1 btn-search-with-icon\"]")
    WebElement searchIcon;
    @FindBy(xpath = "//button[@title='Sort By']")
    WebElement recentCampaignDown;
    @FindBy(xpath = "//div[@class=\"dropdown-menu show\"]/button[contains(text(),'Recent')]")
    WebElement recentListShow;
    @FindBy(xpath = "(//button[@type='submit'][normalize-space()='Save Answer'])[3]")
    WebElement singleChoiseSave;
    @FindBy(xpath="(//a[@title='privateCampaign'][normalize-space()='privateCampaign'])[1]")
    WebElement campaignVerify;
    @FindBy(xpath="//input[@id='login-email']")
    WebElement usernameEl;

    @FindBy(xpath="//input[@id='login-password']")
    WebElement passwordEl;

    @FindBy(xpath="//button[normalize-space()='Log in']")
    WebElement loginBtn;

    @FindBy(xpath="//button[@class='btn btn-primary flex-fill json-link']")
    WebElement acceptCookies;

    //create construction and initiate
    public PrivateCampaignCrossCheck() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }


    public PrivateCampaignCrossCheck clickexpandLink(){
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

    public PrivateCampaignCrossCheck dropdownPrivate() throws InterruptedException {
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

    public PrivateCampaignCrossCheck privatelinkPagefillUp(String title, String des) throws InterruptedException {
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

    public PrivateCampaignCrossCheck searchPrivate(){
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

    public boolean verifyCampaign(){
        try {
            fluentwait.until(ExpectedConditions.visibilityOf(campaignVerify));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //login to other account

    /*public HomePage login(String usernameone, String password) throws IOException, InterruptedException {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary flex-fill json-link']")));
        WebElement cookies=driver.findElement(By.xpath("//button[@class='btn btn-primary flex-fill json-link']"));
        Actions actions=new Actions(driver);
        actions.click(cookies).build().perform();
        usernameEl.isDisplayed();
        usernameEl.sendKeys(usernameone);
        passwordEl.sendKeys(password);
        loginBtn.click();
        return  new HomePage();


    }*/
}