package com.mygdx.game;

public class Month{
      private String Name;
      private int length;
      private int currentDate;
      
   public Month(){}
   
   public String getName(){
      return Name;
   }
   public void SetName(String g){
      this.Name = g;
   }
      public int getlength(){
      return length;
   }
   public void SetLength(int length ){
      this.length = length;
   }
     public int getcurrentDate(){
      return currentDate;
   }
   public void setcurrentDate(int currentDate ){
      this.currentDate = currentDate;
   }
}
