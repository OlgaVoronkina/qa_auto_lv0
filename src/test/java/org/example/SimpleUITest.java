package org.example;

import com.codeborne.selenide.*;
import org.example.ui.data.BankAccount;
import org.example.ui.pages.RegisterAccountPage;
import org.example.utils.RandomData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.element;

public class SimpleUITest {
    @BeforeAll
    public static void setupUiTests(){
        Configuration.baseUrl="https://parabank.parasoft.com";
        //Configuration.browser="chrome";
        //Configuration.timeout=10;
    }
    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly() {
        //Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        //Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .build();

        //Шаги теста
        registerAccountPage.errorRegister(bankAccount);

        //Проверка
        registerAccountPage.getAddressErrorText().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getCityErrorText().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getStateErrorText().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getZipCodeErrorText().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getSsnErrorText().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getUserNameErrorText().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordErrorText().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getConfirmErrorText().shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userCreateAccountSuccessfully() {
        //Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        //Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .address(RandomData.randomString())
                .city(RandomData.randomString())
                .state(RandomData.randomString())
                .zipCode(RandomData.randomInt())
                .ssn(RandomData.randomInt())
                .userName(RandomData.randomString())
                .password("123123")
                .confirmPassword("123123")
                .build();

        //Шаги теста
        registerAccountPage.successRegister(bankAccount);

        //Проверка
        registerAccountPage.getWelcomeMessage().shouldHave(Condition.innerText("Welcome"));
    }
}
