import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.lang.Thread;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private Rectangle player;
    private Rectangle sword;
    private int width;
    private int height;
    private boolean hasSword;
    private boolean canGetHit = true;
    private boolean isAttacking = false;
    private int fCount = -1;
    private int SFCount = -1; 
    private boolean canX = true;

    private String imageName;
    

    /**
     * Constructor for objects of class Player
     */
    public Player(int x, int y, int w, int h)
    {
        // initialise instance variables
        player = new Rectangle(x, y, w,h); //x y w h
        width = w;
        height = h;
        imageName = "playerdownnosword.png";
        
        
    }
    
    public void attack()
    {
        if(hasSword)
        {   
            isAttacking = true;
            if(imageName.equals("playerup.png"))
            {
                sword = new Rectangle(player.x + 15, player.y -40, 30,50);
                imageName = "playerswordup.png";
                SFCount = 8;
                canX = false;
            }
            else if(imageName.equals("playerdown.png"))
            {
                sword = new Rectangle(player.x + 40, player.y + 75, 50,30);
                imageName = "playersworddown.png";
                SFCount = 8;
                canX = false;
            }
            else if(imageName.equals("playerleft.png"))
            {
                sword = new Rectangle(player.x - 35, player.y + 30, 50,30);
                imageName = "playerswordleft.png";
                SFCount = 8;
                canX = false;
            }
            else if(imageName.equals("playerright.png"))
            {
                sword = new Rectangle(player.x + 75, player.y + 30, 50,30);
                imageName = "playerswordright.png";
                SFCount = 8;
                canX = false;
            }
        }
    }
    
    public void SFCount()
    {
        SFCount --;
        if(SFCount <= 1)
        {
            sword = null;
            SFCount = -1;
            isAttacking = false;
            canX = true;
            if(imageName.equals("playerswordup.png"))
            {
                imageName = "playerup.png";
            }
            else if(imageName.equals("playersworddown.png"))
            {
                imageName = "playerdown.png";
            }
            else if(imageName.equals("playerswordleft.png"))
            {
                imageName = "playerleft.png";
            }
            else if(imageName.equals("playerswordright.png"))
            {
                imageName = "playerright.png";
            }
        }
    }
    
    public boolean getCanX()
    {
        return canX;
    }
    public int getSFCount()
    {
        return SFCount;
    }
    
    public boolean canGetHit()
    {   
    
        if(fCount < 0)
        {
            canGetHit = true;
            fCount = -1;
        }
        return canGetHit;
    }
    
    public Rectangle getRectSword()
    {
        return sword;
    }
    
    public void hit()
    {   
        canGetHit = false;
        fCount = 30;
    }
    
    public int getFCount()
    {
        return fCount;
    }
    
    public void fCount()
    {
        fCount--;
    }
    
    public int getX()
    {
        return player.x;
    }
    public int getY()
    {
        return player.y;
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
        player.x+= tx;
    }
    public void setX(int tx)
    {
        player.x= tx;
    }
    public void y(int ty)
    {
        player.y+= ty;
    }
    public void setY(int ty)
    {
        player.y = ty;
    }
    
    public Rectangle getRect()
    {
        return player;
    }
    
    public void getSword()
    {
        hasSword = true;
    }
    
    public boolean getHasSword()
    {
        return hasSword;
    }
    
    public void up()
    {   if(!isAttacking)
        {
            if(hasSword)
            {
                imageName = "playerup.png";
            }
            else
            {
                imageName = "playerupnosword.png";
            }
        
            this.y(-6);
        }
    }
    public void down()
    {
        if(!isAttacking)
        {
            if(hasSword)
            {
                imageName = "playerdown.png";
            }
            else
            {
                imageName = "playerdownnosword.png";
            }
        
            this.y(6);
        }
    }
    public void left()
    {
        if(!isAttacking)
        {
            if(hasSword)
            {
                imageName = "playerleft.png";
            }
            else
            {
                imageName = "playerleftnosword.png";
            }
        
            this.x(-6);
        }
    }
    public void right()
    {
        if(!isAttacking)
        {
            imageName = "playerright.png";
        
            this.x(6);
        }
    }
    public void diagUpRight()
    {
        if(!isAttacking)
        {
            imageName = "playerright.png";
        
            this.y(-6);
            this.x(6);
        }
    }
    public void diagUpLeft()
    {
        if(!isAttacking)
        {
            if(hasSword)
            {
                imageName = "playerleft.png";
            }
            else
            {
                imageName = "playerleftnosword.png";
            }
        
            this.y(-6);
            this.x(-6);
        }
    }
    public void diagDownRight()
    {
        if(!isAttacking)
        {
            imageName = "playerright.png";
        
            this.y(6);
            this.x(6);
        }
    }
    public void diagDownLeft()
    {
        if(!isAttacking)
        {
            if(hasSword)
            {
                imageName = "playerleft.png";
            }
            else
            {
                imageName = "playerleftnosword.png";
            }
        
            this.y(6);
            this.x(-6);
        }
    }
    

    
    public Image getImage()
    {
        return ImageLoader.loadCompatibleImage(imageName);
    }
    
}
