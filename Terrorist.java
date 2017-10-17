public class Terrorist extends Player
{
    Terrorist(String type,Strategy s, double r)
    {
        super(s,r,type);
    }
    
    void Almove(Player p[],location bombSite)
    {
        if(super.getStrategy().equals(new bomb()))
            super.getStrategy().setLocation(this,bombSite);
        else
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
class AggressiveT extends Terrorist
{
    private int numberOfHits;
    private int energyLevel;
    private static double speed = 7.0;
    
    AggressiveT(String type,Strategy s, double r)
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
class CautiousT extends Terrorist
{
    private int numberOfHits;
    private int energyLevel;
    private static double speed = 2.5;
    
    CautiousT(String type,Strategy s, double r)
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
        this.energyLevel--;
    }
    
    static double getSpeed()
    {
        return speed;
    }
}
class BlindT extends Terrorist
{
    private int numberOfHits;
    private int energyLevel;
    private static double speed = 10;
    
    BlindT(String type,Strategy s, double r)
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
