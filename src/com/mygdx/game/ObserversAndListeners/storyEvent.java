
package ObserversAndListeners;

import com.mygdx.game.Player.player;

public class storyEvent {
    private player p;


    public storyEvent(com.mygdx.game.Player.player p) {
       this.p = p;}
       
    public player getSource(){
       return p;
    
    }
    
    }
    

