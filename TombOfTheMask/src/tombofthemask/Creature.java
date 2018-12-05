package tombofthemask;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Creature extends Entity 
{
    public static final float DEFAULT_SPEED = 10.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 30;
    public static final int DEFAULT_CREATURE_HEIGHT = 30;
    
    protected float speed;
    protected float xMove, yMove;
    
    public Creature(Handler handler, float x, float y, int width, int height)
    {
        super(handler, x, y, width, height);
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }
    
    
    public void move()
    {
        try {
            checkEntityCollisions(xMove, yMove);
        } catch (Throwable ex) {
            Logger.getLogger(Creature.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        moveX();
        moveY();
    }
    
    public void moveX()
    {
        if (xMove > 0)
        {
            int tx = (int) (x+xMove + bounds.x + bounds.width)/Tile.TILEWIDTH;
            
            if (!collisionWithTile(tx,(int)((y+bounds.y)/Tile.TILEHEIGHT)) && 
                    !collisionWithTile(tx, (int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT))
                        x+=xMove;
            else
                KeyManager.keys[KeyEvent.VK_RIGHT] = false;
        }
        else if (xMove < 0)
        {
            int tx = (int) (x+xMove + bounds.x)/Tile.TILEWIDTH;
            
            if (!collisionWithTile(tx,(int)((y+bounds.y)/Tile.TILEHEIGHT)) && 
                    !collisionWithTile(tx, (int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT))
                        x+=xMove;
            else
                KeyManager.keys[KeyEvent.VK_LEFT] = false;
        }
    }
    
    public void moveY()
    {
        if (yMove < 0)
        {
            int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
            
            if (!collisionWithTile((int)(x+bounds.x)/Tile.TILEWIDTH, ty)&&
                    !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILEWIDTH, ty))
            y+=yMove;
            else
                KeyManager.keys[KeyEvent.VK_UP] = false;
        }
        else if (yMove > 0)
        {
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
            
            if (!collisionWithTile((int)(x+bounds.x)/Tile.TILEWIDTH, ty)&&
                    !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILEWIDTH, ty))
            y+=yMove;
            else
                KeyManager.keys[KeyEvent.VK_DOWN] = false;
        }
    }
    
    protected boolean collisionWithTile(int x, int y)
    {
        return handler.getMap().getTile(x, y).isSolid();
    }
    
    // getters setters
    
    public float getSpeed()
    {
        return speed;
    }
            
    public void setSpeed(float speed)
    {
        this.speed = speed;
    }
    
    public float getXMove()
    {
        return xMove;
    }
            
    public void setXMove(float xMove)
    {
        this.xMove = xMove;
    }
    
    public float getYMove()
    {
        return yMove;
    }
            
    public void setYMove(float yMove)
    {
        this.yMove = yMove;
    }
}
