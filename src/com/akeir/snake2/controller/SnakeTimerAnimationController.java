/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akeir.snake2.controller;

import com.akeir.controller.AnimationController;
import com.akeir.global.GameState;
import com.akeir.snake2.global.GlobalParamsImpl;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 *
 * @author Codeiro
 */
public class SnakeTimerAnimationController extends AnimationController {
    
    protected SnakeTimerCountersController counter;
    
    public SnakeTimerAnimationController(ObservableList<Node> snakeList, ObservableList<Node> elements) 
    {
        super(snakeList, elements);
        
        counter = new SnakeTimerCountersController(elementsHolder);
    }
    
    @Override
    protected void handleCollisions()
    {
        super.handleCollisions();
        
        if(counter.retrieveTimeCount() <= 0.00)
        {
            handleDeath();
        }
    }
    
    @Override
    protected void executeAnimation()
    {
        if(!GameState.RUNNING.equals(GlobalParamsImpl.CURRENT_STATE))
        {
            return;
        }
        else
        {
            super.executeAnimation();
            counter.handleTime();
        }
    }
    
    @Override
    protected void handleScoreCount()
    {
        counter.handleScore();
        counter.checkToIncreaseSpeed();
        counter.resetTimeCount();
    }
    
    @Override
    protected void handleDeath()
    {
        super.handleDeath();
        counter.setInitialTimer();
    }
    
    @Override
    protected void saveScoreToFile()
    {
        SnakeTimerFileController.get().saveLongestTime(((Label) elementsHolder.getElementsMap().get("lbLongestTimeCount")).getText());
    }
}
