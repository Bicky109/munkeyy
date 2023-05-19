import java.awt.*;

public class VerticalEnemy extends Enemy
{
    private int speed;
    private int screenHeight;

    public VerticalEnemy(int x, int y, int w, int h, int sH, int yS) 
    {
    super(x,y,w,h);
    speed = yS;
    screenHeight = sH;
    }
    
    public Color getColor()
    {
        return new Color(255,0,3);
    }
    
    public void move()
    {
        Rectangle rect = getRectangle();
        rect.y += speed;
        if(rect.y + rect.height > screenHeight)
        {
            speed = -speed;
            rect.y = screenHeight - (rect.width);
        }
        rect.y += speed;
        if(rect.y - rect.width < 0)
        {
            speed = -speed;
            rect.y = 0 + (rect.width);
        }
        rect.y += speed;
        
    }
    public void draw(Graphics g) {
        //g.setColor(Color.RED);
        //g.fillRect(getRectangle().x, getRectangle().y, 50, 30);
        
        g.drawImage(getImage(),getRectangle().x, getRectangle().y, 50, 30,null);
    
    }
    public Image getImage(){
        return ImageLoader.loadCompatibleImage("spider6.png");
    }
}