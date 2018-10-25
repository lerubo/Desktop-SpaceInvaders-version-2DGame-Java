
package models;

import javax.swing.ImageIcon;

/**
 *  This class creates an Enemy object 
 *  to store all the information about an enemy of the game.
 * @author Leandro Ruiz Boyle
 */
public class Enemy extends Character {
    //Atributes
    private boolean visibility = false;
    private boolean movingRight = true;
    
    //Constructor
    public Enemy(int x, int y,ImageIcon img){  
        
        setImg(img);
        setPosition(x, y);
    }

    //Getters and Setters
    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }
   
       
}
