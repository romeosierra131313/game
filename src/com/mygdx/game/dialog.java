
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 *
 * @author Stefan
 */
public class dialog {
    String g;
    Skin skin ;
    Stage stage;
    
    TextButton box;
    public dialog(Skin skin, Stage stage,String g){
      this.g = g;
      this.skin = skin;
      this.stage = stage;
      box = new TextButton(g,skin);
      box.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/10);
      box.addListener(new ClickListener() {
			public void clicked (InputEvent event,float x,float y) {
			//advnce dialog    
                        }});
    stage.addActor(box);}
    
}
