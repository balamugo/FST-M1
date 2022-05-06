package liveProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class Activity5 {
    WebDriver driver;

    @BeforeMethod
    // Open the browser and navigate to LMS portal
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void Validate_My_Account_page_title() {
        driver.findElement(By.xpath("//a[text()='My Account']")).click();
        boolean MyAccount_title = driver.getTitle().contains("My Account");
        assertTrue(MyAccount_title);
        String MyAccountTitle = driver.getTitle();
        System.out.println("Title of My Account page is : " + MyAccountTitle);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
