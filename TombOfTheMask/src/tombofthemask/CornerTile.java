package tombofthemask;

public class CornerTile extends Tile {
    
    public CornerTile(int id)
    {
        super(Assets.corner, id);
    }
    
    @Override
    public boolean isSolid()
    {
        return true;
    }
}
