package liveProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {
    WebDriver driver;

    @BeforeMethod
    // Open the browser and navigate to LMS portal
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void Verify_the_title_of_the_second_most_popular_course() {
        WebElement SecMostPopularCourse = driver.findElement(By.xpath("(//*[@class=\"entry-title\"])[2]"));
        String SecMostPopularCourseText = SecMostPopularCourse.getText();
        System.out.println("Second Most Popular Course is: " + SecMostPopularCourseText);
        Assert.assertEquals("Email Marketing Strategies", SecMostPopularCourseText);
        try {
            Assert.assertEquals("Email Marketing Strategies", SecMostPopularCourseText);
        } catch (AssertionError e) {
            System.out.println("Second Most Popular Course text are Not equal");
            System.out.println("Expected Second Most Popular Course Text : Email Marketing Strategies");
            System.out.println("Actual Second Most Popular Course Text : " + SecMostPopularCourseText);
            throw e;
        }
        System.out.println("Expected and Actual Second Most Popular Course text are Equal : " + SecMostPopularCourseText);
        driver.quit();

    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
