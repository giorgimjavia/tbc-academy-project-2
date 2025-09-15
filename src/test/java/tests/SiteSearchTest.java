package tests;

import data.Constants;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import runners.BaseTest;
import steps.HomeSteps;

public class SiteSearchTest extends BaseTest {
    HomeSteps homeSteps;

    @BeforeClass
    public void initSteps() {
        homeSteps = new HomeSteps(page);
    }

    @Test()
    public void siteSearchingByKeywordTest() {
        homeSteps
                .openHomePage()
                .rejectCookies()
                .clickSearchButton()
                .fillNonValidDataInSearch(Constants.NON_RESULT_DATA)
                .validateEmptyResults()
                .clearSearchInput()
                .fillSearchBar(Constants.SEARCH_DATA)
                .validateListResults()
                .navigateToResultedPage();
    }
}
