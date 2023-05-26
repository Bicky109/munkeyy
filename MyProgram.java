
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MyProgram extends JPanel implements ActionListener, KeyListener {

    private ArrayList<Level> levels = new ArrayList<Level>();

    // private boolean up, down, left, right, x; //booleans that track which keys
    // are currently pressed
    private Timer timer; // the update timer

    private int gameWidth = 1280; // the width of the game area
    private int gameHeight = 720; // the height of the game area
    private boolean win;
    int count;
    int countLose;

    Sound sound = new Sound();

    private static JLabel dialogLabel;
    private static JFrame frame;
    private static JDialog dialog;

    // Sets up the basic GUI for the game
    public static void main(String[] args) {
        frame = new JFrame();

        dialog = new JDialog(frame, "Status");
        dialogLabel = new JLabel("");
        dialogLabel.setHorizontalAlignment(JLabel.CENTER);
        dialog.add(dialogLabel);
        dialog.setBounds(125, 125, 100, 70);
        dialog.setVisible(false);

        frame.setTitle("The Legend of Zonkey");
        frame.setLayout(new BorderLayout());

        MyProgram game = new MyProgram();
        frame.add(game, BorderLayout.CENTER);

        game.addKeyListener(game);
        frame.addKeyListener(game);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();

        game.setUpGame();
        // game.enterFullScreen();
    }

    // Constructor for the game panel
    public MyProgram() {
        setPreferredSize(new Dimension(gameWidth, gameHeight));
    }

    // Method that is called by the timer 30 times per second (roughly)
    // Most games go through states - updating objects, then drawing them
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    // Called every time a key is pressed
    // Stores the down state for use in the update method
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_X) {
            if (levels.get(getCurrentLevel()).getPlayer().getCanX()) {
                levels.get(getCurrentLevel()).setX(true);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            levels.get(getCurrentLevel()).setUp(true);

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            levels.get(getCurrentLevel()).setDown(true);

        } else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            levels.get(getCurrentLevel()).setLeft(true);

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            levels.get(getCurrentLevel()).setRight(true);

        }
    }

    // Called every time a key is released
    // Stores the down state for use in the update method
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_X) {
            levels.get(getCurrentLevel()).setX(false);
        } else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            levels.get(getCurrentLevel()).setUp(false);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            levels.get(getCurrentLevel()).setDown(false);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            levels.get(getCurrentLevel()).setLeft(false);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            levels.get(getCurrentLevel()).setRight(false);
        }
    }

    // Called every time a key is typed
    public void keyTyped(KeyEvent e) {
    }

    // Sets the initial state of the game
    // Could be modified to allow for multiple levels
    public void setUpGame() {
        for (int i = levels.size() - 1; i >= 0; i--) {
            levels.remove(i);
        }
        count = 0;
        countLose = 0;
        levels.add(new Level1());
        levels.add(new Level2());
        levels.add(new Level3());
        levels.add(new Level4());
        levels.add(new Level5());

        levels.get(0).setOnLevel(true);

        if (timer != null) {
            timer.stop();
        }

        timer = new Timer(1000 / 30, this); // roughly 30 frames per second
        timer.start();
        levels.get(getCurrentLevel()).clear();

    }

    private void enterFullScreen() {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphicsEnvironment.getDefaultScreenDevice();
        if (device.isFullScreenSupported()) {
            device.setFullScreenWindow(frame);
            frame.validate();
        }
    }

    public int getCurrentLevel() {
        for (int i = 0; i < levels.size(); i++) {
            if (levels.get(i).onLevel()) {
                // System.out.println(i);
                return i;
            }
        }
        return 3;
    }

    public void playMusic(int i)
    {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic()
    {
        try{
            sound.stop();
        }
        catch(Exception e){
            System.out.println("No music playing");
        }
    }   

    public void playSE(int i)
    {
        sound.setFile(i);
        sound.play();
    }

    // The update method does 5 things
    // 1 - it has the player move based on what key is currently being pressed
    // 2 - it prevents the player from leaving the screen
    // 3 - it checks if the player has reached the goal, and if so congratualtes
    // them and restarts the game
    // 4 - it checks if any of the Enemy objects are touching the player, and if so
    // notifies the player of their defeat and restarts the game
    // 5 - it tells each of the Enemy objects to update()
    public void update() {

        playerUpdate();

        if (levels.get(getCurrentLevel()).getLives().getFCount() >= 0) {
            levels.get(getCurrentLevel()).getLives().fCount();
        }

        enemyUpdate();

        if (levels.get(getCurrentLevel()).getLives().getLifeCount() <= 0) {
            if (countLose < 1) {
                onLose();
            }
        }

        levelUpdate();

        if (!win) {
            checkWin();
        }

        if (win && count < 1) {
            onWin();
        }

    }

    public void playerUpdate() {
        if (levels.get(getCurrentLevel()).getX() && levels.get(getCurrentLevel()).getPlayer().getHasSword()) {
            levels.get(getCurrentLevel()).getPlayer().attack();
        } else if (levels.get(getCurrentLevel()).getUp() && levels.get(getCurrentLevel()).getRight()) {
            levels.get(getCurrentLevel()).getPlayer().diagUpRight();
        } else if (levels.get(getCurrentLevel()).getUp() && levels.get(getCurrentLevel()).getLeft()) {
            levels.get(getCurrentLevel()).getPlayer().diagUpLeft();
        } else if (levels.get(getCurrentLevel()).getDown() && levels.get(getCurrentLevel()).getRight()) {
            levels.get(getCurrentLevel()).getPlayer().diagDownRight();
        } else if (levels.get(getCurrentLevel()).getDown() && levels.get(getCurrentLevel()).getLeft()) {
            levels.get(getCurrentLevel()).getPlayer().diagDownLeft();
        } else if (levels.get(getCurrentLevel()).getUp()) {
            levels.get(getCurrentLevel()).getPlayer().up();
        } else if (levels.get(getCurrentLevel()).getDown()) {
            levels.get(getCurrentLevel()).getPlayer().down();
        } else if (levels.get(getCurrentLevel()).getLeft()) {
            levels.get(getCurrentLevel()).getPlayer().left();
        } else if (levels.get(getCurrentLevel()).getRight()) {
            levels.get(getCurrentLevel()).getPlayer().right();
        }

        if (levels.get(getCurrentLevel()).getPlayer().getX() < 110) {
            levels.get(getCurrentLevel()).getPlayer().setX(110);
        } else if (levels.get(getCurrentLevel()).getPlayer().getX()
                + levels.get(getCurrentLevel()).getPlayer().getWidth() > 1168) {
            levels.get(getCurrentLevel()).getPlayer()
                    .setX(1168 - levels.get(getCurrentLevel()).getPlayer().getWidth());
        }

        if (levels.get(getCurrentLevel()).getPlayer().getY() < 110) {
            levels.get(getCurrentLevel()).getPlayer().setY(110);
        } else if (levels.get(getCurrentLevel()).getPlayer().getY()
                + levels.get(getCurrentLevel()).getPlayer().getHeight() > 605) {
            levels.get(getCurrentLevel()).getPlayer()
                    .setY(605 - levels.get(getCurrentLevel()).getPlayer().getHeight());
        }

        levels.get(getCurrentLevel()).levelSpecificCollision();

        // if(levels.get(getCurrentLevel()).getPlayer().getRect().intersects(goal)) {
        // onWin();
        // }
        if (levels.get(getCurrentLevel()).hasSword()) {
            if (levels.get(getCurrentLevel()).getPlayer().getRect()
                    .intersects(levels.get(getCurrentLevel()).getSword().getRect())) {
                levels.get(getCurrentLevel()).getPlayer().getSword();
                levels.get(getCurrentLevel()).getSword().getSword();
            }
        }

        if (levels.get(getCurrentLevel()).hasCrown()) {
            if (levels.get(getCurrentLevel()).getPlayer().getRect()
                    .intersects(levels.get(getCurrentLevel()).getCrown().getRect())) {
                levels.get(getCurrentLevel()).getPlayer().getCrown();
                levels.get(getCurrentLevel()).getCrown().getCrown();
            }
        }

        if (levels.get(getCurrentLevel()).getPlayer().getSFCount() >= 0) {
            levels.get(getCurrentLevel()).getPlayer().SFCount();
        }

        if (levels.get(getCurrentLevel()).getPlayer().getFCount() >= 0) {
            levels.get(getCurrentLevel()).getPlayer().fCount();
        }

    }

    public void levelUpdate() {
        for (Door D : levels.get(getCurrentLevel()).getDoors()) {
            if (D == null)
                continue;

            if (D.getFCount() >= 0) {
                D.fCount();
            }

            if (D.canUse()) {
                if (D.intersects(levels.get(getCurrentLevel()).getPlayer().getRect())) {
                    System.out.println("Door");
                    D.use();
                    Player tempPlayer = levels.get(getCurrentLevel()).getPlayer();
                    Lives tempLives = levels.get(getCurrentLevel()).getLives();
                    Door doorEnteredFrom = D;
                    levels.get(levels.get(getCurrentLevel()).getNextLevel(D) - 1).setOnLevel(true);
                    stopMusic();
                    playMusic(levels.get(getCurrentLevel()).getLevelNum());
                    levels.get(getCurrentLevel()).updateValues(tempPlayer, tempLives, doorEnteredFrom);
                    levels.get(getCurrentLevel()).setStartingPosition();
                }

            }
        }
    }

    public void enemyUpdate() {
        int count = -1;
        for (Enemy e : levels.get(getCurrentLevel()).getEnemies()) {
            count++;
            if (e == null)
                continue;
            if (e instanceof StalkerEnemy) {
                e.updateRect(levels.get(getCurrentLevel()).getPlayer().getRect());
            }
            e.move();
            if (levels.get(getCurrentLevel()).getLives().getLifeCount() > 0) {
                if (levels.get(getCurrentLevel()).getPlayer().canGetHit()) {
                    if (e.intersects(levels.get(getCurrentLevel()).getPlayer().getRect())) {
                        levels.get(getCurrentLevel()).getPlayer().hit();
                        levels.get(getCurrentLevel()).getLives().startFCount();
                    }
                }
                if (e.intersects(levels.get(getCurrentLevel()).getPlayer().getRect())) {
                    levels.get(getCurrentLevel()).getPlayer().bounce();
                }
            }
            try {
                if (e.canGetHit() && levels.get(getCurrentLevel()).getPlayer().getHasSword() && e.getLives() > 0) {
                    if (e.intersects(levels.get(getCurrentLevel()).getPlayer().getRectSword())) {
                        e.hit();
                        System.out.println("gotHit");
                        levels.get(getCurrentLevel()).setEnemy(count, e.checkLives(e));
                    }
                }
            } catch (Exception er) {

            }
            if (e.getFCount() >= 1) {
                e.fCount();
            }
        }
    }

    // The paint method does 3 things
    // 1 - it draws a white background
    // 2 - it draws the player in blue
    // 3 - it draws the goal in green
    // 4 - it draws all the Enemy objects
    public void paint(Graphics g) {

        g.drawImage(levels.get(getCurrentLevel()).getImage(), 0, 0, gameWidth, gameHeight, null);

        // doorsTest
        // g.setColor(Color.BLUE);
        // g.drawRect(60, 334, 60, 50);
        // g.drawRect(615, 60, 50, 60);
        // g.drawRect(1160, 334, 60, 50);
        // g.drawRect(615, 600, 50, 60);

        // draws lives background
        g.setColor(Color.WHITE);
        g.fillRect(7, 10, 140, 44);
        g.setColor(Color.BLACK);
        g.drawRect(7, 10, 140, 44);

        // playerTest
        g.setColor(Color.RED);
        // g.drawRect(levels.get(getCurrentLevel()).getPlayer().getX(),
        // levels.get(getCurrentLevel()).getPlayer().getY(),
        // levels.get(getCurrentLevel()).getPlayer().getWidth(),
        // levels.get(getCurrentLevel()).getPlayer().getHeight());
        // g.drawRect(levels.get(getCurrentLevel()).getPlayer().getX() - 5,
        // levels.get(getCurrentLevel()).getPlayer().getY() - 60, 60, 75);
        // g.drawRect(levels.get(getCurrentLevel()).getPlayer().getX() + 5,
        // levels.get(getCurrentLevel()).getPlayer().getY() + 60, 60, 75);
        // g.drawRect(levels.get(getCurrentLevel()).getPlayer().getX() - 70,
        // levels.get(getCurrentLevel()).getPlayer().getY() + 5, 75, 60);
        // g.drawRect(levels.get(getCurrentLevel()).getPlayer().getX() + 45,
        // levels.get(getCurrentLevel()).getPlayer().getY() + 5, 75, 60);

        // swordTest
        // if (levels.get(getCurrentLevel()).hasSword()) {
        // g.drawRect(levels.get(getCurrentLevel()).getSword().getX(),
        // levels.get(getCurrentLevel()).getSword().getY(),
        // levels.get(getCurrentLevel()).getSword().getWidth(),
        // levels.get(getCurrentLevel()).getSword().getHeight());
        // }

        // draw crown
        if (levels.get(getCurrentLevel()).hasCrown()) {
            g.drawImage(levels.get(getCurrentLevel()).getCrown().getImage(),
                    levels.get(getCurrentLevel()).getCrown().getX(), levels.get(getCurrentLevel()).getCrown().getY(),
                    levels.get(getCurrentLevel()).getCrown().getWidth(),
                    levels.get(getCurrentLevel()).getCrown().getHeight(), null);
        }

        // draws sword
        if (levels.get(getCurrentLevel()).hasSword()) {
            g.drawImage(levels.get(getCurrentLevel()).getSword().getImage(),
                    levels.get(getCurrentLevel()).getSword().getX(), levels.get(getCurrentLevel()).getSword().getY(),
                    levels.get(getCurrentLevel()).getSword().getWidth(),
                    levels.get(getCurrentLevel()).getSword().getHeight(), null);
        }
        // draws player
        g.drawImage(levels.get(getCurrentLevel()).getPlayer().getImage(),
                levels.get(getCurrentLevel()).getPlayer().getX() - 58,
                levels.get(getCurrentLevel()).getPlayer().getY() - 52, 168, 168, null);
        // draws lives
        g.drawImage(levels.get(getCurrentLevel()).getLives().getImage(),
                levels.get(getCurrentLevel()).getLives().getX(), levels.get(getCurrentLevel()).getLives().getY(),
                levels.get(getCurrentLevel()).getLives().getWidth(),
                levels.get(getCurrentLevel()).getLives().getHeight(), null);

        // draws enemies
        for (Enemy e : levels.get(getCurrentLevel()).getEnemies()) {
            if (e == null)
                continue;
            e.draw(g);
        }
    }

    private void checkWin() {
        for (int i = 0; i < levels.size(); i++) {
            if (levels.get(i).isEmpty()) {
                win = true;
            } else {
                win = false;
                break;
            }
        }
    }

    private void onWin() {
        count++;
        levels.get(getCurrentLevel()).clear();
        createDialog("You have rid the world of all enemies! Go to the Banana Temple to get your prize.", 5000);
        levels.get(0).addCrown();
    }

    private void onLose() {
        countLose++;
        levels.get(getCurrentLevel()).clear();
        createDialog("You have Died. Restart", 2250);
        levels.get(0).reset();
        setUpGame();
    }

    // Sets visible a Pseudo-dialog that removes itself after a fixed time interval
    // Uses a thread to not block the rest of the program
    //
    // @param: message: String -> The message that will appear on the dialog
    // @param: delay: int -> How long (in milliseconds) that Dialog is visible
    private void createDialog(String message, int delay) {
        dialogLabel.setText(message);
        dialog.setVisible(true);
        frame.requestFocus();

        Thread thread = new Thread(() -> {
            try {
                // Show pop up for [delay] milliseconds
                Thread.sleep(delay);
            } catch (Exception e) {
                System.out.println("Thread failed :(");
                dialog.setVisible(false);
                frame.requestFocus();
            }
            // End of 3 seconds
            // Close the pop up
            dialog.setVisible(false);
            frame.requestFocus();
        });
        thread.start();
    }
}