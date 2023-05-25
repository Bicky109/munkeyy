public class Level3 extends Level {

    // prevoius level method
    public Level3() {
        super(3, -1, -1, 2, -1, 1170, 334, false, false, true, false, false, "images/level3.png");
        setEnemy(0, new DiagonalEnemy(500, 150, 80, 80, 600, 4, 1000, 4, 2));
        setEnemy(1, new DiagonalEnemy(400, 350, 80, 80, 600, 4, 1000, 4, 2));

    }

}
