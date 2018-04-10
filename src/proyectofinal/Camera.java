/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.awt.Graphics;

/**
 *
 * @author Sergio González
 */
public class Camera extends Item
{
    private Player player;      // to focus on player
    private Game game;          // to get game info
    
    public Camera(int x, int y, int width, int height, Game game, Player player) 
    {
        super(x, y, width, height);     
        this.game = game;
        this.player = player;
    }

    public void tick()
    {
        if (game.getKeyManager().Left)
        {
            setX(getX() - 10);
        }
        if (game.getKeyManager().Right)
        {
            setX(getX() + 10);
        }
        if (game.getKeyManager().Up)
        {
            setY(getY() + 10);
        }
        if (game.getKeyManager().Down)
        {
            setY(getY() - 10);
        }
    }    

    @Override
    public void render(Graphics g)
    {
    }
}
