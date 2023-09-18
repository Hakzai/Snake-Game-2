/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akeir.snake2.resources;

import com.akeir.resources.ResourcesConstants;

/**
 *
 * @author Codeiro
 */
public class ResourcesConstantsImpl extends ResourcesConstants {
    
    protected ResourcesConstantsImpl() { }
    
    public static final String LONGEST_TIME_FILE_STRING = "Longest Time: ";
    public static final String LONGEST_TIME_FILE_PATH = System.getenv("AppData") +"\\SnakeSaveTimer.txt";
}
