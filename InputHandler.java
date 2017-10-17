import java.util.Scanner;
public class InputHandler
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter total number of players");
        int n = sc.nextInt();
        int countT=0, countCT=0;    //count for terrorists and counter terrorists
        
        Player p[] = new Player[n];
        System.out.println("Enter team(0 for T/1 for CT), type, strategy and range of site of each player for terrorists");
        for(int i=0;i<n;i++)
        {
            int team = sc.nextInt();
            String type = sc.next();
            String strat = sc.next();
            double range = sc.nextDouble();
            
            if(team==0)
                countT++;
            else
                countCT++;
                
            Strategy strategy = null;
            if(strat.equals("nearest"))
                strategy = new nearest();
            else if(strat.equals("random"))
                strategy = new random();
            else if(strat.equals("ahead"))
                strategy = new ahead();
            else if(strat.equals("bomb")&&team==0)
                strategy = new bomb();
            
            if(type.equals("cautious"))
            {
                Cautious c = new Cautious(team,type,strategy,range);
                p[i] = c;
            }
            else if(type.equals("aggressive"))
            {
                Aggressive a = new Aggressive(team,type,strategy,range);
                p[i] = a; 
            }
            else if(type.equals("blind"))
            {
                Blind b = new Blind(team, type,strategy,range);
                p[i] = b;
            }
        }
        
        System.out.println("Enter ground dimensions(>50*>50)");
        location Ground = new location(sc.nextInt(),sc.nextInt(),0.0);
        
        System.out.println("Enter bombsite");
        location bombSite = new location(sc.nextInt(),sc.nextInt(),0.0);
        
        System.out.println("Enter playing order");
        String order = sc.next();
        
        System.out.println("Enter storage mechanism");
        String storage = sc.next();
        
        Environment e = new Environment(p, countT, countCT,  Ground, bombSite, order, storage);
        new GameEngine(e).play(); 
    }
} 