
package models;

import javax.swing.ImageIcon;
/**
 *  This class will show will instanciate the
 * bullet that the main player ahs shoted.
 * 
 * @author Leandro Ruiz Boyle
 */
public class Bullet extends Character{
    //attributes
    private boolean from;
    private boolean visible = false;
    
    //Constructor
    public Bullet(boolean from,int x,int y) {
        this.from = from;
        if (from == true) {   
            this.setImg(new ImageIcon("src\\icons\\LoveBullet.png"));
        }
        this.setPosition(x,y);      
    }

    public boolean isFrom() {
        return from;
    }

    public void setFrom(boolean from) {
        this.from = from;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
