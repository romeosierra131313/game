/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.Player;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;

/**
 *
 * @author Stefan
 */
public class WalkLeftTask extends LeafTask<player> {

    @Override
    public Status execute() {
        player player = getObject();
        player.moveleft();
        System.out.print("im walked left"); 
        return Status.SUCCEEDED;  }

    @Override
    protected Task<player> copyTo(Task<player> task) {
      return task; }

    
    
}