import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CityDAO {

    private static CityDAO uniqueInstance = null;
    private static Connection connection = null;

    private CityDAO(DBmanager db) { //precondition dbExisis()
        if ((connection = db.getConnection()) == null) //connect to the city db
            System.err.println(">>> CityDAO: The database doesn't exist ...");
    }

    // apply singleton design pattern to CityDao
    public static synchronized CityDAO getInstance(DBmanager db) {
        if (uniqueInstance == null)
            uniqueInstance = new CityDAO(db);
        return uniqueInstance;
    }

    public ArrayList<String> getCityNames(String cityName) {
        ArrayList<String> cityNames = new ArrayList<String>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM city WHERE name LIKE ?");
            preparedStatement.setString(1, cityName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                cityNames.add(resultSet.getString("name"));
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }// nothing we can do
        }
        return cityNames;
    }
}