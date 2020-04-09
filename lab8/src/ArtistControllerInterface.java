import java.sql.SQLException;

public interface ArtistControllerInterface {
    public void create(String name, String country) throws SQLException;
    public void findByName(String name) throws SQLException;
}
