/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akeir.snake2.controller;

import com.akeir.controller.AnimationController;
import com.akeir.snake2.global.UtilsImpl;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Codeiro
 */
public class SnakeScaryAnimationController extends AnimationController{
    
    public SnakeScaryAnimationController(ObservableList<Node> snakeList, ObservableList<Node> elements) 
    {
        super(snakeList, elements);
        
        counter = new SnakeScaryCountersController(elementsHolder);
    }
    
    @Override
    protected void handleScoreCount()
    {
        super.handleScoreCount();
        
        if(((SnakeScaryCountersController) counter).getScoreCount()==20)
        {
            turnAllBlackAndFullScreen();
        }
        else if(((SnakeScaryCountersController) counter).getScoreCount()==40)
        {
            this.stop();
            UtilsImpl.popMessage("Are you sure of what you're doing??");
            this.start();
        }
    }

    private void turnAllBlackAndFullScreen() 
    {
        AnchorPane parent = (AnchorPane) ((Pane) elementsHolder.getElementsMap().get("paneSnake")).getParent();
        parent.setStyle("-fx-background-color: black;");
        
//        ((Stage) parent.getScene().getWindow()).setFullScreen(true);
    }
}
