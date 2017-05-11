/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ai.btree.BehaviorTree;

/**
 *
 * @author Stefan
 */
public class player extends character  {
      
        public  Boolean up = true;
        public  Boolean down = false;
        public  Boolean left= false;
        public  Boolean right= false;
        public  BehaviorTree<player> btree;
          
          
       public player(){
           
                  x = 400;
                  y = 260;
                 
                  t = new Texture(Gdx.files.internal("player.png"));
                  definetextureregions(t);
                  
                  }
       public player(BehaviorTree<player> btree){
             this.btree = btree;
              if(btree != null)btree.setObject(this);
             
       }
            public void  drawplayer(SpriteBatch sb,float time){
                
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
            this.x = x; }
            public void setY(int y){
            this.y = y;}
            public int getX(){
           int lo = Math.round(x);
            return lo; }
            public int getY(){
           int lo = Math.round(y);
            return lo; }
            public void moveright(){
            resetdirs();
            right = true;
            int px = getX();
            px +=1;
            setX(px);
            }
            public void moveleft(){
            resetdirs();
            left = true;
            int px = getX();
            px -=1;
            setX(px);
            }
            public void moveup(){
            resetdirs();
            up = true;
            int py = getY();
            py +=1;
            setY(py);
            }            
            public void movedown(){
            resetdirs();
            down = true;
            int py = getY();
            py -=1;
            setY(py);
            }               
}
