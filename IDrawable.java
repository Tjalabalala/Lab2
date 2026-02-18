import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public interface IDrawable {
    public int getWidth();
    public int getHeight();
    public double getX();
    public double getY();
    public String getImagePath();

    public default BufferedImage getImage() {
        try {
            return ImageIO.read(DrawPanel.class.getResourceAsStream(getImagePath()));
        } catch (IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
}
