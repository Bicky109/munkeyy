
import java.awt.*;

public class VerticalEnemy extends Enemy
{
    private int speed;
    private int screenHeight;
    private String imageName1 = "images/crocdown.png";

    public VerticalEnemy(int x, int y, int w, int h, int sH, int yS, int L) 
    {
    super(x,y,w,h,L);
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
            imageName1 = "images/crocup.png";
        }
        rect.y += speed;
        if(rect.y - rect.width < 0)
        {
            speed = -speed;
            rect.y = 0 + (rect.width);
            imageName1 = "images/crocdown.png";
        }
        rect.y += speed;
        
    }
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(getRectangle().x, getRectangle().y, 50, 30);
        
        g.drawImage(getImage(),getRectangle().x, getRectangle().y, 50, 30,null);
    
    }
    public Image getImage(){
        return ImageLoader.loadCompatibleImage(imageName1);
    }
}