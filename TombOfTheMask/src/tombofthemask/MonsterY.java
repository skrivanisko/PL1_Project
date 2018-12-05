package tombofthemask;

public class MonsterY extends MonsterX
{
    
    public MonsterY(Handler handler, float x, float y) {
        super(handler, x, y);
        
        bounds.x = 5;
        bounds.y = 5;
        bounds.width = Tile.TILEWIDTH-10;
        bounds.height = Tile.TILEHEIGHT-10;
        
        yMove = 4;
    }
    
     @Override
    public void move()
    {
        this.moveY();
    }

    @Override
    public void moveY()
    {

        
        y+=yMove;

            int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
            int ty1 = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
            
            if (!collisionWithTile((int)(x+bounds.x)/Tile.TILEWIDTH, ty)&&
                    !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILEWIDTH, ty))
            yMove=-yMove;
            
            if (!collisionWithTile((int)(x+bounds.x)/Tile.TILEWIDTH, ty1)&&
                    !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILEWIDTH, ty1))
            yMove=-yMove;

    }
    
    
    
}
