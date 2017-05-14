/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.towns;

import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;
import com.mygdx.game.Constants;

/**
 *
 * @author Stefan
 */
public class Paths {
      public ArrayList<Vector2> currentPath;
      public final ArrayList<Vector2> pathmakitojinku;
      public final ArrayList<Vector2> pathjinkutomaki;
      
      private final String pmtj ="pathmakitojinku";
    
      public Paths(){
      
        currentPath = new ArrayList();
        
          
        pathmakitojinku = new ArrayList();
        pathmakitojinku.add(new Vector2(434,294));
        pathmakitojinku.add(new Vector2(445,301));
        pathmakitojinku.add(new Vector2(462,307));
        pathmakitojinku.add(new Vector2(477,316));
        pathmakitojinku.add(new Vector2(492,323));
        pathmakitojinku.add(new Vector2(508,330));
        pathmakitojinku.add(new Vector2(527,333));
        pathmakitojinku.add(new Vector2(544,339));
        pathmakitojinku.add(new Vector2(559,344));
        pathmakitojinku.add(new Vector2(578,352));
        pathmakitojinku.add(new Vector2(609,365));
        pathmakitojinku.add(new Vector2(626,379));
        pathmakitojinku.add(new Vector2(642,384));
        pathmakitojinku.add(new Vector2(658,391));
        pathmakitojinku.add(new Vector2(678,392));
        pathmakitojinku.add(new Vector2(698,392));
      
        pathjinkutomaki = new ArrayList();
        pathjinkutomaki.add(new Vector2(698,392));
        pathjinkutomaki.add(new Vector2(678,392));
        pathjinkutomaki.add(new Vector2(658,391));
        pathjinkutomaki.add(new Vector2(642,384));
        pathjinkutomaki.add(new Vector2(626,379));
        pathjinkutomaki.add(new Vector2(609,365));
        pathjinkutomaki.add(new Vector2(578,352));
        pathjinkutomaki.add(new Vector2(559,344));
        pathjinkutomaki.add(new Vector2(544,339));
        pathjinkutomaki.add(new Vector2(527,333));
        pathjinkutomaki.add(new Vector2(508,330));
        pathjinkutomaki.add(new Vector2(492,323));
        pathjinkutomaki.add(new Vector2(477,316));
        pathjinkutomaki.add(new Vector2(462,307));
        pathjinkutomaki.add(new Vector2(445,301));     
        pathjinkutomaki.add(new Vector2(434,294));
        
        
        
        
        
      }
      
    
      public ArrayList getCurrentPath(String g){
      if(g.compareTo(pmtj) == 0){
         currentPath = pathmakitojinku;
      }
      return currentPath;
      
      }
}
