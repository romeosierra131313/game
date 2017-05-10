/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author Stefan
 */
public class character {
      Texture t;
      final int cols = 13;
      final int rows = 21;
      Animation walkright;
      Animation walkleft;
      Animation walkdown;
      Animation walkup;
      
      public float x;
      public float y;
      
    public Texture gettexture(String g) {
     t = new Texture(g); 
     return t;
     
     
    }
    public void definetextureregions(Texture t){
    
              
        TextureRegion[][] tmp = TextureRegion.split(t,64,64);
        TextureRegion[]anim = new TextureRegion[273];
        int index = 0 ;
        for (int i = 0; i<cols; i++){
          for (int j = 0; j <rows; j++){
            anim[index++] = tmp[j][i];
          }
        }
        walkright(anim);
        walkdown(anim);
        walkleft(anim);
        walkup(anim);
        
    }
    public void walkright(TextureRegion[]anim){
               walkright = new Animation(0.25f,anim[11],anim[32],anim[53],anim[74],anim[95],
                                                 anim[116],anim[137],anim[158],anim[179]);
                                              }
   
    public void walkdown(TextureRegion[]anim){
                   walkdown = new Animation(0.25f,anim[10],anim[31],anim[52],anim[73],anim[94],
                                                 anim[115],anim[136],anim[157],anim[178]);
                                             }
        public void walkleft(TextureRegion[]anim){
                   walkleft = new Animation(0.25f,anim[9],anim[30],anim[51],anim[72],anim[93],
                                                 anim[114],anim[135],anim[156],anim[177]);
                                             }
                public void walkup(TextureRegion[]anim){
                   walkup = new Animation(0.25f,anim[8],anim[29],anim[50],anim[71],anim[92],
                                                 anim[113],anim[134],anim[155],anim[176]);
                                             }
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public void move(float x, float y) {
        this.x = x;
        this.y = y;
        }
}
