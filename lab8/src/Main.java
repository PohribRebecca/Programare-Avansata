import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        try {
           // Database database = new Database("jdbc:mysql://localhost/musicalbums");
            ArtistController artist = new ArtistController();
           /* artist.create("Tom Misch", "Australia");
            artist.create("Laura Vass", "Romania");
            artist.create("IAMDDB", "Anglia");*/

            AlbumController album = new AlbumController();
           /* album.create("blabla", 2, 2002);
            album.create("vara manelelor", 1, 1980);
            album.create("carantina", 9, 2021);*/

            artist.findByName("IAMDDB");
            album.findByArtist(2);

        } catch (SQLException e) {
                 e.printStackTrace();
        }

    }

}
