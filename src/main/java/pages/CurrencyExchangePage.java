package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CurrencyExchangePage {
    public Locator
            firstInput,
            swapIcon,
            dropdowns,
            dropdownList;

    public CurrencyExchangePage(Page page) {
        this.firstInput = page.locator("#tbcx-text-input-1");
        this.swapIcon = page.locator("//div[contains(@class, 'swap')]");
        this.dropdowns = page.locator("div.tbcx-dropdown-selector");
        this.dropdownList = page.locator("//tbcx-dropdown-popover-item[@class = 'tbcx-dropdown-popover-item ng-star-inserted']");
    }
}
