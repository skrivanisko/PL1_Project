package tombofthemask;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener
{
    public static boolean[] keys;
    public static boolean up, down, left, right;
    
    public KeyManager()
    {
        keys = new boolean[256];
    }
    
    public void update()
    {
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
        keys[e.getKeyCode()] = true;
        
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        //keys[e.getKeyCode()] = false;
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        
    }
    
    
}
