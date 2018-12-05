package tombofthemask;

import java.awt.Graphics;

public class DeathTile extends StaticEntity
{

    public DeathTile(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
        
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = Tile.TILEWIDTH;
        bounds.height = Tile.TILEHEIGHT;
    }
    
    @Override
    public boolean isDeadly()
    {
        return true;
    }

    @Override
    public void update()
    {
        
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(Assets.deathTile, (int) x, (int) y, width, height, null);
    }
    
 
}
