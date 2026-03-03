package View;

import Model.I2dObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public interface IDrawable extends I2dObject {
    public String getImagePath();

    public static class ImageCache {
        private static HashMap<String, BufferedImage> images = new HashMap<>();
        public static BufferedImage fetchImage(String path) {
            try {
                if (!images.containsKey(path))
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
}
