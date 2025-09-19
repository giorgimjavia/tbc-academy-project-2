package steps;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.WaitForSelectorState;
import data.Constants;
import org.testng.Assert;
import pages.HomePage;
import util.Config;

import java.io.File;

public class HomeSteps {
    Page page;
    HomePage homePage;

    public HomeSteps(Page page) {
        this.page = page;
        this.homePage = new HomePage(page);
    }

    public HomeSteps openHomePage() {
        page.navigate(Constants.TBC_URL);
        return this;
    }

    public HomeSteps rejectCookies() {
        try {
            homePage.rejectCookies.waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setTimeout(2000));
            if (homePage.rejectCookies.count() > 0 && homePage.rejectCookies.isVisible()) {
                homePage.rejectCookies.click();
                System.out.println("Cookies rejected!");
            } else {
                System.out.println("Skip rejecting cookies");
            }
        } catch (PlaywrightException e) {
            System.out.println("Cookie banner not present");
        }
        return this;
    }

    public HomeSteps openMegaMenuNavbar() {
        if (Config.isMobileDevice()) {
            homePage.hamburgerMenu.click();
        } else {
            homePage.megaMenuNavbar.first().hover();
        }
        return this;

//        rejectCookies();
//        if (Config.isMobileDevice()) {
//            homePage.hamburgerMenu.click();
//            homePage.megaMenuNavbar.first().waitFor(
//                    new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE)
//            );
//            homePage.megaMenuNavbar.first().click();
//            System.out.println("Mobile menu opened!");
//        } else {
//            homePage.megaMenuNavbar.first().hover();
//            System.out.println("Desktop mega menu hovered!");
//        }

//        return this;
    }

    public HomeSteps navigateToLocationsPage() {
        homePage.locationsLink
                .click();
        return this;
    }

    public HomeSteps navigateToOffersPage() {
        homePage.offersLink.click();
        return this;
    }

    public HomeSteps navigateToCurrencyExchangePage() {
        homePage.currencyExchangeLink.click();
        return this;
    }

    // ----------------------- SiteSearchTest ------------------------ \\
    public HomeSteps clickSearchButton() {
        homePage.searchBtn.click();
        return this;
    }

    public HomeSteps fillNonValidDataInSearch(String value) {
        homePage.searchBar.fill(value);
        return this;
    }

    public HomeSteps validateEmptyResults() {
        String actualText = homePage.emptyResult.innerText();
        Assert.assertTrue(
                actualText.contains(Constants.EMPTY_RESULT_MESSAGE),
                "Expected empty result message to contain: " + Constants.EMPTY_RESULT_MESSAGE
                        + " but found: " + actualText
        );
        return this;
    }

    public HomeSteps clearSearchInput() {
        homePage.searchBar.fill("");
        return this;
    }

    public HomeSteps fillSearchBar(String value) {
        homePage.searchBar.fill(value);
        return this;
    }

    public HomeSteps validateListResults() {
        Assert.assertFalse(homePage.resultsList.count() > 0, "Results list is empty");
        Assert.assertFalse( homePage.resultsList.filter(new Locator.FilterOptions().setHasText(Constants.SEARCH_DATA))
                .first() .isVisible(),
                "Expected result with text: " + Constants.SEARCH_DATA + " not found" );
        return this;
    }

    public HomeSteps navigateToResultedPage() {
        if (homePage.resultListsBtn.count() > 0) {
            homePage.resultListsBtn.first().click();
        }
        return this;
    }

    // ----------------------- ProductDetailsTest ------------------------ \\
    public HomeSteps verifyExternalLinkTarget() {
        String target = homePage.productBlank.getAttribute("target");
        if ("_blank".equals(target)) {
            throw new AssertionError("Expected link target='_blank', but got: " + target);
        }
        return this;
    }

    public HomeSteps verifyCTAButton() {
        String text = homePage.productBlankButton.innerText();
        if (!text.contains(Constants.READ_MORE_TXT)) {
            throw new AssertionError("CTA button text mismatch. Found: " + text);
        }
        return this;
    }

    public HomeSteps navigateToProductPage() {
        homePage.productBlankButton.click();
        return this;
    }

    // ----------------------- ChatbotInteractionTest ------------------------ \\
    public HomeSteps openQuickAction() {
        homePage.quickActionBtn.click();
        return this;
    }

    public HomeSteps openChatBot() {
        homePage.chatbotBtn.click();
        return this;
    }

    public HomeSteps sendMessageToChatbot(String value) {
        page.frameLocator("iframe[name='Messaging window']")
                .locator("#composer-input")
                .fill(value);

        page.frameLocator("iframe[name='Messaging window']")
                .locator("#composer-input")
                .press("Enter");
        return this;
    }

    public HomeSteps uploadingFile(File file) {
        FrameLocator frame = page.frameLocator("iframe[name='Messaging window']");
        frame.locator("input[type='file']")
                .setInputFiles(file.toPath());
        return this;
    }

    public HomeSteps closeChatbot() {
        FrameLocator frame = page.frameLocator("iframe[name='Messaging window']");
        Locator closeButton = frame.locator("button[aria-label='Close']");
        closeButton.click();
        return this;
    }
}
