package liveProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass()
    {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
     public void testMethod() {
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title,"Alchemy LMS – An LMS Application");
    }
    @AfterClass
    public void tearDown()
    {
        driver.close();
    }
}
