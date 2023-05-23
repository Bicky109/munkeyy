import java.awt.Rectangle;
public abstract class Door {
    private Rectangle rect;
    private boolean canUse;
    private int fCount = 50;

    public Door(int x, int y, int width, int height) {
        rect = new Rectangle(x, y, width, height);
        canUse = true;
    }

    public Rectangle getRect() {
        return rect;
    }

    public int getX() {
        return rect.x;
    }

    public int getY() {
        return rect.y;
    }

    public boolean canUse() {
        if(fCount <= 1)
        {
            canUse = true;
            fCount = -1;
            return canUse;
        }
        return canUse;
    }

    public void use() {
        canUse = false;
        fCount = 50;
    }

    public int getFCount() {
        return fCount;
    }

    public void fCount() {
        fCount--;
    }

    public boolean intersects(Rectangle p) {
        return rect.intersects(p);
    }

    public String getName() {
        return "Door";
    }
}
