import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lives
{
    // instance variables - replace the example below with your own
    private Rectangle life;
    private int width;
    private int height;
    private int lifeCount;
    private int fCount = -1;
    private boolean fCountBool =false;
    private String imageName;
    

    /**
     * Constructor for objects of class Player
     */
    public Lives(int x, int y, int w, int h)
    {
        // initialise instance variables
        life = new Rectangle(x, y, w, h); //x y w h
        width = w;
        height = h;
        lifeCount = 3;
        imageName = "fulllife.png";
        
        
    }
    
    public int getX()
    {
        return life.x;
    }
    public int getY()
    {
        return life.y;
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }
    
    
    public void setX(int tx)
    {
        life.x= tx;
    }
    
    public void setY(int ty)
    {
        life.y = ty;
    }
    
    public Rectangle getRect()
    {
        return life;
    }
    
    public void startFCount()
    {
        fCount = 30;
    }
    
    public int getFCount()
    {
        return fCount;
    }
    
    public int getLifeCount()
    {
        return lifeCount;
    }
    
    public void loseLife()
    {
        lifeCount--;
        fCount = -1;
    }
    
    
    public void fCount()
    {
        fCount --;
        if(fCount < 0)
        {
            fCount = -1;
        }
        if(lifeCount == 3 && fCount <= 30 && fCount > 28)
        {
            imageName = "3lifesad.png";
        }
        else if(lifeCount == 3 && fCount < 28 && fCount > 23)
        {
            imageName = "3lifebroke.png";
        }
        else if(lifeCount == 3 && fCount <= 23 && fCount > 0)
        {
            imageName = "3lifeblank.png";
            this.loseLife();
        }
        if(lifeCount == 2 && fCount <= 30 && fCount > 28)
        {
            imageName = "2lifesad.png";
        }
        else if(lifeCount == 2 && fCount < 28 && fCount > 23)
        {
            imageName = "2lifebroke.png";
        }
        else if(lifeCount == 2 && fCount <= 23 && fCount > 0)
        {
            imageName = "2lifeblank.png";
            this.loseLife();
        }
        if(lifeCount == 1 && fCount <= 30 && fCount > 28)
        {
            imageName = "1lifesad.png";
        }
        else if(lifeCount == 1 && fCount < 28 && fCount > 23)
        {
            imageName = "1lifebroke.png";
        }
        else if(lifeCount == 1 && fCount <= 23 && fCount > 0)
        {
            imageName = "blank.png";
            this.loseLife();
        }
    }
    
    public Image getImage()
    {
        return ImageLoader.loadCompatibleImage(imageName);
    }
    
}
