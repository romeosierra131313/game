/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author Stefan
 */
public class Constants {
    

    public Constants() {

        
    }
   
   
   public enum state{loading,menu,help,info,overworld,game} 
   public enum gameplace{menu,overworld}
   public enum playerlocation{Maki,jinku,testtown1,ttown2,ttown3,ttown4}
   public enum playerstate{waiting,moving,inbattle,intown}
   public enum playermovingdir{north,south,east,west,non}
     


   


}