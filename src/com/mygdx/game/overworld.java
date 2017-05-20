/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import ObserversAndListeners.storyEvent;
import ObserversAndListeners.storyListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ai.btree.BehaviorTree;
import com.badlogic.gdx.ai.btree.utils.BehaviorTreeParser;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.StreamUtils;
import com.mygdx.game.Constants.playerlocation;
import com.mygdx.game.Player.player;
import com.mygdx.game.towns.Jinku;
import com.mygdx.game.towns.Maki;
import com.mygdx.game.towns.testtown1;
import com.mygdx.game.towns.ttown2;
import com.mygdx.game.towns.ttown3;
import com.mygdx.game.towns.ttown4;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Stefan
 */
public class overworld implements calendarListener {
        public TiledMap overworld;
        OrthographicCamera cam;
        Stage stage;
        Skin skin;
        InputMultiplexer im;
      
        
        public player p;
        public overworldpathfinding owpathfinding;
        public Calendar c;
        private Set<calendarListener> listeners;
        public int currentWay = 0;
        public int totalWay;
        public float movetime;
        public float time;
        
        
        worldmenu worldmenu;
        
        
       float worldx = 0;
       float worldy = 0;
       ArrayList<Rectangle> townrec = new ArrayList();
       public  ArrayList<Vector2> townnodes = new ArrayList();
       
       public playerlocation playerlocation;
       Vector2 v = new Vector2();
       public HashMap<Vector2,playerlocation> townlocations = new HashMap();   
        TiledMapRenderer tmr;
      
       Maki maki;
       Jinku jinku;
       testtown1 testtown1;
       ttown2 ttown2;
       ttown3 ttown3;
       ttown4 ttown4;
       public  Rectangle rec;   ///town hitboxs
       int storyprogress;
       
       public overworld( OrthographicCamera cam, TiledMap tt,Stage stage,Skin skin,InputMultiplexer im){
      
        //instanstiate new town
        //set it up
        // add it to hashmap townlocations
        //add its hitbox to arraylist townrec
        // dont forget to add new towns marketlist in overworldmenu!
        // add town node
       
       this.cam = cam;
      // overworld = new TmxMapLoader().load("overworld.tmx");
      
       this.skin = skin;
       this.stage = stage;
       this.im = im;

      
       
       
        rec = new Rectangle();
       
        createtowns();
        c = new Calendar();
        listeners = new HashSet<calendarListener>();
        listeners.add(c);
       playerlocation = playerlocation.Maki;
        createplayer();
        worldmenu = new worldmenu(stage,skin,im,p,owpathfinding.current,currentWay,storyprogress);
     
        }
       
void DrawTowns(SpriteBatch sb,float time){

           
      // sb.draw(world, worldx, worldy);
      
       maki.towns.draw(sb);
       jinku.towns.draw(sb);
       testtown1.towns.draw(sb);
       ttown2.towns.draw(sb);
       ttown3.towns.draw(sb);
       ttown4.towns.draw(sb);
       p.drawplayer(sb, time);
       c.render(sb);
       }
private void createplayer() {
      Reader reader = null;
      try {
         reader = Gdx.files.internal("player.tree").reader();
         BehaviorTreeParser<player> parser = new BehaviorTreeParser<player>(BehaviorTreeParser.DEBUG_HIGH);
         BehaviorTree<player> btree = parser.parse(reader,p = new player());
         
          p.btree = btree;
          p.playerlocation = p.playerlocation.Maki;
          p.pstate =  p.pstate.overworld;
          p.pdirY =  p.pdirY.non;
          p.pdirX =  p.pdirX.non;
                  p.x = 400;
                  p.y = 260;
          owpathfinding = new overworldpathfinding(p,townnodes);
          p.funds = 1000;
         
      } finally{
      
         StreamUtils.closeQuietly(reader);
      }
    }
public void moveplayer( float movetime,float time,Vector2 loca) {
                 
                 if( p.isMoving ){//&&(time-movetime)> 0.005f){
                             
                    
                    

                       if(currentWay < (totalWay)){
                        if(p.x < owpathfinding.current.get(currentWay).x ){
                         p.moveright();
                         p.turnright();
                        
                        }
                        }
                        if(p.x > owpathfinding.current.get(currentWay).x ){
                         p.moveleft();
                         p.turnleft();
                         }
                        if(p.y < owpathfinding.current.get(currentWay).y ){
                         p.moveup();
                         p.turnup();}
                        if(p.y > owpathfinding.current.get(currentWay).y){
                         p.movedown();
                         p.turndown();
                         
                        }
                        
                        if(p.x == owpathfinding.current.get(currentWay).x && p.y == owpathfinding.current.get(currentWay).y){
                       
                            playerlocation pl;
                        Vector2 vb = new Vector2(owpathfinding.current.get(currentWay).x,owpathfinding.current.get(currentWay).y);
                         pl = townlocations.get(vb);
                         System.out.println(pl);
                         p.setplayerlocation(pl,listeners);
                           currentWay++; 
                        
                       } 
                        if(p.x == owpathfinding.destination.x && p.y == owpathfinding.destination.y){
                         
                         
                         p.resetPlayerstates();
                         owpathfinding.current.clear();
                         currentWay =0;
                         owpathfinding.setdeparture(p.x, p.y);
                        
                      //  p.x = Math.round(loca.x);
                      //  p.y = Math.round(loca.y);
                      
                        
                        buidworldmenu();
                        p.pstate = p.pstate.overworld;
                        p.isMoving = false;
                        
                      
                   }} movetime = time; 
    }
private void buidworldmenu() {
                      worldmenu.buildmenu(rec.x,rec.y,playerlocation);
                      worldmenu.stage.addAction(Actions.alpha(1f));
                       } 

public int getStoryprogress(){
      return storyprogress;
}
public void setStoryprogress(int i){
     storyprogress = i;
}

    private void createtowns() {
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
       
       
 }

    @Override
    public void daypassed(calendarEvent e) {
       }

    @Override
    public void monthpassed(calendarEvent e) {
        }
            public synchronized void AddstoryListener(calendarListener e ){
            listeners.add(e);
            }
            public synchronized void RemovestoryListener(calendarListener e){
            listeners.remove(e);
            }
}
