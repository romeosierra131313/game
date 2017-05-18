/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.towns;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 *
 * @author Stefan
 */
public class Maki extends town {
    
    
    public Maki(){
    
    name = "Maki";
    townID=1;
    x = 400;
    y = 260;
    townxy.add(x, y);
    townt = new Texture(Gdx.files.internal("town.jpg"));
    towns = new Sprite(townt);
    r.set(x,y, 64, 64);
    numberOfExits = 2;
    exit1 = "pathmakitojinku";

   
    }
    public void setuptown(){
        towns.setSize(32  , 32);
        towns.setPosition(x,y);
    }
}
