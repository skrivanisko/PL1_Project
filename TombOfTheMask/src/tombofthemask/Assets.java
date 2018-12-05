package tombofthemask;

import java.awt.image.BufferedImage;

public class Assets
{
    private static final int WIDTH = 30, HEIGHT = 30;
    
    public static BufferedImage player, path, wall, corner, coin, monster, deathTile;
    
    public static void init()
    {
        player = ImageLoader.loadImage("player.png");
        path = ImageLoader.loadImage("path.png");
        wall = ImageLoader.loadImage("wall.png");
        corner = ImageLoader.loadImage("corner.png");
        coin = ImageLoader.loadImage("coin.png");
        monster = ImageLoader.loadImage("monster.png");
        deathTile = ImageLoader.loadImage("deathTile.png");
    }
}
