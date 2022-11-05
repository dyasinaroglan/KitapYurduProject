package page;

import locators.LoginLocators;
import methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.logging.Logger;

import static locators.LoginLocators.email;
import static locators.LoginLocators.lEmail;
import static locators.LoginLocators.lGirisYapButton;
import static locators.LoginLocators.lHesabimText;
import static locators.LoginLocators.lHesabimText;
import static locators.LoginLocators.lLoginButton;
import static locators.LoginLocators.lPassword;
import static locators.LoginLocators.password;
import static locators.LoginLocators.url;
import static locators.SearchAndScrollLocators.lEnCokIlgilenilenAramaText;
import static locators.SearchAndScrollLocators.lFavoriteButton;
import static locators.SearchAndScrollLocators.lFavoriteMessage;
import static locators.SearchAndScrollLocators.lSearchBox;

public class LoginPage extends Methods {

    public void login() {
        loginMethod();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lHesabimText));
        Assert.assertTrue(isElementVisible(lHesabimText));
        LoginLocators.logger.info("Login is successful");

    }

}
