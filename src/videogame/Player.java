/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

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
        //setX(game.getCam().getX() + 280);
        //setY(game.getCam().getY() * - 1 + 150);
        
        if (game.getKeyManager().W)
        {
            setY(getY() - 5);
        }
        if (game.getKeyManager().S)
        {
            setY(getY() + 5);
        }
        if (game.getKeyManager().A)
        {
            setX(getX() - 5);
        }
        if (game.getKeyManager().D)
        {
            setX(getX() + 5);
        }
        // collision with walls
        /*
        if (getX() + 100 >= game.getWidth())
        {
            setX(game.getWidth() - 100);
        } else if (getX() <= 0)
        {
            setX(0);
        }
        */        
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(Assets.player, x, y, width, height, null);
    }
}

