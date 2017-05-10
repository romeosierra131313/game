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
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.game.Constants.place;
import com.mygdx.game.Constants.playerlocation;
import com.mygdx.game.towns.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Stefan
 */
public class shamballa extends ApplicationAdapter implements InputProcessor{
     

       
    
       Stage stage;
       Skin skin;
       Texture test;
       SpriteBatch sb;
       place place;
       cursor cursor;
       overworld overworld;
       player p;
       Paths Paths;
       playerlocation playerlocation;
       Texture t ;
       Sprite s;
       final float worldheight = 720;
       OrthographicCamera cam;
       Rectangle r;
       worldmenu worldmenu;
       public float time;
       public int timeSinceCollision = 0 ;
       public  ArrayList<Vector2> paths;
        
        
    public shamballa(Stage stage,Skin skin){
        
                 this.stage = stage;
                 this.skin = skin;
                 playerlocation = playerlocation.Maki;
                 p =new player();
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
                        
                        overworld.drawworld(sb);
                        p.drawplayer(sb, time);
                     
                       
                    sb.end();
  System.out.println("rendered");
                        
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
                          
                         for (int q =0; q< Paths.pathmakitojinku.size(); q ++){
                             
                              setq(q);
                               
                                   try {   
                                      Thread.sleep(250);
                                      System.out.println("slept");
// do nothing for 1000 miliseconds (1 seco.nd)
                                  } catch (InterruptedException ex) {
                                      Logger.getLogger(shamballa.class.getName()).log(Level.SEVERE, null, ex);
                                  }
                             
                              for(float playerx = p.x; playerx <= Paths.pathmakitojinku.get(timeSinceCollision).x ; playerx++){
                                  p.x = playerx;
                                   System.out.print("px  "+p.x);
                                   }
   
                                  for(float playery = p.y; playery <= Paths.pathmakitojinku.get(timeSinceCollision).y ; playery++){
                                  
                                      p.y = playery;
                                      System.out.print("py  "+p.y);
                                     sb.begin();
                                      p.drawplayer(sb, time);
                                                sb.end();                         try {   
                                      Thread.sleep(250);
                                      System.out.println("slept at render");
// do nothing for 1000 miliseconds (1 seco.nd)
                                  } catch (InterruptedException ex) {
                                      Logger.getLogger(shamballa.class.getName()).log(Level.SEVERE, null, ex);
                                  }
                                  }
                         
                         
                         }
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
               
             //     for(Rectangle r : overworld.townrec ){
               //      if(r.contains(touchPos.x, touchPos.y)){
                 //        loca.x = r.x;
                   //      loca.y = r.y;
                     //    String town =  overworld.townlocations.get(loca);
                       //    System.out.print(town);
                         
                      
                         
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
        System.out.println(iterator);  }

public void setq(int q){
timeSinceCollision = q;

}
public int getq(){
return timeSinceCollision;
}



}
