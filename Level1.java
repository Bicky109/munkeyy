public class Level1 extends Level {

    private Crown crown;
    private boolean hasCrown;

    public Level1() {
        super(1, 2, -1, -1, -1, 215, 315, true, false, false, false, true, "images/swordroom.png");
        setSword(new Sword(980, 422, 60, 80));
        setStartingPosition(215, 315);
    }

    public void addCrown() {
        hasCrown = true;
        crown = new Crown(580, 300, 105, 105);
    }

    public boolean hasCrown() {
        return hasCrown;
    }

    public Crown getCrown() {
        return crown;
    }

    public void levelSpecificCollision() {
        if (getPlayer().getX() > 750 && getPlayer().getX() < 818 && getPlayer().getY() < 249) {
            if (getPlayer().getImageName().equals("images/playerleft.png")
                    || getPlayer().getImageName().equals("images/playerleftnosword.png")
                    || getPlayer().getImageName().equals("images/playerleftcrown.png")) {
                getPlayer().setX(818);
            } else if (getPlayer().getImageName().equals("images/playerright.png")
                    || getPlayer().getImageName().equals("images/playerright.png")
                    || getPlayer().getImageName().equals("images/playerrightcrown.png")) {
                getPlayer().setX(750);
            }
            if (getPlayer().getImageName().equals("images/playerup.png")
                    || getPlayer().getImageName().equals("images/playerupnosword.png")
                    || getPlayer().getImageName().equals("images/playerupcrown.png")) {
                getPlayer().setY(250);
            }
        } else if (getPlayer().getX() > 750 && getPlayer().getX() < 818 && getPlayer().getY() > 251
                && getPlayer().getY() < 260) {
            getPlayer().setY(260);
        } else if (getPlayer().getX() > 750 && getPlayer().getX() < 818 && getPlayer().getY() > 329) {
            if (getPlayer().getImageName().equals("images/playerleft.png")
                    || getPlayer().getImageName().equals("images/playerleftnosword.png")
                    || getPlayer().getImageName().equals("images/playerleftcrown.png")) {
                getPlayer().setX(818);
            } else if (getPlayer().getImageName().equals("images/playerright.png")
                    || getPlayer().getImageName().equals("images/playerright.png")
                    || getPlayer().getImageName().equals("images/playerrightcrown.png")) {
                getPlayer().setX(750);
            }
            if (getPlayer().getImageName().equals("images/playerdown.png")
                    || getPlayer().getImageName().equals("images/playerdownnosword.png")
                    || getPlayer().getImageName().equals("images/playerdowncrown.png")) {
                getPlayer().setY(330);
            }
        } else if (getPlayer().getX() > 750 && getPlayer().getX() < 818 && getPlayer().getY() < 330
                && getPlayer().getY() > 320) {
            getPlayer().setY(320);
        }
    }

}
