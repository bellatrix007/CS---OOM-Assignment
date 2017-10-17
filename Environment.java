
public class Environment
{
    private Terrorist t[];
    private CounterTerrorist ct[];
    private Player player[];
    private location Ground, bombSite;
    private String order, storage;
    
    Environment()
    {
        t = null;
        ct = null;
        player = null;
        Ground = null;
        bombSite = null;
        order = "";
        storage = "";
    }
    
    Environment(Terrorist t[], CounterTerrorist ct[], location Ground, location bombSite, String order, String storage)
    {
        this.t = t;
        this.ct = ct;
        this.Ground = Ground;
        this.bombSite = bombSite;
        this.order = order;
        this.storage = storage;
        this.setPlayer();
    }
    
    void setPlayer()
    {
        int n = t.length;
        player = new Player[2*n];
        
        for(int i=0;i<n;i++)
        {
            player[i] = t[i];
        }
        for(int i=0;i<n;i++)
        {
            player[n+i] = ct[i];
        }
    }
}

