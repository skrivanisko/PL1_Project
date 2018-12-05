package tombofthemask;

public class Handler
{
    private Game game;
    private Map map;
    
    public Handler(Game game)
    {
        this.game = game;
    }
    
    public int getWidth()
    {
        return game.getWidth();
    }
    
    public int getHeight()
    {
        return game.getHeight();
    }
    
    // get game.camera
    
    public KeyManager getKeyManager()
    {
        return game.getKeyManager();
    }
    
    public Game getGame()
    {
        return game;
    }
    
    public void setGame(Game game)
    {
        this.game = game;
    }
    
    public Map getMap()
    {
        return map;
    }
    
    public void setMap(Map map)
    {
        this.map = map;
    }
}
