/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author antoniomejorado
 */
public class Player extends Item
{

    private Game game;
    private int speed = 10;

    public Player(int x, int y, int width, int height, Game game)
    {
        super(x, y, width, height);
        this.game = game;
    }

    @Override
    public void tick()
    {
        // moving player depending on keys       
        if (game.getKeyManager().Left)
        {
            setX(getX() - speed);
        }
        if (game.getKeyManager().Right)
        {
            setX(getX() + speed);
        }
        if (game.getKeyManager().Down) 
        {
            setY(getY() + speed);
        }
        if (game.getKeyManager().Up) 
        {
            setY(getY() - speed);
        }
        // collision with walls
        if (getX() + 100 >= game.getWidth())
        {
            setX(game.getWidth() - 100);
        } else if (getX() <= 0)
        {
            setX(0);
        }
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(Assets.player, x, y, width, height, null);
    }
}

