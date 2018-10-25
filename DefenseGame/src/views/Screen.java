
package views;

import gameControl.GameStatus;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import models.Bullet;
import models.Enemy;
import models.Player;

/**
 *  This class is the class that will hold most of the code .In this class we have
 * Physics, events, timmers,...
 * 
 * @author Leandro Ruiz Boyle
 */
public class Screen extends JPanel implements ActionListener, KeyListener{
    // GLOBAL variables
    GameStatus gs;
    ScorePanel sp; 
    Splash splash;
    JLabel lbl1,lbl2,lbl3,lblSplash;
    
    ImageIcon pImage,bImage,eImage,background;
    ArrayList<Enemy> enemiesList = new ArrayList<>();
    Component[] lbl_list;
    
    Player p;
    Bullet b;
    Timer t = new Timer(20,this);

    int speedPlayer = 30, speedBullet = 30, speedEnemyY = 1, speedEnemyX = 1;
    int pX = 225, pY = 700;
    int eX = 0, eY = 0;
    int count = 0;
    int enemyCount = 0;
    int NUMBER_OF_ENEMIES;
    boolean shooting = false, start = false, nextEnemy = false;
    Random randomGenerator;
    
    //Constructor
    public Screen(int level){  
        splash = new Splash();
        splash.setVisible(false);
        lblSplash = (JLabel) splash.getComponent(0);
        gs = new GameStatus(5,1,10); //points , lives , level 
        configuration(level);
        NUMBER_OF_ENEMIES = gs.getNumberEnemies();
        
        p = new Player(pX,pY);   
        t.start();
        sp = new ScorePanel();
        this.add(splash);
        this.add(sp);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
       
        randomGenerator = new Random();
        for(int i = 0; i<NUMBER_OF_ENEMIES;i++){
            int temp = randomGenerator.nextInt(450);
            enemiesList.add(new Enemy(temp,eY,eImage));
        }     
        lbl_list = sp.getComponents();
        lbl1 = (JLabel) lbl_list[0];
        lbl2 = (JLabel) lbl_list[1];
        lbl3 = (JLabel) lbl_list[2];
        
        lbl3.setText("LIVES: "+gs.getLives());
        lbl2.setText("SCORE: 0/"+NUMBER_OF_ENEMIES);
        lbl1.setText("LEVEL: "+gs.getLevel());
       
        
    }
    
    /**
   * This function sets the details specific for each level.
   * @param int level .  
   */
    public void configuration(int level){
        
        switch(level){
            case 1:                                           //LEVEL 1     
                gs.setLevel(1);
                gs.setLives(5);
                gs.setNumberEnemies(20); 
                speedEnemyX = 3;
                background = new ImageIcon("src\\icons\\background1.jpg"); 
                eImage = new ImageIcon("src\\icons\\Boss1.png");     
                break;
            case 2:                                          //LEVEL 2
                
                gs.setLevel(2);
                gs.setLives(5);
                gs.setNumberEnemies(40);
                speedEnemyX = 5;
                background = new ImageIcon("src\\icons\\background2.jpg");  
                eImage = new ImageIcon("src\\icons\\Boss2.png"); 
                break;
            case 3:                                          //LEVEL 3
               
                gs.setLevel(3);
                gs.setLives(7);
                gs.setNumberEnemies(60);
                speedEnemyY = 2;
                speedEnemyX = 2;
                 background = new ImageIcon("src\\icons\\background3.jpg");
                 eImage = new ImageIcon("src\\icons\\Boss3.png"); 
                break;
            case 4:                                          //LEVEL 4 
                
                gs.setLevel(4);
                gs.setLives(10);
                gs.setNumberEnemies(80);
                speedEnemyY = 2;
                speedEnemyX = 4;
                background = new ImageIcon("src\\icons\\background4.jpg");
                eImage = new ImageIcon("src\\icons\\Boss4.png"); 
                break;
            case 5:                                          //LEVEL 5
                
                gs.setLevel(5);
                gs.setLives(20);
                gs.setNumberEnemies(100);
                speedEnemyY = 3;
                speedEnemyX = 4;
                background = new ImageIcon("src\\icons\\background5.jpg");
                eImage = new ImageIcon("src\\icons\\Boss5.png"); 
                break;
        }
    }
    
     /**
   * This function draws all the components on the screen.
   * @param Graphics g .  
   */
    @Override
    public void paintComponent(Graphics g) {
       
        //BACKGROUND DRAWING
       g.drawImage(background.getImage(), 0, 0, this);
       
       //PLAYER DRAWING
       pImage = p.getImg();
       g.drawImage(pImage.getImage(), pX, pY, this);
       
       //BULLET DRAWING
       if((shooting)&&(b.isVisible())){
           bImage = b.getImg();
           g.drawImage(bImage.getImage(), b.getPosition().x, b.getPosition().y, this);
       }
       
       
       //ENEMY DRAWING
       for(Enemy e: enemiesList){
            if(e.isVisibility()){
                eImage =  e.getImg();            
                if(e.isMoving()){
                   e.setPosition(e.getPosition().x , e.getPosition().y+speedEnemyY);    
                }  
                if(e.isVisibility()){
                    g.drawImage(eImage.getImage(), e.getPosition().x, e.getPosition().y , this);
                }   
            }   
        }   
    }
    
     /**
   * This listener gets triggered by any event. In this
   * case the main event that it controls is the ticking of the
   * @param ActionEvent e .  
   */
    @Override
    public void actionPerformed(ActionEvent e) {       
        
        repaint();
        if(count>250){
           checkEnemyHit(); 
        }
        checkDamage();
        
        //Move bullet one position up each tick of the timer
        if((shooting)&&(b.getPosition().y > -20)&&(b.isMoving())){
            b.setPosition(b.getPosition().x, b.getPosition().y-speedBullet);
        }else if(shooting){
            b.setVisible(false);            
    }
        //This piece of code sets visible each new enemy
        if ((count > 250) && (count % (randomGenerator.nextInt(100-1) + 1) == 0)){
            enemiesList.get(enemyCount).setVisibility(true);         
            if(enemyCount< enemiesList.size()-1){
                enemyCount++;
            }         
        }     
        
        count++;
        
        //This loop checks the enemy does not fall out of the screen. 
        for(Enemy enemy: enemiesList){
            if(enemy.isMoving()){
                if(enemy.isMovingRight()){
                     enemy.setPosition(enemy.getPosition().x + speedEnemyX, enemy.getPosition().y); //MOVE RIGHT
                }
                if(!enemy.isMovingRight()){
                     enemy.setPosition(enemy.getPosition().x - speedEnemyX, enemy.getPosition().y);    //MOVE LEFT
                }
                if (enemy.getPosition().x <= 0){    //LEFT LIMIT BOUND
                    enemy.setMovingRight(true);
                }
                if (enemy.getPosition().x >= 450){    //RIGHT LIMIT BOUND
                    enemy.setMovingRight(false);
                }
            }
        }   
        
        //GAME OVER SPLASH
        if(gs.getLives()==0){  
                    t.stop();                      
                    splash.setVisible(true);
        
        }
        
        //CHECK IF ALL ENEMIES ARE KILLED
        boolean winner = true;
        for(Enemy checkE:enemiesList){
            if(checkE.isMoving()){
                winner = false;
            }
        }
         //WINNER SPLASH
        if(t.isRunning()&&winner){
            lblSplash.setText("LEVEL COMPLETED!");
            splash.setVisible(true);
        }
    }  
    
   /**
   * This function checks if any enemy has been hit with the
   * bullet.
   */
    public void checkEnemyHit(){
        
        if(b != null){
            for (Enemy enemy:enemiesList){
                
                //Check on all enemies are not in the bullet area overlapping.
                if((b.getPosition().x+16>=enemy.getPosition().x)&&
                        (b.getPosition().x<=enemy.getPosition().x+32)&&
                        (b.getPosition().y+16>=enemy.getPosition().y)&&
                        (b.getPosition().y<=enemy.getPosition().y+32)&&
                        (b.isMoving())&&(enemy.isMoving())){
                    
                        //if its hit change values of that specific enemy
                        enemy.setImg(new ImageIcon("src\\icons\\bones.png"));
                        enemy.setMoving(false);
                        b.setMoving(false);  
                        
                        //add a point
                        gs.setPoints(gs.getPoints()+1);
                        lbl2.setText("SCORE: "+gs.getPoints()+"/"+NUMBER_OF_ENEMIES);               
                }
            }       
        }          
    }
    
     /**
   * This function checks if any enemy
   * reaches the baseline.
   */
    public void checkDamage(){                                                  //HIT
       
        for(Enemy enemy:enemiesList){
            //Enemy reaches the baseline change the image to a splash
            if(enemy.getPosition().y+32>=p.getPosition().y){             
                enemy.setImg(new ImageIcon("src\\icons\\splash.png"));
                enemy.setMoving(true);
                    
            }
            //After a few ticks set the enemy to invisible. And take a life of the board
            if(enemy.getPosition().y+10>=p.getPosition().y){                          
                enemy.setMoving(false);
                if(enemy.isVisibility()){
                    gs.setLives(gs.getLives()-1);
                    lbl3.setText("LIVES: "+gs.getLives());
                }              
                enemy.setVisibility(false);
            }
        }      
    }   
    
   /**
   * This lister runs the keyboard events.
   */
    @Override
    public void keyPressed(KeyEvent e) {
       int code = e.getKeyCode();
       
       //right  arrow presed on to move player right
       if(code == KeyEvent.VK_RIGHT){
            if(pX+65 < this.getWidth()){
                pX += speedPlayer;     
                p.setPosition(pX,pY);
            }
       }
       //LEFT arrow pressed on to move player left
       if(code == KeyEvent.VK_LEFT){
           if(pX > 0){
               pX -= speedPlayer;       
               p.setPosition(pX,pY);
           }
       }
       //Space bar to shoot a new bullet
       if(code == KeyEvent.VK_SPACE){
          b = new Bullet(true,pX,pY);
          b.setPosition(pX+25, pY);       
          shooting = true; 
          b.setVisible(true);
       }
    }
    
    //NOT USED 
    @Override
    public void keyReleased(KeyEvent e) {}
    
    //NOT USED
    @Override
    public void keyTyped(KeyEvent e) {}
}
