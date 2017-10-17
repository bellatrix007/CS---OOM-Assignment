public class location
{
    //simple class for location storage
    private int X,Y;
    private double theta;
    
    location()
    {
        this.X = 0;
        this.Y = 0;
        this.theta = 0.0;
    }
    
    location(int x,int y,double t)
    {
        this.X = x;
        this.Y = y;
        this.theta = t;
    }
    
    location(location l)
    {
        this.X = l.X;
        this.Y = l.Y;
        this.theta = l.theta;
    }
    
    void setX(int x)
    {
        this.X = x;
    }
    
    void setY(int y)
    {
        this.Y = y;
    }
    
    void setTheta(double t)
    {
        this.theta = t;
    }
    
    int getX()
    {
        return this.X;
    }
    
    int getY()
    {
        return this.Y;
    }
    
    double getTheta()
    {
        return this.theta;
    }
}
