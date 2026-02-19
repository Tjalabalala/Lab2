import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public interface IDrawable {
    public int getWidth();
    public int getHeight();
    public double getX();
    public double getY();
    public String getImagePath();

    public static class ImageCache {
        private static HashMap<String, BufferedImage> images = new HashMap<>();
        public static BufferedImage fetchImage(String path) {
            if (images.containsKey(path))
                return images.get(path);

            try {
                images.put(path, ImageIO.read(DrawPanel.class.getResourceAsStream(path)));
                return images.get(path);
            } catch (IOException ex)
            {
                ex.printStackTrace();
                return null;
            }
        }
    }

    public default BufferedImage getImage() {
        return ImageCache.fetchImage(getImagePath());
    }

    public default boolean pointCollision(double x, double y) {
        return getX() <= x && x <= getX() + getWidth()
            && getY() <= y && y <= getY() + getHeight();
    }

    public default boolean overlaps(IDrawable other) {
        return  pointCollision(other.getX()                     , other.getY())
        ||      pointCollision(other.getX()+other.getWidth() , other.getY())
        ||      pointCollision(other.getX()                     , other.getY()+other.getHeight())
        ||      pointCollision(other.getX()+other.getWidth() , other.getY()+other.getHeight());
    }
}
