import javax.swing.*;
import java.awt.*;

public class DesignPanel extends JPanel {
    MainFrame frame;
    int width;
    int height;
    public DesignPanel(MainFrame frame,int width,int height)
    {
        this.width=width;
        this.height=height;
        this.frame=frame;
        setPreferredSize(new Dimension(this.width,this.height));

    }

}
