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

    /**
     * Constructor for objects of class Level
     * @param levelNum the level number
     * @param nextLevelNumLeft the level number of the level to the left
     * @param nextLevelNumUp the level number of the level above
     * @param nextLevelNumRight the level number of the level to the right
     * @param nextLevelNumDown the level number of the level below
     * @param playerX player's x position
     * @param playerY player's y position
     * @param doorLeft whether the level has a door left
     * @param doorUp wether the level has a door up
     * @param doorRight whether the level has a door right
     * @param doorDown whether the level has a door down
     * @param doesHaveSword whether the level has a sword
     * @param theImageName image name
     */
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
            doors.add(new UpDoor(590, 60, 50, 50));
        }
        if(doorRight)
        {
            doors.add(new RightDoor(1170, 334, 50, 50));
        }
        if(doorDown)
        {
            doors.add(new DownDoor(590, 610, 50, 50));
        }
        imageName = theImageName;
    }

    /**
     * Passes in the player, lives, and door entered from
     * @param p the player
     * @param l the lives
     * @param d the door entered from
     */
    public void updateValues(Player p, Lives l, Door d)
    {
        player = p;
        lives = l;
        doorEnteredFrom = d;
    }

    /**
     * @param d the door to check
     * @return the level number of the next level based on the door entered
     */
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

    /**
     * @return array of enemies
     */
    public Enemy[] getEnemies()
    {
        return enemies;
    }
    /**
     * @param i the index of the enemy
     * @return the enemy at the index
     */
    public Enemy getEnemy(int i)
    {
        return enemies[i];
    }

    /**
     * @return wether x is pressed
     */
    public boolean getX()
    {
        return x;
    }
    /**
     * @return wether left is pressed
     */
    public boolean getLeft()
    {
        return left;
    }
    /**
     * @return wether right is pressed
     */
    public boolean getRight()
    {
        return right;
    }
    /**
     * @return wether up is pressed
     */
    public boolean getUp()
    {
        return up;
    }
    /**
     * @return wether down is pressed
     */
    public boolean getDown()
    {
        return down;
    }

    /**
     * @return the player
     */
    public Player getPlayer()
    {
        return player;
    }

    /**
     * @return the lives
     */
    public Lives getLives()
    {
        return lives;
    }

    /**
     * @return the sword
     */
    public Sword getSword()
    {
        if(hasSword)
        {
             return sword;
        }
        return null;
    }
    

    /**
     * @return an array list of doors
     */
    public ArrayList<Door> getDoors()
    {
        return doors;
    }

    /**
     * @return the door entered from
     */
    public Door getDoorEnteredFrom()
    {
        return doorEnteredFrom;
    }

    /**
     * @return wether the level has a sword
     */
    public boolean hasSword()
    {
        return hasSword;
    }

    /**
     * @return if the player is on the level
     */
    public boolean onLevel()
    {
        return onLevel;
    }

    /**
     * @return the image level background image
     */
    public Image getImage() {
        return ImageLoader.loadCompatibleImage(imageName);
    }

    /**
     * Sets starting location of player based on which door they entered from
     */
    public void setStartingPosition()
    {
        if(this.getDoorEnteredFrom() instanceof LeftDoor)
        {
            setStartingPosition(110,334);
            if(player.getHasSword())
            {
                player.setImageName("images/playerright.png");
            }
            else
            {
                player.setImageName("images/playerright.png");
            }
        }
        else if(this.getDoorEnteredFrom() instanceof UpDoor)
        {
            setStartingPosition(590,110);
            if(player.getHasSword())
            {
                player.setImageName("images/playerdown.png");
            }
            else
            {
                player.setImageName("images/playerdownnosword.png");
            }
        }
        else if(this.getDoorEnteredFrom() instanceof RightDoor)
        {
            setStartingPosition(1170,334);
            if(player.getHasSword())
            {
                player.setImageName("images/playerleft.png");
            }
            else
            {
                player.setImageName("images/playerleftnosword.png");
            }
        }
        else if(this.getDoorEnteredFrom() instanceof DownDoor)
        {
            setStartingPosition(590,610);
            if(player.getHasSword())
            {
                player.setImageName("images/playerup.png");
            }
            else
            {
                player.setImageName("images/playerupnosword.png");
            }
        }
    }

    /**
     * Sets the starting position of the player
     * @param x
     * @param y
     */
    public void setStartingPosition(int x, int y)
    {
        player.setX(x);
        player.setY(y);
    }

    /**
     * @param b boolean to set the level to
     */
    public void setOnLevel(boolean b)
    {
        onLevel = b;
    }

    /**
     * @param i the index of the enemy
     * @param e the enemy to set
     */
    public void setEnemy(int i, Enemy e)
    {
        enemies[i] = e;
    }

    /**
     * @param s the sword to set
     */
    public void setSword(Sword s)
    {
        sword = s;
    }

    /**
     * @param b boolean to set X to
     */
    public void setX(boolean b)
    {
        x = b;
    }
    /**
     * @param b boolean to set left to
     */
    public void setLeft(boolean b)
    {
        left = b;
    }
    /**
     * @param b boolean to set right to
     */
    public void setRight(boolean b)
    {
        right = b;
    }
    /**
     * @param b boolean to set up to
     */
    public void setUp(boolean b)
    {
        up = b;
    }
    /**
     * @param b boolean to set down to
     */
    public void setDown(boolean b)
    {
        down = b;
    }

    /**
     * resets all the booleans to false
     */
    public void clear()
    {
        up = down = left = right = x = false;
    }

}
