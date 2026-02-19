import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    private final ArrayList<IDrawable> drawables;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<IDrawable> draw) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        drawables = draw;

        // IO if they haven't been read yet
        for (IDrawable drawable : drawables) drawable.getImage();
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IDrawable drawable : drawables)
            g.drawImage(drawable.getImage(), (int)drawable.getX(), (int)drawable.getY(), null);
    }
}