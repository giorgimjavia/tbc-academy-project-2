package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LocationsPage {
    public Locator
            tabs,
            subTabs,
            dropdownList,
            dropdown,
            enableSearchBar,
            searchInput;

    public LocationsPage(Page page) {
        this.tabs = page.locator("//button[contains(@class , 'tbcx-pw-tab')]//span");
        this.subTabs = page.locator("span.tbcx-pw-chip__checkmark");
        this.dropdownList = page.locator("//div[@class ='tbcx-dropdown-popover-item__title']");
        this.dropdown = page.locator("//div[@class ='tbcx-dropdown-selector']");
        this.enableSearchBar = page.locator("//tbcx-text-input[contains(@class, 'size-normal')]");
        this.searchInput = page.locator("#tbcx-text-input-1");
    }
}
