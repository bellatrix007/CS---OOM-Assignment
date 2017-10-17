public class Strategy
{
    void setLocation(Player currentPlayer,location bomb)
    {
        
    }
    
    void setLocation(Player player[],Player currentPlayer)
    {
        
    }
}

class ahead extends Strategy
{
    Player findAheadPlayer(Player player[],Player currentPlayer,int cx,int cy)
    {
        double distance=0.0,sd = Double.MAX_VALUE;
        Player found = null;
         
        for(int i=0;i<player.length;i++)
        {
            location l = new location(player[i].getLocation());
            int x = l.getX();
            int y = l.getY();
            
            distance = Math.sqrt(Math.pow((cx-x),2)+Math.pow((cy-y),2));
            
            if(distance<sd&&currentPlayer.site(player[i])==1)
            {
                sd = distance;
                found = player[i];
            }
        }
        
        return found;
    }
       
    void setLocation(Player player[],Player currentPlayer)
    {
        int cx = currentPlayer.getLocation().getX();
        int cy = currentPlayer.getLocation().getY();
        
        Player nearestP = findAheadPlayer(player,currentPlayer,cx,cy);
        int gx = nearestP.getLocation().getX();
        int gy = nearestP.getLocation().getY();
        
        double distance = Math.sqrt(Math.pow((gx-cx),2)+Math.pow((gy-cy),2));
        double s = currentPlayer.getSpeed(); 
        
        int newX = cx + (int)((s*(gx-cx))/distance);
        int newY = cy + (int)((s*(gy-cy))/distance);
        double newTheta = Math.atan2((gy-cy),(gx-cx)); 
        
        currentPlayer.setLocation(new location(newX,newY,newTheta)); 
    }
}

class nearest extends Strategy
{
    Player findNearestPlayer(Player player[],int cx,int cy)
    {
        double distance=0.0,sd = Double.MAX_VALUE;
        Player found = null;
         
        for(int i=0;i<player.length;i++)
        {
            location l = new location(player[i].getLocation());
            int x = l.getX();
            int y = l.getY();
            
            distance = Math.sqrt(Math.pow((cx-x),2)+Math.pow((cy-y),2));
            
            if(distance<sd)
            {
                sd = distance;
                found = player[i];
            }
        }
        
        return found;
    }
       
    void setLocation(Player player[],Player currentPlayer)
    {
        int cx = currentPlayer.getLocation().getX();
        int cy = currentPlayer.getLocation().getY();
        
        Player nearestP = findNearestPlayer(player,cx,cy);
        int gx = nearestP.getLocation().getX();
        int gy = nearestP.getLocation().getY();
        
        double distance = Math.sqrt(Math.pow((gx-cx),2)+Math.pow((gy-cy),2));
        double s = currentPlayer.getSpeed(); 
        
        int newX = cx + (int)((s*(gx-cx))/distance);
        int newY = cy + (int)((s*(gy-cy))/distance);
        double newTheta = Math.atan2((gy-cy),(gx-cx)); 
        
        currentPlayer.setLocation(new location(newX,newY,newTheta)); 
    }
}
class random extends Strategy
{
    void setLocation(Player player[],Player currentPlayer)
    {
        int cx = currentPlayer.getLocation().getX();
        int cy = currentPlayer.getLocation().getY();
        
        int randomIndex = (int)(Math.random()*player.length);
        
        Player randomP = player[randomIndex];
        int gx = randomP.getLocation().getX();
        int gy = randomP.getLocation().getY();
        
        double distance = Math.sqrt(Math.pow((gx-cx),2)+Math.pow((gy-cy),2));
        double s = currentPlayer.getSpeed(); 
        
        int newX = cx + (int)((s*(gx-cx))/distance);
        int newY = cy + (int)((s*(gy-cy))/distance);
        double newTheta = Math.atan2((gy-cy),(gx-cx)); 
        
        currentPlayer.setLocation(new location(newX,newY,newTheta)); 
    }
}

class bomb extends Strategy
{
    void setLocation(Player currentPlayer,location bombSite)
    {
        int cx = currentPlayer.getLocation().getX();
        int cy = currentPlayer.getLocation().getY();
        
        int gx = bombSite.getX();
        int gy = bombSite.getY();
        
        double distance = Math.sqrt(Math.pow((gx-cx),2)+Math.pow((gy-cy),2));
        double s = currentPlayer.getSpeed(); 
        
        int newX = cx + (int)((s*(gx-cx))/distance);
        int newY = cy + (int)((s*(gy-cy))/distance);
        double newTheta = Math.atan2((gy-cy),(gx-cx)); 
        
        currentPlayer.setLocation(new location(newX,newY,newTheta)); 
    }
}

