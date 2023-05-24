public class Level2 extends Level {

    //prevoius level method
    public Level2()
    {
        super(2, -1, -1, 1, -1,1170,334,false,false,true,false,false, "images/jungle.jpg");
        setEnemy(0, new StillEnemy(450, 450, 40, 40,2));
        setEnemy(1, new StillEnemy(1000, 450, 80, 40,2));
        
    }
    
}
