/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import ObserversAndListeners.storyEvent;
import ObserversAndListeners.storyListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Player.player;
import com.mygdx.game.mission.mission;
import java.util.ArrayList;

/**
 *
 * @author Stefan
 */
public class Board implements storyListener {
   

	Stage stage;
        Skin skin;
	Table container;
        TiledMap board;
        player p;
        final Boolean closed = false;
        int storyprogress;
        mission mission;
        ArrayList<mission> misionlist ;
        
        
	public Board (Stage stage,Skin skin,TiledMap board,player p,int storyprogress) {
		this.stage = stage;
	        this.skin = skin;
                this.board = board;
                this.p = p;
                this.storyprogress = storyprogress;
                mission = new mission();
                misionlist = new ArrayList();
                getmissions(storyprogress);
                
                
                
		 Gdx.graphics.setVSync(false);
        
		TextButton button = new TextButton(" fhgkdhkfghdkjhgkjfdghbdgbdhgbdgfhdbgjgs", skin);
			   button.setSize((Gdx.graphics.getWidth()/2), Gdx.graphics.getHeight());
                           button.setPosition(Gdx.graphics.getWidth()/2,0);
                        

			
		

		final TextButton close = new TextButton("Close", skin.get("toggle", TextButtonStyle.class));
		close.setPosition((Gdx.graphics.getWidth()/2)+50, 10);
                close.setSize((Gdx.graphics.getWidth()/10), 50);
		close.addListener(new ClickListener() {
			public void clicked (InputEvent event,float x,float y) {
			    
                                  clearstage();  }});
                
                final TextButton accept = new TextButton("Accept", skin.get("toggle", TextButtonStyle.class));
		accept.setPosition((Gdx.graphics.getWidth())-((Gdx.graphics.getWidth()/10))-50, 10);
                accept.setSize((Gdx.graphics.getWidth()/10), 50);
		accept.addListener(new ClickListener() {
			public void clicked (InputEvent event,float x,float y) {
			    /////	player.exit();
                                  clearstage();  }});
                
                stage.addActor(button);
                stage.addActor(close);
                stage.addActor(accept);
        }



    void clearstage() {
                      stage.clear();
                      p.pstate = p.pstate.overworld;}

    private void getmissions(int storyprogress) {
      if(storyprogress == 0){
          //instansiate mission rank 0 missions
         }    
    }

    @Override
    public void progress(storyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void random(storyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
    

