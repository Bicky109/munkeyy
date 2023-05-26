public class Level5 extends Level {

    // prevoius level method
    public Level5() {
        super(5, -1, 2, -1, -1, 1170, 334, false, true, false, false, false, "images/level5.png");
        setEnemy(0, new StalkerEnemy(450, 350, 80, 80, 2, 2, getPlayer().getRect()));
        setEnemy(1, new StalkerEnemy(1000, 450, 160, 160, 2, 5, getPlayer().getRect()));
        setEnemy(2, new StalkerEnemy(150, 150, 60, 60, 4, 1, getPlayer().getRect()));
        setEnemy(3, new StalkerEnemy(900, 250, 100, 100, 1, 3, getPlayer().getRect()));
        setEnemy(4, new StalkerEnemy(0, 600, 60, 60, 10, 1, getPlayer().getRect()));
    }

}