/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author antoniomejorado
 */
public class Game implements Runnable
{

    private BufferStrategy bs;      // to have several buffers when displaying
    private Graphics g;             // to paint objects
    private Display display;        // to display in the game
    String title;                   // title of the window
    private int width;              // width of the window
    private int height;             // height of the window
    private Thread thread;          // thread to create the game
    private boolean running;        // to set the game
    private Player player;          // to use a player
    private KeyManager keyManager;  // to manage the keyboard
    private Camera cam;             // to manage camera
    /**
     * to create title, width and height and set the game is still not running
     *
     * @param title to set the title of the window
     * @param width to set the width of the window
     * @param height to set the height of the window
     */
    public Game(String title, int width, int height)
    {
        this.title = title;
        this.width = width;
        this.height = height;
        running = false;
        keyManager = new KeyManager();
        
    }

    /**
     * To get the width of the game window
     *
     * @return an <code>int</code> value with the width
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * To get the height of the game window
     *
     * @return an <code>int</code> value with the height
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * initializing the display window of the game
     */
    private void init()
    {
        display = new Display(title, getWidth(), getHeight());
        Assets.init();
        cam = new Camera(0, 0, 0, 0, this, player);
        player = new Player(cam.getX() + 280, cam.getY() + 150, 50, 50, this);         
        display.getJframe().addKeyListener(keyManager);
    }

    @Override
    public void run()
    {
        init();
        // frames per second
        int fps = 60;
        // time for each tick in nano segs
        double timeTick = 1000000000 / fps;
        // initializing delta
        double delta = 0;
        // define now to use inside the loop
        long now;
        // initializing last time to the computer time in nanosecs
        long lastTime = System.nanoTime();
        while (running)
        {
            // setting the time now to the actual time
            now = System.nanoTime();
            // acumulating to delta the difference between times in timeTick units
            delta += (now - lastTime) / timeTick;
            // updating the last time
            lastTime = now;

            // if delta is positive we tick the game
            if (delta >= 1)
            {
                tick();
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

    private void tick()
    {
        keyManager.tick();
        player.tick();
        cam.tick();
    }

    private void render()
    {
        // get the buffer strategy from the display
        bs = display.getCanvas().getBufferStrategy();
        /* if it is null, we define one with 3 buffers to display images of
        the game, if not null, then we display every image of the game but
        after clearing the Rectangle, getting the graphic object from the 
        buffer strategy element. 
        show the graphic and dispose it to the trash system
         */
        if (bs == null)
        {
            display.getCanvas().createBufferStrategy(3);
        } else
        {                        
            g = bs.getDrawGraphics();
            Graphics2D g2d = (Graphics2D) g;
            g2d.scale(3, 3);
            g2d.translate(-cam.getX(), cam.getY());
            
            g.drawImage(Assets.background, -width/2, -height/2, 2560, 962, null);
            player.render(g);
            
            bs.show();
            g.dispose();
        }

    }

    /**
     * setting the thead for the game
     */
    public synchronized void start()
    {
        if (!running)
        {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    /**
     * stopping the thread
     */
    public synchronized void stop()
    {
        if (running)
        {
            running = false;
            try
            {
                thread.join();
            } catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
    }

    public Camera getCam()
    {
        return cam;
    }

}
