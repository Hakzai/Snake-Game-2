/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akeir.snake2.controller;

import com.akeir.global.Constants;
import com.akeir.global.MessageLog;
import com.akeir.resources.controllers.FileController;
import com.akeir.snake2.global.MessageLogImpl;
import com.akeir.snake2.resources.ResourcesConstantsImpl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Codeiro
 */
public class SnakeTimerFileController{
    
    protected SnakeTimerFileController() { }
    
    protected static SnakeTimerFileController instance;
    
    public static SnakeTimerFileController get()
    {
        if(null == instance)
        {
            instance = new SnakeTimerFileController();
        }
        
        return instance;
    }
    
    public void saveLongestTime(String longestTime)
    {
        MessageLogImpl.SAVE_LONGEST_TIME();
        
        try 
        {
            FileWriter file = new FileWriter(ResourcesConstantsImpl.LONGEST_TIME_FILE_PATH);
            PrintWriter writeFile = new PrintWriter(file);

            writeFile.printf(ResourcesConstantsImpl.LONGEST_TIME_FILE_STRING + longestTime);
            
            file.close();
            
        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public String loadLongestTime()
   {
        MessageLogImpl.LOAD_LONGEST_TIME();
        String currentLongestTime = Constants.ZERO_AS_NUMBER;
        
        try
        {
            BufferedReader fileRead = new BufferedReader(new FileReader(ResourcesConstantsImpl.LONGEST_TIME_FILE_PATH));
            
            List<Object> linesList = Arrays.asList(fileRead.lines().toArray());
            String lastLine = String.valueOf(linesList.get(linesList.size()-1));
            currentLongestTime = lastLine.substring(ResourcesConstantsImpl.LONGEST_TIME_FILE_STRING.length());
            
            fileRead.close();
            
        } catch (IOException ex) {
            if(ex instanceof FileNotFoundException)
            {
                MessageLogImpl.FILE_NOT_FOUND_ERROR();
                saveLongestTime("0.0 sec");
                return loadLongestTime();
            }
            else
            {
            	MessageLogImpl.FILE_READ_ERROR();
            	MessageLogImpl.EXCEPTION(ex);
            }

            return currentLongestTime;
        }

        return currentLongestTime;
   }
}
