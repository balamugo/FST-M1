package liveProject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity2_GoogleKeep {
    //Driver declaration
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId","5fafae1f");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage","com.google.android.keep");
        caps.setCapability("appActivity",".activities.BrowseActivity");
        caps.setCapability("noReset",true);

        //Appium Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Driver Initialization
        driver = new AndroidDriver<MobileElement>(serverURL, caps);
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void addGoogleKeep() throws IOException {

       // String Title = "Activity Title";
        //String Description = "Activity Description";
        String[] Notes1 = {"Activity Title", "Activity Description"};
        wait.until(ExpectedConditions.elementToBeClickable(By.id("new_note_button")));
        driver.findElementById("new_note_button").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("editable_title")));
        driver.findElementById("editable_title").sendKeys(Notes1[0]);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("edit_note_text")));
        driver.findElementById("edit_note_text").sendKeys(Notes1[1]);
        //wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.className("ImageButton")));
        driver.findElement(MobileBy.className("android.widget.ImageButton")).click();
        //driver.findElementsByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]");
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("index_note_title")));

        String TitleSaved = driver.findElement(MobileBy.id("index_note_title")).getText();
        String DescriptionSaved = driver.findElement(MobileBy.id("index_note_text_description")).getText();
        Assert.assertEquals(Notes1[0],TitleSaved);
        Assert.assertEquals(Notes1[1],DescriptionSaved);

        takeScreenshot("GoogleKeep");



    }


    public void takeScreenshot(String filename) throws IOException {
        // Take screenshot
        File scrShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // This specifies the location the screenshot will be saved
        File screenShotName = new File("src/test/resources/screenshot_" + filename + ".jpg");

        // This will copy the screenshot to the file created
        FileUtils.copyFile(scrShot, screenShotName);

        // Set filepath for image
        String filePath = "../" + screenShotName;

        // Set image HTML in the report
        String path = "<img src='" + filePath + "'/>";

        // Show image in report
        Reporter.log(path);
    }

    @AfterClass
    public void tearDown() {
        //Close the Application
        //    driver.quit();
    }

}
