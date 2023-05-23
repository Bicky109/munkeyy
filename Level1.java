public class Level1 extends Level {

    public Level1()
    {
        super(1, 2, -1, -1, -1,215,315,true,false,false,false,true, "images/swordroom.png");
        setSword(new Sword(980,422,60,80));
        setEnemy(0, new StillEnemy(250, 250, 40, 40,2));
        setStartingPosition(215,315);
    }

    public void levelSpecificCollision()
    {
        if(getPlayer().getX() > 750 && getPlayer().getX() < 818 && getPlayer().getY() < 250)
        {
            if(getPlayer().getImageName().equals("images/playerleft.png") || getPlayer().getImageName().equals("images/playerleftnosword.png"))
            {
                getPlayer().setX(818);
            }
            else if(getPlayer().getImageName().equals("images/playerright.png") || getPlayer().getImageName().equals("images/playerright.png"))
            {
                getPlayer().setX(750);
            }
            //fix
            else if(getPlayer().getImageName().equals("images/playerup.png") || getPlayer().getImageName().equals("images/playerupnosword.png"))
            {
                getPlayer().setY(250);
            }
        }
    }
    
}
