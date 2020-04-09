import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database database = null;
    private static Connection connection = null;

    private Database() {
    }

    public Database getInstance() {
        if (database == null) {
            try {
                database=new Database();
                connection = DriverManager.getConnection("jdbc:mysql://localhost/musicalbums", "dba", "sql1");
            }
            catch (SQLException e) {
                System.err.println("Cannot connect to DB: " + e);
            }
        }
        return database;
    }


    public static Connection getConnection() {

        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/musicalbums", "dba", "sql1");
            } catch (SQLException e) {
                System.err.println("Cannot connect to DB: " + e);
            }
        }
        return connection;
    }
}

