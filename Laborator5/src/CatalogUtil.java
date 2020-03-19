import java.awt.*;
import java.io.*;
import java.net.URI;

public class CatalogUtil {

    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String fileName)
            throws InvalidCatalogException {
        try {
            FileInputStream fileStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileStream);
            return (Catalog) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void view(Document document) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(URI.create(document.getLocation()));
    }
}


