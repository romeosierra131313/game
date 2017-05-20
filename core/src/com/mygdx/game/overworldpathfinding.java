/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Player.player;
import com.mygdx.game.Player.player;
import com.mygdx.game.overworld;
import java.util.ArrayList;

/**
 *
 * @author Stefan
 */
public class overworldpathfinding {
      player p;
      overworld overworld;
      public Vector2 departure;
      public Vector2 destination;
      public Vector2 diff;
       ArrayList<Vector2> current = new ArrayList();
       ArrayList<Vector2> townnodes;
       Vector2 templocation = new Vector2();
       Vector2 previous = new Vector2();
    
      public overworldpathfinding(player p,ArrayList townnodes){
         this.p = p;
         this.townnodes = townnodes;
         departure =new Vector2();
         destination = new Vector2();
         
         
      }
      public void setdeparture(float x,float y){
        departure.x = x;
        departure.y = y;
        setdiff();
      
      }
      public void setdestination(float x,float y){
        destination.x = x;
        destination.y = y;
      
      }
      public void setdiff(){
      diff = new Vector2(Math.abs(departure.x - destination.x) ,Math.abs(departure.y - destination.y));
      
      }
      public void calculatePaths() {
        setdiff();
       
       
        //is destination NSEW of departure
           if(departure.x < destination.x && diff.x >= diff.y){
              //T
               System.out.println("destination is EAST");
               p.pdirX =  p.pdirX.east;
           }
           if(departure.x > destination.x && diff.x >= diff.y){
             
              System.out.println("//destination is WEST " );
              p.pdirX =  p.pdirX.west;
           }
           if(departure.y < destination.y && diff.y >= diff.x){
             
              System.out.println("//destion is NORTH  " );
              p.pdirY = p.pdirY.north;
           }
           if(departure.y> destination.y && diff.y >= diff.x){
             
              System.out.println("//destination is SOUTH" );
              p.pdirY =  p.pdirY.south;
           }
         
                  
           
                  for(int towncount = 0; towncount < townnodes.size(); towncount++){
                      templocation = townnodes.get(towncount);
                         setdiff();
                           if( p.pdirY ==  p.pdirY.north 
                                   && templocation.y > departure.y
                                   && templocation.y < destination.y 
                                   && Math.abs(templocation.y- departure.y  ) <= 350 
                                   && Math.abs(templocation.x- departure.x  ) <= 350
                                   && Math.abs(destination.y - templocation.y) < diff.y
                                   && Math.abs(destination.x - templocation.x) < diff.x){
                             current.add(templocation);
                             System.out.println("added " + templocation +"/n");
                           //  diff.y = Math.abs(templocation.y - destination.y);
                           setdeparture(templocation.x,templocation.y);
                           }else{}
                           if( p.pdirY ==  p.pdirY.south 
                                   && departure.y > templocation.y 
                                   && templocation.y > destination.y 
                                   && Math.abs(departure.y - templocation.y) <= 350
                                    && Math.abs(templocation.x- departure.x) <= 350 
                                   && Math.abs(templocation.y - destination.y) < diff.y
                                   && Math.abs(destination.x - templocation.x) < diff.x){
                             current.add(templocation);
                             System.out.println("added " + templocation +"/f");
                         //  diff.y = Math.abs(templocation.y - destination.y);
                          setdeparture(templocation.x,templocation.y);
                           }else{}
                           if( p.pdirX ==  p.pdirX.east  
                                   && departure.x < templocation.x 
                                   && templocation.x < destination.x 
                                   &&  Math.abs(templocation.x-departure.x) <= 350
                                   && Math.abs(templocation.y- departure.y  ) <= 350 
                                   && Math.abs(destination.x-templocation.x) < diff.x 
                                   && Math.abs(destination.y - templocation.y) < diff.y){
                             current.add(templocation);
                             System.out.println("added " + templocation +"/n");
                        //   diff.x = Math.abs(templocation.x - destination.x);
                              setdeparture(templocation.x,templocation.y);
                           }else{}
                           if( p.pdirX ==  p.pdirX.west  
                                   && templocation.x > departure.x 
                                   && templocation.x< destination.x 
                                   && Math.abs(departure.x - templocation.x) <= 350
                                   && Math.abs(templocation.y- departure.y  ) <= 350 
                                   && Math.abs(templocation.x - destination.x) < diff.x
                                   && Math.abs(destination.y - templocation.y) < diff.y){
                             current.add(templocation);
                             System.out.println("added " + templocation +"/q");
                       //    diff.x = Math.abs(templocation.x - destination.x);
                              setdeparture(templocation.x,templocation.y);
                           }else{}
                     
            
                         //System.out.println("added " + templocation +"/z");
                         
              
           
            
          
         }current.add(destination);
          current.remove(0);

             
           }
    public void setup(Vector2 loca,player p,int totalWay ){
    
                   current.clear();
                   setdeparture( p.x , p.y );
                   current.add(new Vector2 (p.x,p.y));
                   setdestination( loca.x,loca.y );
                   calculatePaths();
                  
    }
}
