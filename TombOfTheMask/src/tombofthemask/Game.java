package tombofthemask;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Game implements Runnable
{
    private Display display;
    
    //imput
    private KeyManager keyManager;
    
    public int width, height;
    public String title;
    private boolean running = false;
    
    private Thread thread;
    
    private BufferStrategy bs;
    private Graphics g;
    private BufferedImage test;
    
    private Handler handler;
    
    // ALL states
    private State gameState;
    private State menuState;
    
    
    public Game(String title, int width, int height)
    {
        this.height = height;
        this.width = width;
        this.title = title;
        keyManager = new KeyManager();
    }
    
    private void init() throws FileNotFoundException
    {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        
        Assets.init();
        
        handler = new Handler(this);
        
        gameState = new GameState(handler);
        //menuState = new MenuState(handler);
        
        State.setState(gameState);
    }
    
    private void update()
    {
       keyManager.update();
       
       if (State.getState() != null)
           State.getState().update();
        
    }
    
    private void render()
    {
        bs = display.getCanvas().getBufferStrategy();
        
        if (bs == null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        
        g = bs.getDrawGraphics();
        // clean
        
        g.clearRect(0, 0, width, height);
        
        // draw
        if (State.getState() != null)
           State.getState().render(g);
        
        //end drawing
        
        bs.show();
        g.dispose();
    }

    @Override
    public void run() 
    {
        try {
            init();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        int fps = 60;
        double timePerFrame = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        
        while(running)
        {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerFrame;
            lastTime = now;
            
            if(delta >= 1)
            {
                update();
                render();
                delta--;
            }
        }
        
        stop();
    }
    
    public KeyManager getKeyManager()
    {
        return keyManager;
    }
    
    public synchronized void start()
    {
        if (running)
            return;
        
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop()
    {
        if(!running)
            return;
        
        running = false;
        
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
}
