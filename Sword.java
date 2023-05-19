import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sword
{
    // instance variables - replace the example below with your own
    private Rectangle sword;
    private int width;
    private int height;

    private String imageName;
    

    /**
     * Constructor for objects of class Player
     */
    public Sword(int x, int y, int w, int h)
    {
        // initialise instance variables
        sword = new Rectangle(x, y, w, h); //x y w h
        width = w;
        height = h;
        imageName = "bananasword.png";
        
        
    }
    
    public int getX()
    {
        return sword.x;
    }
    public int getY()
    {
        return sword.y;
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
        sword.x+= tx;
    }
    public void setX(int tx)
    {
        sword.x= tx;
    }
    public void y(int ty)
    {
        sword.y+= ty;
    }
    public void setY(int ty)
    {
        sword.y = ty;
    }
    
    public Rectangle getRect()
    {
        return sword;
    }
    
    public void getSword()
    {
        imageName = "blank.png";
    }
    
    public Image getImage()
    {
        return ImageLoader.loadCompatibleImage(imageName);
    }
    
}
