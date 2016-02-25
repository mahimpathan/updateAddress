package de.zalando.updateAddress;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.junit.Assert.assertNotNull;

public class UpdateAddressTest {


    private static final String ADDRESS_URL = "https://www.zalando.de/benutzerkonto/adressbuch/";
    private static final String NEW_ADDRESS = "https://www.zalando.de/benutzerkonto/adressbuch/adresse/neu/";
    public static final Logger LOG = Logger.getLogger(UpdateAddressTest.class.getName());
    private static WebDriver mDriver;


    public void setUp() {
        if (mDriver == null) {
            mDriver = new FirefoxDriver();
        }
    }

    public void OnALoginPage() {
        mDriver.get("https://www.zalando.de/login/");
        mDriver.manage().window().maximize();

        WebElement loginEmailEle = mDriver.findElement(By.id("loginEmail"));
        assertNotNull("Login Element is found", loginEmailEle);
    }

    public void userEmailAndPassword(String email, String password) {
        mDriver.findElement(By.id("loginEmail")).sendKeys(email);
        mDriver.findElement(By.id("loginPassword")).sendKeys(password);
    }

    public void userLoginSuccessfully() {
        mDriver.findElement(By.id("login")).click();
        mDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public void userOnAddressPage() {
        mDriver.get(ADDRESS_URL);
        mDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void userOnEditAddressPage() {
        WebElement editPageElement = mDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div[1]/div/div[1]/div/a"));
        assertNotNull("Edit page element is not found", editPageElement);
        editPageElement.click();
        mDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void userOnStreetOne(String address) {
        mDriver.findElement(By.id("street1")).clear();
        mDriver.findElement(By.id("street1")).sendKeys(address);
        mDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void userOnStreetTwo(String address) {
        WebElement street2 = mDriver.findElement(By.id("street2"));
        street2.clear();
        street2.sendKeys(address);
        mDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void userOnPostalCode(final String zip) {
        WebElement postalCodeEle = mDriver.findElement(By.id("zip"));
        postalCodeEle.clear();
        postalCodeEle.sendKeys(zip);
        mDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public void userOnSaveAddressButton() {
        mDriver.findElement(By.xpath("//*[@id=\"customerEdit\"]/div[2]/button")).click();
        mDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public void userOnPopUpAcceptAddressButton() {
        mDriver.findElement(By.xpath("//*[@id=\"selectSuggestedAddressForm\"]/div[2]/div[3]/input")).click();
        mDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void userOnAddAdditionalAddress() {
        WebElement removeElement;
        try {
            removeElement = mDriver.findElement(By.className("removeAddress"));
            removeElement.click();
            Alert alert = mDriver.switchTo().alert();
            alert.accept();
        } catch (NoSuchElementException e) {
            LOG.info("Proceed to the new address page");
        }

        mDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mDriver.get(NEW_ADDRESS);
    }

    public void userNewStreetField(String address) {
        WebElement street1 = mDriver.findElement(By.id("street1"));
        assertNotNull("Street1 for address element is not found", street1);
        street1.clear();
        mDriver.findElement(By.id("street1")).sendKeys(address);
        mDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void userOnNewPostalCode(final String zip) {
        mDriver.findElement(By.id("zip")).clear();
        mDriver.findElement(By.id("zip")).sendKeys(zip);
        mDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void userOnCityField(final String City) {
        mDriver.findElement(By.id("city")).sendKeys(City);
        mDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void userOnSaveAdditionalAddress() {
        mDriver.findElement(By.xpath("//*[@id=\"customerEdit\"]/div[2]/button")).click();
        mDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    public void userDeleteAddress() {
        mDriver.findElement(By.className("removeAddress"));
        mDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void userOnPopUpAcceptCorrectAddressClickButton() {

        WebElement element = mDriver.findElement(By.xpath("//*[@id=\"selectSuggestedAddressForm\"]/div[2]/div[3]/input"));
        assertNotNull("alert box for confirm address element is null", element);
        element.click();

        mDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void close() {
        mDriver.close();
    }
}