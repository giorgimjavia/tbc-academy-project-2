package runners;

import com.microsoft.playwright.*;
import data.Constants;
import org.testng.annotations.*;
import util.Config;

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
//        launchOptions.setSlowMo(500);
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

//protected Playwright playwright;
//    protected Browser browser;
//    protected BrowserContext context;
//    public static Page page;
//
//    @BeforeClass
//    @Parameters({"browser", "device"}) // Pass browser type and device from TestNG XML
//    public void setUp(String browserName, String device) {
//        playwright = Playwright.create();
//        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
//        launchOptions.setHeadless(false); // Set to true for headless execution
//
//        // 1️⃣ Launch correct browser
//        switch (browserName.toLowerCase()) {
//            case "firefox":
//                browser = playwright.firefox().launch(launchOptions);
//                break;
//            case "webkit":
//                browser = playwright.webkit().launch(launchOptions);
//                break;
//            default:
//                browser = playwright.chromium().launch(launchOptions);
//                break;
//        }
//
//        // 2️⃣ Configure context for desktop or mobile
//        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions();
//        if (device.equalsIgnoreCase("mobile")) {
//            contextOptions.setViewportSize(375, 667) // iPhone X dimensions
//                    .setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X)");
//            Config.setMobileDevice(true);
//        } else {
//            Config.setMobileDevice(false);
//        }
//
//        context = browser.newContext(contextOptions);
//        page = context.newPage();
//        page.navigate(Constants.TBC_URL);
//    }
//
//    @AfterClass
//    public void tearDown() {
//        if (context != null) context.close();
//        if (browser != null) browser.close();
//        if (playwright != null) playwright.close();
//    }

}
