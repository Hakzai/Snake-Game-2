/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akeir.snake2.scene.builder;

import com.akeir.scene.builder.SnakeGameBuilder;
import com.akeir.snake2.scene.controller.SnakeTimerController;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Codeiro
 */
public class SnakeTimerBuilder extends SnakeGameBuilder {
    
    protected SnakeTimerController timerScene;
    
    public SnakeTimerBuilder(AnchorPane parentScene)
    {
        super(parentScene);
        
        if(parentScene instanceof SnakeTimerController)
        {
            timerScene = (SnakeTimerController) parentScene;
        }
    }
    
    @Override
    protected void createInstanceForElements()
    {
        super.createInstanceForElements();
        
        timerScene.setLbTime(new Label());
        timerScene.setLbTimeCount(new Label());
        timerScene.setLbTotalTime(new Label());
        timerScene.setLbTotalTimeCount(new Label());
        timerScene.setLbLongestTime(new Label());
        timerScene.setLbLongestTimeCount(new Label());
    }
    
    @Override
    public void executeBuild()
    {
        super.executeBuild();
        
        timerScene.getLbTime().setId("lbTime");
        timerScene.getLbTime().setText("Time: ");
        labelStyleCopy(timerScene.getLbScore(), timerScene.getLbTime());
        timerScene.getChildren().add(timerScene.getLbTime());
        
        timerScene.getLbTimeCount().setId("lbTimeCount");
        timerScene.getLbTimeCount().setText("0.0 sec");
        labelStyleCopy(timerScene.getLbScoreCount(), timerScene.getLbTimeCount());
        timerScene.getChildren().add(timerScene.getLbTimeCount());
        
        timerScene.getLbTotalTime().setId("lbTotalTime");
        timerScene.getLbTotalTime().setText("Total Time: ");
        labelStyleCopy(timerScene.getLbHighScore(), timerScene.getLbTotalTime());
        AnchorPane.setLeftAnchor(timerScene.getLbTotalTime(), AnchorPane.getLeftAnchor(timerScene.getLbHighScore())-60.0);
        timerScene.getChildren().add(timerScene.getLbTotalTime());
        
        timerScene.getLbTotalTimeCount().setId("lbTotalTimeCount");
        timerScene.getLbTotalTimeCount().setText("0.0 sec");
        labelStyleCopy(timerScene.getLbHighScoreCount(), timerScene.getLbTotalTimeCount());
        AnchorPane.setLeftAnchor(timerScene.getLbTotalTimeCount(), AnchorPane.getLeftAnchor(timerScene.getLbHighScoreCount())-60.0);
        timerScene.getChildren().add(timerScene.getLbTotalTimeCount());
        
        timerScene.getLbLongestTime().setId("lbLongestTime");
        timerScene.getLbLongestTime().setText("Longest Time: ");
        labelStyleCopy(timerScene.getLbTotalTime(), timerScene.getLbLongestTime());
        AnchorPane.setLeftAnchor(timerScene.getLbLongestTime(), AnchorPane.getLeftAnchor(timerScene.getLbTotalTime())+260.0);
        timerScene.getChildren().add(timerScene.getLbLongestTime());
        
        timerScene.getLbLongestTimeCount().setId("lbLongestTimeCount");
        timerScene.getLbLongestTimeCount().setText("0.0 sec");
        labelStyleCopy(timerScene.getLbTotalTimeCount(), timerScene.getLbLongestTimeCount());
        AnchorPane.setLeftAnchor(timerScene.getLbLongestTimeCount(), AnchorPane.getLeftAnchor(timerScene.getLbTotalTimeCount())+285.0);
        timerScene.getChildren().add(timerScene.getLbLongestTimeCount());
    }
    
    protected void labelStyleCopy(Label srcLabel, Label tgtLabel)
    {
        tgtLabel.setAlignment(srcLabel.getAlignment());
        tgtLabel.setTextAlignment(srcLabel.getTextAlignment());
        tgtLabel.setPrefHeight(srcLabel.getPrefHeight());
        AnchorPane.setLeftAnchor(tgtLabel, AnchorPane.getLeftAnchor(srcLabel));
        AnchorPane.setBottomAnchor(tgtLabel, AnchorPane.getBottomAnchor(srcLabel));
        tgtLabel.setTextFill(srcLabel.getTextFill());
        tgtLabel.setFont(srcLabel.getFont());
        tgtLabel.setVisible(true);
    }
}
