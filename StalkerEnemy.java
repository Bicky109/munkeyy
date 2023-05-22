
import java.awt.*;

public class StalkerEnemy extends Enemy
{
    
    private Rectangle playerRect;
    
    public StalkerEnemy(int x, int y, int w, int h, Rectangle p) 
    {
        super(x,y,w,h);
        playerRect = p;
    }
    
    public Color getColor()
    {
        return new Color(0,0,0);
    }
    
    public void move()
    {
        Rectangle ourRect = getRectangle();
        
        if(ourRect.x < playerRect.x)
        {
            ourRect.x += 1;
        }
        else if(ourRect.x > playerRect.x)
        {
            ourRect.x -= 1;
        }
        
        if(ourRect.y < playerRect.y)
        {
            ourRect.y += 1;
        }
        else if (ourRect.y > playerRect.y)
        {
            ourRect.y -= 1;
        }
        
        
    }
    
    public void draw(Graphics g) {
        //g.setColor(Color.WHITE);
        //g.fillRect(getRectangle().x, getRectangle().y, 30, 30);
        
        g.drawImage(getImage(),getRectangle().x, getRectangle().y, 30, 30,null);
    
    }
    public Image getImage(){
        return ImageLoader.loadCompatibleImage("snake.png");
    }
    
}