
import java.awt.*;


public class SporeEnemy extends SpinningEnemy
{
 
    private double range;
    private double count;
    private int radius;

    public SporeEnemy(int x, int y, int w, int h, int r, double theRange, int L)
    {
        super(x,y,w,h,r, L);
        range = theRange;
        count = 0;
        radius = r;
    }
    
    public Color getColor()
    {
        return new Color(255,255,3);
    }
    
    public void move()
    {
        count += 1;
        super.move();
        if(((int)count) == range)
        {
            count = 0;
            changeR(radius);
        }
        changeR((super.getR() + count));
    }
    
    public void draw(Graphics g) {
    
        //g.setColor(Color.RED);
        //g.fillRect(getRectangle().x, getRectangle().y, getRectangle().width, getRectangle().height);
        
        g.drawImage(getImage(),getRectangle().x - 5, getRectangle().y -5, 30, 30,null);
   
        
        g.setColor(new Color(250, 146, 0));
        g.fillOval((getX() - 10), (getY() - 10), 20, 20);
    }
    public Image getImage(){
        return ImageLoader.loadCompatibleImage("bee.png");
    }

}