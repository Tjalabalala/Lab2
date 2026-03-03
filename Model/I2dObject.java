package Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import View.*;

public interface I2dObject {
    public int getWidth();
    public int getHeight();
    public double getX();
    public double getY();

    public default boolean pointCollision(double x, double y) {
        return getX() <= x && x <= getX() + getWidth()
            && getY() <= y && y <= getY() + getHeight();
    }

    public default boolean overlaps(I2dObject other) {
        return  pointCollision(other.getX()                     , other.getY())
        ||      pointCollision(other.getX()+other.getWidth() , other.getY())
        ||      pointCollision(other.getX()                     , other.getY()+other.getHeight())
        ||      pointCollision(other.getX()+other.getWidth() , other.getY()+other.getHeight());
    }
}
