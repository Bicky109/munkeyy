public class Level3 extends Level {

    // prevoius level method
    public Level3() {
        super(3, -1, -1, 2, -1, 1170, 334, false, false, true, false, false, "images/level3.png");
        setEnemy(0, new DiagonalEnemy(500, 150, 84, 84, 550, -2, 1100, -2, 1));
        setEnemy(1, new DiagonalEnemy(400, 350, 84, 84, 550, 2, 1100, 1, 2));
        setEnemy(2, new DiagonalEnemy(200, 250, 168, 168, 550, -1, 1100, -1, 4));
        setEnemy(3, new DiagonalEnemy(100, 450, 42, 42, 550, 4, 1100, -1, 1));

    }

    public void levelSpecificCollision() {
        if (getPlayer().getY() < 170) {
            getPlayer().setY(170);
        } else if (getPlayer().getY()
                + getPlayer().getHeight() > 550) {
            getPlayer()
                    .setY(550 - getPlayer().getHeight());
        }
    }

}
