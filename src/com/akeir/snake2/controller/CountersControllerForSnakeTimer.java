/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akeir.snake2.controller;

import com.akeir.controller.CountersController;
import com.akeir.global.Constants;
import com.akeir.helper.ElementsHolder;
import javafx.scene.control.Label;

/**
 *
 * @author Codeiro
 */
public class CountersControllerForSnakeTimer extends CountersController {
    
    public CountersControllerForSnakeTimer(ElementsHolder elements) 
    {
        super(elements);
    }
    
    protected double timeCount = Constants.ZERO_AS_INTEGER;
    protected double totalTimeCount = Constants.ZERO_AS_INTEGER;
    protected double longestTimeCount = Constants.ZERO_AS_INTEGER;
    
    protected Label lbTimeCount;
    protected Label lbTotalTimeCount;
    protected Label lbLongestTimeCount;
    
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
        mapResultsToTimeCounters();
    }

    protected void mapTimeCountersToDouble() 
    {
        
    }

    protected void mapResultsToTimeCounters() 
    {
        
    }
    
    
    
}
