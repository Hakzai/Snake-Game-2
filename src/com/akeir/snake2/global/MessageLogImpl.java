/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akeir.snake2.global;

import com.akeir.global.MessageLog;

/**
 *
 * @author Codeiro
 */
public class MessageLogImpl extends MessageLog{
    
    protected MessageLogImpl() { }
    
    public static final void SAVE_LONGEST_TIME()
    {
        System.err.print("Saving Longest Time...\n");
    }
    
    public static final void LOAD_LONGEST_TIME()
    {
        System.err.print("Loading Longest Time...\n");
    }
}
