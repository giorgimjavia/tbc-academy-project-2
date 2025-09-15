package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import runners.BaseTest;
import steps.AllOffersSteps;
import steps.HomeSteps;
import steps.OffersSteps;

public class FillOffersTest extends BaseTest {
    HomeSteps homeSteps;
    OffersSteps offersSteps;
    AllOffersSteps allOffersSteps;

    @BeforeClass
    public void initSteps() {
        homeSteps = new HomeSteps(page);
        offersSteps = new OffersSteps(page);
        allOffersSteps = new AllOffersSteps(page);
    }

    @Test()
    public void filterAndResetResultedOffersTest() {
        homeSteps
                .openHomePage()
                .rejectCookies()
                .openMegaMenuNavbar()
                .navigateToOffersPage();
        offersSteps
                .navigateToAllOffersPage();
        allOffersSteps
                .checkAnyCategoryInOffers()
                .validateListUpdate()
                .uncheckSelectedCategory();
    }
}
