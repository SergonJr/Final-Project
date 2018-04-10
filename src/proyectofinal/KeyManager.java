/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Sergio González
 */
public class KeyManager implements KeyListener
{

    public boolean Up;      // flag to move up the player
    public boolean Down;    // flag to move down the player
    public boolean Left;    // flag to move left the player
    public boolean Right;   // flag to move right the player    
    private boolean keys[];  // to store all the flags for every key
    public boolean Space;   // flag for space
    public boolean P;       // flag for p
    public boolean A;       // flag for a
    public boolean W;       // flag for w
    public boolean S;       // flag for s
    public boolean D;       // flag for d
    public boolean Shift;   // flag for Shift
    public boolean Esc;     // flag for Esc
    

    public KeyManager()
    {
        keys = new boolean[256];
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        // set true to every key pressed
        // set flag space if needed        
        keys[e.getKeyCode()] = true;

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        // set false to every key released
        keys[e.getKeyCode()] = false;
    }

    /**
     * to enable or disable moves on every tick
     */
    public void tick()
    {
        Up = keys[KeyEvent.VK_UP];
        Down = keys[KeyEvent.VK_DOWN];
        Left = keys[KeyEvent.VK_LEFT];
        Right = keys[KeyEvent.VK_RIGHT];
        Space = keys[KeyEvent.VK_SPACE];
        P = keys[KeyEvent.VK_P];
        A = keys[KeyEvent.VK_A];
        W = keys[KeyEvent.VK_W];
        S = keys[KeyEvent.VK_S];
        D = keys[KeyEvent.VK_D];
    }
}
