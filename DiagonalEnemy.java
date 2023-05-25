
import java.awt.*;

public class DiagonalEnemy extends VerticalEnemy 
{

    private int xspeed;
    private int screenWidth;
    private String imageName;
    
    public DiagonalEnemy(int x, int y, int w, int h, int sH, int yS, int sW, int xS, int L) {
    super(x,y,w,h,sH,yS, L);
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
            imageName = "images/cropleft.png";
        }
        rect.x += xspeed;
        if(rect.x - rect.width < 0)
        {
            xspeed = -xspeed;
            rect.x = 0 + (rect.width);
            imageName = "images/crocright.png";
        }
        rect.x += xspeed;
        
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(getRectangle().x, getRectangle().y, getRectangle().width, getRectangle().height);
        
        g.drawImage(getImage(),getRectangle().x, getRectangle().y, getRectangle().width, getRectangle().height,null);
    
    }
    public Image getImage(){
        return ImageLoader.loadCompatibleImage(imageName);
    }

}