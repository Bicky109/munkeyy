import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyProgram extends JPanel implements ActionListener, KeyListener {

    private Player player; //a rectangle that represents the player
    private Rectangle goal = new Rectangle(); //a rectangle that represents the goal
    private Sword sword;
    private Lives lives;
    private Enemy[] enemies = new Enemy[7]; //the array of Enemy objects
    //private Level[] levels = new Level[9]; //number of levels
    private boolean up, down, left, right, x; //booleans that track which keys are currently pressed
    private Timer timer; //the update timer
   
    private int gameWidth = 1280; //the width of the game area
    private int gameHeight = 720; //the height of the game area

    private static JLabel dialogLabel;
    private static JFrame frame;
    private static JDialog dialog;
   
    //Sets up the basic GUI for the game
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
   
    //Constructor for the game panel
    public MyProgram() {
         setPreferredSize(new Dimension(gameWidth, gameHeight));
    }
   
    //Method that is called by the timer 30 times per second (roughly)
    //Most games go through states - updating objects, then drawing them
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }
   
    //Called every time a key is pressed
    //Stores the down state for use in the update method
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_X) {
            if(player.getCanX())
            {
                x = true;
            }
            else
            {
                x = false;
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP||e.getKeyCode() == KeyEvent.VK_W) {
            up = true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN||e.getKeyCode() == KeyEvent.VK_S) {
            down = true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT||e.getKeyCode() == KeyEvent.VK_A) {
            left = true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT||e.getKeyCode() == KeyEvent.VK_D) {
            right = true;
        }
    }
   
    //Called every time a key is released
    //Stores the down state for use in the update method
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_X)
        {
                x = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP||e.getKeyCode() == KeyEvent.VK_W) {
            up = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN||e.getKeyCode() == KeyEvent.VK_S) {
            down = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT||e.getKeyCode() == KeyEvent.VK_A) {
            left = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT||e.getKeyCode() == KeyEvent.VK_D) {
            right = false;
        }
    }
   
    //Called every time a key is typed
    public void keyTyped(KeyEvent e) {
    }
   
    //Sets the initial state of the game
    //Could be modified to allow for multiple levels
    public void setUpGame() {
   
        if(timer != null) {
            timer.stop();
        }
   
        timer = new Timer(1000 / 30, this); //roughly 30 frames per second
        timer.start();
       
        up = down = left = right = false;
   
        player = new Player(215,315,50,60);
        sword = new Sword(980,422,60,80);
        lives = new Lives(400,400,128,128);
        //goal = new Rectangle(400, 300, 20, 20);
           
        
        //levels[0] = new Level(); //create level  string image name
        
        enemies[0] = new StillEnemy(250, 250, 40, 40,2);
        //enemies[1] = new VerticalEnemy(200, 100, 40, 20, gameHeight, 4);
        //enemies[2] = new DiagonalEnemy(300, 300, 20, 20, gameHeight, 1, gameWidth, 1);
        //enemies[3] = new StalkerEnemy(100, 200, 20, 20, player.getRect());
        //enemies[4] = new SwingingEnemy(400, 100, 20, 20, 50);
        //enemies[5] = new SporeEnemy(400,75,20,20,20,9);
        //enemies[6] = new SporeEnemy(75,250,20,20,20,9);
        
    }
   
    private void enterFullScreen() {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphicsEnvironment.getDefaultScreenDevice();
        if (device.isFullScreenSupported()) {
            device.setFullScreenWindow(frame);
            frame.validate();
        }
    }
   
    //The update method does 5 things
    //1 - it has the player move based on what key is currently being pressed
    //2 - it prevents the player from leaving the screen
    //3 - it checks if the player has reached the goal, and if so congratualtes them and restarts the game
    //4 - it checks if any of the Enemy objects are touching the player, and if so notifies the player of their defeat and restarts the game
    //5 - it tells each of the Enemy objects to update()
    public void update() {
        if(x && player.getHasSword())
        {
            player.attack();
        }
        else if(up && right)
        {
            player.diagUpRight();
        }
        else if(up && left)
        {
            player.diagUpLeft();
        }
        else if(down && right)
        {
            player.diagDownRight();
        }
        else if(down && left)
        {
            player.diagDownLeft();
        }
        else if(up) {
            player.up();
        }
        else if(down) {
            player.down();
        }
        else if(left) {
            player.left();
        }
        else if(right) {
            player.right();
        }
        
        if(player.getX() < 0) {
            player.setX(0);
        }
        else if(player.getX() + player.getWidth() > gameWidth) {
            player.setX(gameWidth - player.getWidth());
        }
       
        if(player.getY() < 0) {
            player.setY(0);
        }
        else if(player.getY() + player.getHeight() > gameHeight) {
            player.setY(gameHeight - player.getHeight());
        }
       
        if(player.getRect().intersects(goal)) {
            onWin();
        }
        
        if(player.getRect().intersects(sword.getRect()))
        {
            player.getSword();
            sword.getSword();
        }
        
        if(lives.getFCount() >= 0)
        {
            lives.fCount();
        }
        
        if(player.getSFCount() >= 0)
        {
            player.SFCount();
        }
        
        if(player.getFCount() >= 0)
        {
            player.fCount();
        }
        int count = -1;
        for(Enemy e: enemies) {
            count++;
            if(e == null)
                continue;
            e.move();
            if(lives.getLifeCount() > 0)
            {
                if(player.canGetHit())
                {
                    if(e.intersects(player.getRect())) {
                        player.hit();
                        lives.startFCount();
                    }
                }
            }
            try{
                if(e.canGetHit() && player.getHasSword() && e.getLives() > 0)
                {
                    if(e.intersects(player.getRectSword()))
                    {
                        e.hit();
                        System.out.println("gotHit");
                        enemies[0] = e.checkLives(e);
                        if(e == null)
                        continue;
                    }
                }
                }
            catch(Exception er)
            {
                
            }
            if(e.getFCount() >= 1)
            {
                e.fCount();
            }
            
        }
       
    }
   
    public Image get1Image(){
        return ImageLoader.loadCompatibleImage("images/chest.png");
    }
    
    public Image get2Image(){
        return ImageLoader.loadCompatibleImage("guide.png");
    }
    
    public Image get3Image(){
        return ImageLoader.loadCompatibleImage("images/swordroom.png");
    }
    //The paint method does 3 things
    //1 - it draws a white background
    //2 - it draws the player in blue
    //3 - it draws the goal in green
    //4 - it draws all the Enemy objects
    public void paint(Graphics g) {
        
        g.drawImage(get3Image(),0, 0,gameWidth,gameHeight,null);
        
        g.setColor(Color.RED);
        g.drawRect(player.getX() , player.getY(), player.getWidth(),player.getHeight());
        //g.drawRect(sword.getX(), sword.getY(), sword.getWidth(), sword.getHeight());
        
        //g.drawImage(get1Image(),goal.x - 15, goal.y - 20, 50, 50,null);
        //g.setColor(Color.BLUE);
        //g.fillRect(goal.x, goal.y, goal.width, goal.height);
        
        //draws player
        g.drawImage(sword.getImage(),sword.getX() , sword.getY(), sword.getWidth(), sword.getHeight(),null);   
        g.drawImage(player.getImage(),player.getX()-58, player.getY() - 52, 168, 168,null);
        g.drawImage(lives.getImage(),lives.getX() , lives.getY(), lives.getWidth(), lives.getHeight(),null);   
            
        for(Enemy e: enemies) {
            if(e == null)
                continue;
            e.draw(g);
        }
    }
   
    private void onWin() {
        up = down = left = right = false;
        createDialog("You Won!", 2000);
        setUpGame();
    }
   
    private void onLose() {
        up = down = left = right = false;
        createDialog("You Lost", 1250);
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
            } catch(Exception e) {
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