public class Level4 extends Level {

    // prevoius level method
    public Level4() {
        super(4, -1, -1, -1, 2, 1170, 334, false, false, false, true, false, "images/level4.png");
        setEnemy(0, new SpinningEnemy(450, 450, 80, 80, 50, 5, 2));
        setEnemy(1, new SpinningEnemy(1000, 450, 80, 80, 50, -9, 3));
        setEnemy(2, new SpinningEnemy(300, 250, 160, 160, 75, -1, 5));
        setEnemy(3, new SpinningEnemy(800, 350, 100, 100, 30, 15, 2));
        setEnemy(4, new SpinningEnemy(400, 350, 40, 40, 200, 5, 1));
    }

}
