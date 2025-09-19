package tests;

import data.Constants;
import data.LocationDataProvider;
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

    @Test(dataProvider = "locationDataProvider", dataProviderClass = LocationDataProvider.class)
    public void validateCityAndLocationFilterTest(String city, String address) {
        homeSteps
                .openHomePage()
                .rejectCookies()
                .openMegaMenuNavbar()
                .navigateToLocationsPage();
        locationsSteps
                .chooseCityWithDropdown(city)
                .searchLocationInSearchBar(address);
    }
}
