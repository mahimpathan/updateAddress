package de.zalando.updateAddress;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class UpdateAddressSteps {
    private UpdateAddressTest updateAddress;

    @BeforeSuite
    public void setUp() {
        System.out.println("Before Suite");
        updateAddress = new UpdateAddressTest();
        updateAddress.setUp();
    }

    @Test(priority = 1)
    public void UserOnLoginPage() {
        updateAddress.OnALoginPage();
    }

    @Test(priority = 2)
    @Parameters({"email","password"})
    public void emailAndPassword(final String email, final String password) {
        updateAddress.userEmailAndPassword(email, password);
    }

    @Test(priority = 3)
    public void loggedIn() {
        updateAddress.userLoginSuccessfully();
    }


    @Test(priority = 4)
    public void addressPage() {
        updateAddress.userOnAddressPage();
    }

    @Test(priority = 5)
    public void userOnEditAddressPage() {
        updateAddress.userOnEditAddressPage();
    }

    @Test(priority = 6)
    @Parameters("street1")
    public void userOnStreet1(final String street1) { updateAddress.userOnStreetOne(street1);
    }

    @Test(priority = 7)
    @Parameters("street2")
    public void userOnStreet2(final String street2){
        updateAddress.userOnStreetTwo(street2);
    }

    @Test(priority = 8)
    @Parameters("postalCode")
    public void userOnpostalcode(final String zip){
        updateAddress.userOnPostalCode(zip);
    }

    @Test(priority = 9)
    public void userOnSaveAddressButton(){ updateAddress.userOnSaveAddressButton();

    }

    @Test(priority = 10)
    public void userOnPopUpAcceptAddressButt(){
        updateAddress.userOnPopUpAcceptAddressButton();
    }

    @Test(priority = 11)
    public void userOnAddAdditionalAddress(){
        updateAddress.userOnAddAdditionalAddress();
    }

    @Test(priority = 12)
    @Parameters("newStreet1")
    public void userNewStreetField(final String street1){
        updateAddress.userNewStreetField(street1);
    }

    @Test(priority = 13)
    @Parameters("newPostalCode")
    public void userOnNewPostalCode(final String zip){
        updateAddress.userOnNewPostalCode(zip);
    }

    @Test(priority = 14)
    @Parameters("newCity")
    public void userOnNCityField(final String City){
        updateAddress.userOnCityField(City);
    }

    @Test(priority = 15)
    public void userOnSaveAdditionalAddress(){
        updateAddress.userOnSaveAdditionalAddress();
    }

    @Test(priority = 16)
    public void userOnPopUpAcceptCorrectAddressClickButton(){
        updateAddress.userOnPopUpAcceptCorrectAddressClickButton();
    }

    @Test(priority = 17)
    public void userDeleteAddress(){
        updateAddress.userDeleteAddress();
    }

    @AfterSuite
    public void tearDown(){
        updateAddress.close();
    }
}
