
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumController implements AlbumControllerInterface{

    public void create(String name, int artistId, int releaseYear) throws SQLException {
        try {
            Connection connection=Database.getConnection();
            Statement stmt = connection.createStatement();
            String sql ="insert into albums values (0,'"+name+"','"+artistId+"','"+releaseYear+"');";
            stmt.executeUpdate(sql);
        } catch (Exception e)
        {
            System.out.println(e);
        }

    }
    public void findByArtist(int artistId){
        try {
            Connection connection=Database.getConnection();
            Statement stmt = connection.createStatement();
            String sql ="select * from albums where artist_id="+artistId+";";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String resultName = rs.getString(2);
                int resultReleaseYear = rs.getInt(4);
                System.out.println("The album you search for is: "+resultName+" from: "+resultReleaseYear);
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
