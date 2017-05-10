/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.character;

/**
 *
 * @author Stefan
 */
public class player extends character  {
      
          Boolean up = true;
          Boolean down = false;
          Boolean left= false;
          Boolean right= false;
          
          
       public player(){
           
                  x = 400;
                  y = 260;
                  t = new Texture(Gdx.files.internal("player.png"));
                  definetextureregions(t);
                  }
            public void  drawplayer(SpriteBatch sb,float time){
               
                 if(up ){sb.draw(walkup.getKeyFrame(time,true)    , getX() , getY()); }
                 if(down ){sb.draw(walkdown.getKeyFrame(time,true), getX() , getY()); }
                 if(left ){sb.draw(walkleft.getKeyFrame(time,true), getX() , getY()); }
                 if(right){sb.draw(walkright.getKeyFrame(time,true),getX() , getY()); }
                 
            }
            public void resetdirs(){
                  up = false;
                  down = false;
                  left= false;
                  right= false;
            
            }
            public void setX(int x){
            this.x = x;
            
            }
                        public void setY(int y){
            this.y = y;
            
            }
            public int getX(){
           int lo = Math.round(x);
            return lo;
            
            }
             public int getY(){
           int lo = Math.round(y);
            return lo;
            
            }
}
