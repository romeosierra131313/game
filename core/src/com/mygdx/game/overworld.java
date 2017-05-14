/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Constants.playerlocation;
import com.mygdx.game.towns.Jinku;
import com.mygdx.game.towns.Maki;
import com.mygdx.game.towns.testtown1;
import com.mygdx.game.towns.town;
import com.mygdx.game.towns.ttown2;
import com.mygdx.game.towns.ttown3;
import com.mygdx.game.towns.ttown4;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Stefan
 */
public class overworld {
       Texture world;
       float worldx = 0;
       float worldy = 0;
       ArrayList<Rectangle> townrec = new ArrayList();
       public  ArrayList<Vector2> townnodes = new ArrayList();
       public playerlocation playerlocation;
       Vector2 v = new Vector2();
       public HashMap<Vector2,playerlocation> townlocations = new HashMap();   
       
      
       Maki maki;
       Jinku jinku;
       testtown1 testtown1;
       ttown2 ttown2;
       ttown3 ttown3;
       ttown4 ttown4;
       
       
       
       
      
      
       
       public overworld(){
      
        //instanstiate new town
        //set it up
        // add it to hashmap townlocations
        //add its hitbox to arraylist townrec
        // dont forget to add new towns marketlist in overworldmenu!
        // add town node
        
      
       maki = new Maki();
       maki.setuptown();
       townlocations.put(maki.townxy,playerlocation.Maki);
       townrec.add(0,maki.r);
       townnodes.add(maki.townxy);
       
       
       
       jinku = new Jinku();
       jinku.setuptown();
       townlocations.put(jinku.townxy,playerlocation.jinku);
       townrec.add(1, jinku.r);
       townnodes.add(jinku.townxy);
       
       testtown1 = new testtown1();
       testtown1.setuptown();
       townlocations.put(testtown1.townxy, playerlocation.testtown1);
       townrec.add(2,testtown1.r);
       townnodes.add(testtown1.townxy);
       
       ttown2 = new ttown2();
       ttown2.setuptown();
       townlocations.put(ttown2.townxy, playerlocation.ttown2);
       townrec.add(2,ttown2.r);
       townnodes.add(ttown2.townxy);
       
       ttown3 = new ttown3();
       ttown3.setuptown();
       townlocations.put(ttown3.townxy, playerlocation.ttown3);
       townrec.add(2,ttown3.r);
       townnodes.add(ttown3.townxy);
       
       ttown4 = new ttown4();
       ttown4.setuptown();
       townlocations.put(ttown4.townxy, playerlocation.ttown4);
       townrec.add(2,ttown4.r);
       townnodes.add(ttown4.townxy);
       
       playerlocation = playerlocation.Maki;
       
     
       world = new Texture(Gdx.files.internal("world.jpg"));
       
      
       
     
       
       }
       
       void DrawTowns(SpriteBatch sb){
       
           
       sb.draw(world, worldx, worldy);
       maki.towns.draw(sb);
       jinku.towns.draw(sb);
       testtown1.towns.draw(sb);
       ttown2.towns.draw(sb);
       ttown3.towns.draw(sb);
       ttown4.towns.draw(sb);
   
       }

   

}
