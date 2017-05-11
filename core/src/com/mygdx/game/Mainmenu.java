/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Constants.state;

/**
 *
 * @author Stefan
 */
public final class Mainmenu extends GameObject{
    
    Texture background ;
    Stage stage;
    Skin skin;
    private state state ;
    Sound click;
    
    BitmapFont font;
    shamballa shamballa;
    Info infoscreen;
    help helpscreen;
   
        
    
    public Mainmenu(Stage stage , Skin skin, state state ){
        this.stage = stage;
        this.skin = skin;
        this.state = state;
        
        
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        
        infoscreen = new Info(skin);
        helpscreen = new help(skin);
       
        
        ass.load("click.wav", Sound.class);
        ass.load("background.jpg", Texture.class);
        ass.update();
        ass.finishLoading();
        background = ass.get("background.jpg");
        click = ass.get("click.wav");
        Gdx.input.setInputProcessor(stage);
        
    
       addmenubuttons();
         
    }
        

    @Override
    public void draw() {
       
     switch(state){
         case menu:
       batch.begin();
       batch.draw(background, 0, 0);
       batch.end();
       stage.draw();
       break;
         case info:
       batch.begin();
       batch.draw(background, 0, 0);
       font.draw(batch, infoscreen.text, Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/10));
       batch.end();
       stage.draw();
        break;
         case help:
             //// dont forget to enter code to render help
        break;
         case game:
             shamballa.render();
     }
    }

    @Override
    public void move(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void gettexture() {

         }
 
    void addmenubuttons() {
        
            
        
        final TextButton newgame = new TextButton("New Game", skin, "default");
       newgame.setWidth(200f);
       newgame.setHeight(20f);
       newgame.setPosition(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/10));
       newgame.pad(50f);
       newgame.addListener(new ClickListener(){
          @Override
              public void clicked(InputEvent event,float x,float y){
                  click.play();
                  state = state.game;
                  stage.clear();
                   shamballa = new shamballa(stage,skin);
                  
                  
                 } });
       

        final TextButton LoadGame = new TextButton("Load Game", skin, "default");
       LoadGame.setWidth(200f);
       LoadGame.setHeight(20f);
       LoadGame.setPosition(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()-((Gdx.graphics.getHeight()/10))*2);
       LoadGame.pad(50f);
       LoadGame.addListener(new ClickListener(){
          @Override
              public void clicked(InputEvent event,float x,float y){
              
               
                 } });
       
       
        final TextButton help = new TextButton("Help", skin, "default");
       help.setWidth(200f);
       help.setHeight(20f);
       help.setPosition(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()-((Gdx.graphics.getHeight()/10))*3);
       help.pad(50f);
       help.addListener(new ClickListener(){
          @Override
              public void clicked(InputEvent event,float x,float y){
                  click.play();
                  state = state.help;
                  stage.clear();
                  addbackbutton();
               
                 } });
       
       
        final TextButton info = new TextButton("Info", skin, "default");
       info.setWidth(200f);
       info.setHeight(20f);
       info.setPosition(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()-((Gdx.graphics.getHeight()/10))*4);
       info.pad(50f); 
       info.addListener(new ClickListener(){
          @Override
              public void clicked(InputEvent event,float x,float y){
                  click.play();
                  state = state.info;
                  stage.clear();
                  addbackbutton();
                     
                 } });
       
        
        stage.addActor(newgame);
        stage.addActor(LoadGame);
        stage.addActor(help);
        stage.addActor(info); }
    void addbackbutton(){
    
            final TextButton iback = new TextButton("Back", skin, "default");
       iback.setWidth(200f);
       iback.setHeight(20f);
       iback.setPosition(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()-((Gdx.graphics.getHeight()/10))*9);
       iback.pad(50f); 
       iback.addListener(new ClickListener(){
          @Override
              public void clicked(InputEvent event,float x,float y){
                  click.play();
                  state = state.menu;
                  stage.clear();
                  addmenubuttons();
                  
                     
                 } });
    stage.addActor(iback);
    }

}
