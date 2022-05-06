package liveProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertTrue;

public class Activity8 {
    WebDriver driver;


    @BeforeMethod
    // Open the browser and navigate to LMS portal
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }
    @Test
    public void ContactUs_SendMessage() {
        driver.findElement(By.xpath("//a[@href=\"https://alchemy.hguy.co/lms/contact/\"]")).click();
        boolean All_Courses_title = driver.getTitle().contains("Contact");
        assertTrue(All_Courses_title);
        String AllCourses_title = driver.getTitle();
        System.out.println("Title of Contact Us page is : " + AllCourses_title);
        String Send_Us_Message = driver.findElement(By.xpath("//*[@class=\"uagb-heading-text\" and contains(text(),'Send')]")).getText();
        System.out.println("Send Us message title is : " + Send_Us_Message);
        driver.findElement(By.xpath("//*[@id=\"wpforms-8-field_0\"]")).sendKeys("Avinash Nagesh");
        driver.findElement(By.xpath("//*[@id=\"wpforms-8-field_1\"]")).sendKeys("avinash.n@in.ibm.com");
        driver.findElement(By.xpath("//*[@id=\"wpforms-8-field_3\"]")).sendKeys("This is subject section");
        driver.findElement(By.xpath("//*[@id=\"wpforms-8-field_2\"]")).sendKeys("This is comments section");
        driver.findElement(By.xpath("//*[@id=\"wpforms-submit-8\"]")).click();
        String ContactUs = driver.findElement(By.xpath("//*[@id=\"wpforms-confirmation-8\"]/p")).getText();
        System.out.println(ContactUs);

    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
