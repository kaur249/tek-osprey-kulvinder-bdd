package tek.bdd.base;

import io.cucumber.java.an.E;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseSetup {


    private static WebDriver driver;
    private final Properties properties = new Properties();

    //Constructor
    public BaseSetup() {
        // To read a Properties file. 1) File in System.
        // 2) FileInputStream, 3) Object of Properties Class. to Load
        //File Location       System.getProperty("user.dir") return location of Project
        try {
            String fileFilePath = System.getProperty("user.dir")
                    + "/src/test/resources/config/application-config.properties";
            File propertiesFile = new File(fileFilePath);
            FileInputStream propertyFileInputStream = new FileInputStream(propertiesFile);

            properties.load(propertyFileInputStream);

        } catch (IOException ex) {
            throw new RuntimeException("Can not read or load config file "
                    + ex.getMessage());
        }

    }


    public void openBrowser() {
        //Read browser type from Properties file
        String browserType = this.properties.getProperty("retail.browser.type");
        boolean isHeadless = Boolean.parseBoolean(
                this.properties.getProperty("retail.browser.headless"));

        if (browserType.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (isHeadless)
                options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (browserType.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            if (isHeadless)
                options.addArguments("--headless");
            driver = new EdgeDriver(options);
        } else if (browserType.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (isHeadless)
                options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        }
        else {
            throw new RuntimeException("Wrong browser Type");
        }

        driver.manage().window().maximize();
        //Get Url from Property File
        String url = this.properties.getProperty("retail.ui.url");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public WebDriver getDriver() {
        return driver;
    }
    /*
    private static WebDriver driver;

    private final Properties properties= new Properties();
    // To read a Properties file.1) File in  System
    // 2) FileInputStream, 3)Object of Properties Class to Load
    // File Location        System.getProperty("user.dir") return location of Project
    try {
        String fileFilePath = System.getProperty("user.dir")
                // below comes from the configuration file
                + "/src/test/resources/config/application-config.properties";
        // // will give you the location where the project is on the driver
        File propertiesFile = new File(fileFilePath);
        FileInputStream propertyFileInputStream = new FileInputStream(propertiesFile);

        properties.load(propertyFileInputStream);
    } catch (IOException ex)
    {
        throw new RuntimeException("Can not read or load config file "
                + ex.getMessage());
    }
}
    // private static ChromeDriver driver;- change this to wed driver-interface all the drive will implement
 // can run even calling open browser before- Constructor - assign the default values , special method
    // that helps to initiate value to the object
    // Instant variable/ methods/ constructor
    public void openBrowser() {
    // Read browser type from Properties file
        // In this we will choose different browser - chrome/edge/ firefox
        // Add if statement to select different types of browser-cross-browser testing
        // String browserType = "chrome";
        // String browserType = "chrome"; change to edge
        String browserType = this.properties.getProperty("retail.browser.type");
        boolean isHeadless = Boolean.parseBoolean(
                this.properties.getProperty("retail.browser.headless"));
        // String browserType = this.properties.getProperty("retail.browser.type").toString();
        if (browserType.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            driver= new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("chrome-headless")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }
        else{
            throw new RuntimeException("Wrong browser Type");
        }

        // driver= new ChromeDriver(); will change if want to change to different browser
        driver.manage().window().maximize();
        // Get Url from Property File
        String url= this.properties.get("retail.ui.url").toString();
        driver.get(url);
        // driver.get("https://retail.tekschool-students.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    public WebDriver getDriver(){
        return driver;

     */
    }

