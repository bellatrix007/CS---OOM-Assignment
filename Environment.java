
public class Environment
{
    private Player player[];
    private location Ground, bombSite;
    private String order, storage;
    private int countT, countCT;
    
    Environment()
    {
        player = null;
        Ground = null;
        bombSite = null;
        order = "";
        storage = "";
        countT = 0;
        countCT = 0;
    }
    
    Environment(Player p[], int countT, int countCT, location Ground, location bombSite, String order, String storage)
    {
        this.player = p;
        this.countT = countT;
        this.countCT = countCT;
        this.Ground = Ground;
        this.bombSite = bombSite;
        this.order = order;
        this.storage = storage;
    }
    
    Player[] getPlayers()
    {
        return this.player;
    }
    
    int getcT()
    {
        return this.countT;
    }
    
    int getcCT()
    {
        return this.countCT;
    }
    
    String getOrder()
    {
        return this.order;
    }
    
    location getBombSite()
    {
        return this.bombSite;
    }
}

