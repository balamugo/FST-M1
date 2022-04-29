package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass()
    {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://alchemy.hguy.co/lms");
        wait = new WebDriverWait(driver, 10);
        driver.findElement(By.xpath("//*[@id='menu-item-1508']/a")).click();
     }

    @Test
    public void testMethod() {
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title,"All Courses – Alchemy LMS");
        System.out.println(driver.findElements(By.xpath("//*[@class='caption']")).size());
        }
    @AfterClass
    public void tearDown()
    {
        driver.close();
    }
}
