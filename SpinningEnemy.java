
import java.awt.*;

public class SpinningEnemy extends Enemy 
{

    private int centerX, centerY;
    private double radius;
    private double angle;
    private int speed;

     public SpinningEnemy(int cX, int cY, int w, int h, double r, int s, int L) {
        super(cX + ((int)r) - w/2, cY - h/2, w, h, L);
        
        this.speed= s;
        centerX = cX;
        centerY = cY;
        radius = r;
        angle = 0;
    }

    public Color getColor() {
        return new Color(randomColorNum(), randomColorNum(), randomColorNum());
    }
    
    public int randomColorNum() {
        return (int)(Math.random() * 256);
    }

    public void move() {
    
        angle += speed;
        
        Rectangle rect = getRectangle();
        
        rect.x = (int)(centerX + radius*Math.cos(Math.toRadians(angle))) - rect.width/2;
        rect.y = (int)(centerY + radius*Math.sin(Math.toRadians(angle))) - rect.height/2;
    }
    
    
    public int getX()
    {
        return centerX;
    }
    
    public int getY()
    {
        return centerY;    }
    
    public double getAngle()
    {
        return angle;
    }
    
    public void setAngle(double theAngle)
    {
        angle = theAngle;
    }
    
    
    public void setX(int x)
    {
        centerX = x;
    }
    
    public void setY(int y)
    {
        centerY = y;
    }
    
    public double getR()
    {
        return radius;
    }
    
    public void changeR(double r)
    {
        radius = r;
    }
    
    public Image getImage(){
        return ImageLoader.loadCompatibleImage("images/spider.png");
    }
    
    public void draw(Graphics g) {
     
       // g.setColor(Color.RED);
       // g.drawRect(getRectangle().x, getRectangle().y, getRectangle().width, getRectangle().height);

        g.drawImage(getImage(),getRectangle().x - (getRectangle().width / 8), getRectangle().y - (getRectangle().height / 8), getRectangle().width + (getRectangle().width / 4), getRectangle().height + (getRectangle().height / 4),null);
        
        //g.setColor(Color.BLACK);
        //g.fillOval(centerX-5, centerY-5, 10, 10);
    }
}