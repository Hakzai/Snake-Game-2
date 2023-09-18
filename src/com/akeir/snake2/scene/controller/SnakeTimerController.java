/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akeir.snake2.scene.controller;

import com.akeir.scene.controller.SnakeGameController;
import com.akeir.snake2.controller.SnakeTimerAnimationController;
import com.akeir.snake2.controller.SnakeTimerFileController;
import com.akeir.snake2.scene.builder.SnakeTimerBuilder;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 *
 * @author Codeiro
 */
public class SnakeTimerController extends SnakeGameController {
    
    protected Label lbTime;
    protected Label lbTimeCount;
    protected Label lbTotalTime;
    protected Label lbTotalTimeCount;
    protected Label lbLongestTime;
    protected Label lbLongestTimeCount;
    
    public SnakeTimerController()
    {
        super();
    }
    
    @Override
    protected SnakeTimerBuilder createInstanceForBuilder()
    {
        return new SnakeTimerBuilder(this);
    }
    
    @Override
    protected void initialize() 
    {
        super.initialize();
        
        hideUnusedElements();
        changeSceneTitle();
        setCurrentLongestTime();
    }
    
    private void hideUnusedElements()
    {
        lbScore.setVisible(false);
        
        lbScoreCount.setVisible(false);
        lbHighScore.setVisible(false);
        lbHighScoreCount.setVisible(false);
    }
    
    private void changeSceneTitle()
    {
        lbTitle.setText("Snake Timer");
        lbTitle.setFont(Font.loadFont(getClass().getResource("/com/akeir/resources/fonts/pioneer.ttf").toExternalForm(), 80.0));
    }
    
    private void setCurrentLongestTime()
    {
        lbLongestTimeCount.setText(SnakeTimerFileController.get().loadLongestTime());
    }
    
    @Override
    protected void startMove()
    {
        if(null == timer)
        {
            timer = new SnakeTimerAnimationController(getPaneSnake().getChildren(), this.getChildren());
        }
        timer.start();
    }

    public Label getLbTime() 
    {
        return lbTime;
    }

    public Label getLbTimeCount() 
    {
        return lbTimeCount;
    }

    public Label getLbTotalTime() 
    {
        return lbTotalTime;
    }

    public Label getLbTotalTimeCount()
    {
        return lbTotalTimeCount;
    }

    public Label getLbLongestTime() 
    {
        return lbLongestTime;
    }

    public Label getLbLongestTimeCount() 
    {
        return lbLongestTimeCount;
    }

    public void setLbTime(Label lbTime)
    {
        this.lbTime = lbTime;
    }

    public void setLbTimeCount(Label lbTimeCount) 
    {
        this.lbTimeCount = lbTimeCount;
    }

    public void setLbTotalTime(Label lbTotalTime) 
    {
        this.lbTotalTime = lbTotalTime;
    }

    public void setLbTotalTimeCount(Label lbTotalTimeCount) 
    {
        this.lbTotalTimeCount = lbTotalTimeCount;
    }

    public void setLbLongestTime(Label lbLongestTime)
    {
        this.lbLongestTime = lbLongestTime;
    }

    public void setLbLongestTimeCount(Label lbLongestTimeCount) 
    {
        this.lbLongestTimeCount = lbLongestTimeCount;
    }
}
