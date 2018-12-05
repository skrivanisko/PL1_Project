package tombofthemask;

import java.awt.Graphics;

public class Player extends Creature
{
    public Player(Handler handler, float x, float y)
    {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        
        bounds.x = 5;
        bounds.y = 5;
        bounds.width = Tile.TILEWIDTH-10;
        bounds.height = Tile.TILEHEIGHT-10;
    }

    @Override
    public void update()
    {
        getInput();
        move();
    }
    
    private void getInput()
    {
        xMove = 0;
        yMove = 0;
        
        if (handler.getKeyManager().up)
            yMove = -speed;

        if (handler.getKeyManager().down)
            yMove = speed;

        if (handler.getKeyManager().left)
            xMove = -speed;

        if (handler.getKeyManager().right)
            xMove = speed;
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(Assets.player,(int) x,(int) y, null);
        
        //g.setColor(Color.red);
       // g.fillRect((int) x+bounds.x,(int) y+bounds.y, bounds.width , bounds.height);
    }
}
