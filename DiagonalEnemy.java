
import java.awt.*;

public class DiagonalEnemy extends VerticalEnemy 
{

    private int xspeed;
    private int screenWidth;
    
    public DiagonalEnemy(int x, int y, int w, int h, int sH, int yS, int sW, int xS) {
    super(x,y,w,h,sH,yS);
    screenWidth = sW;
    xspeed = xS;
    }
    
    public Color getColor()
    {
        return new Color(255,3,255);
    }
    
    public void move()
    {
        Rectangle rect = getRectangle();
        super.move();
        rect.x += xspeed;
        if(rect.x + rect.width > screenWidth)
        {
            xspeed = -xspeed;
            rect.x = screenWidth - (rect.width);
        }
        rect.x += xspeed;
        if(rect.x - rect.width < 0)
        {
            xspeed = -xspeed;
            rect.x = 0 + (rect.width);
        }
        rect.x += xspeed;
        
    }
    
    public void draw(Graphics g) {
        //g.setColor(Color.RED);
        //g.fillRect(getRectangle().x, getRectangle().y, 30, 30);
        
        g.drawImage(getImage(),getRectangle().x, getRectangle().y, 30, 30,null);
    
    }
    public Image getImage(){
        return ImageLoader.loadCompatibleImage("Bird2.png");
    }

}