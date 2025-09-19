package data;

import org.testng.annotations.DataProvider;

public class OffersDataSupplier {
    @DataProvider(name = "offerFilters")
    public static Object[][] offersDataProvider() {
        return new Object[][]{
//                {"Travel"},
//                {"Shopping"},
//                {"Cafe and Restaurant"},
//                {"Home"},
//                {"Developers"},
                {"Category", "Travel"},
                {"Product Type", "TBC Card"},
                {"Offer Type", "Cashback"},
                {"Card Type", "MasterCard"}
        };
    }
}
