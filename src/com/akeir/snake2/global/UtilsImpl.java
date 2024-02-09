/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akeir.snake2.global;

import com.akeir.global.MessageLog;
import com.akeir.helper.Utils;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

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

    public static void popMessage(String msg) 
    {
        Pane root = new AnchorPane();
        Scene alert = new Scene(root);
        alert.setRoot(root);
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.setScene(alert);
        
        root.setPrefWidth(50.0);
        root.setPrefHeight(50.0);
        
        Label lbMessage = new Label(msg);
        lbMessage.setLayoutX(25.0);
        lbMessage.setLayoutY(25.0);
        root.getChildren().add(lbMessage);
        
        stage.centerOnScreen();
        stage.showAndWait();
    }
}
