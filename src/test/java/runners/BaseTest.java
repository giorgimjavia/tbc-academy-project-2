package runners;

import com.microsoft.playwright.*;
import data.Constants;
import org.testng.annotations.*;
import util.Config;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    public Page page;

    @BeforeClass
    @Parameters({"device", "browser"})
    public void setUp(@Optional("desktop") String device, @Optional("chromium") String browserName) {
        if ("mobile".equalsIgnoreCase(device)) {
            Config.setMobileDevice(true);
        } else {
            Config.setMobileDevice(false);
        }
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setHeadless(true);
        switch (browserName.toLowerCase()) {
            case "firefox":
                browser = playwright.firefox().launch(launchOptions);
                break;
            case "webkit":
                browser = playwright.webkit().launch(launchOptions);
                break;
            default:
                browser = playwright.chromium().launch(launchOptions);
        }
        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions();
        if (Config.isMobileDevice()) {
            contextOptions.setViewportSize(375, 667);
        } else {
            contextOptions.setViewportSize(1440, 900);
        }
        context = browser.newContext(contextOptions);
        page = context.newPage();
        page.setDefaultTimeout(60000);
        page.navigate(Constants.TBC_URL);
    }

    @AfterClass
    public void tearDown() {
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}
