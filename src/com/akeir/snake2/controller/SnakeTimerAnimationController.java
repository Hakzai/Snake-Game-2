/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akeir.snake2.controller;

import com.akeir.controller.AnimationController;
import com.akeir.controller.CollisionController;
import com.akeir.global.GlobalParams;
import com.akeir.snake2.global.ConstantsImpl;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 *
 * @author Codeiro
 */
public class SnakeTimerAnimationController extends AnimationController {
    
    protected CountersControllerForSnakeTimer counter;
    
    private double timeCount = ConstantsImpl.INITIAL_TIME - GlobalParams.GAME_SPEED;
    private double totalTime = 0.0;
    private double longestTime = 0.0;
    private long currentTime = 0;
    private long previousTime = 0;
    
    public SnakeTimerAnimationController(ObservableList<Node> snakeList, ObservableList<Node> elements) 
    {
        super(snakeList, elements);
        
        counter = new CountersControllerForSnakeTimer(elementsHolder);
    }
    
    @Override
    protected void handleCollisions()
    {
        if(CollisionController.getInstance().isCollideFood(snakeHead, food.getLayoutX(), food.getLayoutY()))
        {
            handleGrowSnake();
            handleScoreCount();
            timeCount = GlobalParams.GAME_SPEED<7 ? ConstantsImpl.INITIAL_TIME-GlobalParams.GAME_SPEED : 3;
        }
        else if((CollisionController.getInstance().isCollideSnake(snakeHead, snake) || CollisionController.getInstance().isCollideWall(snakeHead)) || timeCount <= 0.00)
        {
            handleDeath();
            currentTime = 0;
            previousTime = 0;
        }
    }
    
    @Override
    protected void executeAnimation()
    {
        super.executeAnimation();
        
        if(currentTime==0)
        {
            currentTime = System.currentTimeMillis();
        }
        else
        {
            previousTime = currentTime;
            currentTime = System.currentTimeMillis();
            timeCount = timeCount - ((currentTime-previousTime)/1000.0);
            totalTime = totalTime + ((currentTime-previousTime)/1000.0);
        }
        
        ((Label) elementsHolder.getElementsMap().get("lbTimeCount")).setText(String.valueOf(new BigDecimal(timeCount).setScale(2, BigDecimal.ROUND_DOWN)) + " sec");
        ((Label) elementsHolder.getElementsMap().get("lbTotalTimeCount")).setText(String.valueOf(new BigDecimal(totalTime).setScale(2, BigDecimal.ROUND_DOWN)) + " sec");
        
        if(totalTime>longestTime)
        {
            longestTime = totalTime;
            ((Label) elementsHolder.getElementsMap().get("lbLongestTimeCount")).setText(String.valueOf(new BigDecimal(longestTime).setScale(2, BigDecimal.ROUND_DOWN)) + " sec");
        }
    }
    
    @Override
    protected void handleScoreCount()
    {
        counter.handleTime();
        counter.checkToIncreaseSpeed();
    }
}
