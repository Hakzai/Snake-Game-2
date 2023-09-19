/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akeir.snake2.controller;

import com.akeir.controller.CountersController;
import com.akeir.global.Constants;
import com.akeir.global.GlobalParams;
import com.akeir.helper.ElementsHolder;
import com.akeir.resources.controllers.SoundController;
import com.akeir.snake2.global.ConstantsImpl;
import com.akeir.snake2.global.UtilsImpl;
import java.math.BigDecimal;
import javafx.scene.control.Label;

/**
 *
 * @author Codeiro
 */
public class SnakeTimerCountersController extends CountersController {
    
    private double totalTime = 0.0;
    private double longestTime = 0.0;
    private long currentTimeStamp = 0;
    private long previousTimeStamp = 0;
    
    private double timeCount = ConstantsImpl.INITIAL_TIME - GlobalParams.GAME_SPEED;
    
    private Label lbTimeCount;
    private Label lbTotalTimeCount;
    private Label lbLongestTimeCount;
    
    public SnakeTimerCountersController(ElementsHolder elements) 
    {
        super(elements);
    }
    
    protected void mapLabelCounters(ElementsHolder elements)
    {
        super.mapLabelCounters(elements);
        
        if(null == lbTimeCount)
        {
            lbTimeCount = (Label) elements.getElementsMap().get("lbTimeCount");
        }
        if(null == lbTotalTimeCount)
        {
            lbTotalTimeCount = (Label) elements.getElementsMap().get("lbTotalTimeCount");
        }
        if(null == lbLongestTimeCount)
        {
            lbLongestTimeCount = (Label) elements.getElementsMap().get("lbLongestTimeCount");
        }
    }
    
    public void handleTime()
    {
        mapTimeCountersToDouble();
        mapResultsToLabelCounters();
    }

    public double retrieveTimeCount() 
    {
        return timeCount;
    }

    protected void mapTimeCountersToDouble() 
    {
        if(currentTimeStamp==0)
        {
            currentTimeStamp = System.currentTimeMillis();
        }
        else
        {
            previousTimeStamp = currentTimeStamp;
            currentTimeStamp = System.currentTimeMillis();
            timeCount = timeCount - ((currentTimeStamp-previousTimeStamp)/1000.0);
            totalTime = totalTime + ((currentTimeStamp-previousTimeStamp)/1000.0);
        }
    }

    protected void mapResultsToLabelCounters() 
    {
        lbTimeCount.setText(
                (timeCount<=0.0 ? String.valueOf(new BigDecimal(0.00).setScale(2, BigDecimal.ROUND_DOWN)) : String.valueOf(new BigDecimal(timeCount).setScale(2, BigDecimal.ROUND_DOWN))
                        ) + " sec");
        lbTotalTimeCount.setText(String.valueOf(new BigDecimal(totalTime).setScale(2, BigDecimal.ROUND_DOWN)) + " sec");
        
        if(totalTime>UtilsImpl.stringToDouble(lbLongestTimeCount.getText().substring(0, 3))) // SUBSTRING IS TO REMOVE " sec" FROM PARSE;
        {
            longestTime = totalTime;
            lbLongestTimeCount.setText(String.valueOf(new BigDecimal(longestTime).setScale(2, BigDecimal.ROUND_DOWN)) + " sec");
        }
    }
    
    public void resetTimeCount()
    {
        timeCount = GlobalParams.GAME_SPEED<=7 ? ConstantsImpl.INITIAL_TIME-GlobalParams.GAME_SPEED : ConstantsImpl.THREE_AS_INTEGER;
        
        lbTimeCount.setText(String.valueOf(new BigDecimal(timeCount).setScale(2, BigDecimal.ROUND_DOWN)) + " sec");
    }
    
    public void setInitialTimer()
    {
        currentTimeStamp = 0;
        previousTimeStamp = 0;
    }
    
    @Override
    public void checkToIncreaseSpeed()
    {
        if(score%ConstantsImpl.SNAKE_TIMER_POINTS_INCREASE_SPEED==Constants.ZERO_AS_INTEGER)
        {
            increaseSpeed();
            SoundController.play().snakeSpeedsUp();
        }
    }
}
