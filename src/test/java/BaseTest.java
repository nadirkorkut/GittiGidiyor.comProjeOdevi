import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected static WebDriver driver;
    public WebElement element(By Locator){

        return driver.findElement(Locator);
    }
    @BeforeClass
    public static void before(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.logfile","Logs/Test-log.log");
        driver=new ChromeDriver();
    }
    @AfterClass
    public static void after() throws InterruptedException{
        Thread.sleep(3000);
    }

    public WebDriver getDriver(){
        return driver;
    }
}
