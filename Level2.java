public class Level2 extends Level {

    //prevoius level method
    public Level2()
    {
        super(2, -1, -1, 1, -1,1170,334,false,false,true,false,false, "images/nameOfDefaultImage.png");
        setStartingPosition(1170,334);
        //setSword(new Sword(980,422,60,80));
        setEnemy(0, new StillEnemy(450, 450, 40, 40,2));
        
    }

    public void setStartingPosition()
    {
        if(this.getDoorEnteredFrom() instanceof LeftDoor)
        {
            setStartingPosition(110,334);
        }
        else if(this.getDoorEnteredFrom() instanceof UpDoor)
        {
            setStartingPosition(590,110);
        }
        else if(this.getDoorEnteredFrom() instanceof RightDoor)
        {
            setStartingPosition(1170,334);
        }
        else if(this.getDoorEnteredFrom() instanceof DownDoor)
        {
            setStartingPosition(590,610);
        }
    }

    // public void setStartingPosition(int x, int y)
    // {
    //     player.setX(x);
    //     player.setY(y);
    // }
    
}
