public class Level3 extends Level {

    // prevoius level method
    public Level3() {
        super(3, -1, -1, 2, -1, 1170, 334, false, false, true, false, false, "images/level3.png");
        // setEnemy(0, new DiagonalEnemy(500, 150, 80, 80, 600, 2, 1000, 2, 2));
        // setEnemy(1, new DiagonalEnemy(400, 350, 80, 80, 600, 2, 1000, 2, 2));

    }

    public void levelSpecificCollision()
    {
        if (getPlayer().getY() < 170) {
            getPlayer().setY(170);
        } else if (getPlayer().getY()
                + getPlayer().getHeight() > 550) {
            getPlayer()
                    .setY(550 - getPlayer().getHeight());
        }
    }

}
