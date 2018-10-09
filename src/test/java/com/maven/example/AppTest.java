package com.maven.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {

    private static ChromeDriverService service;
    private WebDriver driver;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp1() {
        assertTrue(true);
    }

    public void testApp2() {
        assertTrue(true);
    }


    @Override
    protected void setUp() throws Exception {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

            service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File("c:\\Sources\\hpaa\\MavenExample\\chromedriver.exe"))
                    .usingAnyFreePort()
                    .build();
            try {
                service.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
            driver = new RemoteWebDriver(service.getUrl(), new ChromeOptions());
        }
    }

    @Override
    protected void tearDown() throws Exception {
        service.stop();
    }

    public void testGoogleSearch() {


        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("testGoogleSearch");

        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();

        Assert.assertTrue(driver.getTitle().startsWith("testGoogleSearch"));
    }


    public void testGoogleSearch2() {

        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("testGoogleSearch2");

        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();

        Assert.assertTrue(driver.getTitle().startsWith("testGoogleSearch2"));
    }


    public void testYnet() {

        driver.get("http://www.ynet.co.il");
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("ynet"));
    }

}
