/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.towns;

/**
 *
 * @author Stefan
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 *
 * @author Stefan
 */
public class Jinku extends town {
    
    
    
    public Jinku(){
    
    name = "jinku";
    x = 700;
    y = 400;
    townxy.add(x, y);
      System.out.print(townxy.x + " +" + townxy.y);
    townt = new Texture(Gdx.files.internal("town.jpg"));
    towns = new Sprite(townt);
    r.set(x,y, 120, 50);

   
    }
    public void setuptown(){
        towns.setSize(32  , 32);
        towns.setPosition(x,y);
    }
}

