public class GameEngine
{
    Environment e;
    
    GameEngine(Environment e)
    {
        this.e = e;
    }
    
    void play()
    {
        Player player[] = e.getPlayers();
        int l = player.length;
        int countT = e.getcT();
        int countCT = e.getcCT(); 
        int flag = 0,turn = 0, firstTime = 1;
        location bombSite = e.getBombSite();;
        while(true)
        {
            arrangeInOrder(player, firstTime);
            int i = -1;
            switch(turn)
            {
                case 0:
                for(i = 0;i < l;i++)
                {
                    if(player[i].getTeam()==0&&player[i].isAlive()==1) 
                    {
                        break;
                    }
                }
                player[i].Almove(player,bombSite);
                if(player[i].getLocation().getX()==bombSite.getX()&&player[i].getLocation().getY()==bombSite.getY())
                    flag = 1;
                for(int j = 0;j<l;j++)
                {
                    if(j!=i&&player[j].getTeam()==1)
                    {
                        if(player[i].fire(player[j]) == 1)
                        {
                            countCT--;
                            break;
                        }
                    }
                }
                break;
                case 1:
                for(i = 0;i < l;i++)
                {
                    if(player[i].getTeam()==1&&player[i].isAlive()==1)
                    {
                        break;
                    }
                }
                player[i].Almove(player,bombSite);
                for(int j = 0;j<l;j++)
                {
                    if(j!=i&&player[j].getTeam()==0)
                    {
                        if(player[i].fire(player[j]) == 1)
                        {
                            countT--;
                            break;
                        }
                    }
                }
            }
            if(flag==1||countCT==0)
            {
                System.out.println("Terrorist won");
                break;
            }
            if(countT==0)
            {
                System.out.println("CounterTerrorist won");
                break;
            }
            turn = (turn + 1)%2;
            firstTime = 0;
        }
    }
    
    void arrangeInOrder(Player p[],int firstTime)
    {
        if(e.getOrder().equals("circular")&&firstTime!=1)
            arrangeCircular(p);
        else if(e.getOrder().equals("energy level"))
            arrangeByEnergyLevel(p);
        else if(e.getOrder().equals("success"))    
            arrangeBySuccess(p);
    }
    
    void arrangeCircular(Player p[])
    {
        int l = p.length;
        Player tmp = p[0];
        for(int i =0;i<l-1;i++)
        {
            p[i] = p[i+1];
        }
        p[l-1] = tmp;
    }
     
    void arrangeByEnergyLevel(Player p[])
    {
        int l = p.length;
        Player tmp = null;
        for(int i=0;i<l-1;i++)
        {
            for(int j=0;j<l-1-i;j++)
            {
                if(p[j].getEnergyLevel()<p[j+1].getEnergyLevel())
                {
                    tmp = p[j];
                    p[j] = p[j+1];
                    p[j+1] = tmp;
                }
            }
        } 
    }
    
    void arrangeBySuccess(Player p[])
    {
        int l = p.length;
        Player tmp = null;
        for(int i=0;i<l-1;i++)
        {
            for(int j=0;j<l-1-i;j++)
            {
                if(p[j].getSuccess()<p[j+1].getSuccess())
                {
                    tmp = p[j];
                    p[j] = p[j+1];
                    p[j+1] = tmp;
                }
            }
        } 
    }
    
}
