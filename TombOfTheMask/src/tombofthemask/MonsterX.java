package tombofthemask;

import java.awt.Graphics;

public class MonsterX extends Creature
{
    public MonsterX(Handler handler, float x, float y)
    {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        
        bounds.x = 5;
        bounds.y = 5;
        bounds.width = Tile.TILEWIDTH-10;
        bounds.height = Tile.TILEHEIGHT-10;
        xMove = 6;
    }
    
    @Override
    public void move()
    {
        this.moveX();
    }

    @Override
    public void moveX() {

        
        x+=xMove;
        
        
            int tx = (int) (x+xMove + bounds.x + bounds.width)/Tile.TILEWIDTH;
            int tx1 = (int) (x+xMove + bounds.x)/Tile.TILEWIDTH;
            
            if (!collisionWithTile(tx,(int)((y+bounds.y)/Tile.TILEHEIGHT)) && 
                    !collisionWithTile(tx, (int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT))
                        xMove = -xMove;
            
            if (!collisionWithTile(tx1,(int)((y+bounds.y)/Tile.TILEHEIGHT)) && 
                    !collisionWithTile(tx1, (int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT))
                        xMove = -xMove;

    }
    
    
    
    public boolean isDeadly()
    {
        return true;
    }

    @Override
    public void update()
    {
       move();
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(Assets.monster,(int) x,(int) y, null);
    }
    
}
