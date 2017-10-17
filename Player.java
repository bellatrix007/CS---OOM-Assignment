
abstract class Player
{
    private String type;
    private Strategy strategy; 
    private double radians;
    private location l;
    //private static int time = 7;
    
    Player(Strategy s, double r,String type)
    {
        this.strategy = s;
        this.radians = r;
        this.type = type;
        l = new location();
    }
    
    abstract void Almove(Player p[],location bombSite);
    
    int site(Player p2)
    {
        int x1 = this.getLocation().getX();
        int y1 = this.getLocation().getY();
        double theta = this.getLocation().getTheta();
        double alpha = this.radians;
        
        int x2 = p2.getLocation().getX();
        int y2 = p2.getLocation().getY();
        
        double gamma = Math.atan2((x2-x1),(y2-y1));
        
        if(Math.cos(theta-gamma)>Math.cos(alpha))
            return 1;
        return 0;
    }
    
    int fire(Player p2)
    {
        if(this.site(p2)==1&&!this.type.equals(p2.type))
            return 1;
        return 0;
    }

    Strategy getStrategy()
    {
        return this.strategy;
    }
    
    location getLocation()
    {
        return l;
    }
    
    void setLocation(location newL)
    {
        this.l = newL;
    }
    
    static double getSpeed()
    {
        return 0.0;
    }
    
}
