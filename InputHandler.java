import java.util.Scanner;
public class InputHandler
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter number of players in each team");
        int n = sc.nextInt();
         
        Terrorist t[] = new Terrorist[n];
        System.out.println("Enter type, startegy and range of site of each player for terrorists");
        for(int i=0;i<n;i++)
        {
            String type = sc.next();
            String strat = sc.next();
            double range = sc.nextDouble();
            
            Strategy strategy = null;
            if(strat.equals("nearest"))
                strategy = new nearest();
            else if(strat.equals("random"))
                strategy = new random();
            else if(strat.equals("ahead"))
                strategy = new ahead();
            else if(strat.equals("bomb"))
                strategy = new bomb();
            
            if(type.equals("cautious"))
            {
                CautiousT cT = new CautiousT(type,strategy,range);
                t[i] = cT;
            }
            else if(type.equals("aggressive"))
            {
                AggressiveT aT = new AggressiveT(type,strategy,range);
                t[i] = aT;
            }
            else if(type.equals("cautious"))
            {
                BlindT bT = new BlindT(type,strategy,range);
                t[i] = bT;
            }
        }
        
        CounterTerrorist ct[] = new CounterTerrorist[n];
        System.out.println("Enter type and startegy of each player for counter terrorists");
        for(int i=0;i<n;i++)
        {
            String type = sc.next();
            String strat = sc.next();
            double range = sc.nextDouble();
            
            Strategy strategy = null;
            if(strat.equals("nearest"))
                strategy = new nearest();
            else if(strat.equals("random"))
                strategy = new random();
            else if(strat.equals("ahead"))
                strategy = new ahead();
            
            if(type.equals("cautious"))
            {
                CautiousCT cCT = new CautiousCT(type,strategy,range);
                ct[i] = cCT;
            }
            else if(type.equals("aggressive"))
            {
                AggressiveCT aCT = new AggressiveCT(type,strategy,range);
                ct[i] = aCT;
            }
            else if(type.equals("cautious"))
            {
                BlindCT bCT = new BlindCT(type,strategy,range);
                ct[i] = bCT;
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
        
    }
} 