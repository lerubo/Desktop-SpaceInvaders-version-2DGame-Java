
package defensegame;

import views.MenuScreen;

/**
* The DefenseGame program implements an application that
* simply displays a Menu Screen to the standard output.
*
* @author  Leandro Ruiz Boyle
* @version 1.0
* @since   2018-05-10 
*/
public class DefenseGame {
    public static void main(String[] args) {  
        
        //We create an object of the Menu JFrame
        MenuScreen ms = new MenuScreen();
        ms.setLocationRelativeTo(null);
        ms.setVisible(true);    
    }
}
