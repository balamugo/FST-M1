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

public class Activity7 {
    WebDriver driver;

    @BeforeMethod
    // Open the browser and navigate to LMS portal
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }
    @Test
    public void All_Courses_Count() {
        driver.findElement(By.xpath("//a[@href=\"https://alchemy.hguy.co/lms/all-courses/\"]")).click();
        boolean All_Courses_title = driver.getTitle().contains("All Courses");
        assertTrue(All_Courses_title);
        String AllCourses_title = driver.getTitle();
        System.out.println("Title of All Courses page is : " + AllCourses_title);
        List<WebElement> xpath = driver.findElements(By.xpath("//*[@class=\"attachment-course-thumb size-course-thumb wp-post-image\"]"));
        int xpathCount = xpath.size();
        System.out.println("Total Courses Count : " + xpathCount);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
