/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akeir.snake2.scene.controller;

import com.akeir.scene.controller.FXMLSnakeGameController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.geometry.Insets;
import javafx.scene.control.Label;

/**
 *
 * @author Codeiro
 */
public class FXMLTimerSnakeController extends FXMLSnakeGameController {
    
    private Label lbTime = new Label("Time: ");
    private Label lbTimeCount = new Label("0.0");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        super.initialize(url, rb);
        
        lbScore.setVisible(false);
        lbScoreCount.setVisible(false);
        lbHighScore.setVisible(false);
        lbHighScoreCount.setVisible(false);
        lbTitle.setText("Snake Timer");
        
        labelStyleCopy(lbScore, lbTime);
        apMain.getChildren().add(lbTime);
        labelStyleCopy(lbScoreCount, lbTimeCount);
        apMain.getChildren().add(lbTimeCount);
    }

    private void labelStyleCopy(Label labelModel, Label labelTarget)
    {
        labelTarget.setAlignment(labelModel.getAlignment());
        labelTarget.setTextAlignment(labelModel.getTextAlignment());
        labelTarget.setPrefHeight(labelModel.getPrefHeight());
        labelTarget.setLayoutX(labelModel.getLayoutX());
        labelTarget.setLayoutY(labelModel.getLayoutY());
        labelTarget.setTextFill(labelModel.getTextFill());
        labelTarget.setFont(labelModel.getFont());
        labelTarget.setVisible(true);
        labelTarget.toFront();
    }
}
