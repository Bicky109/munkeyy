public class Level5 extends Level {

    // prevoius level method
    public Level5() {
        super(5, -1, 2, -1, -1, 1170, 334, false, true, false, false, false, "images/level5.png");
        setEnemy(0, new StalkerEnemy(450, 450, 80, 80, 1, 2, getPlayer().getRect()));
    }

}