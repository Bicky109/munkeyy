public class Level4 extends Level {

    // prevoius level method
    public Level4() {
        super(4, -1, -1, -1, 2, 1170, 334, false, false, false, true, false, "images/level4.png");
        setEnemy(0, new SpinningEnemy(450, 450, 80, 80, 50, 5, 2));
        // setEnemy(1, new SpinningEnemy(1000, 450, 80, 80, 50, 9, 2));

    }

}
