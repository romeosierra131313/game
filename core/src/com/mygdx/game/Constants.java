/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

/**
 *
 * @author Stefan
 */
public class Constants {
    

    public Constants() {

        
    }
   
   
   public enum state{loading,menu,help,info,overworld,game} 
 
   public enum playerlocation{Maki,jinku,testtown1,ttown2,ttown3,ttown4}
   public enum gamestate{waiting,inbattle,overworld,intown}
   public enum intownstate{board,market,team,system,exit}
   public enum playermovingdir{north,south,east,west,non}
     


   


}