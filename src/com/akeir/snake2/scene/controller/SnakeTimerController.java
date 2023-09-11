/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akeir.snake2.scene.controller;

import com.akeir.scene.controller.SnakeGameController;
import com.akeir.snake2.controller.SnakeTimerAnimationController;
import com.akeir.snake2.controller.SnakeTimerFileController;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

/**
 *
 * @author Codeiro
 */
public class SnakeTimerController extends SnakeGameController {
    
    private Label lbTime;
    private Label lbTimeCount;
    private Label lbTotalTime;
    private Label lbTotalTimeCount;
    private Label lbLongestTime;
    private Label lbLongestTimeCount;
    
    public SnakeTimerController()
    {
        super();
    }
    
    @Override
    protected void initialize() 
    {
        super.initialize();
        
        buildLocalElements();
        hideUnusedElements();
        changeSceneTitle();
        setCurrentLongestTime();
    }
    
    private void buildLocalElements() 
    {
        lbTime = new Label("Time: ");
        lbTime.setId("lbTime");
        labelStyleCopy(lbScore, lbTime);
        this.getChildren().add(lbTime);
        
        lbTimeCount = new Label("0.0");
        lbTimeCount.setId("lbTimeCount");
        labelStyleCopy(lbScoreCount, lbTimeCount);
        this.getChildren().add(lbTimeCount);
        
        lbTotalTime = new Label("Total time: ");
        lbTotalTime.setId("lbTotalTime");
        labelStyleCopy(lbHighScore, lbTotalTime);
        AnchorPane.setLeftAnchor(lbTotalTime, AnchorPane.getLeftAnchor(lbHighScore)-60.0);
        this.getChildren().add(lbTotalTime);
        
        lbTotalTimeCount = new Label("0.0");
        lbTotalTimeCount.setId("lbTotalTimeCount");
        labelStyleCopy(lbHighScoreCount, lbTotalTimeCount);
        AnchorPane.setLeftAnchor(lbTotalTimeCount, AnchorPane.getLeftAnchor(lbHighScoreCount)-60.0);
        this.getChildren().add(lbTotalTimeCount);
        
        lbLongestTime = new Label("Longest time: ");
        lbLongestTime.setId("lbLongestTime");
        labelStyleCopy(lbTotalTime, lbLongestTime);
        AnchorPane.setLeftAnchor(lbLongestTime, AnchorPane.getLeftAnchor(lbTotalTime)+260.0);
        this.getChildren().add(lbLongestTime);
        
        lbLongestTimeCount = new Label("0.0");
        lbLongestTimeCount.setId("lbLongestTimeCount");
        labelStyleCopy(lbTotalTimeCount, lbLongestTimeCount);
        AnchorPane.setLeftAnchor(lbLongestTimeCount, AnchorPane.getLeftAnchor(lbTotalTimeCount)+285.0);
        this.getChildren().add(lbLongestTimeCount);
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

    private void labelStyleCopy(Label srcLabel, Label tgtLabel)
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
    
    @Override
    public void startGame()
    {
//        System.err.print("STARTING THE GAME ALREADYYY");
        super.startGame();
        
//        System.err.print("STARTING THE TIMER ALREADYYY");
//        startTimer();
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
}
