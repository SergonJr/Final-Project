/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.Graphics;

/**
 *
 * @author Sergon
 */
public class Camera extends Item
{
    private Player player;      // to focus on player
    private Game game;          // to get game info
    private int speed;          // pan speed
    
    public Camera(int x, int y, int width, int height, Game game, Player player) 
    {
        super(x, y, width, height);     
        this.game = game;
        this.player = player;
    }

    public void tick()
    {
        if (game.getKeyManager().A)
        {
            setX(getX() - 5);
        }
        if (game.getKeyManager().D)
        {
            setX(getX() + 5);
        }
        if (game.getKeyManager().W)
        {
            setY(getY() + 5);
        }
        if (game.getKeyManager().S)
        {
            setY(getY() - 5);
        }
    }    

    @Override
    public void render(Graphics g)
    {
    }
}
