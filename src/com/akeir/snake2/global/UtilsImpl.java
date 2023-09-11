/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akeir.snake2.global;

import com.akeir.global.MessageLog;
import com.akeir.helper.Utils;

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
}
