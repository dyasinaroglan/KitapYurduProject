package methods;

import driver.Driver;
import locators.LoginLocators;
import locators.SearchAndScrollLocators;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.logging.Logger;

public class Methods {

    protected WebDriver driver;
    protected FluentWait<WebDriver> wait;

    JavascriptExecutor js;

    Logger logger = Logger.getLogger(Methods.class.getName());

    public Methods() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 20);
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize(); // ekranı tam ekran yapar
        wait = new FluentWait<>(driver); //elementin durumuna göre bekleme (visibil,clickable olana kadar)
        wait.withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(300)) //
                .ignoring(NoSuchElementException.class); //her element için bekleme süresi
        driver.manage().deleteAllCookies(); //tüm cookileri siler
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void gotoUrl(String url) {
        driver.get(url);
    }

    public void clickTo(By locator) {
        findElement(locator).click();
    }

    public void sendKeysTo(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    public void sendKeysTo(By locator, String text, boolean clear) {
        WebElement element = findElement(locator);
        if (clear)
            element.clear();
        element.sendKeys(text);
    }

    public void waitFor(By locator, WaitConditions conditions) {
        switch (conditions) {
            case CLICKABLE:
                wait.until(ExpectedConditions.elementToBeClickable(locator));
                break;
            case VISIBLE:
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                break;
            case EXIST:
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                break;
        }
    }

    public void sleepTo(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Select getSelect(By locator) {
        return new Select(findElement(locator));
    }

    public void selectByIndex(By locator, String text) {
        getSelect(locator).selectByVisibleText(text);
    }

    public int randomNumber(int max) {
        Random random = new Random(); //random sayı üretmek için
        return random.nextInt(max); //0 ile max arasında random sayı üretir
    }

    public WebElement randomElement(By locator) {
        List<WebElement> elementList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)); //listeyi bul
        int options = elementList.size(); //listeyi say
        return elementList.get(randomNumber(options)); //random bir element seç

    }

    public String getAttribute(By locator, String attribute) {
        return findElement(locator).getAttribute(attribute);
    }

    public String getText(By locator) {
        return findElement(locator).getText();
    }

    public String getValue(By locator) {
        return js.executeScript("return arguments[0].value", findElement(locator)).toString();
    }

    public void screenShotBySelenium() throws IOException {
        String scrName = "ScreenShot_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss")); //
        TakesScreenshot scr = (TakesScreenshot) driver; //driverı screenshota çeviriyoruz
        File scrShot = scr.getScreenshotAs(OutputType.FILE); //screenshotı file olarak alıyoruz
        File destScr = new File("ScreenShots\\" + scrName + ".png"); //dosya oluşturuyoruz
        FileUtils.copyFile(scrShot, destScr); //dosyayı kaydediyoruz

    }

    public void scrollWithJS(By locator) {
        js.executeScript("arguments[0].scrollIntoView();", findElement(locator));
    }

    public void scrollWithJS(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void selectChoiceValues(By locator, String... values) {
        List<WebElement> elementList = driver.findElements(locator);
        if (!values[0].equalsIgnoreCase("all")) {
            for (WebElement element : elementList) {
                String text = element.getText();
                for (String value : values) {
                    if (text.equals(value)) {
                        element.click();
                        break;
                    }
                }
            }
        } else {
            for (WebElement element : elementList) {
                element.click();
            }
        }
    }

    public void clickTextInSelect(By locator, String text) {
        List<WebElement> elementList = driver.findElements(locator); //tüm elementleri liste atıyoruz
        for (WebElement element : elementList) { //liste içindeki her bir element için
            if (element.getText().equals(text)) { //
                element.click(); //elementin texti ile parametredeki text aynı ise tıklıyoruz
                break; //döngüden çıkıyoruz
            }
        }
    }

    public boolean isElementVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void loginMethod() {
        gotoUrl(LoginLocators.url);
        clickTo(LoginLocators.lGirisYapButton);
        sendKeysTo(LoginLocators.lEmail, LoginLocators.email);
        sendKeysTo(LoginLocators.lPassword, LoginLocators.password);
        clickTo(LoginLocators.lLoginButton);
    }

    public static int random(int size) {
        return (int) (Math.random() * size);
    }

    public void addFavorites() {
        List<WebElement> products = driver.findElements(SearchAndScrollLocators.lFavoriteButton);
        for (int i = 4; i <= 7; i++) {
            WebElement element = products.get(i);
            products.get(i).click();
        }
    }

    public Actions getActions(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(locator)).build().perform();
        return actions;
    }

}


