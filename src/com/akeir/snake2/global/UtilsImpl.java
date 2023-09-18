/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akeir.snake2.global;

import com.akeir.global.MessageLog;
import com.akeir.helper.Utils;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Codeiro
 */
public class UtilsImpl extends Utils {
    
    public static final double stringToDouble(String number)
    {
        double result;
        
        try
        {
            result = Double.parseDouble(number);
        } catch (NumberFormatException e) {
            MessageLog.EXCEPTION(e);
            return -1;
        }
        
        return result;
    }
    
    public static final void labelStyleCopy(Label srcLabel, Label tgtLabel)
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
