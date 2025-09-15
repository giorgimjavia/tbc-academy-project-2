package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import runners.BaseTest;
import steps.HomeSteps;
import steps.LocationsSteps;

public class LocationTabsTest extends BaseTest {
    HomeSteps homeSteps;
    LocationsSteps locationsSteps;

    @BeforeClass
    public void initSteps() {
        homeSteps = new HomeSteps(page);
        locationsSteps = new LocationsSteps(page);
    }

    @Test()
    public void locationsTabAndSubtabsTest() {
        homeSteps
                .openHomePage()
                .rejectCookies()
                .openMegaMenuNavbar()
                .navigateToLocationsPage();
        locationsSteps
                .selectAtmsTab()
                .selectATMsSubTab24_7()
                .unSelectATMsSubTab24_7()
                .selectATMsSubTabOpenNow()
                .unSelectATMsSubTabOpenNow()
                .selectBranchesTab()
                .selectBranchesSubTab24_7()
                .unSelectBranchesSubTab24_7()
                .selectBranchesSubTabOpenNow()
                .unSelectBranchesSubTabOpenNow();
    }
}
