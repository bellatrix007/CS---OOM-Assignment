
class Player
{
    private String type;
    private Strategy strategy; 
    private double radians;
    private location l;
    private int Alive;
    private int successNumber;
    private int team; //0=terrorist 1=counter terrorist
    //private static int time = 7;
    
    Player(int team, String type, Strategy s, double r,location l)
    {
        this.team = team;
        this.strategy = s;
        this.radians = r;
        this.type = type;
        this.Alive = 1;
        this.successNumber = 0;
        this.l = new location(l);
    }
    
    void Almove(Player p[],location bombSite)
    {
        if(this.strategy.equals(new bomb())&&this.team==0)
            this.strategy.setLocation(this,bombSite);
        else
            this.strategy.setLocation(p,this);
        this.decEnergyLevel(); 
    }
    
    void decEnergyLevel()
    {
    }
    
    int site(Player p2,double alpha)
    {
        int x1 = this.getLocation().getX();
        int y1 = this.getLocation().getY();
        double theta = this.getLocation().getTheta();
        
        int x2 = p2.getLocation().getX();
        int y2 = p2.getLocation().getY();
        
        double gamma = Math.atan2((x2-x1),(y2-y1));
        
        if(Math.cos(theta-gamma)>Math.cos(alpha))
            return 1;
        return 0;
    }
    
    int fire(Player p2)
    {
        if(this.site(p2,p2.radians)==1&&p2.Alive==1)
        {
            if(p2.incHits()==1)
            {
                this.incSuccessNumber();
                p2.Alive = 0;
                return 1;
            }
        }
        return 0;
    }
    
    int getTeam()
    {
        return this.team;
    }
    
    int isAlive()
    {
        return this.Alive;
    }
    
    int incHits()
    {
        return 0;
    }
    
    void incSuccessNumber()
    {
        this.successNumber++;
    }
    
    int getSuccess()
    {
        return this.successNumber;
    }
    
    location getLocation()
    {
        return l;
    }
    
    void setLocation(location newL)
    {
        this.l = newL;
    }
    
    double getSpeed()
    {
        return 0.0;
    }
    
    int getEnergyLevel()
    {
        return 0;
    }
    
}
    
class Aggressive extends Player
{
    private int numberOfHits;
    private int energyLevel;
    private static double speed = 7.0;
    
    Aggressive(int team, String type,Strategy s, double r,location l)
    {
        super(team,type,s,r,l);
        this.energyLevel = 100;
        numberOfHits = 0;
    }
    
    int incHits()
    {
        this.numberOfHits++;
        if(this.numberOfHits==2)
            return 1;
        return 0;
    }
    
    int getEnergyLevel()
    {
        return this.energyLevel;
    }
    
    void decEnergyLevel()
    {
        this.energyLevel-=2;
    }
    
    double getSpeed()
    {
        return speed;
    }
}

class Cautious extends Player
{
    private int numberOfHits;
    private int energyLevel;
    private static double speed = 2.5;
    
    Cautious(int team, String type,Strategy s, double r,location l)
    {
        super(team,type,s,r,l);
        numberOfHits = 0;
        this.energyLevel = 100;
    }
    
    int incHits()
    {
        this.numberOfHits++;
        if(this.numberOfHits==1)
            return 1;
        return 0;
    }
    
    int getEnergyLevel()
    {
        return this.energyLevel;
    }
    
    void decEnergyLevel()
    {
        this.energyLevel--;
    }
    
    double getSpeed()
    {
        return speed;
    }
}
class Blind extends Player
{
    private int numberOfHits;
    private int energyLevel;
    private static double speed = 10;
    
    Blind(int team, String type,Strategy s, double r,location l)
    {
        super(team,type,s,r,l);
        this.energyLevel = 100;
        numberOfHits = 0;
    }
    
    int incHits()
    {
        this.numberOfHits++;
        if(this.numberOfHits==5)
            return 1;
        return 0;
    }
    
    int getEnergyLevel()
    {
        return this.energyLevel;
    }
    
    void decEnergyLevel()
    {
        this.energyLevel-=3;
    }
    
    double getSpeed()
    {
        return speed;
    }
}