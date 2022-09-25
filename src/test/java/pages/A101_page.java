package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class A101_page extends BasePage {

    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    public WebElement cerezKullanımıKabul;

    @FindBy(xpath = "(//a[@href='/giyim-aksesuar/'])[1]")
    public WebElement giyim_Aksesuar;

    @FindBy(xpath = "(//a[@data-value='1565'])")
    public WebElement kadınIcGiyim;

    @FindBy(xpath = "(//a[@data-value='1567'])")
    public WebElement dizaltiCorap;

    @FindBy(xpath = "(//em[@class='icon-sepetekle'][1])")
    public WebElement urunSecim;

    @FindBy(xpath = "//div[@class='selected-variant-text']/span")
    public WebElement Renk;

    @FindBy(xpath = "//i[@class='icon-sepetekle']")
    public WebElement sepeteEkle;

    @FindBy(xpath = "//a[@class='go-to-shop']")
    public WebElement sepetiGörüntüle;

    @FindBy(xpath = "(//a[@title='Sepeti Onayla'])[2]")
    public WebElement sepetiOnayla;

    @FindBy(xpath = "//a[@title='ÜYE OLMADAN DEVAM ET']")
    public WebElement üyeOlmadanDevamEt;

    @FindBy(name = "user_email")
    public WebElement email;

    @FindBy(xpath = "(//a[@title='Yeni adres oluştur'])[1]")
    public WebElement yeniAdres;

    @FindBy(xpath = "//input[@name='title']")
    public WebElement adresBaşlığı;

    @FindBy(xpath = "//input[@name='first_name']")
    public WebElement adı;

    @FindBy(name = "last_name")
    public WebElement soyadı;

    @FindBy(name = "phone_number")
    public WebElement cepTelefonu;

    @FindBy(xpath = "//select[@name='city']")
    public WebElement şehir;

    @FindBy(xpath = "//select[@name='township']")
    public WebElement ilce;

    @FindBy(xpath = "//select[@class='js-district']")
    public WebElement mahalle;

    @FindBy(xpath = "//textarea[@class='js-address-textarea']")
    public WebElement adreskutucugu;

    @FindBy(css = "button[class='button green js-set-country js-prevent-emoji']")
    public WebElement kaydet;

    @FindBy(xpath = "(//div[@class='radio'])[4]")
    public WebElement kargosecim;

    @FindBy(xpath = "//button[@data-index='1']")
    public WebElement kaydetVeDevamet;

    @FindBy(xpath = "(//div[@data-type='masterpass'])[1]")
    public WebElement kartİleÖdeme;

    //@FindBy(xpath = "(//div[@onclick='persona_PopupClose();'])[1]")
    //public WebElement popUpPencere;

}
