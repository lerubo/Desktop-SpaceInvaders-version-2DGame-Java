
package models;

import javax.swing.ImageIcon;

/**
 *  This class creates an instance of the main player in the game.
 * 
 * @author Leandro Ruiz Boyle
 */
public class Player extends Character { 
    //contructor
    public Player(int x, int y){            
        this.setPosition(x,y);
        this.setImg(new ImageIcon("src\\icons\\Player1.png"));
    }
 
}
