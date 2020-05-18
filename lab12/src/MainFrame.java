import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    int width;
    int height;
    ControlPanel controlPanel;
    DesignPanel designPanel;
    int dWidth, dHeight;
    int cWidth, cHeight;
    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public MainFrame(int width, int height, int dHeight, int dWidth,int cHeight,int cWidth) {
        this.width = width;
        this.height = height;
        this.setLayout(new BorderLayout());
        rootPane.setPreferredSize(new Dimension(this.width, this.height));
        this.setVisible(true);
        this.controlPanel = new ControlPanel(this,cWidth,cHeight);
        this.add(controlPanel, BorderLayout.NORTH);
        this.designPanel = new DesignPanel(this,dWidth,dHeight);
        this.add(designPanel, BorderLayout.CENTER);
        pack();
    }
}
