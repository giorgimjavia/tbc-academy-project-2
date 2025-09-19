package steps;

import util.MSSQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LocationDatabaseSteps {
    public static ResultSet getAllLocations() throws SQLException {
        Connection connection = MSSQLConnection.connection();
        Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );
        return statement.executeQuery("SELECT * FROM LocationAddress");
    }
}
