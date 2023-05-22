
import java.awt.*;

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
        imageName = "images/playerdownnosword.png";
        
        
    }
    
    public void attack()
    {
        if(hasSword)
        {   
            isAttacking = true;
            if(imageName.equals("images/playerup.png"))
            {
                sword = new Rectangle(player.x + 15, player.y -50, 60,75);
                imageName = "images/playerswordup.png";
                SFCount = 8;
                canX = false;
            }
            else if(imageName.equals("images/playerdown.png"))
            {
                sword = new Rectangle(player.x + 22, player.y + 75, 50,70);
                imageName = "images/playersworddown.png";
                SFCount = 8;
                canX = false;
            }
            else if(imageName.equals("images/playerleft.png"))
            {
                sword = new Rectangle(player.y - 40, player.y + 23, 75,50);
                imageName = "images/playerswordleft.png";
                SFCount = 8;
                canX = false;
            }
            else if(imageName.equals("images/playerright.png"))
            {
                sword = new Rectangle(player.x + 75, player.y + 30, 50,30);
                imageName = "images/playerswordright.png";
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
            if(imageName.equals("images/playerswordup.png"))
            {
                imageName = "images/playerup.png";
            }
            else if(imageName.equals("images/playersworddown.png"))
            {
                imageName = "images/playerdown.png";
            }
            else if(imageName.equals("images/playerswordleft.png"))
            {
                imageName = "images/playerleft.png";
            }
            else if(imageName.equals("images/playerswordright.png"))
            {
                imageName = "images/playerright.png";
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
    
    public void bounce()
    {
        if(imageName.equals("images/playerup.png") || imageName.equals("images/playerupnosword.png"))
            {
                player.y += 42;
                System.out.println(imageName);
            }
            else if(imageName.equals("images/playerdown.png") || imageName.equals("images/playerdownnosword.png"))
            {
                player.y -= 42;
            }
            else if(imageName.equals("images/playerleft.png") || imageName.equals("images/playerleftnosword.png"))
            {
                player.x += 42;
            }
            else if(imageName.equals("images/playerright.png") || imageName.equals("images/playerrightnosword.png"))
            {
                player.x -= 42;
            }
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
                imageName = "images/playerup.png";
            }
            else
            {
                imageName = "images/playerupnosword.png";
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
                imageName = "images/playerdown.png";
            }
            else
            {
                imageName = "images/playerdownnosword.png";
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
                imageName = "images/playerleft.png";
            }
            else
            {
                imageName = "images/playerleftnosword.png";
            }
        
            this.x(-6);
        }
    }
    public void right()
    {
        if(!isAttacking)
        {
            imageName = "images/playerright.png";
        
            this.x(6);
        }
    }
    public void diagUpRight()
    {
        if(!isAttacking)
        {
            imageName = "images/playerright.png";
        
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
                imageName = "images/playerleft.png";
            }
            else
            {
                imageName = "images/playerleftnosword.png";
            }
        
            this.y(-6);
            this.x(-6);
        }
    }
    public void diagDownRight()
    {
        if(!isAttacking)
        {
            imageName = "images/playerright.png";
        
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
                imageName = "images/playerleft.png";
            }
            else
            {
                imageName = "images/playerleftnosword.png";
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
