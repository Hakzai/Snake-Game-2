/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akeir.snake2.controller;

import com.akeir.controller.CountersController;
import com.akeir.helper.ElementsHolder;
import com.akeir.resources.controllers.SoundController;
import com.akeir.snake2.global.ConstantsImpl;
import com.akeir.snake2.global.UtilsImpl;

/**
 *
 * @author Codeiro
 */
public class SnakeScaryCountersController extends CountersController {
    
    public SnakeScaryCountersController(ElementsHolder elements) 
    {
        super(elements);
    }
    
    @Override
    public void checkToIncreaseSpeed()
    {
        if(score%ConstantsImpl.SNAKE_SCARY_POINTS_INCREASE_SPEED==ConstantsImpl.ZERO_AS_INTEGER)
        {
            increaseSpeed();
            SoundController.play().snakeSpeedsUp();
        }
    }
    
    public int getScoreCount()
    {
        return UtilsImpl.stringToInt(lbScoreCount.getText());
    }
}
