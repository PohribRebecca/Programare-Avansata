import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ControlPanel extends JPanel {
    MainFrame frame;
    int width;
    int height;
    JLabel typeName = new JLabel("Type");
    JTextField defaultName = new JTextField(25);
    JLabel text = new JLabel("Text");
    JTextField defaultText = new JTextField(25);
    JButton create = new JButton("Add");

    public ControlPanel(MainFrame frame, int width, int height) {
        add(typeName, BorderLayout.WEST);
        add(defaultName, BorderLayout.WEST);
        add(create, BorderLayout.EAST);
        add(text, BorderLayout.NORTH);
        add(defaultText, BorderLayout.NORTH);
        add(create, BorderLayout.CENTER);
        this.width = width;
        this.height = height;
        this.frame = frame;
        setPreferredSize(new Dimension(this.width, this.height));
        buttonSetting();
    }

    private void buttonSetting() {
        create.addActionListener(e -> {
            try {
                JComponent componenta = createComponent(defaultName.getText(), defaultText.getText());
                frame.designPanel.add(componenta);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException ex) {
                ex.printStackTrace();
            }
        });

    }

    private JComponent createComponent(String name, String text) throws  IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {

        try {
            Class created = Class.forName(name);
            JComponent component = (JComponent) created.getConstructor().newInstance();
            setText(created, component, text);
            return component;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    private void setText (Class created, JComponent component, String text)
    {

        try {
            Method possibleText = created.getMethod("setText", String.class);
            possibleText.invoke(component,text);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }
    }


}
