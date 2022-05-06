package liveProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;

    @BeforeMethod
    // Open the browser and navigate to LMS portal
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void Verify_the_website_title() {
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertEquals("Alchemy LMS – An LMS Application", title);
        try {
            Assert.assertEquals("Alchemy LMS – An LMS Application", title);
        } catch (AssertionError e) {
            System.out.println("Title Not equal");
            System.out.println("Expected Title : Alchemy LMS – An LMS Application xyz ");
            System.out.println("Actual Title : " + title);
            throw e;
        }
        System.out.println("Expected and Actual titles are Equal : " + title);
        driver.quit();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}