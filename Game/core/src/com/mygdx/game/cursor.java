/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

/**
 *
 * @author Stefan
 */
public class cursor extends GameObject {
    Texture cursor ;
       public cursor(){
       cursor = new Texture(Gdx.files.internal("cursor.png"));
       Pixmap pm = new Pixmap(Gdx.files.internal("cursor.png"));
       Gdx.input.setCursorImage(pm, 0, 0);
       pm.dispose();
       }
    @Override
    public void gettexture() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
