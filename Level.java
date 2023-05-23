import java.awt.*;
import java.awt.font.TextHitInfo;
import java.util.ArrayList;
public class Level {

    private Player player; //a rectangle that represents the player
    private Rectangle goal = new Rectangle(); //a rectangle that represents the goal
    private Sword sword;
    private Lives lives;
    private Enemy[] enemies = new Enemy[7]; //the array of Enemy objects
    private String imageName; //the name of the image to use for the level
    private boolean onLevel; //a boolean that tracks whether the player is on the level
    private boolean hasSword;
    private ArrayList<Door> doors = new ArrayList<Door>();

    private boolean up, down, left, right, x; //booleans that track which keys are currently pressed

    public Level(int playerX, int playerY, boolean doorLeft, boolean doorUp, boolean doorRight, boolean doorDown, boolean doesHaveSword, String theImageName)
    {
        up = down = left = right = x = false;

        player = new Player(playerX, playerY,50,60);
        lives = new Lives(15,15,128,128);
        hasSword = doesHaveSword;
        if(doorLeft)
        {
            doors.add(new LeftDoor(0, 200, 50, 200));
        }
        if(doorUp)
        {
            doors.add(new UpDoor(200, 0, 200, 50));
        }
        if(doorRight)
        {
            doors.add(new RightDoor(450, 200, 50, 200));
        }
        if(doorDown)
        {
            doors.add(new DownDoor(200, 450, 200, 50));
        }
        imageName = theImageName;
        

    }


    public void setOnLevel(boolean b)
    {
        onLevel = b;
    }

    public Lives getLives()
    {
        return lives;
    }

    public Enemy[] getEnemies()
    {
        return enemies;
    }

    public boolean getX()
    {
        return x;
    }
    public boolean getLeft()
    {
        return left;
    }
    public boolean getRight()
    {
        return right;
    }
    public boolean getUp()
    {
        return up;
    }
    public boolean getDown()
    {
        return down;
    }

    public Enemy getEnemy(int i)
    {
        return enemies[i];
    }

    public void setEnemy(int i, Enemy e)
    {
        enemies[i] = e;
    }

    public Player getPlayer()
    {
        return player;
    }

    public Sword getSword()
    {
        return sword;
    }

    public ArrayList<Door> getDoors()
    {
        return doors;
    }

    public boolean onLevel()
    {
        return onLevel;
    }

    public void setSword(Sword s)
    {
        sword = s;
    }

    public void clear()
    {
        up = down = left = right = x = false;
    }

    public void setX(boolean b)
    {
        x = b;
    }
    public void setLeft(boolean b)
    {
        left = b;
    }
    public void setRight(boolean b)
    {
        right = b;
    }
    public void setUp(boolean b)
    {
        up = b;
    }
    public void setDown(boolean b)
    {
        down = b;
    }

    public void getNextLevel()
    {

    }


    public Image getImage() {
        return ImageLoader.loadCompatibleImage(imageName);
    }
   

}
