/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 *
 * @author Stefan
 */
public final class help extends GameObject {
    
    String text;
    Skin skin;
     
     public help(Skin skin){
         

        
        
        this.skin = skin; 
       
        text = "HELP?" ;

       
     }

    @Override
    public void gettexture() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw() {

       
       }

    @Override
    public void move(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}