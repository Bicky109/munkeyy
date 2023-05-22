
import java.awt.*;

public class StillEnemy extends Enemy
{

    public StillEnemy(int x, int y, int w, int h, int l) 
    {
        super(x,y,w,h,l);
    }
    
    public Color getColor()
    {
        return new Color(255,0,3);
    }
    
    public void move()
    {

        
    }
    
    public void draw(Graphics g) {
        //g.setColor(Color.RED);
        //g.fillRect(getRectangle().x, getRectangle().y, 50, 30);
        
        g.drawImage(getImage(),getRectangle().x, getRectangle().y, 40, 40,null);
    
    }
    public Image getImage(){
        return ImageLoader.loadCompatibleImage("images/stillenemy.png");
    }
}