import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DrawableCar {
    private final Car _car;
    private final String _imgPath;
    private final int _width;
    private final int _height;
    private BufferedImage _image = null;

    public int getWidth() { return _width; }
    public int getHeight() { return _width; }
    public double getX() { return _car.getX(); }
    public double getY() { return _car.getY(); }
    public String getImgPath() { return _imgPath; }
    public Car getCar() { return _car; }

    public BufferedImage getImage() {
        if (_image != null) return _image;

        try {
            _image = ImageIO.read(DrawPanel.class.getResourceAsStream(getImgPath()));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

        return _image;
    }

    public DrawableCar(Car car, String imgPath, int width, int height) {
        _car = car;
        _imgPath = imgPath;
        _width = width;
        _height = height;
    }
}
