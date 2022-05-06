package activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Calendar;

import static java.time.LocalTime.now;

public class Activity3 {
    // Declare Android driver
    AndroidDriver<MobileElement> driver;

    public void takeScreenshot() throws IOException {
        // Take screenshot
        File scrShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // This specifies the location the screenshot will be saved
        //File screenShotName = new File("src/test/resources/screenshot_"+Math.random()+".jpg");
        File screenShotName = new File("src/test/resources/screenshot_"+ Calendar.getInstance().getTimeInMillis()+".jpg");

        // This will copy the screenshot to the file created
        FileUtils.copyFile(scrShot, screenShotName);

        // Set filepath for image
        String filePath = "../" + screenShotName;

        // Set image HTML in the report
        String path = "<img src='" + filePath + "'/>";

        // Show image in report
        Reporter.log(path);
    }

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId","5fafae1f");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage","com.android.bbkcalculator");
        caps.setCapability("appActivity",".Calculator");
        caps.setCapability("noReset",true);


        // Instantiate Appium driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
    }

    @Test
    public void add() throws IOException {
        driver.findElementById("digit7").click();
        driver.findElementById("plus").click();
        driver.findElementById("digit9").click();
        // Perform Calculation
        driver.findElementById("equal").click();
        takeScreenshot();

        // Display Result
        String result = driver.findElementById("input_edit").getText();
        System.out.println(result);
        Assert.assertEquals(result, "16");
    }


    @Test
    public void subtract() throws IOException {
        driver.findElementById("digit8").click();
        driver.findElementById("digit5").click();
        driver.findElementById("minus").click();
        driver.findElementById("digit5").click();
        // Perform Calculation
        driver.findElementById("equal").click();
        takeScreenshot();

        // Display Result
        String result = driver.findElementById("input_edit").getText();
        System.out.println(result);
        Assert.assertEquals(result, "80");
    }


    @Test
    public void multiply() throws IOException {
        driver.findElementById("digit5").click();
        driver.findElementById("mul").click();
        driver.findElementById("digit1").click();
        driver.findElementById("digit0").click();
        driver.findElementById("digit0").click();
        // Perform Calculation
        driver.findElementById("equal").click();
        takeScreenshot();

        // Display Result
        String result = driver.findElementById("input_edit").getText();
        System.out.println(result);
        Assert.assertEquals(result, "500");
    }

    @Test
    public void divide() throws IOException {
        driver.findElementById("digit5").click();
        driver.findElementById("digit0").click();
        driver.findElementById("div").click();
        driver.findElementById("digit2").click();
        // Perform Calculation
        driver.findElementById("equal").click();
        takeScreenshot();

        // Display Result
        String result = driver.findElementById("input_edit").getText();
        System.out.println(result);
        Assert.assertEquals(result, "25");
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}