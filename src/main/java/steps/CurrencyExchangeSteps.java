package steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.CurrencyExchangePage;

public class CurrencyExchangeSteps {
    Page page;
    CurrencyExchangePage currencyExchangePage;

    public CurrencyExchangeSteps(Page page) {
        this.page = page;
        this.currencyExchangePage = new CurrencyExchangePage(page);
    }

    public CurrencyExchangeSteps chooseFirstCurrency(String value) {
        currencyExchangePage.dropdowns.first().click();
        currencyExchangePage.dropdownList
                .filter(new Locator.FilterOptions().setHasText(value))
                .first()
                .click();
        return this;
    }

    public CurrencyExchangeSteps chooseSecondCurrency(String value) {
        currencyExchangePage.dropdowns.nth(1).click();
        currencyExchangePage.dropdownList
                .filter(new Locator.FilterOptions().setHasText(value))
                .first()
                .click();
        return this;
    }

    public CurrencyExchangeSteps enterFirstCurrencyAmount(String value) {
        currencyExchangePage.firstInput.fill(value);
        return this;
    }

    public CurrencyExchangeSteps swapCurrencies() {
        currencyExchangePage.swapIcon.click();
        return this;
    }
}
