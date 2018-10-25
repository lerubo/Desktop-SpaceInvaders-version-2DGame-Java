
package gameControl;
/**
 *  This class is a data structure to keep the game data. 
 * @author Leandro Ruiz Boyle
 */
public class GameStatus {
   //atributes
    private int points = 0;
   private int lives;
   private int level;
   private int numberEnemies;
   
   
   //Constructors
    public GameStatus() {
    }
    public GameStatus(int lives, int level, int ne) {       
        this.lives = lives;
        this.level = level;  
        this.numberEnemies = ne;
   }
    
    //Getters and Setters
    public int getNumberEnemies() {
        return numberEnemies;
    }

    public void setNumberEnemies(int numberEnemies) {
        this.numberEnemies = numberEnemies;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
 
}
