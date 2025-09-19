package data;

import org.testng.annotations.DataProvider;

public class OffersDataSupplier {
    @DataProvider(name = "offerFilters")
    public static Object[][] offersDataProvider() {
        return new Object[][]{
                {"Travel"},
                {"Shopping"},
                {"Cafe and Restaurant"},
                {"Home"},
                {"Leisure"},
                {"Developers"},
                {"Education"},
                {"Beauty & Health"},
                {"Auto"},
                {"Transport"},
                {"Accessories"},
                {"Clothes"},
                {"Online Partners"},
                {"Perfume"},
                {"Electronics"},
                {"Groceries"},
                {"For Kids"},
                {"Entertainment"},
                {"Flowers"}
        };
    }
}
