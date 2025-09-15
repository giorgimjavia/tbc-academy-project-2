package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import runners.BaseTest;
import steps.HomeSteps;

public class ProductDetailsTest extends BaseTest {
    HomeSteps homeSteps;

    @BeforeClass
    public void initSteps() {
        homeSteps = new HomeSteps(page);
    }

    @Test()
    public void productsButtonAndVisibilityTest() {
        homeSteps
                .openHomePage()
                .rejectCookies()
                .verifyExternalLinkTarget()
                .verifyCTAButton()
                .navigateToProductPage();
    }
}
