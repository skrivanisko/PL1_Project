package tombofthemask;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Tile 
{
    public static Tile[] tiles = new Tile[7];
    public static Tile pathTile = new PathTile(0);
    public static Tile wallTile = new WallTile(1);
    public static Tile cornerTile = new CornerTile(2);
    
    // class
    public static final int TILEWIDTH = 30, TILEHEIGHT = 30;
    
    protected BufferedImage texture;
    protected final int id;
    
    public Tile(BufferedImage texture, int id)
    {
        this.texture = texture;
        this.id = id;
        
        tiles[id] = this;
    }
    
    public void update()
    {
        
    }
    
    public void render(Graphics g, int x, int y)
    {
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }
    
    public boolean isSolid()
    {
        return false;
    }
    
    public int getId()
    {
        return id;
    }
}
