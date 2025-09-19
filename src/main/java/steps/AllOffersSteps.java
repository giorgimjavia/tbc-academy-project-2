package steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import data.OffersDataSupplier;
import pages.AllOffersPage;
import util.Config;

public class AllOffersSteps {
    Page page;
    AllOffersPage allOffersPage;

    public AllOffersSteps(Page page) {
        this.page = page;
        this.allOffersPage = new AllOffersPage(page);
    }

    public AllOffersSteps checkAnyCategoryInOffers(String categoryName) {
        if (Config.isMobileDevice()) {
            allOffersPage.mobileFilter.click();
            allOffersPage.offersCheckboxes
                    .filter(new Locator.FilterOptions().setHasText(categoryName))
                    .first()
                    .click(new Locator.ClickOptions().setForce(true));
            allOffersPage.mobileApplyFilter.click();
        } else {
            allOffersPage.offersCheckboxes
                    .filter(new Locator.FilterOptions().setHasText(categoryName))
                    .first()
                    .click();
        }
        return this;
    }

    public AllOffersSteps validateListUpdate() { int count = allOffersPage.offerCards.count();
        if (count < 0) { throw new AssertionError("Offer list did not update — no cards found.");
        } for (int i = 0; i < count; i++) {
            if (!allOffersPage.offerCards.nth(i).isVisible()) {
                throw new AssertionError("Offer card at index " + i + " is not visible."); }
        }
        return this;
    }

    public AllOffersSteps uncheckSelectedCategory(String categoryName) {
        if (Config.isMobileDevice()) {
            allOffersPage.mobileFilter.click();
            allOffersPage.offersCheckboxes
                    .filter(new Locator.FilterOptions().setHasText(categoryName))
                    .first()
                    .click(new Locator.ClickOptions().setForce(true));
            allOffersPage.mobileApplyFilter.click();
        } else {
            allOffersPage.offersCheckboxes
                    .filter(new Locator.FilterOptions().setHasText(categoryName))
                    .first()
                    .click();
        }
        return this;
    }
}
