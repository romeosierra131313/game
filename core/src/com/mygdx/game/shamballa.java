/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ai.btree.BehaviorTree;
import com.badlogic.gdx.ai.btree.utils.BehaviorTreeParser;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.StreamUtils;
import com.mygdx.game.Constants.gameplace;
import com.mygdx.game.Constants.playerlocation;
import com.mygdx.game.Constants.playermovingdir;
import com.mygdx.game.Constants.playerstate;
import com.mygdx.game.towns.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import com.mygdx.game.Player.player;
import com.mygdx.game.towns.town;
import java.io.Reader;



/**
 *
 * @author Stefan
 */
public class shamballa extends ApplicationAdapter implements InputProcessor{
     

       
       //graphics
       Stage stage;
       Skin skin;
       Texture test;
       SpriteBatch sb;
       Texture t ;
       Sprite s;
       final float worldheight = 720;
       OrthographicCamera cam;
       
       
       //enums
       gameplace place;
       playerlocation playerlocation;
       playerstate pstate;
       playermovingdir pdirY;
       playermovingdir pdirX;
       
       //class declaration
       cursor cursor;
       overworld overworld;
       player p;
       Paths Paths;
       
       Rectangle r;   ///town hitboxs
       worldmenu worldmenu;
       
       
       public float time;
       public int timeSinceCollision = 0 ;
      
       
       public  ArrayList<Vector2> paths;
       public town departure;
       public town destination;
       public int currentWay = 0;
       
       public float movetime;
        
        
    public shamballa(Stage stage,Skin skin){
        
                 this.stage = stage;
                 this.skin = skin;
                 
                 createplayer();
                 Paths = new Paths();
                 paths = new ArrayList();      
                 
                 
                cam = new OrthographicCamera(); // set 0,0 to bottom left 
                cam.setToOrtho(false,worldheight* Gdx.graphics.getWidth()/
                               Gdx.graphics.getHeight(),720);  // turn it right side up
                
                cam.update();
               
              
                place = place.overworld;
                overworld = new overworld(); 
                worldmenu = new worldmenu(stage,skin);
                sb = new SpriteBatch();
        
       
         InputMultiplexer im = new InputMultiplexer(this,stage);
         Gdx.input.setInputProcessor(im);
    }
 
    public void Resize(int height,int width){
            cam.setToOrtho(false,worldheight* Gdx.graphics.getWidth()/Gdx.graphics.getHeight(),720);   
            sb.setProjectionMatrix(cam.combined);
            cam.update();
    }    
       @Override
     public void render(){
                Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
               
                Resize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
                time+= Gdx.graphics.getDeltaTime();
                
                sb.setProjectionMatrix(cam.combined);
                    sb.begin();
                        
                        overworld.DrawTowns(sb);
                        p.drawplayer(sb, time);
                       
                       
                       
                    sb.end();
                   moveplayer();  

                      

                 //p.btree.step();
                // 
                 
                        
                stage.draw();
   
     
     }



    @Override
    public boolean keyDown(int i) {
      
                     if(Gdx.input.isKeyJustPressed(Keys.A)){
                         p.resetdirs();
                         p.left = true;
                         }
                     if(Gdx.input.isKeyJustPressed(Keys.S)){
                         p.resetdirs();
                         p.down = true; }
                     if(Gdx.input.isKeyJustPressed(Keys.W)){
                         p.resetdirs();
                         p.up = true;}
                     if(Gdx.input.isKeyJustPressed(Keys.D)){
                         p.resetdirs();
                         p.right = true;}
                     if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)){
                         Gdx.app.exit();}
                     if(Gdx.input.isKeyJustPressed(Keys.ENTER)){
                         System.out.print(paths); //temp to get paths
                        
                         }
                     if(Gdx.input.isKeyJustPressed(Keys.M)){
                          p.resetdirs();
                         p.right = true;

                         
                        
                         
                         
                          
                         
                         
                          
            //                for (int q =0; q< Paths.pathmakitojinku.size(); q ++){
            //                  
            //                setq(q);
            //                 
            //                   for(float playerx = p.x; playerx <= Paths.pathmakitojinku.get(getq()).x; playerx++){
            //               
            //                      p.x = playerx;
                                System.out.print("   Up\n ");
            //                   }
            //  
            //                   for(float playery = p.y; playery <= Paths.pathmakitojinku.get(getq()).y ; playery++){
            //                
            //                       p.y = playery;
            //                       System.out.print("   Right\n " );
            //                                 
            //           
            //               }
                          
                          
            //   }
   }return true;}

    @Override
    public boolean keyUp(int i) {
 return true;  }

    @Override
    public boolean keyTyped(char c) {
       return false; }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
               Vector2 v2 = new Vector2();
              
               Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
               Vector2 loca = new Vector2();
               cam.unproject(touchPos);
               v2.x = touchPos.x;
               v2.y = touchPos.y;
               paths.add(v2);
               
            //   System.out.print("x" + touchPos.x );
           //    System.out.print("y"+touchPos.y );
          //     System.out.print("z"+touchPos.z );
               
                for(Rectangle r : overworld.townrec ){
                 if(r.contains(touchPos.x, touchPos.y)){
                  loca.x = r.x;
                  loca.y = r.y;
                  
                destination =  overworld.townlocations.get(loca);
                        
                                
                p.setcurrentPath("pathmakitojinku");
                p.turnright();
                         pstate = pstate.moving;
                         pdirY = pdirY.north;
                         pdirX = pdirY.east;
                         movetime = time;
              
                 
                 }
                 }
                      
                         
                 //       worldmenu.buildmenu(r.x,r.y,overworld.playerlocation);
                   //     worldmenu.stage.addAction(Actions.alpha(1f));
                     //   System.out.println("menu added");
                        
                         
                        
               // }else if(!r.contains(touchPos.x, touchPos.y)) {}
                 //  }
           
        return false;  }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
       return false;  }
    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;  }
    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;  }
    @Override
public boolean scrolled(int i) {
        return false; }
private void openmenu(Iterator<Rectangle> iterator) {
          }
public void setq(int q){
timeSinceCollision = q;

}
public int getq(){
return timeSinceCollision;
}
private void createplayer() {
      Reader reader = null;
      try {
         reader = Gdx.files.internal("player.tree").reader();
         BehaviorTreeParser<player> parser = new BehaviorTreeParser<player>(BehaviorTreeParser.DEBUG_HIGH);
         BehaviorTree<player> btree = parser.parse(reader,p = new player());
         
         p.btree = btree;
         playerlocation = playerlocation.Maki;
         pstate = pstate.waiting;
         pdirY = pdirY.non;
         pdirX = pdirX.non;
         
      } finally{
      
         StreamUtils.closeQuietly(reader);
      }
    }

    private Vector2 GetCurrentLocation() {
        
        Vector2 departurexy = new Vector2();
         switch(playerlocation){
             case Maki: departurexy.x = overworld.maki.townxy.x;
                        departurexy.y = overworld.maki.townxy.y;
                 break;
             case jinku:departurexy.x = overworld.jinku.townxy.x;
                        departurexy.y = overworld.jinku.townxy.y;
                 break;
             case testtown1:departurexy.x = overworld.testtown1.townxy.x;
                            departurexy.y = overworld.testtown1.townxy.y;
                 break;
             case ttown2:departurexy.x = overworld.ttown2.townxy.x;
                         departurexy.y = overworld.ttown2.townxy.y;
                 break;
             case ttown3:departurexy.x = overworld.ttown3.townxy.x;
                         departurexy.y = overworld.ttown3.townxy.y;
                 break;
             case ttown4:departurexy.x = overworld.ttown4.townxy.x;
                         departurexy.y = overworld.ttown4.townxy.y;
                 break;
             
         
         
         }
        return departurexy;
        
    }

    private town GetDestination() {
      return destination; }

    private ArrayList calculatePaths() {
           // do A* add all waypoints to one arraylist
           
        return p.currentPath;
         }

    private void moveplayer() {
                            
                 if(pstate == pstate.moving && (time-movetime)> 0.1f){
                    GetCurrentLocation();
                    GetDestination();
                   ArrayList<Vector2> current = new ArrayList();
                    current =  calculatePaths();
                    //set playerdirectios();
                    
                    int totalWay = p.currentPath.size();
                       if(currentWay < totalWay){
                        if(p.x < current.get(currentWay).x && pdirX == pdirX.east){
                         p.moveright();
                        }
                        if(p.y < current.get(currentWay).y && pdirY == pdirY.north){
                         p.moveup();
                        }
                        
                        if(p.x == current.get(currentWay).x && p.y == current.get(currentWay).y)
                        currentWay++;
                       } else{
                        pstate = pstate.waiting ;
                        pdirX = pdirX.non;
                        pdirY = pdirY.non;
                        
                           switch(destination.townID){
                               case 1:playerlocation = playerlocation.Maki;
                                   break;
                               case 2:playerlocation = playerlocation.jinku;
                                   break;
                               case 3:playerlocation = playerlocation.testtown1;
                                   break;
                               case 4:playerlocation = playerlocation.ttown2;
                                   break;
                               case 5:playerlocation = playerlocation.ttown3;
                                   break;
                               case 6:playerlocation = playerlocation.ttown4;
                                   break;
                           
                           }
                       }
                   movetime = time;  }
    }


}
