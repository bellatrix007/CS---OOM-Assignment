
public class CounterTerrorist extends Player
{
    CounterTerrorist(String type,Strategy s, double r)
    {
        super(s,r,type);
    }
    
    void Almove(Player p[],location bombSite)
    {
        super.getStrategy().setLocation(p,this);
        this.decEnergyLevel();     
    }
    
    void decEnergyLevel()
    {
        
    }
    
    static double getSpeed()
    {
        return 0.0;
    }
}

class AggressiveCT extends CounterTerrorist
{
    private int numberOfHits;
    private int energyLevel;
    private static double speed = 7.0;
    
    AggressiveCT(String type,Strategy s, double r)
    {
        super(type,s,r);
        this.energyLevel = 100;
        numberOfHits = 0;
    }
    
    int incHits()
    {
        this.numberOfHits++;
        return numberOfHits;
    }
    
    void decEnergyLevel()
    {
        this.energyLevel-=2;
    }
    
    static double getSpeed()
    {
        return speed;
    }
}

class CautiousCT extends CounterTerrorist
{
    private int numberOfHits;
    private int energyLevel;
    private static double speed = 2.5;
    
    CautiousCT(String type,Strategy s, double r)
    {
        super(type,s,r);
        numberOfHits = 0;
        this.energyLevel = 100;
    }
    
    int incHits()
    {
        this.numberOfHits++;
        return numberOfHits;
    }
    
    void decEnergyLevel()
    {
        this.energyLevel--;
    }
    
    static double getSpeed()
    {
        return speed;
    }
}
class BlindCT extends CounterTerrorist
{
    private int numberOfHits;
    private int energyLevel;
    private static double speed = 10;
    
    BlindCT(String type,Strategy s, double r)
    {
        super(type,s,r);
        this.energyLevel = 100;
        numberOfHits = 0;
    }
    
    int incHits()
    {
        this.numberOfHits++;
        return numberOfHits;
    }
    
    void decEnergyLevel()
    {
        this.energyLevel-=3;
    }
    
    static double getSpeed()
    {
        return speed;
    }
}
