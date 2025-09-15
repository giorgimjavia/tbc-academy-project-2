package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    public Locator
            locationsLink,
            offersLink,
            currencyExchangeLink,
            searchBtn,
            searchBar,
            emptyResult,
            hamburgerMenu,
            productBlank,
            productBlankButton,
            rejectCookies,
            quickActionBtn,
            chatbotBtn,
            chatbotInput,
            chatbotIFrame,
            uploadFileInput,
            closeChatbotBtn,
            resultsList,
            resultListsBtn,
            megaMenuNavbar;

    public HomePage(Page page) {
        this.locationsLink = page.locator("//span[contains(@class, 'item__title') and text()=' Locations']");
        this.offersLink = page.locator("//span[contains(@class, 'item__title') and text()=' Offers']");
        this.currencyExchangeLink = page.locator("//span[contains(@class, 'item__title') and text()=' Currency Exchange']");
        this.searchBtn = page.locator("//button[contains(@class, 'search__button')]");
        this.searchBar = page.locator("//input[contains(@id, 'tbcx-text-input')]");
        this.emptyResult = page.locator("//p[contains(@class, 'not-fount-result__title')]");
        this.hamburgerMenu = page.locator("//button[contains(@class, 'hamburger-menu')]");
        this.productBlank = page.locator("//a[contains(@href, 'tbcconcept') and @target='_blank']");
        this.productBlankButton = page.locator("//a[contains(@href, 'tbcconcept') and @target='_blank']//button[text()='Read more']");
        this.rejectCookies = page.locator("//button[text()=' Reject All ']");
        this.quickActionBtn = page.locator("//div[@class='quick-action-item']//button[contains(@class, 'primary')]");
        this.chatbotBtn = page.locator("//div[@class='quick-action-item']//button[contains(@class, 'secondary')]");
        this.chatbotInput = page.locator("#composer-input");
        this.chatbotIFrame = page.locator("//iframe[@name='Messaging window']");
        this.uploadFileInput = page.locator("input[type='file']");
        this.closeChatbotBtn = page.locator("//button[@aria-label='Close']");
        this.resultsList = page.locator(".search-result-item__title");
        this.resultListsBtn = page.locator("//h3[@class='search-result-item__title']//following-sibling::tbcx-pw-button");
        this.megaMenuNavbar = page.locator("//div[contains(@class, 'navigation-item__link')]");
    }
}
