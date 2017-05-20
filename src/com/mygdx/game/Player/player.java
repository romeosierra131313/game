/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.Player;

import ObserversAndListeners.storyEvent;
import ObserversAndListeners.storyListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ai.btree.BehaviorTree;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Constants.playerlocation;
import com.mygdx.game.Constants.playermovingdir;
import com.mygdx.game.Constants.gamestate;
import com.mygdx.game.calendarEvent;
import com.mygdx.game.calendarListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Stefan
 */
public class player extends character  {
        private String name = "Foo";
        public Sprite pl;
        public  Boolean up = true;
        public  Boolean down = false;
        public  Boolean left= false;
        public  Boolean right= false;
        public  BehaviorTree<player> btree;
        public playerlocation playerlocation; 
        public gamestate pstate;
        public playermovingdir pdirY;
        public playermovingdir pdirX;
        public int funds;
        String fundsstring;
        BitmapFont bf;
        
          
       public player(){
           

                  
                  
                  t = new Texture(Gdx.files.internal("player.png"));
                  definetextureregions(t);
                  pl = new Sprite();
                  bf = new BitmapFont();
                  
                  }
       public player(BehaviorTree<player> btree){
             this.btree = btree;
              if(btree != null)btree.setObject(this);
             
       }
            public void  drawplayer(SpriteBatch sb,float time){
                 
                 fundsstring = Integer.toString(funds)+"g";
                 bf.draw(sb,fundsstring , Gdx.graphics.getBackBufferWidth()/20,Gdx.graphics.getHeight()-10);
                 if(up ){sb.draw(walkup.getKeyFrame(time,true)    , getX() , getY()); }
                 if(down ){sb.draw(walkdown.getKeyFrame(time,true), getX() , getY()); }
                 if(left ){sb.draw(walkleft.getKeyFrame(time,true), getX() , getY()); }
                 if(right){sb.draw(walkright.getKeyFrame(time,true),getX() , getY()); }
                 
            }
            public BehaviorTree<player> getbtree(){
                return btree;}   
            public void setbtree(BehaviorTree<player> btree){
            this.btree = btree;
            }
            public void resetdirs(){
                  up = false;
                  down = false;
                  left= false;
                  right= false; }
            public void setX(int x){
            this.x = x ; }
            public void setY(int y){
            this.y = y ;}
            public int getX(){
          
            return x; }
            public int getY(){
          
            return y; }
            public void moveright(){
             x +=1;
            }
            public void moveleft(){
            x -=1;
            }
            public void moveup(){
            
            y += 1;
            }            
            public void movedown(){
            y -=1;
           
            } 
            public void turnup(){
            resetdirs();
            up = true;
            }
            public void turndown(){ // TURN DOWN FO WHAT!!!
            resetdirs();
            down = true;
            }
            public void turnright(){
            resetdirs();
            right = true;}
            public void turnleft(){
            resetdirs();
            left = true;
            }
            public void resetPlayerstates(){
                         
                        // pstate =  pstate.waiting ;
                         pdirX = pdirX.non;
                         pdirY =  pdirY.non;
                         
                         
            } 
            public String GetName(){
              return name;
            }

           
           public playerlocation getplayerlocation(){
             return playerlocation;
           } 

    public void setplayerlocation(playerlocation playerlocation,Set<calendarListener> listeners) {
        this.playerlocation = playerlocation;
         
        calendarEvent e = new calendarEvent(this);
        
                for(calendarListener cl : listeners){
                  cl.daypassed(e);
                  
        }

    
}}
