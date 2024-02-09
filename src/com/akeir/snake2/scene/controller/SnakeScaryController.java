/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akeir.snake2.scene.controller;

import com.akeir.resources.controllers.MusicController;
import com.akeir.scene.controller.SnakeGameController;
import com.akeir.snake2.controller.SnakeScaryAnimationController;
import com.akeir.snake2.global.UtilsImpl;
import javafx.scene.text.Font;

/**
 *
 * @author Codeiro
 */
public class SnakeScaryController extends SnakeGameController {
    
    public SnakeScaryController()
    {
        super();
    }

    @Override
    protected void initialize()
    {
        super.initialize();
        
        changeSceneTitle();
    }
    
    private void changeSceneTitle()
    {
        lbTitle.setText("Snake Scary");
        lbTitle.setFont(Font.loadFont(getClass().getResource("/com/akeir/resources/fonts/pioneer.ttf").toExternalForm(), 70.0));
    }
    
    @Override
    protected void startMove()
    {
        MusicController.get().stopMusic();
        UtilsImpl.popMessage(". . .");
        
        if(null == timer)
        {
            setTimer(new SnakeScaryAnimationController(getPaneSnake().getChildren(), this.getChildren()));
        }
        timer.start();
    }
}
