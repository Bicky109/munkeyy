public class Level3 extends Level {

    // prevoius level method
    public Level3() {
        super(3, -1, -1, 2, -1, 1170, 334, false, false, true, false, false, "images/level3.png");
        setEnemy(0, new StillEnemy(450, 450, 40, 40, 2));
        setEnemy(1, new StillEnemy(1000, 450, 80, 40, 2));

    }

}
