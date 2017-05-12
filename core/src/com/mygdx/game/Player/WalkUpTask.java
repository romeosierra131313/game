/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.Player;
import com.mygdx.game.shamballa;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stefan
 */
public class WalkUpTask extends LeafTask<player> {
       float t ;
    @Override
    public Status execute() {
        player player = getObject();
        
        player.moveup();
      
         
         
        
        System.out.print("im walked up"); 
        return Status.SUCCEEDED;}

    @Override
    protected Task<player> copyTo(Task<player> task) {
        return task; }

    
}
