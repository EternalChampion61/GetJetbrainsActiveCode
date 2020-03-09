package online.hugesea.scholar.jba.Layout;

import javax.swing.*;

public class Layout {
    private int Height, Width;
    private String Title;

    /**
     * Control height of layout.
     * @param height: Height of layout.
     */
    public void setHeight(int height) {
        Height = height;
    }

    /**
     * Control height of layout.
     * @param title: Title of layout.
     */
    public void setTitle(String title) {
        Title = title;
    }

    /**
     * Control height of layout.
     * @param width: Width of layout.
     */
    public void setWidth(int width) {
        Width = width;
    }

    /**
     * Create layout.
     */
    public void initLayout() {
        JFrame frame = new JFrame(Title);
        frame.setSize(Width, Height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        PlaceComponents.placeComponents(panel);
        frame.setVisible(true);
    }
}
