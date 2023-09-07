/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akeir.snake2.controller;

import com.akeir.controller.AnimationController;
import com.akeir.controller.CountersController;
import com.akeir.global.Constants;
import com.akeir.global.GlobalParams;
import com.akeir.helper.ElementsHolder;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 *
 * @author Codeiro
 */
public class AnimationControllerForSnakeTimer extends AnimationTimer {
    
    protected double time = 30.0;
    protected ElementsHolder elementsHolder;
    protected CountersControllerForSnakeTimer counter;
    
    public AnimationControllerForSnakeTimer(ObservableList<Node> snakeList, ObservableList<Node> elements)
    {
        elementsHolder = new ElementsHolder(elements);
//        counter = new CountersControllerForSnakeTimer(elementsHolder);
    }
    
    @Override
    public void handle(long now) 
    {
        time -= 0.01 * GlobalParams.GAME_SPEED;

        if (time > 0.0) 
        {
            executeAnimation();
        }
        else
        {
            time = 30.0;
        }
    }
    
    protected void executeAnimation()
    {
        if(!GlobalParams.GAME_STARTED)
        {
            return;
        }
        
        DecimalFormat decimalFormat = new DecimalFormat("#,#0.0");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        ((Label) elementsHolder.getElementsMap().get("lbTimeCount")).setText(String.valueOf(decimalFormat.format(time)));
    }
    
}
