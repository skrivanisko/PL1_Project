package tombofthemask;

import java.awt.Graphics;

public abstract class State
{
    private static State currentState = null;
    
    
    // Manager
    public static void setState(State state)
    {
        currentState = state;
    }
    
    public static State getState()
    {
        return currentState;
    }
    
    
    
    
    //CLASS
    
    protected Handler handler;
    
    public State(Handler handler)
    {
        this.handler = handler;
    }
    
    public abstract void update();
    
    public abstract void render(Graphics g);
    
}
