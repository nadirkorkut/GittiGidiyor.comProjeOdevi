import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PageTestCases extends BaseTest{
    private static final Logger logger = LogManager.getLogger(PageTestCases.class);
    private Object Priority;

    //GittiGidiyor Anasayfaya Giriş.
    @Test
    public void Test_1_1_HomePage(){
        HomePage homePage=new HomePage(driver);
        driver.get(homePage.site());
        driver.manage().window().maximize();
        try {
            Assert.assertEquals("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi",driver.getTitle());
        } catch (Exception e){
            logger.error("Hatalı başlık.");
        }

        logger.info("Anasayfaya giriş yapıldı.");
    }

    //Login Sayfasına Geçiş işlemi
    private By login=By.cssSelector("div[data-cy='header-user-menu']");
    private By loginButton=By.cssSelector("a[data-cy='header-login-button']");
    @Test
    public void Test_1_2_LoginPage() throws InterruptedException{
        HomePage homePage=new HomePage(driver);
        driver.get(homePage.site());
        driver.findElement(login).click();
        Thread.sleep(3000);
        driver.findElement(loginButton).click();
        logger.info("Login Sayfasına Giriş Yapıldı");
    }

    //Kayıtlı Hesaba Giriş işlemi
    private By username=By.id("L-UserNameField");
    private By password=By.id("L-PasswordField");
    private By submit=By.id("gg-login-enter");
    @Test
    public void Test_1_3_LoginForm() throws InterruptedException{
        HomePage homePage=new HomePage(driver);
        driver.get(homePage.site()+"uye-girisi?s=1");
        driver.findElement(username).sendKeys("seleniumtestautomation11@gmail.com");
        driver.findElement(password).sendKeys("123korkut");
        Thread.sleep(3000);
        driver.findElement(submit).click();
        logger.info("Giriş Yapıldı");
    }

    //Search İşlemi
    private By search=By.name("k");
    private By searchButton=By.cssSelector("button[data-cy='search-find-button']");
    @Test
    public void Test_1_4_Search() throws InterruptedException{
        HomePage homePage=new HomePage(driver);
        driver.get(homePage.site());
        driver.findElement(search).sendKeys("Bilgisayar");
        driver.findElement(searchButton).click();
        Thread.sleep(3000);
        logger.info("Arama işlemi Başarılı Bir Şekilde Yapıldı");
    }

    private By nextLink=By.className("next-link");
    private By closePolicy=By.cssSelector("a[class='policy-alert-close btn-alert-close']");
    private By closewis=By.className("wis-clsbtn-94970");
    @Test
    public void Test_1_5_SecondPage() throws InterruptedException{
        HomePage homePage=new HomePage(driver);
        driver.get(homePage.site()+"arama/?k=bilgisayar&sf=2");
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("scroll(0,250)");
        driver.findElement(closewis).click();
        Thread.sleep(2000);
        driver.findElement(closePolicy).click();
        Thread.sleep(2000);
        driver.findElement(nextLink);
        Thread.sleep(2000);
        logger.info("İkinci Sayfaya Geçildi");
    }



    @Test
    public void Test_1_6_SecondPageControl() throws InterruptedException{
        HomePage homePage=new HomePage(driver);
        driver.get(homePage.site()+"arama/?k=bilgisayar&sf=2");
        Assert.assertEquals("Bilgisayar - GittiGidiyor - 2/100",driver.getTitle());
        logger.info("İkinci arama sayfasına geçiş kontrolü yapıldı");
    }

    private By product=By.id("product_id_576239506");
    @Test
    public void Test_1_7_SelectProduct() throws InterruptedException{
        HomePage homePage=new HomePage(driver);
        driver.get(homePage.site()+"arama/?k=bilgisayar&sf=2");
        driver.findElement(product).click();
        logger.info("Ürün Seçildi");
    }

    private By basket=By.cssSelector("a[class='gg-ui-btn-default padding-none']");
    private By wisContainerClose=By.className("wis-clsbtn-96096");
    @Test
    public void Test_1_8_AddToBasketAndComparisonPrice() throws InterruptedException{

        HomePage homePage=new HomePage(driver);
        driver.get(homePage.site()+"bilgisayar-tablet/aizen-gx42-i5-3470-16-gb-1tb-hdd-2gb-e-k-23-8-oyuncu-bilgisayari_pdp_576239506");
        Thread.sleep(2000);
        driver.findElement(wisContainerClose).click();
        Thread.sleep(2000);
        WebElement element =driver.findElement(By.id("add-to-basket"));
        JavascriptExecutor executor=(JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",element);
        logger.info("Ürün Sepete Eklendi");
        driver.findElement(By.cssSelector("span[id='sp-price-highPrice']")).getText();
        Thread.sleep(2000);
        driver.findElement(basket).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div[class='total-price']")).getText();
        logger.info("Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırıldı");
    }

    private By Basket=By.cssSelector("a[class='gg-ui-btn-default padding-none']");
    private By numberOfProducts=By.cssSelector("option[value='2']");
    @Test
    public void Test_1_9_ProductPlus() throws InterruptedException{
        HomePage homePage=new HomePage(driver);
        driver.get(homePage.site()+"bilgisayar-tablet/aizen-gx42-i5-3470-16-gb-1tb-hdd-2gb-e-k-23-8-oyuncu-bilgisayari_pdp_576239506");
        Thread.sleep(2000);
        driver.findElement(wisContainerClose).click();
        Thread.sleep(2000);
        WebElement element =driver.findElement(By.id("add-to-basket"));
        JavascriptExecutor executor=(JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",element);
        Thread.sleep(2000);
        driver.findElement(basket).click();
        Thread.sleep(2000);
        driver.findElement(numberOfProducts).click();
        logger.info("Sepetteki ürün sayısı arttırıldı ve 2 yapıldı.");
    }

    private By Basket2 = By.cssSelector("a[class='gg-ui-btn-default padding-none']");
    private By DeleteProduct=By.cssSelector("a[title='Sil']");
    private By EmptyBasket = By.cssSelector("div[class='gg-w-15 gg-d-14 gg-t-14 gg-m-24']");
    @Test
    public void Test_2_1_DeleteProductAndCheckBasket() throws InterruptedException{
        HomePage homePage=new HomePage(driver);
        driver.get(homePage.site()+"bilgisayar-tablet/aizen-gx42-i5-3470-16-gb-1tb-hdd-2gb-e-k-23-8-oyuncu-bilgisayari_pdp_576239506");
        Thread.sleep(2000);
        driver.findElement(wisContainerClose).click();
        Thread.sleep(2000);
        WebElement element =driver.findElement(By.id("add-to-basket"));
        JavascriptExecutor executor=(JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",element);
        Thread.sleep(2000);
        driver.findElement(basket).click();
        Thread.sleep(2000);
        driver.findElement(DeleteProduct).click();
        Thread.sleep(2000);
        driver.findElement(EmptyBasket).getText();
        logger.info("Ürün Sepetten Çıkarıldı ve Boş olduğu kontrol edildi");
        logger.info("Test Sonlandırıldı");
        driver.quit();
    }

}
