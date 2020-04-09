import java.sql.SQLException;

public interface AlbumControllerInterface {
    public void create(String name, int artistId, int releaseYear) throws SQLException;
    public void findByArtist(int artistId);
}
