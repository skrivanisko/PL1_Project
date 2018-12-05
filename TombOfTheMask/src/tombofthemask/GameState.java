package tombofthemask;

import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameState extends State 
{
    private Map map;
    
    public GameState(Handler handler)
    {
        super(handler);
        map = new Map(handler,"map.txt");
        handler.setMap(map);
        //player = new Player(handler, map.getSpawnX()* Tile.TILEWIDTH, map.getSpawnY()*Tile.TILEHEIGHT);   
    }

    @Override
    public void update() 
    {
        try {
            map.update();
        } catch (Exception ex) {
            Logger.getLogger(GameState.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void render(Graphics g) 
    {
        map.render(g);
    }
    
}
