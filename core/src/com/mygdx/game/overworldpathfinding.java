/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Player.player;
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
       ArrayList<Vector2> current = new ArrayList();
       Vector2 templocation = new Vector2();
       Vector2 previous = new Vector2();
    
      public overworldpathfinding(player p,overworld overworld){
         this.p = p;
         this.overworld = overworld;
         departure =new Vector2();
         destination = new Vector2();
      }
      public void setdeparture(float x,float y){
        departure.x = x;
        departure.y = y;
      
      }
      public void setdestination(float x,float y){
        destination.x = x;
        destination.y = y;
      
      }
      private Vector2 GetDestination() {
      return destination; }
      public ArrayList calculatePaths() {

        previous = destination;
        int currentcount = 0;
        float x;
        float y;
       
        //is destination NSEW of departure
           if(departure.x < destination.x){
              //T
               System.out.println("destination is EAST");
               p.pdirX =  p.pdirX.east;
           }
           if(departure.x > destination.x){
             
              System.out.println("//destination is WEST " );
              p.pdirX =  p.pdirX.west;
           }
           if(departure.y < destination.y){
             
              System.out.println("//destion is NORTH  " );
              p.pdirY = p.pdirY.north;
           }
           if(departure.y> destination.y){
             
              System.out.println("//destination is SOUTH" );
              p.pdirY =  p.pdirY.south;
           }
           templocation = overworld.townnodes.get(0);
                  
              if(  p.pdirY ==  p.pdirY.north && departure.y < templocation.y ){
             //dget all nodes to the north
                  for(int towncount = 0; towncount < overworld.townnodes.size(); towncount++){
                      templocation = overworld.townnodes.get(towncount);
                           if(templocation.y >= departure.y){
                              //sort EW
                              //
                              checkEW(templocation);
                           }else{}
                    }  
            }
              if(  p.pdirY ==  p.pdirY.south && departure.y> templocation.y){
             //dget all nodes to the north
                  for(int towncount = 0; towncount < overworld.townnodes.size(); towncount++){
                      templocation = overworld.townnodes.get(towncount);
                           if(templocation.y <= departure.y){
                              //sort EW
                              //
                              checkEW(templocation);
                           }else{}
                    }  
            }
           current.add(destination);
            System.out.println("destination" + destination);
           return current;
         }
      private void checkEW(Vector2 templocation){
                 if( p.pdirX ==  p.pdirX.east){
                      if(templocation.x > departure.x){
                         current.add(templocation);
                         System.out.println("added est" + templocation);
                      }else{}
             
           }     
                 if( p.pdirX ==  p.pdirX.west){
                      if(templocation.x < departure.x){
                         current.add(templocation);
                          System.out.println("added west" + templocation);
                      }else{}
             
           }
    }
}
