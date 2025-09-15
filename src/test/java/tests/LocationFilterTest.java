package tests;

import data.Constants;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import runners.BaseTest;
import steps.HomeSteps;
import steps.LocationsSteps;

public class LocationFilterTest extends BaseTest {
    HomeSteps homeSteps;
    LocationsSteps locationsSteps;

    @BeforeClass
    public void initSteps() {
        homeSteps = new HomeSteps(page);
        locationsSteps = new LocationsSteps(page);
    }

    @Test()
    public void validateCityAndLocationFilterTest() {
        homeSteps
                .openHomePage()
                .rejectCookies()
                .openMegaMenuNavbar()
                .navigateToLocationsPage();
        locationsSteps
                .chooseCityWithDropdown(Constants.CITY_DATA)
                .searchLocationInSearchBar(Constants.CITY_LOCATION_DATA);
    }
}
