package data;

import org.testng.annotations.DataProvider;
import steps.LocationDatabaseSteps;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationDataProvider {
    @DataProvider(name = "locationDataProvider")
    public static Object[][] getLocationData() {
        try {
            ResultSet resultSet = LocationDatabaseSteps.getAllLocations();

            resultSet.last();
            int rowCount = resultSet.getRow();
            int columnCount = resultSet.getMetaData().getColumnCount();
            resultSet.beforeFirst();

            Object[][] data = new Object[rowCount][columnCount - 1];

            int iter = 0;
            while (resultSet.next()) {
                data[iter] = new Object[]{
                        resultSet.getString("city"),
                        resultSet.getString("address")
                };
                iter++;
            }
            return data;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
