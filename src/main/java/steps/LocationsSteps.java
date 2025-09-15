package steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import data.Constants;
import pages.LocationsPage;

public class LocationsSteps {
    Page page;
    LocationsPage locationsPage;

    public LocationsSteps(Page page) {
        this.page = page;
        this.locationsPage = new LocationsPage(page);
    }

    // ----------------------- LocationTabsTest ------------------------ \\
    public LocationsSteps selectAtmsTab() {
        locationsPage.tabs
                .filter(new Locator.FilterOptions().setHasText(Constants.ATMS_TXT))
                .first()
                .click();
        return this;
    }

    public LocationsSteps selectATMsSubTab24_7() {
        locationsPage.subTabs
                .filter(new Locator.FilterOptions().setHasText(Constants.TWENTY_FOUR_SEVEN_TX))
                .first()
                .click();
        return this;
    }

    public LocationsSteps unSelectATMsSubTab24_7() {
        locationsPage.subTabs
                .filter(new Locator.FilterOptions().setHasText(Constants.TWENTY_FOUR_SEVEN_TX))
                .first()
                .click();
        return this;
    }

    public LocationsSteps selectATMsSubTabOpenNow() {
        locationsPage.subTabs
                .filter(new Locator.FilterOptions().setHasText(Constants.OPEN_NOW_TXT))
                .first()
                .click();
        return this;
    }

    public LocationsSteps unSelectATMsSubTabOpenNow() {
        locationsPage.subTabs
                .filter(new Locator.FilterOptions().setHasText(Constants.OPEN_NOW_TXT))
                .first()
                .click();
        return this;
    }

    public LocationsSteps selectBranchesTab() {
        locationsPage.tabs
                .filter(new Locator.FilterOptions().setHasText(Constants.BRANCHES_TXT))
                .first()
                .click();
        return this;
    }

    public LocationsSteps selectBranchesSubTab24_7() {
        locationsPage.subTabs
                .filter(new Locator.FilterOptions().setHasText(Constants.TWENTY_FOUR_SEVEN_TX))
                .first()
                .click();
        return this;
    }

    public LocationsSteps unSelectBranchesSubTab24_7() {
        locationsPage.subTabs
                .filter(new Locator.FilterOptions().setHasText(Constants.TWENTY_FOUR_SEVEN_TX))
                .first()
                .click();
        return this;
    }

    public LocationsSteps selectBranchesSubTabOpenNow() {
        locationsPage.subTabs
                .filter(new Locator.FilterOptions().setHasText(Constants.OPEN_NOW_TXT))
                .first()
                .click();
        return this;
    }

    public LocationsSteps unSelectBranchesSubTabOpenNow() {
        locationsPage.subTabs
                .filter(new Locator.FilterOptions().setHasText(Constants.OPEN_NOW_TXT))
                .first()
                .click();
        return this;
    }

    // ----------------------- LocationFilterTest ------------------------ \\
    public LocationsSteps chooseCityWithDropdown(String value) {
        locationsPage.dropdown.click();
        locationsPage.dropdownList
                .filter(new Locator.FilterOptions().setHasText(value))
                .first()
                .click();
        return this;
    }

    public LocationsSteps searchLocationInSearchBar(String value) {
        locationsPage.enableSearchBar.click();
        locationsPage.searchInput
                .fill(value);
        locationsPage.searchInput.press("Enter");
        return this;
    }
}
