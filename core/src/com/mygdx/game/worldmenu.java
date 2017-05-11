/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Constants.playerlocation;
import com.mygdx.game.towns.Maki;

/**
 *
 * @author Stefan
 */
public class worldmenu {
    
    Stage stage;
    Skin skin;
   // float x;
   // float y;
 
    Boolean showing = false;
    TextButton menuback;
    TextButton Board;
    TextButton market;
    
    public worldmenu(Stage stage,Skin skin){
           
            this.skin = skin;
            this.stage =stage;
            
       
       menuback = new TextButton("", skin, "default");
       menuback.setWidth(120f);
       menuback.setHeight(50f);
       Board = new TextButton("Board",skin,"default");
       Board.setWidth(100);
       Board.setHeight(15);

       market = new TextButton("Market",skin,"default");
       market.setWidth(100);
       market.setHeight(15);
       market.addListener(new ClickListener(){
          @Override
              public void clicked(InputEvent event,float x,float y){
                 // click.play();
                 //place = place.market;
                  System.out.println("market");
                  
                  
                 } });
         }

    public void buildmenu(float x,float y,playerlocation playerlocation) {
        
        switch(playerlocation){
            case Maki:

       menuback.setPosition(x,y);
       Board.setPosition(x+10, y+10);
              Board.addListener(new ClickListener(){
          @Override
              public void clicked(InputEvent event,float x,float y){
                 // click.play();
                 //place = place.market;
                  System.out.println("board");
                  
                  
                 } });
       market.setPosition(x+10, y+30);
       stage.addActor(menuback);
       stage.addActor(Board);
       stage.addActor(market);
       
          //case next town;
          //case next town;
       
    }}

}
