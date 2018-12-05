package tombofthemask;

import java.awt.Graphics;
import java.util.LinkedList;

public class EntityManager
{
    private Handler handler;
    private Player player;
    
    private LinkedList<Entity> entities;
    
    public EntityManager(Handler handler, Player player)
    {
        this.handler = handler;
        this.player = player;
        
        entities = new LinkedList<Entity>();
        addEntity(player);
    }
    
    public void update()
    {
      for (int i = 0; i < entities.size(); i++)
        {
            entities.get(i).update();
        }  
    }
    
    public void render(Graphics g)
    {
       for (int i = 0; i < entities.size(); i++)
        {
            entities.get(i).render(g);
        }
    }
    
    public void addEntity(Entity e)
    {
        entities.add(e);
    }
    
    // getters setters

    public Handler getHandler() {
        return handler;
    }

    public Player getPlayer() {
        return player;
    }

    public LinkedList<Entity> getEntities() {
        return entities;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setEntities(LinkedList<Entity> entities) {
        this.entities = entities;
    }
    
    
    
}
