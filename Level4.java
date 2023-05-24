public class Level4 extends Level {

    // prevoius level method
    public Level4() {
        super(4, -1, -1, -1, 2, 1170, 334, false, false, false, true, false, "images/level4.png");
        setEnemy(0, new StillEnemy(450, 450, 40, 40, 2));
        setEnemy(1, new StillEnemy(1000, 450, 80, 40, 2));

    }

}
