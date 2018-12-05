package tombofthemask;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public abstract class Entity
{
    protected Handler handler;
    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;
    
    public Entity(Handler handler, float x, float y, int width, int height)
    {
        this.handler=handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        bounds = new Rectangle(0, 0, width, height);
    }
    
    public abstract void update();
    
    public abstract void render(Graphics g);
    
    public void checkEntityCollisions(float x, float y) throws Throwable
    {
        for (int i = 0; i < handler.getMap().getEntityManager().getEntities().size(); i++)
        {
            if (handler.getMap().getEntityManager().getEntities().get(i).equals(this))
                continue;
            
            if (handler.getMap().getEntityManager().getEntities().get(i).getCollisionBounds(0f, 0f).intersects(getCollisionBounds(x,y)))
            {
                if (handler.getMap().getEntityManager().getEntities().get(i).isDeadly())
                {
                    handler.getMap().incrementDeathCount();
                    KeyManager.keys[KeyEvent.VK_RIGHT] = false;
                    KeyManager.keys[KeyEvent.VK_UP] = false;
                    KeyManager.keys[KeyEvent.VK_LEFT] = false;
                    KeyManager.keys[KeyEvent.VK_DOWN] = false;
                    
                    handler.getMap().getEntityManager().getPlayer().setX(handler.getMap().getSpawnX()*Tile.TILEWIDTH);
                    handler.getMap().getEntityManager().getPlayer().setY(handler.getMap().getSpawnY()*Tile.TILEHEIGHT);
                }
                else
                {
                 handler.getMap().getEntityManager().getEntities().remove(i);   
                 handler.getMap().incrementScore();
                }
            }
        }
    }
    
    public boolean isDeadly()
    {
        return false;
    }
    
    public Rectangle getCollisionBounds(float x, float y)
    {
        return new Rectangle((int) (this.x+bounds.x + x), (int) (this.y + bounds.y + y), bounds.width, bounds.height);
    }
    
    
    
    public float getX()
    {
     return x;   
    }
    
    public float getY()
    {
     return y;   
    }
    
    public int getWidth()
    {
     return width;   
    }
    
    public int getHeight()
    {
     return height;   
    }
    
    public void setX(float x)
    {
        this.x = x;
    }
    
    public void setY(float y)
    {
        this.y = y;
    }
    
    public void setWidth(int width)
    {
        this.width = width;
    }
    
    public void setHeight(int height)
    {
        this.height = height;
    }
    
}
