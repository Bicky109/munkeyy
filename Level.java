import java.awt.*;
import java.util.ArrayList;
public class Level {

    private Player player; //a rectangle that represents the player
    private Sword sword;
    private Lives lives;
    private Enemy[] enemies = new Enemy[7]; //the array of Enemy objects
    private String imageName; //the name of the image to use for the level
    private boolean onLevel; //a boolean that tracks whether the player is on the level
    private int levelNum;
    private int nextLevelNumLeft;
    private int nextLevelNumUp;
    private int nextLevelNumRight;
    private int nextLevelNumDown;
    private Door doorEnteredFrom;
    private boolean hasSword;
    private ArrayList<Door> doors = new ArrayList<Door>();

    private boolean up, down, left, right, x; //booleans that track which keys are currently pressed

    // new level consturcotr
    public Level(int levelNum, int nextLevelNumLeft, int nextLevelNumUp, int nextLevelNumRight, int nextLevelNumDown, int playerX, int playerY, boolean doorLeft, boolean doorUp, boolean doorRight, boolean doorDown, boolean doesHaveSword, String theImageName)
    {
        up = down = left = right = x = false;

        this.levelNum = levelNum;
        this.nextLevelNumLeft = nextLevelNumLeft;
        this.nextLevelNumUp = nextLevelNumUp;
        this.nextLevelNumRight = nextLevelNumRight;
        this.nextLevelNumDown = nextLevelNumDown;

        player = new Player(playerX, playerY,50,60);
        lives = new Lives(15,15,128,128);
        hasSword = doesHaveSword;
        if(doorLeft)
        {
            doors.add(new LeftDoor(60, 334, 50, 50));
        }
        if(doorUp)
        {
            //doors.add(new UpDoor(200, 0, 200, 50));
        }
        if(doorRight)
        {
            doors.add(new RightDoor(1170, 334, 50, 50));
        }
        if(doorDown)
        {
            //doors.add(new DownDoor(200, 450, 200, 50));
        }
        imageName = theImageName;
    }

    public void updateValues(Player p, Lives l, Door d)
    {
        player = p;
        lives = l;
        doorEnteredFrom = d;
    }

    public void setStartingPosition()
    {

    }

    public void setStartingPosition(int x, int y)
    {
        player.setX(x);
        player.setY(y);
    }

    public Door getDoorEnteredFrom()
    {
        return doorEnteredFrom;
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

    public boolean hasSword()
    {
        return hasSword;
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
        // if(hasSword)
        // {
        //     return sword;
        // }
        // return null;
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

    public int getNextLevel(Door d)
    {
        onLevel = false;
        this.clear();
        if(d.getName().equals("LeftDoor") && nextLevelNumLeft != -1)
        {
            return nextLevelNumLeft;
        }
        else if(d.getName().equals("UpDoor") && nextLevelNumUp != -1)
        {
            return nextLevelNumUp;
        }
        else if(d.getName().equals("RightDoor") && nextLevelNumRight != -1)
        {
            return nextLevelNumRight;
        }
        else if(d.getName().equals("DownDoor") && nextLevelNumDown != -1)
        {
            return nextLevelNumDown;
        }
        return 0;
    }


    public Image getImage() {
        return ImageLoader.loadCompatibleImage(imageName);
    }
   

}
