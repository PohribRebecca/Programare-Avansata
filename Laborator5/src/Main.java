import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException, InvalidCatalogException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("java5", "E:\\Test\\java5.ser");
        Document document = new Document(1, "Java Course 1", "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        document.addTag("type", "Slides");
        catalog.add(document);
        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws InvalidCatalogException, IOException {
        Catalog catalog = CatalogUtil.load("E:\\Test\\java5.ser");
        assert catalog != null;
        Document document = catalog.findById(1);
        CatalogUtil.view(document);
    }
}
