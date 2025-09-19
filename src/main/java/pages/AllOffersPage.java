package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AllOffersPage {
    public Locator
            offersCheckboxes,
            mobileOffersCheckboxes,
            offerCards,
            mobileFilter,
            mobileApplyFilter;

    public AllOffersPage(Page page) {
        this.offersCheckboxes = page.locator("//div[@class ='filter-item__label']");
        this.mobileOffersCheckboxes = page.locator("//ng-component[contains(@class,'cdk-dialog-container')]//div[@class='filter-item__label']");
        this.offerCards = page.locator("//div[@class ='marketing__cards-list ng-star-inserted']//a");
        this.mobileFilter = page.locator("//div[@class = 'marketing__filter-chip__title']");
        this.mobileApplyFilter = page.locator("//button[text() ='Filter']");
    }
}
