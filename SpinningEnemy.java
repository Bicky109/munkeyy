import java.awt.*;

public class SpinningEnemy extends Enemy 
{

    private int centerX, centerY;
    private double radius;
    private double angle;

     public SpinningEnemy(int cX, int cY, int w, int h, double r) {
        super(cX + ((int)r) - w/2, cY - h/2, w, h);
        
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
    
        angle += 3;
        
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
        return ImageLoader.loadCompatibleImage("tiger.png");
    }
    
    public void draw(Graphics g) {
     
        g.drawImage(getImage(),getRectangle().x -15, getRectangle().y -15, 60, 60,null);
    
        //g.setColor(Color.RED);
        //g.fillRect(getRectangle().x, getRectangle().y, 20, 20);
        
        //g.setColor(Color.BLACK);
        //g.fillOval(centerX-5, centerY-5, 10, 10);
    }
}