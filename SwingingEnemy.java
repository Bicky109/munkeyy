
import java.awt.*;

public class SwingingEnemy extends SpinningEnemy 
{
    private int count;
    
    public SwingingEnemy(int cX, int cY, int w, int h, int r)
    {
        super(cX,cY,w,h,r);
        count = 0;
    }
    
    public Color getColor()
    {
        return new Color(130, 77, 17);
    }
    
    
    public void move() {
        super.move();
        if (getAngle() % 180 == 0)
        {
            count += 1;
    
            setX(getX() - 100);
            setAngle(0);
                
            if(count % 5 == 0)
            {
                setX(getX() + 500);
            }
        }
       
    }
    
    public Image getImage(){
        return ImageLoader.loadCompatibleImage("monkey.png");
    }
    
    public void draw(Graphics g) {
        
        //g.setColor(Color.RED);
        //g.fillRect(getRectangle().x, getRectangle().y, getRectangle().width, getRectangle().height);
        
        g.drawImage(getImage(),getRectangle().x -10, getRectangle().y - 10, 50, 50,null);
        
        g.setColor(new Color(25, 189, 46));
        g.fillOval((getX() - 5), (getY() - 5), 10, 10);
    }

    

}