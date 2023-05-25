
import java.awt.*;

import org.w3c.dom.css.Rect;

public class StalkerEnemy extends Enemy {

    private Rectangle playerRect;
    private int speed;

    public StalkerEnemy(int x, int y, int w, int h, int s, int L, Rectangle p) {
        super(x, y, w, h, L);
        speed = s;
        playerRect = p;
    }

    public void updateRect(Rectangle p) {
        playerRect = p;
    }

    public Color getColor() {
        return new Color(0, 0, 0);
    }

    public void move() {
        Rectangle ourRect = getRectangle();

        if (ourRect.x < playerRect.x) {
            ourRect.x += speed;
        } else if (ourRect.x > playerRect.x) {
            ourRect.x -= speed;
        }

        if (ourRect.y < playerRect.y) {
            ourRect.y += speed;
        } else if (ourRect.y > playerRect.y) {
            ourRect.y -= speed;
        }

    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(getRectangle().x, getRectangle().y, getRectangle().width, getRectangle().height);

        g.drawImage(getImage(), getRectangle().x, getRectangle().y, getRectangle().width, getRectangle().height, null);

    }

    public Image getImage() {
        return ImageLoader.loadCompatibleImage("images/crocdown.png");
    }

}