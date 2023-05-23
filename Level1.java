public class Level1 extends Level {

    public Level1()
    {
        super(1, 2, -1, -1, -1,215,315,true,false,false,false,true, "images/swordroom.png");
        setSword(new Sword(980,422,60,80));
        setEnemy(0, new StillEnemy(250, 250, 40, 40,2));
        
    }
    
}
