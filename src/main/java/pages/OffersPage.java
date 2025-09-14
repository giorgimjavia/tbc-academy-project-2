package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class OffersPage {
    public Locator allOffersLink;

    public OffersPage(Page page) {
        this.allOffersLink = page.locator("//a[contains(@href, 'TBCCard')]");
    }
}
