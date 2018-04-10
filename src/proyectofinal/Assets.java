/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.awt.image.BufferedImage;

/**
 *
 * @author antoniomejorado
 */
public class Assets
{

    public static BufferedImage background; // to store background image
    public static BufferedImage player;     // to store the player image
    public static BufferedImage enemy;      // to store the enemy player

    /**
     * initializing the images of the game
     */
    public static void init()
    {
        background = ImageLoader.loadImage("/images/space.jpg");
        player = ImageLoader.loadImage("/images/zimShip.png");
        enemy = ImageLoader.loadImage("/images/enemy.png");
    }

}
