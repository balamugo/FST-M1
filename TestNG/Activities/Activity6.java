package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass()
    {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://alchemy.hguy.co/lms");
        wait = new WebDriverWait(driver, 10);
        driver.findElement(By.xpath("//*[@id='menu-item-1507']/a")).click();
        wait = new WebDriverWait(driver, 10);
        driver.findElement(By.xpath("//*[@id='uagb-column-e9d225cb-cee9-4e02-a12d-073d5f051e91']/div[2]/div[2]/a")).click();
        //driver.findElement(By.cssSelector("Login"));

    }

    @Test
   // @Parameters({"username", "password"})
    public void loginTestCase() {
        //Find username and password fields
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title,"My Account – Alchemy LMS");

        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");

        //Click Log in
        driver.findElement(By.id("wp-submit")).click();


        String title1 = driver.getTitle();
        System.out.println("Title is: " + title1);
        Assert.assertEquals(title1,"My Account – Alchemy LMS");
    }
    @AfterClass
    public void tearDown()
    {
        driver.close();
    }
}
