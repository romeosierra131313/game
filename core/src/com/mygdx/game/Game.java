package com.mygdx.game;

import com.mygdx.game.Constants.state;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;


public class Game extends ApplicationAdapter {
        SpriteBatch batch;
        Boolean loading = true;
        state state;
        

        Skin skin;
      
        
        
        Mainmenu menu ;        ///instansiating menu and items
        cursor cursor;
        
        Stage menustage;       ////giving everyone their own stage
        
     
        
        
        Texture loadingpic;
        
        
	@Override
	public void create () {
                
               
                
                menustage = new Stage();
               
                
                
                
                skin = new Skin(Gdx.files.internal("uiskin.json"));
		batch = new SpriteBatch();
                
                
                state = state.menu;   ///set initial state
                
                 cursor = new cursor();
                 menu = new Mainmenu(menustage,skin,state.menu);
                 Gdx.input.setInputProcessor(menustage);
                 
                 
                 
                 menu.gettexture();
                 loadingpic = menu.ass.get("background.jpg");
                 
                
	}
        
	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                
                
              
                batch.begin();
                menu.draw();
                batch.end();
	}


}
