package runners;

import com.microsoft.playwright.*;
import data.Constants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    public static Page page;

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setHeadless(false);
        browser = playwright.chromium().launch(launchOptions);
        context = browser.newContext();
        page =  context.newPage();
        page.navigate(Constants.TBC_URL);
    }

    @AfterClass
    public void tearDown() {
        context.close();
        browser.close();
        playwright.close();
    }
}
