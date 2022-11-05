package locators;

import org.openqa.selenium.By;

public interface SearchAndScrollLocators {

    By lSearchBox = By.id("search-input");

    By lUrünler = By.cssSelector("div[class='name'] span");
    By lFavoriteButton = By.cssSelector("div[class='hover-menu'] a[class='in-favorites']");
    By lFavoriteMessage = By.cssSelector("h2[id='swal2-title']");
    By lEnCokIlgilenilenAramaText = By.xpath("(//div[@class='ribbon-text'])[2]");
    By lLogoButton = By.cssSelector("div[class='logo-text']");

    //By lFavorilereEkleButton = By.xpath("(//*[@class='fa fa-heart'])" + "[" + i + "]");

    By lFavoriButton7 = By.xpath("(//a[@class='in-favorites'])[10]");
    By lListelerim = By.cssSelector(".menu.top.my-list");
    By lFavorilerim = By.xpath("//*[@id=\"header-top\"]/div/div[2]/ul/li[1]/div/ul/li/div/ul/li[1]/a");
    By lGösterMessage = By.cssSelector(".limit");
    By lPuanKatalogButton = By.cssSelector("div[class='lvl1catalog'] a[class='common-sprite']");
    By lTürkKlasikleriButton = By.xpath("(//img[@class='landing-button'])[2]");

    By lSelectOy = By.xpath("(//select[@onchange='location = this.value;'])[1]");
    By lTümKitaplarButton = By.xpath("(//span[@class='mn-strong common-sprite'])[3]");
    By lHobiButton = By.xpath("//a[@class='mn-icon icon-angleRight' and text()='Hobi']");

    By lBooks = By.cssSelector("div[class='cover']");
    By lSepeteEkleButton = By.id("button-cart");
    By lUrunSilme3 = By.xpath("(//*[@class='fa fa-heart-o'])" + "[" + 3 + "]");
    By lSepetButton = By.cssSelector("div[id='cart']");
    By lSepeteGitButton = By.xpath("(//a[@class='button'])[1]");

    By lUrünArttır = By.xpath("(//input[@type='text'])[2]");
    By lRefreshButton = By.cssSelector("i[class='fa fa-refresh green-icon']");
    By lSatınAlButton = By.cssSelector("a[class='button red']");

    //Adres bilgileri
    By lname = By.id("address-firstname-companyname");
    By lSurname = By.id("address-lastname-title");
    By lCountry = By.id("address-country-id");
    By lCity = By.id("address-zone-id");
    By lIlce = By.id("address-county-id");
    By lMahalle = By.id("district");
    By lAdres = By.id("address-address-text");
    By lTelephone = By.id("address-mobile-telephone");
    By lTC = By.id("address-tax-id");
    By lDevamEtButton = By.id("button-checkout-continue");
    By lNewAdressSelect = By.cssSelector("div[id='shipping-tabs'] a[class='selected']");
    By lDevamButton2 = By.id("button-checkout-continue");

    //card bilgileri
    By lCardName = By.id("credit-card-owner");
    By lCardNumber1 = By.xpath("(//input[@type='text'])[4]");
    By lCardNumber2 = By.xpath("(//input[@type='text'])[5]");
    By lCardNumber3 = By.xpath("(//input[@type='text'])[6]");
    By lCardNumber4 = By.xpath("(//input[@type='text'])[7]");

    By lMonths = By.id("credit-card-expire-date-month");
    By lYears = By.id("credit-card-expire-date-year");
    By lGüvenlikCode = By.id("credit-card-security-code");
    By lDevamButton3 = By.id("button-checkout-continue");
    By lError = By.cssSelector("span[class='error']");
    By lCıkısButton = By.xpath("(//a[@class='common-sprite'])[1]");
    By lLogout = By.cssSelector(".login ul li:nth-of-type(4)");

}
