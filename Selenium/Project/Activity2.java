package liveProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @BeforeMethod
    // Open the browser and navigate to LMS portal
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void Verify_the_website_heading() {
        String abcd;
        WebElement heading = driver.findElement(By.xpath("//*[contains(text(),'Learn from Industry Experts')]"));
        String headingText = heading.getText();
        System.out.println("Page Heading is: " + headingText);
        Assert.assertEquals("Learn from Industry Experts", headingText);
        try {
            Assert.assertEquals("Learn from Industry Experts", headingText);
        } catch (AssertionError e) {
            System.out.println("Heading Not equal");
            System.out.println("Expected heading : Learn from Industry Experts");
            System.out.println("Actual Title : " + headingText);
            throw e;
        }
        System.out.println("Expected and Actual heading are Equal : " + headingText);
        driver.quit();

    }

    @AfterMethod
    public void afterMethod() {
        // Close the browser
        driver.quit();
    }

}