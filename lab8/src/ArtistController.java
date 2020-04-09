
import java.sql.*;

public class ArtistController implements ArtistControllerInterface {

    public void create(String name, String country) throws SQLException {
        try {
            Connection connection = Database.getConnection();
            Statement stmt = connection.createStatement();
            String sql = "insert into artists values (DEFAULT, '" + name + "','" + country + "');";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByName(String name) throws SQLException {
        try {
            Connection connection = Database.getConnection();
            Statement stmt = connection.createStatement();
            String sql = "select * from artists where name=\""+name+"\";";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String resultName = rs.getString(2);
                String resultCountry = rs.getString(3);
                System.out.println("The artist you search for is: "+resultName+" from: "+resultCountry);
            }

            }
        catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
