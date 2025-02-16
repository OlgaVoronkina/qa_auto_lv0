package org.example.ui.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.example.ui.data.BankAccount;

import static com.codeborne.selenide.Selenide.element;
@Getter
public class RegisterAccountPage {
    private SelenideElement firstNameInput = element(Selectors.byId("customer.firstName"));
    private SelenideElement lastNameInput = element(Selectors.byId("customer.lastName"));
    private SelenideElement addressInput = element(Selectors.byId("customer.address.street"));
    private SelenideElement cityInput = element(Selectors.byId("customer.address.city"));
    private SelenideElement stateInput = element(Selectors.byId("customer.address.state"));
    private SelenideElement zipCodeInput = element(Selectors.byId("customer.address.zipCode"));
    private SelenideElement ssnInput = element(Selectors.byId("customer.ssn"));
    private SelenideElement userNameInput = element(Selectors.byId("customer.username"));
    private SelenideElement passwordInput = element(Selectors.byId("customer.password"));
    private SelenideElement confirmPasswordInput = element(Selectors.byId("repeatedPassword"));
    private SelenideElement registerButton = element(Selectors.byValue("Register"));
    private SelenideElement addressErrorText = element(Selectors.byId("customer.address.street.errors"));
    private SelenideElement cityErrorText = element(Selectors.byId("customer.address.city.errors"));
    private SelenideElement stateErrorText = element(Selectors.byId("customer.address.state.errors"));
    private SelenideElement zipCodeErrorText = element(Selectors.byId("customer.address.zipCode.errors"));
    private SelenideElement ssnErrorText = element(Selectors.byId("customer.ssn.errors"));
    private SelenideElement userNameErrorText = element(Selectors.byId("customer.username.errors"));
    private SelenideElement passwordErrorText = element(Selectors.byId("customer.password.errors"));
    private SelenideElement confirmErrorText = element(Selectors.byId("repeatedPassword.errors"));
    private SelenideElement welcomeMessage = element(Selectors.byCssSelector(".title"));

    public void open(){
        Selenide.open("/parabank/register.htm");
    }
    public void errorRegister(BankAccount bankAccount){
        firstNameInput.sendKeys(bankAccount.getFirstName());
        lastNameInput.sendKeys(bankAccount.getLastName());
        registerButton.click();
    }

    public void successRegister(BankAccount bankAccount){
        firstNameInput.sendKeys(bankAccount.getFirstName());
        lastNameInput.sendKeys(bankAccount.getLastName());
        addressInput.sendKeys(bankAccount.getAddress());
        cityInput.sendKeys(bankAccount.getCity());
        stateInput.sendKeys(bankAccount.getState());
        zipCodeInput.sendKeys(bankAccount.getZipCode());
        ssnInput.sendKeys(bankAccount.getSsn());
        userNameInput.sendKeys(bankAccount.getUserName());
        passwordInput.sendKeys(bankAccount.getPassword());
        confirmPasswordInput.sendKeys(bankAccount.getConfirmPassword());
        registerButton.click();
    }
}
