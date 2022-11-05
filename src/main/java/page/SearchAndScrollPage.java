package page;

import locators.LoginLocators;
import methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static locators.SearchAndScrollLocators.lAdres;
import static locators.SearchAndScrollLocators.lCıkısButton;
import static locators.SearchAndScrollLocators.lDevamButton2;
import static locators.SearchAndScrollLocators.lDevamButton3;
import static locators.SearchAndScrollLocators.lDevamEtButton;
import static locators.SearchAndScrollLocators.lError;
import static locators.SearchAndScrollLocators.lGüvenlikCode;
import static locators.SearchAndScrollLocators.lMahalle;
import static locators.SearchAndScrollLocators.lBooks;
import static locators.SearchAndScrollLocators.lCity;
import static locators.SearchAndScrollLocators.lCountry;
import static locators.SearchAndScrollLocators.lEnCokIlgilenilenAramaText;


import static locators.SearchAndScrollLocators.lFavorilerim;
import static locators.SearchAndScrollLocators.lHobiButton;
import static locators.SearchAndScrollLocators.lIlce;
import static locators.SearchAndScrollLocators.lListelerim;
import static locators.SearchAndScrollLocators.lLogoButton;
import static locators.SearchAndScrollLocators.lMonths;
import static locators.SearchAndScrollLocators.lNewAdressSelect;
import static locators.SearchAndScrollLocators.lPuanKatalogButton;
import static locators.SearchAndScrollLocators.lRefreshButton;
import static locators.SearchAndScrollLocators.lSatınAlButton;
import static locators.SearchAndScrollLocators.lSearchBox;
import static locators.SearchAndScrollLocators.lSelectOy;
import static locators.SearchAndScrollLocators.lSepetButton;
import static locators.SearchAndScrollLocators.lSepeteEkleButton;
import static locators.SearchAndScrollLocators.lSepeteGitButton;
import static locators.SearchAndScrollLocators.lSurname;
import static locators.SearchAndScrollLocators.lTC;
import static locators.SearchAndScrollLocators.lTelephone;
import static locators.SearchAndScrollLocators.lTümKitaplarButton;
import static locators.SearchAndScrollLocators.lTürkKlasikleriButton;
import static locators.SearchAndScrollLocators.lUrunSilme3;
import static locators.SearchAndScrollLocators.lUrünArttır;
import static locators.SearchAndScrollLocators.lUrünler;
import static locators.SearchAndScrollLocators.lYears;
import static locators.SearchAndScrollLocators.lname;

public class SearchAndScrollPage extends Methods {

    public void searchAndScroll() {
        loginMethod();
        clickTo(lLogoButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lSearchBox));
        clickTo(lSearchBox);
        sendKeysTo(lSearchBox, "oyuncak" + Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(lEnCokIlgilenilenAramaText));
        sleepTo(2000);
        List<WebElement> urunler = driver.findElements(lUrünler);
        WebElement urun7 = urunler.get(2);
        scrollWithJS(urun7);
        sleepTo(5000);
        for (int i = 6; i < 10; i++) {
            clickTo(By.xpath("(//*[@class='fa fa-heart'])" + "[" + i + "]"));
            sleepTo(2000);
            LoginLocators.logger.info("4 ürün başarılı bir şekilde favorilere eklendi");
        }
        //ANASAYFAYA DÖNÜŞ
        clickTo(lLogoButton);
        clickTo(lPuanKatalogButton);
        clickTo(lTürkKlasikleriButton);
        selectByIndex(lSelectOy,"Yüksek Oylama");

        getActions(lTümKitaplarButton);
        sleepTo(1000);
        clickTo(lHobiButton);
        //Random kitap seçme
        randomElement(lBooks).click();
        LoginLocators.logger.info("Rastgele bir kitap seçildi");
        clickTo(lSepeteEkleButton);
        scrollWithJS(lListelerim);
        getActions(lListelerim);
        sleepTo(1000);
        clickTo(lFavorilerim);

        clickTo(lUrunSilme3);
        sleepTo(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lSepetButton));
        //Sepete gitme
        clickTo(lSepetButton);
        sleepTo(5000);

        clickTo(lSepeteGitButton);

        sendKeysTo(lUrünArttır, "2",false);
        LoginLocators.logger.info("Ürün adedi 2 olarak değiştirildi");
        clickTo(lRefreshButton);
        sleepTo(3000);
        clickTo(lSatınAlButton);
        sleepTo(3000);
        clickTo(lNewAdressSelect);
        sleepTo(2000);
        sendKeysTo(lname,"Mahmut");
        sendKeysTo(lSurname,"Taşdelen");
        selectByIndex(lCountry,"Türkiye");
        selectByIndex(lCity,"İstanbul");
        selectByIndex(lIlce,"Maltepe");
        selectByIndex(lMahalle,"Ünalan Mahallesi");
        selectByIndex(lAdres,"Müjde sokak");
        selectByIndex(lTelephone,"05555657890");
        selectByIndex(lTC,"");
        LoginLocators.logger.info("Adres bilgileri girildi");
        clickTo(lDevamEtButton);
        sleepTo(2000);
        clickTo(lDevamButton2);
        selectByIndex(lMonths,"03");
        selectByIndex(lYears,"2025");
        selectByIndex(lGüvenlikCode,"123");
        sleepTo(2000);
        clickTo(lDevamButton3);
        Assert.assertTrue("Kart numarası geçersiz. Kontrol ediniz!",driver.findElement(lError).isDisplayed());
        LoginLocators.logger.info("Kart numarası geçersiz. Kontrol ediniz! Mesajı görüldü");

        sleepTo(2000);
        clickTo(lLogoButton);
        getActions(lCıkısButton);
        sleepTo(1000);
        clickTo(lLogoButton);
        LoginLocators.logger.info("Çıkış yapıldı");

    }

}
