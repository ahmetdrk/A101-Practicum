package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import static org.openqa.selenium.Keys.ENTER;

public class StepDefinition {
    A101_page a101_page = new A101_page();

    @BeforeMethod
    public void setupMethod() {
        Driver.getDriver().get(ConfigurationReader.getProperty("A101.url"));
        a101_page = new A101_page();
    }

    @Test
    public void test() {


        BrowserUtils.sleep(2);
        a101_page.cerezKullanımıKabul.click();
        BrowserUtils.sleep(2);
        System.out.println("Çerez kullanımı kabul edildi.");

        a101_page.giyim_Aksesuar.click();
        BrowserUtils.sleep(2);
        System.out.println("Giyim & Aksesuar kategorisine tıklandı.");

        a101_page.kadınIcGiyim.click();
        BrowserUtils.sleep(2);
        System.out.println("Kadın İç Giyim kategorisine tıklandı.");

        a101_page.dizaltiCorap.click();
        BrowserUtils.sleep(2);
        System.out.println("Dizaltı Çorap seçeneğine tıklandı.");

        a101_page.urunSecim.click();
        BrowserUtils.sleep(2);
        System.out.println("Ürün seçimi yapıldı.");

        String expectedResult = "SİYAH";
        String actualResult = a101_page.Renk.getText();
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println("Seçilen ürünün SİYAH olduğu doğrulandı.");

        a101_page.sepeteEkle.click();
        BrowserUtils.sleep(1);
        System.out.println("Sepete Ekle butonuna tıklandı.");

        a101_page.sepetiGörüntüle.click();
        BrowserUtils.sleep(1);
        System.out.println("Sepeti Görüntüle butonuna tıklandı.");

        a101_page.sepetiOnayla.click();
        BrowserUtils.sleep(1);
        System.out.println("Sepeti Onayla butonuna tıklandı.");

        a101_page.üyeOlmadanDevamEt.click();
        BrowserUtils.sleep(1);
        System.out.println("ÜYE OLMADAN DEVAM ET butonuna tıklandı.");

        a101_page.email.sendKeys("dorukahmet@gmail.com" + ENTER);
        BrowserUtils.sleep(1);
        System.out.println("E-mail bilgileri girildi.ENTER'a tıklandı.");

        a101_page.yeniAdres.click();
        BrowserUtils.sleep(1);
        System.out.println("Yeni adres oluştur butonuna tıklandı.");

        Faker faker = new Faker();
        a101_page.adresBaşlığı.sendKeys(faker.name().username());
        a101_page.adı.sendKeys(faker.name().firstName());
        a101_page.soyadı.sendKeys(faker.name().lastName());
        a101_page.cepTelefonu.sendKeys(faker.phoneNumber().cellPhone());
        BrowserUtils.waitFor(2);

        Select il = new Select(a101_page.şehir);
        il.selectByIndex(34);
        Select ilce = new Select(a101_page.ilce);
        ilce.selectByIndex(10);
        BrowserUtils.waitFor(10);
        Select mahalle = new Select(a101_page.mahalle);
        try {
            mahalle.selectByVisibleText("GÖKMEYDAN MAH");
        } catch (StaleElementReferenceException e) {
            mahalle.selectByVisibleText("GÖKMEYDAN MAH");
        }

        try {
            a101_page.adreskutucugu.sendKeys(faker.address().fullAddress());
        } catch (StaleElementReferenceException e) {
            BrowserUtils.waitForStaleElement(a101_page.adreskutucugu, 10);
            a101_page.adreskutucugu.sendKeys(faker.address().fullAddress());
        }
        System.out.println("Adres bilgileri dolduruldu.");

        a101_page.kaydet.click();
        BrowserUtils.waitFor(2);
        System.out.println("KAYDET butonuna tıklandı.");

        a101_page.kargosecim.click();
        BrowserUtils.waitFor(2);
        System.out.println("Kargo firma seçimi yapıldı.");

        a101_page.kaydetVeDevamet.click();
        BrowserUtils.waitFor(2);
        System.out.println("Kaydet ve Devam Et butonuna tıklandı.");

        String expectedResult1 = "masterpass";
        String actualResult1 = a101_page.kartİleÖdeme.getAttribute("data-type");
        BrowserUtils.waitForVisibility(a101_page.kartİleÖdeme, 10);
        Assert.assertEquals(expectedResult1, actualResult1);
        System.out.println("Ödeme ekranına gidildiği doğrulandı.");

        BrowserUtils.waitFor(2);
    }

    @AfterMethod
    public void tearDown() {
        Driver.getDriver().close();
    }

}

