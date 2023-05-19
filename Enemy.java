import java.awt.*;

public abstract class Enemy 
{
    private Rectangle rect;
    private int lives;
    private boolean canGetHit = true;
    private int fCount = -1;
    
    public Enemy(int x, int y, int w, int h) {
        rect = new Rectangle(x, y, w, h);
    }
    public Enemy(int x, int y, int w, int h, int l) {
        rect = new Rectangle(x, y, w, h);
        lives = l;
    }
    
    public Rectangle getRectangle() {
        return rect;
    }
    
    public boolean canGetHit()
    {
        if(fCount < 0)
        {
            canGetHit = true;
            fCount = -1;
        }
        return canGetHit;
    }
    
    public void hit()
    {
        canGetHit = false;
        fCount = 30;
        lives --;
    }
    
    public void fCount()
    {
        fCount --;
        if(fCount <= 3)
        {
            fCount = -1;
        }
    }
    public int getLives()
    {
        return lives;
    }
    public int getFCount()
    {
        return fCount;
    }
    
    public Enemy checkLives(Enemy e)
    {
        if(e.getLives() <=0)
        {
            System.out.println("die");
            return null;
        }
        else
        {
            return e;
        }
    }
    
    
    public boolean intersects(Rectangle p) {
        return rect.intersects(p);
    }
       
    public void draw(Graphics g) {
        g.drawImage(getImage(),rect.x, rect.y, rect.width, rect.height,null);
    }
    
    public Image getImage(){
        return ImageLoader.loadCompatibleImage("nameOfDefaultImage.png");
    }
    
    public abstract Color getColor();
    
    public abstract void move();
}