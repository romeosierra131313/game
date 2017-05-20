package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.HashMap;
import java.util.Set;

public class Calendar implements calendarListener{
      month1 month1;
      month2 month2;
      BitmapFont bf;
      Month month;
      int currentDate=0;
      int currentMonth = 1;
      String currentMonthString;
      int nextday;
      public HashMap<Integer,Month> calendar = new HashMap();
       private Set<calendarListener> listeners;
      
      public Calendar(){
          month1 = new month1();
          month2 = new month2();
          
          calendar = new HashMap<Integer,Month>();
          calendar.put(1,month1);
          calendar.put(2,month2);
          
          bf = new BitmapFont();
          month = new Month();
          
      }
      public void render(SpriteBatch sb){
           bf.draw(sb, monthString(currentMonth,getcurrentDate()), 
                    Gdx.graphics.getWidth() - 200,Gdx.graphics.getHeight() - 50);
      
      
      }
      public void daypassed(calendarEvent e){
          if(getcurrentDate() < 20){ System.out.println("changed day");
               nextday = getcurrentDate()+1;
               currentDate = nextday;}else{
               currentDate =0;
          }
           switch(getcurrentMonth()){
              
                case 1 : month1.setcurrentDate(nextday);
                break;
                case 2 : month2.setcurrentDate(nextday);
                break;
           }
      }
      public void monthpassed(calendarEvent e){
          
          
            if(currentMonth < 2){
               calendar.get(currentMonth).setcurrentDate(1);
               currentMonth++;
               
             }else{
               calendar.get(currentMonth).setcurrentDate(1);
               currentMonth = 1;
              }
             
      }
      
      private String monthString(int currentMonth,int currentDate){
           currentMonthString = calendar.get(currentMonth).getName() + "/ " + Integer.toString(currentDate);
           return  currentMonthString;
      }
      private void setcurrentDate(){
            this.currentDate =  calendar.get(currentMonth).getcurrentDate();
      }
      public int getcurrentDate(){
            return currentDate;
      }

    public int getcurrentMonth() {
        return currentMonth; }
    public void setcurrentMonth(int i){
    this.currentMonth = i;
    
    }

}
