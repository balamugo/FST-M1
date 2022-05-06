package liveProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class Activity9 {
    //Initialization of object and variables
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
    public void Complete_Simple_Lesson() {
        driver.findElement(By.xpath("//a[text()='My Account']")).click(); // CLick on My account link
        boolean MyAccount_title = driver.getTitle().contains("My Account");// Compare My Account title
        assertTrue(MyAccount_title);
        String MyAccountTitle = driver.getTitle();
        System.out.println("Title of My Account page is : " + MyAccountTitle);// Display My Account title
        driver.findElement(By.className("ld-login")).click();// CLick on login button
        driver.findElement(By.id("user_login")).sendKeys(username); // Input username
        driver.findElement((By.name("pwd"))).sendKeys(password);// Input password
        driver.findElement(By.id("wp-submit")).click();// Click on submit button
        driver.findElement(By.className("display-name")).isDisplayed();//Check display of customer after login
        String DisplayName = driver.findElement(By.className("display-name")).getText();
        System.out.println("The logged-in display name is : " + DisplayName);// Display the customer display name
        driver.findElement(By.xpath("//a[@href=\"https://alchemy.hguy.co/lms/all-courses/\"]")).click(); // Click on All Courses link
        boolean All_Courses_title = driver.getTitle().contains("All Courses");// Validate the title of All Courses
        assertTrue(All_Courses_title);
        String AllCourses_title = driver.getTitle();
        System.out.println("Title of All Courses page is : " + AllCourses_title);
        driver.findElement(By.xpath("//*[@id=\"post-69\"]/a/img")).click(); // Select a course
        driver.findElement(By.xpath("//*[@id=\"ld-expand-83\"]/div[1]/a/div[2]")).click(); // Click on Course content
        String CourseContent = driver.getTitle();
        System.out.println("The title of the course content is " + CourseContent);

    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
