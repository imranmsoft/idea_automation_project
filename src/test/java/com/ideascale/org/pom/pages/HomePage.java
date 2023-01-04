package com.ideascale.org.pom.pages;

import com.ideascale.org.pom.basetest.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends BaseClass {


    @FindBy(xpath="//div[@class='slick-slide slick-active slick-current']//div//div[@class='w-100 px-5 fw-bold h1 d-block text-truncate text-center'][normalize-space()='cleaner-dhaka']")
    WebElement cleanerDhaka;
    @FindBy(xpath="//h1[@id='idea-submission-form']")
    WebElement submissionForm;

    //create constructor of HomePage
    public HomePage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }


//    //click on menu button
   public boolean homeTitleIsShown(){
     return cleanerDhaka.isDisplayed();
   }
}
