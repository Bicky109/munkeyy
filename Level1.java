public class Level1 extends Level {

    public Level1()
    {
        super(215,315,true,false,false,false,true, "images/swordroom.png");
        setOnLevel(true);
        setSword(new Sword(980,422,60,80));
        setEnemy(0, new StillEnemy(250, 250, 40, 40,2));
        
    }
    
}
