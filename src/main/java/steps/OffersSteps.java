package steps;

import com.microsoft.playwright.Page;
import pages.OffersPage;

public class OffersSteps {
    Page page;
    OffersPage offersPage;

    public OffersSteps(Page page) {
        this.page = page;
        this.offersPage = new OffersPage(page);
    }

    public OffersSteps navigateToAllOffersPage() {
        offersPage.allOffersLink
                .first()
                .click();
        return this;
    }
}
