package liveProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class Activity6 {
    WebDriver driver;
    String username = "root";
    String password = "pa$$w0rd";

    @BeforeMethod
    // Open the browser and navigate to LMS portal
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void Validate_Login() {
        driver.findElement(By.xpath("//a[text()='My Account']")).click();
        boolean MyAccount_title = driver.getTitle().contains("My Account");
        assertTrue(MyAccount_title);
        String MyAccountTitle = driver.getTitle();
        System.out.println("Title of My Account page is : " + MyAccountTitle);
        driver.findElement(By.className("ld-login")).click();
        driver.findElement(By.id("user_login")).sendKeys(username);
        driver.findElement((By.name("pwd"))).sendKeys(password);
        driver.findElement(By.id("wp-submit")).click();
        driver.findElement(By.className("display-name")).isDisplayed();
        String DisplayName = driver.findElement(By.className("display-name")).getText();
        System.out.println("The logged-in display name is : " + DisplayName);
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
