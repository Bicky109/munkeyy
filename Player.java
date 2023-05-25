
import java.awt.*;

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player {
    // instance variables - replace the example below with your own
    private Rectangle player;
    private Rectangle sword;
    private int width;
    private int height;
    private boolean hasSword;
    private boolean canGetHit = true;
    private boolean isAttacking = false;
    private int fCount = -1;
    private int SFCount = -1;
    private boolean canX = true;
    private boolean hasCrown;

    private String imageName;

    /**
     * Constructor for objects of class Player
     */
    public Player(int x, int y, int w, int h) {
        // initialise instance variables
        player = new Rectangle(x, y, w, h); // x y w h
        width = w;
        height = h;
        imageName = "images/playerdownnosword.png";

    }

    public void attack() {
        if (hasSword) {
            isAttacking = true;
            if (!hasCrown) {
                if (imageName.equals("images/playerup.png")) {
                    sword = new Rectangle(player.x - 5, player.y - 60, 60, 75);
                    imageName = "images/playerswordup.png";
                    SFCount = 8;
                    canX = false;
                } else if (imageName.equals("images/playerdown.png")) {
                    sword = new Rectangle(player.x + 5, player.y + 60, 60, 75);
                    imageName = "images/playersworddown.png";
                    SFCount = 8;
                    canX = false;
                } else if (imageName.equals("images/playerleft.png")) {
                    sword = new Rectangle(player.x - 70, player.y + 5, 75, 60);
                    imageName = "images/playerswordleft.png";
                    SFCount = 8;
                    canX = false;
                } else if (imageName.equals("images/playerright.png")) {
                    sword = new Rectangle(player.x + 45, player.y + 5, 75, 60);
                    imageName = "images/playerswordright.png";
                    SFCount = 8;
                    canX = false;
                }
            } else {
                if (imageName.equals("images/playerupcrown.png")) {
                    sword = new Rectangle(player.x - 5, player.y - 60, 60, 75);
                    imageName = "images/playerswordupcrown.png";
                    SFCount = 8;
                    canX = false;
                } else if (imageName.equals("images/playerdowncrown.png")) {
                    sword = new Rectangle(player.x + 5, player.y + 60, 60, 75);
                    imageName = "images/playersworddowncrown.png";
                    SFCount = 8;
                    canX = false;
                } else if (imageName.equals("images/playerleftcrown.png")) {
                    sword = new Rectangle(player.x - 70, player.y + 5, 75, 60);
                    imageName = "images/playerswordleftcrown.png";
                    SFCount = 8;
                    canX = false;
                } else if (imageName.equals("images/playerrightcrown.png")) {
                    sword = new Rectangle(player.x + 45, player.y + 5, 75, 60);
                    imageName = "images/playerswordrightcrown.png";
                    SFCount = 8;
                    canX = false;
                }
            }
        }
    }

    public void SFCount() {
        SFCount--;
        if (SFCount <= 1) {
            sword = null;
            SFCount = -1;
            isAttacking = false;
            canX = true;
            if (!hasCrown) {
                if (imageName.equals("images/playerswordup.png")) {
                    imageName = "images/playerup.png";
                } else if (imageName.equals("images/playersworddown.png")) {
                    imageName = "images/playerdown.png";
                } else if (imageName.equals("images/playerswordleft.png")) {
                    imageName = "images/playerleft.png";
                } else if (imageName.equals("images/playerswordright.png")) {
                    imageName = "images/playerright.png";
                }
            } else {
                if (imageName.equals("images/playerswordupcrown.png")) {
                    imageName = "images/playerupcrown.png";
                } else if (imageName.equals("images/playersworddowncrown.png")) {
                    imageName = "images/playerdowncrown.png";
                } else if (imageName.equals("images/playerswordleftcrown.png")) {
                    imageName = "images/playerleftcrown.png";
                } else if (imageName.equals("images/playerswordrightcrown.png")) {
                    imageName = "images/playerrightcrown.png";
                }
            }
        }
    }

    public boolean getCanX() {
        return canX;
    }

    public int getSFCount() {
        return SFCount;
    }

    public boolean canGetHit() {

        if (fCount < 0) {
            canGetHit = true;
            fCount = -1;
        }
        return canGetHit;
    }

    public Rectangle getRectSword() {
        return sword;
    }

    public void bounce() {
        if (imageName.equals("images/playerup.png") || imageName.equals("images/playerupnosword.png")
                || imageName.equals("images/playerupcrown.png") || imageName.equals("images/playerswordup.png")
                || imageName.equals("images/playerswordupcrown.png")) {
            player.y += 42;
        } else if (imageName.equals("images/playerdown.png") || imageName.equals("images/playerdownnosword.png")
                || imageName.equals("images/playerdowncrown.png") || imageName.equals("images/playersworddown.png")
                || imageName.equals("images/playersworddowncrown.png")) {
            player.y -= 42;
        } else if (imageName.equals("images/playerleft.png") || imageName.equals("images/playerleftnosword.png")
                || imageName.equals("images/playerleftcrown.png") || imageName.equals("images/playerswordleft.png")
                || imageName.equals("images/playerswordleftcrown.png")) {
            player.x += 42;
        } else if (imageName.equals("images/playerright.png") || imageName.equals("images/playerrightnosword.png")
                || imageName.equals("images/playerrightcrown.png") || imageName.equals("images/playerswordright.png")
                || imageName.equals("images/playerswordrightcrown.png")) {
            player.x -= 42;
        }
    }

    public void hit() {
        canGetHit = false;
        fCount = 30;
    }

    public void setImageName(String name) {
        imageName = name;
    }

    public int getFCount() {
        return fCount;
    }

    public void fCount() {
        fCount--;
    }

    public int getX() {
        return player.x;
    }

    public int getY() {
        return player.y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void x(int tx) {
        player.x += tx;
    }

    public void setX(int tx) {
        player.x = tx;
    }

    public void y(int ty) {
        player.y += ty;
    }

    public void setY(int ty) {
        player.y = ty;
    }

    public Rectangle getRect() {
        return player;
    }

    public void getSword() {
        hasSword = true;
    }

    public boolean getHasSword() {
        return hasSword;
    }

    public void up() {
        if (!isAttacking) {
            if (!hasCrown) {
                if (hasSword) {
                    imageName = "images/playerup.png";
                } else {
                    imageName = "images/playerupnosword.png";
                }
            } else {
                imageName = "images/playerupcrown.png";
            }

            this.y(-6);
        }
    }

    public void down() {
        if (!isAttacking) {
            if (!hasCrown) {
                if (hasSword) {
                    imageName = "images/playerdown.png";
                } else {
                    imageName = "images/playerdownnosword.png";
                }
            } else {
                imageName = "images/playerdowncrown.png";
            }

            this.y(6);
        }
    }

    public void left() {
        if (!isAttacking) {
            if (!hasCrown) {
                if (hasSword) {
                    imageName = "images/playerleft.png";
                } else {
                    imageName = "images/playerleftnosword.png";
                }
            } else {
                imageName = "images/playerleftcrown.png";
            }
            this.x(-6);
        }
    }

    public void right() {
        if (!isAttacking) {
            if (!hasCrown) {
                imageName = "images/playerright.png";
            } else {
                imageName = "images/playerrightcrown.png";
            }
            this.x(6);
        }
    }

    public void diagUpRight() {
        if (!isAttacking) {
            if (!hasCrown) {
                imageName = "images/playerright.png";
            } else {
                imageName = "images/playerrightcrown.png";
            }
            this.y(-6);
            this.x(6);
        }
    }

    public void diagUpLeft() {
        if (!isAttacking) {
            if (!hasCrown) {
                if (hasSword) {
                    imageName = "images/playerleft.png";
                } else {
                    imageName = "images/playerleftnosword.png";
                }
            } else {
                imageName = "images/playerleftcrown.png";
            }

            this.y(-6);
            this.x(-6);
        }
    }

    public void diagDownRight() {
        if (!isAttacking) {
            if (!hasCrown) {
                imageName = "images/playerright.png";
            } else {
                imageName = "images/playerrightcrown.png";
            }

            this.y(6);
            this.x(6);
        }
    }

    public void diagDownLeft() {
        if (!isAttacking) {
            if (!hasCrown) {
                if (hasSword) {
                    imageName = "images/playerleft.png";
                } else {
                    imageName = "images/playerleftnosword.png";
                }
            } else {
                imageName = "images/playerleftcrown.png";
            }
            this.y(6);
            this.x(-6);
        }
    }

    public void getCrown() {
        hasCrown = true;
    }

    public String getImageName() {
        return imageName;
    }

    public Image getImage() {
        return ImageLoader.loadCompatibleImage(imageName);
    }

}
