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
       float camx = 0;
       float camy =0;
       
       
       //enums
       gameplace place;
       

       
       //class declaration
       cursor cursor;
       overworld overworld;
       worldmenu worldmenu;
       player p;
       overworldpathfinding owpathfinding;
       Paths Paths;
       
       Rectangle r;   ///town hitboxs
       
       
       //for moving player in overworld
       public int currentWay = 0;
       public float movetime;
       public float time;
        
    public shamballa(Stage stage,Skin skin){
        
                 this.stage = stage;
                 this.skin = skin;
                 
                

                cam = new OrthographicCamera(); // set 0,0 to bottom left 
                cam.setToOrtho(false,worldheight* Gdx.graphics.getWidth()/
                               Gdx.graphics.getHeight(),720);  // turn it right side up
                
                cam.update();
               
              
                place = place.overworld;
                overworld = new overworld(); 
                worldmenu = new worldmenu(stage,skin);
                 createplayer();
                sb = new SpriteBatch();
                
                
         InputMultiplexer im = new InputMultiplexer(this,stage);
         Gdx.input.setInputProcessor(im);
    }
 
    public void Resize(int height,int width){
          //  cam.setToOrtho(false,worldheight* Gdx.graphics.getWidth()/Gdx.graphics.getHeight(),720);   
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
                cam.update();
                    sb.begin();
                        
                        overworld.DrawTowns(sb);
                        p.drawplayer(sb, time);
                       
                       
                       
                    sb.end();
                   moveplayer();  

                      

                 //p.btree.step();
                // 
                 
                        
                stage.draw();
                camx = 0;
                camy = 0;
     
     }



    @Override
    public boolean keyDown(int i) {
      
                     if(Gdx.input.isKeyJustPressed(Keys.A)){
                         camx += 15;
                         cam.translate(camx ,camy, 0);
                         
                         
                         }
                     if(Gdx.input.isKeyJustPressed(Keys.S)){
                          camy += 15;
                         cam.translate(camx, camy, 0);   
                         
                     }
                     if(Gdx.input.isKeyJustPressed(Keys.W)){
                           camy -= 15;
                         cam.translate(camx, camy, 0);
                        
                     }
                     if(Gdx.input.isKeyJustPressed(Keys.D)){
                          camx -= 15;
                         cam.translate(camx, camy, 0);
                          
                     }
                     if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)){
                         Gdx.app.exit();}
                     if(Gdx.input.isKeyJustPressed(Keys.ENTER)){
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
               
               //Vector2 v2 = new Vector2();
              
               Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
               Vector2 loca = new Vector2();
               cam.unproject(touchPos);
               
               //v2.x = touchPos.x;
               //v2.y = touchPos.y;
               //paths.add(v2);

               
                for(Rectangle r : overworld.townrec ){                         
                 if(r.contains(touchPos.x, touchPos.y)){
                  loca.x = r.x;
                  loca.y = r.y;
                  

                         /// set up owpathfinding
                         owpathfinding.setdeparture(p.x,p.y );
                         owpathfinding.setdestination( touchPos.x,touchPos.y );
                         owpathfinding.calculatePaths();
                         p.pstate =  p.pstate.moving;
                         movetime = time;
                         moveplayer();
                         
                 
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
private void createplayer() {
      Reader reader = null;
      try {
         reader = Gdx.files.internal("player.tree").reader();
         BehaviorTreeParser<player> parser = new BehaviorTreeParser<player>(BehaviorTreeParser.DEBUG_HIGH);
         BehaviorTree<player> btree = parser.parse(reader,p = new player());
         
         p.btree = btree;
         p.playerlocation = p.playerlocation.Maki;
          p.pstate =  p.pstate.waiting;
          p.pdirY =  p.pdirY.non;
          p.pdirX =  p.pdirX.non;
          owpathfinding = new overworldpathfinding(p,overworld);
         
      } finally{
      
         StreamUtils.closeQuietly(reader);
      }
    }
private void moveplayer() {
                            
                 if( p.pstate ==  p.pstate.moving && (time-movetime)> 0.01f){
                             
                    
                    int totalWay = owpathfinding.current.size();
                       if(currentWay <= totalWay+1){
                        if(p.x < owpathfinding.current.get(currentWay).x &&  p.pdirX ==  p.pdirX.east){
                         p.moveright();
                         p.turnright();
                        }
                        if(p.x > owpathfinding.current.get(currentWay).x &&  p.pdirX ==  p.pdirX.west){
                         p.moveleft();
                         p.turnleft();
                        }
                        if(p.y < owpathfinding.current.get(currentWay).y &&  p.pdirY ==  p.pdirY.north){
                         p.moveup();
                         p.turnup();
                        }
                        if(p.y > owpathfinding.current.get(currentWay).y &&  p.pdirY ==  p.pdirY.south){
                         p.movedown();
                         p.turndown();
                        }
                        
                        if(p.x == owpathfinding.current.get(currentWay).x && p.y == owpathfinding.current.get(currentWay).y)
                        currentWay++;
                       } 
                        if(p.x == owpathfinding.destination.x && p.y == owpathfinding.destination.y){
                         p.pstate =  p.pstate.waiting ;
                         p.pdirX =  p.pdirX.non;
                         p.pdirY =  p.pdirY.non;
                        
                        p.playerlocation =  overworld.townlocations.get(owpathfinding.destination);
                      
                   } movetime = time; 
    }
    }
}


