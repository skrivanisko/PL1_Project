package tombofthemask;

import java.awt.Graphics;

public class Coin extends StaticEntity
{

    public Coin(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
      
        bounds.x = 10;
        bounds.y = 10;
        bounds.width = 10;
        bounds.height = 10;
        
    }

    @Override
    public void update()
    {
        
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(Assets.coin,(int) x,(int) y, width, height, null);
    }
    
}
