import java.awt.*;

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Crown
{
    // instance variables - replace the example below with your own
    private Rectangle crown;
    private int width;
    private int height;

    private String imageName;
    

    /**
     * Constructor for objects of class Player
     */
    public Crown(int x, int y, int w, int h)
    {
        // initialise instance variables
        crown = new Rectangle(x, y, w, h); //x y w h
        width = w;
        height = h;
        imageName = "images/crown.png";
        
        
    }
    
    public int getX()
    {
        return crown.x;
    }
    public int getY()
    {
        return crown.y;
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }
    
    public void x(int tx)
    {
        crown.x+= tx;
    }
    public void setX(int tx)
    {
        crown.x= tx;
    }
    public void y(int ty)
    {
        crown.y+= ty;
    }
    public void setY(int ty)
    {
        crown.y = ty;
    }
    
    public Rectangle getRect()
    {
        return crown;
    }
    
    public void getcrown()
    {
        imageName = "images/blank.png";
    }
    
    public Image getImage()
    {
        return ImageLoader.loadCompatibleImage(imageName);
    }

}