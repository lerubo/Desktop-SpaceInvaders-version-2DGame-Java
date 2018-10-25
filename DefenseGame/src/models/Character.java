
package models;

import java.awt.Point;
import javax.swing.ImageIcon;

abstract class Character {
    //attributes
    private boolean moving = true;
    private int height = 50;
    private int width = 50;
    private Point position = new Point(0,0);
    private ImageIcon img;
    
    //Getters and Setters
    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean move) {
        this.moving = move;
    }

    public ImageIcon getImg() {
        return img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }
   
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        this.position = new Point(x,y);
    }

    @Override
    public String toString() {
        return "Character{" + "height=" + height + ", width=" + width + ", position=" + position + ", img=" + img + '}';
    }
    
   
}
