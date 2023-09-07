/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akeir.snake2.scene.controller;

import com.akeir.controller.AnimationController;
import com.akeir.scene.controller.SnakeGameController;
import com.akeir.snake2.controller.AnimationControllerForSnakeTimer;
import javafx.animation.AnimationTimer;
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
    private AnimationTimer snakeTimer;
    
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
        System.err.print("STARTING THE GAME ALREADYYY");
        super.startGame();
        
        System.err.print("STARTING THE TIMER ALREADYYY");
        startTimer();
    }
    
    private void startTimer()
    {
        if(null == snakeTimer)
        {
            snakeTimer = new AnimationControllerForSnakeTimer(getPaneSnake().getChildren(), this.getChildren());
        }
        snakeTimer.start();
    }
}
