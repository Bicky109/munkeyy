public class Level2 extends Level {

    //prevoius level method
    public Level2()
    {
        super(2, -1, -1, 1, -1,1170,334,false,false,true,false,true, "images/nameOfDefaultImage.png");
        setSword(new Sword(980,422,60,80));
        setEnemy(0, new StillEnemy(450, 450, 40, 40,2));
        
    }
    
}
