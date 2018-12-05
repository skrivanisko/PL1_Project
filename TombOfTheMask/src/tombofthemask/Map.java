package tombofthemask;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Map
{
    private Handler handler;
    private int width, height;
    private int [][] map;
    private int spawnX, spawnY;
    private int finishX, finishY;
    private int score;
    private int deathCount;
    private String mapName;
    
    private EntityManager entityManager;
    
    public Map(Handler handler, String path)
    {
        this.handler=handler;
        mapName = path;
        
        load(path);
        
        entityManager = new EntityManager(handler, new Player(handler, spawnX*Tile.TILEWIDTH, spawnY*Tile.TILEHEIGHT));
        initEntities();
    }
    
    private void initEntities()
    {
       for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
            {
                if (map[i][j] == 3)
                    entityManager.addEntity(new Coin(handler, i*Tile.TILEWIDTH,j*Tile.TILEHEIGHT));
                else if (map[i][j] == 4)
                    entityManager.addEntity(new MonsterX(handler, i*Tile.TILEWIDTH,j*Tile.TILEHEIGHT));
                else if (map[i][j] == 5)
                    entityManager.addEntity(new MonsterY(handler, i*Tile.TILEWIDTH,j*Tile.TILEHEIGHT));
                else if (map[i][j] == 6)
                    entityManager.addEntity(new DeathTile(handler, i*Tile.TILEWIDTH,j*Tile.TILEHEIGHT));
            } 
    }
    
    public void update() throws Exception
    {
        entityManager.update();
        insertDatabase();
    }
    
    public void insertDatabase() throws Exception
    {
        if (handler.getMap().getEntityManager().getPlayer().getX() == finishX*Tile.TILEWIDTH &&
                handler.getMap().getEntityManager().getPlayer().getY() == finishY*Tile.TILEHEIGHT)
        {
            KeyManager.keys[KeyEvent.VK_RIGHT] = false;
            KeyManager.keys[KeyEvent.VK_UP] = false;
            KeyManager.keys[KeyEvent.VK_LEFT] = false;
            KeyManager.keys[KeyEvent.VK_DOWN] = false;
            
            this.getEntityManager().getPlayer().setXMove(0);
            this.getEntityManager().getPlayer().setYMove(0);
            
            
            handler.getMap().getEntityManager().getPlayer().setX(spawnX*Tile.TILEWIDTH);
            handler.getMap().getEntityManager().getPlayer().setY(spawnY*Tile.TILEWIDTH);
            
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            
            DBManager.insert(mapName, Integer.toString(score), Integer.toString(deathCount), timeStamp);            
        }
    }
 
    public void render(Graphics g)
    {
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
            {
                getTile(i,j).render(g, i*Tile.TILEWIDTH, j*Tile.TILEHEIGHT);
            }
        
        entityManager.render(g);
        
        g.setColor(Color.red);
        g.drawString("SCORE: " + Integer.toString(score), 35 , 45);
        g.drawString("DEATH COUNT: " + Integer.toString(deathCount), 35 , 65);
    }
    
    public Tile getTile(int x, int y)
    {
        if (x<0 || y<0 || x>= width || y>=height)
            return Tile.pathTile;
        
        Tile t = Tile.tiles[map[x][y]];
        
        if(t==null)
            return Tile.pathTile;
        return t;
    }
    
    public void load(String path)
    {       
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);
        finishX = Utils.parseInt(tokens[4]);
        finishY = Utils.parseInt(tokens[5]);
        
        
        map = new int[width][height];
        
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                map[i][j] = Utils.parseInt(tokens[(i+j*width)+6]);
    }
    
    public int getSpawnX()
    {
        return spawnX;
    }
    
    public int getSpawnY()
    {
        return spawnY;
    }
    
    public Map getMap()
    {
        return this;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public int getScore() {
        return score;
    }
    
    public int getDeathCount() {
        return deathCount;
    }

    public void incrementDeathCount()
    {
        this.deathCount++;
    }

    public void incrementScore()
    {
        this.score++;
    }

    public int getFinishX() {
        return finishX;
    }

    public int getFinishY() {
        return finishY;
    }
    
    
    
    
}
