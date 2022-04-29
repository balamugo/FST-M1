package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass()
    {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://alchemy.hguy.co/lms");
        wait = new WebDriverWait(driver, 10);
        driver.findElement(By.xpath("//*[@id='menu-item-1506']/a")).click();
    }

    @Test
   // @Parameters({"username", "password"})
    public void contat() {
        //Find username and password fields
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title,"Contact – Alchemy LMS");

        driver.findElement(By.id("wpforms-8-field_0")).sendKeys("Balamurugan");
        driver.findElement(By.id("wpforms-8-field_1")).sendKeys("balamugo@in.ibm.com");
        driver.findElement(By.id("wpforms-8-field_3")).sendKeys("Testing");
        driver.findElement(By.id("wpforms-8-field_2")).sendKeys("Testing message");

        //Click submit button
        driver.findElement(By.id("wpforms-submit-8")).click();

        String title1 = driver.findElement(By.id("wpforms-confirmation-8")).getText();
        System.out.println("Title is: " + title1);
    }
    @AfterClass
    public void tearDown()
    {
        driver.close();
    }
}
