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
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import java.util.ArrayList;
import java.util.Iterator;



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
       
       //class declaration
       cursor cursor;
       overworld overworld;
       TiledMap overworldtm;
       TiledMap board;
       TiledMapRenderer boardtmr;
       TiledMapRenderer worldtmr;
       InputMultiplexer im ;
       
       
        public ArrayList<Vector2> paths = new ArrayList(); //temp
      
       //for moving player in overworld
      public float movetime;
       public float time;
       public Vector2 loca = new Vector2();
        
    public shamballa(Stage stage,Skin skin){
        
                 this.stage = stage;
                 this.skin = skin;
                 
                overworldtm = new TmxMapLoader().load("ov.tmx");
                board = new TmxMapLoader().load("board.tmx");
                boardtmr = new OrthogonalTiledMapRenderer(board); 
                worldtmr = new OrthogonalTiledMapRenderer(overworldtm);
                
                
                cam = new OrthographicCamera(); // set 0,0 to bottom left 
                cam.setToOrtho(false,worldheight* Gdx.graphics.getWidth()/
                               Gdx.graphics.getHeight(),720);  // turn it right side up
                cam.update();
              
                InputMultiplexer im = new InputMultiplexer(this,stage);
                Gdx.input.setInputProcessor(im); 
                
                
                overworld = new overworld(cam,overworldtm,stage,skin,im); 
                overworld.setStoryprogress(0);
                
               
                sb = new SpriteBatch();
                
         
        
    }
 
    public void Resize(int height,int width){
           
            sb.setProjectionMatrix(cam.combined);
            cam.update();
    }    
       @Override
     public void render(){
                Gdx.gl.glClearColor(0, 0,0,0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                setinputhandler();
               
                if (overworld.p.pstate == overworld.p.pstate.overworld ||
                    overworld.p.pstate == overworld.p.pstate.waiting){
                    worldtmr.setView(cam);
                    worldtmr.render();}
                if (overworld.p.pstate == overworld.p.pstate.intown){
                    boardtmr.setView(cam);
                    boardtmr.render();}
                
                Resize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
                time+= Gdx.graphics.getDeltaTime();
                sb.setProjectionMatrix(cam.combined);
               
                    sb.begin();
                     
                       if (overworld.p.pstate == overworld.p.pstate.overworld ||
                           overworld.p.pstate == overworld.p.pstate.waiting ){
                           overworld.DrawTowns(sb,time);
                           overworld.p.drawplayer(sb, time);
                            if(overworld.p.isMoving){
                               overworld.moveplayer(movetime,time,loca);
                            }
                       }
                       if(overworld.p.pstate == overworld.p.pstate.intown){
                         overworld.p.drawplayer(sb, time);
                          if(overworld.p.isMoving){
                               overworld.moveplayer(movetime,time,loca);
                            }
                       }
                      
                      
                          
                          
                          
                      
                      
                        sb.end();
                   

                      

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
                         for(int igg = 0 ; igg < paths.size(); igg++){
                          System.out.println(paths.get(igg) + "\n");
                         }
                        }
                     if(Gdx.input.isKeyJustPressed(Keys.M)){
                         this.create();

                
   }return true;}

    @Override
    public boolean keyUp(int i) {
 return true;  }

    @Override
    public boolean keyTyped(char c) {
       return false; }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
               stage.clear();
              
               Vector2 v2 = new Vector2();
              
               Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
               
               cam.unproject(touchPos);
               
               v2.x = touchPos.x;
               v2.y = touchPos.y;
               paths.add(v2);


              for(Rectangle r : overworld.townrec ){                                          
               if(r.contains(touchPos.x, touchPos.y)){
                loca.x = r.x;
                loca.y = r.y;
                 System.out.print("loca " + loca.x);
                  System.out.print("loca " + loca.y);
                overworld.rec.x = r.x;
                overworld.rec.y = r.y;
                
                overworld.owpathfinding.setup(loca,overworld.p,overworld.totalWay);
                  overworld.totalWay = overworld.owpathfinding.current.size();
                   overworld.p.isMoving = true;
                   movetime = time;
                  // moveplayer(); 
                       
               
               }                                                               
               }
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

    private void setinputhandler() {
       if(overworld.p.pstate == overworld.p.pstate.overworld){
           Gdx.input.setInputProcessor(this);
       }
           if(overworld.p.pstate == overworld.p.pstate.waiting){
             Gdx.input.setInputProcessor(stage);}
      
       if(overworld.p.pstate == overworld.p.pstate.intown){
             Gdx.input.setInputProcessor(stage);}
    
    }




}


