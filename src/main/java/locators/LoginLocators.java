package locators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public interface LoginLocators {

    Logger logger = LogManager.getLogger(LoginLocators.class);
    String url = "https://www.kitapyurdu.com/";
    String email = "yasinargln264@gmail.com";
    String password = "264264264";
    By lGirisYapButton = By.cssSelector("div[class='menu-top-button login']");
    By lEmail = By.id("login-email");
    By lPassword = By.id("login-password");
    By lLoginButton = By.cssSelector("button[class='ky-btn ky-btn-orange w-100 ky-login-btn']");
    By lHesabimText = By.cssSelector("h1[class='section']");

}
