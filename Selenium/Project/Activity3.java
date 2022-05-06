package liveProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;

    @BeforeMethod
    // Open the browser and navigate to LMS portal
    public void beforeMethod() {
        // Open the browser and navigate to LMS portal
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void Verify_the_title_of_the_first_info_box() {
        WebElement firstinfobox = driver.findElement(By.xpath("(//*[@class=\"uagb-ifb-title\"])[2]"));
        String firstinfoboxText = firstinfobox.getText();
        System.out.println("Page firstinfobox is: " + firstinfoboxText);
        Assert.assertEquals("Actionable Training", firstinfoboxText);
        try {
            Assert.assertEquals("Actionable Training", firstinfoboxText);
        } catch (AssertionError e) {
            System.out.println("first info box Not equal");
            System.out.println("Expected first info box Text : Actionable Training");
            System.out.println("Actual first info box Text : " + firstinfoboxText);
            throw e;
        }
        System.out.println("Expected and Actual first info box text are Equal : " + firstinfoboxText);
        driver.quit();

    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}