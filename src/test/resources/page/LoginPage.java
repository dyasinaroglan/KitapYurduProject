package page;

import methods.Methods;
import org.apache.logging.log4j.core.util.Assert;


import static locators.LoginLocators.*;

public class LoginPage extends Methods {

    public void login() {
        gotoUrl(url);
        clickTo(lGirisYapButton);
        sendKeysTo(lEmail, email);
        sendKeysTo(lPassword, password);
        clickTo(lLoginButton);
    }
}
