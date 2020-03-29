import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Resident {

    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Resident(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "name='" + name + '\'' +
                '}';
    }
}

