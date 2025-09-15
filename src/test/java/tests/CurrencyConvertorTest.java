package tests;

import data.Constants;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import runners.BaseTest;
import steps.CurrencyExchangeSteps;
import steps.HomeSteps;

public class CurrencyConvertorTest extends BaseTest {
    HomeSteps homeSteps;
    CurrencyExchangeSteps currencyExchangeSteps;

    @BeforeClass
    public void initSteps() {
        homeSteps = new HomeSteps(page);
        currencyExchangeSteps = new CurrencyExchangeSteps(page);
    }

    @Test()
    public void validateCurrencyExchangeTest() {
        homeSteps
                .openHomePage()
                .rejectCookies()
                .openMegaMenuNavbar()
                .navigateToCurrencyExchangePage();
        currencyExchangeSteps
                .chooseFirstCurrency(Constants.FIRST_CURRENCY_DATA)
                .chooseSecondCurrency(Constants.SECOND_CURRENCY_DATA)
                .enterFirstCurrencyAmount(Constants.AMOUNT_DATA)
                .swapCurrencies();
    }
}
