/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Stefan
 */
public abstract class GameObject {
    SpriteBatch batch = new SpriteBatch();
    AssetManager ass = new AssetManager();
    
    public abstract void gettexture();
    public abstract void draw();
    public abstract void move(int x,int y);
    
    
    
}
