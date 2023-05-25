public class Level2 extends Level {

    // prevoius level method
    public Level2() {
        super(2, 3, 4, 1, -1, 1170, 334, true, true, true, false, false, "images/level2.png");
        //setEnemy(0, new StillEnemy(450, 450, 40, 40, 2));
        //setEnemy(1, new StillEnemy(1000, 450, 80, 40, 2));

    }

    public void levelSpecificCollision()
    {

        if (getPlayer().getX() < 560 && getPlayer().getY() < 285)
        {
            getPlayer().setX(560);
        } 
        if(getPlayer().getX() < 560 && getPlayer().getY() < 292)
        {
            getPlayer().setY(292);
        }


        if (getPlayer().getX() > 480 && getPlayer().getX() < 853 && getPlayer().getY() > 317 && getPlayer().getY() < 513)
        {
            getPlayer().setX(480);
        } 
        if (getPlayer().getX() > 480 && getPlayer().getX() < 860 && getPlayer().getY() > 317 && getPlayer().getY() < 513)
        {
            getPlayer().setX(860);
        }
        if(getPlayer().getX() > 480 && getPlayer().getX() < 860 && getPlayer().getY() > 310 && getPlayer().getY() < 513)
        {
            getPlayer().setY(310);
        }
        if(getPlayer().getX() > 480 && getPlayer().getX() < 860 && getPlayer().getY() > 310 && getPlayer().getY() < 520)
        {
            getPlayer().setY(520);
        }
        if(getPlayer().getX() > 720 && getPlayer().getY() > 518)
        {
            getPlayer().setX(720);   
        }
        if(getPlayer().getX() > 859 && getPlayer().getY() > 380)
        {
            getPlayer().setY(380);
        }

        


        if (getPlayer().getX() > 730 && getPlayer().getY() < 245)
        {
            getPlayer().setX(730);
        } 
        if(getPlayer().getX() > 730 && getPlayer().getY() < 252)
        {
            getPlayer().setY(252);
        }
        // else if (getPlayer().getX() + getPlayer().getWidth() > 1168)
        // {
        //     getPlayer().setX(1168 - getPlayer().getWidth());
        // }

        // if (getPlayer().getY() < 170) 
        // {
        //     getPlayer().setY(170);
        // } 
        // else if (getPlayer().getY() + getPlayer().getHeight() > 550) 
        // {
        // getPlayer().setY(550 - getPlayer().getHeight());
        // }
    }

}
