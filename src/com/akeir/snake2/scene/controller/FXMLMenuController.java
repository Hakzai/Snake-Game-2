/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akeir.snake2.scene.controller;

import com.akeir.controller.KeyController;
import com.akeir.snake2.global.GameMode;
import com.akeir.snake2.global.GlobalParamsImpl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Codeiro
 */
public class FXMLMenuController implements Initializable {
    
    private Pane root;
    private Stage menu;

    @FXML
    private AnchorPane apMenu;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lbSelectGame;

    @FXML
    private Label lbNormalGame;

    @FXML
    private Label lbGlitchGame;

    @FXML
    private Label lbTimerGame;

    @FXML
    private Label lbScaryGame;
    
    @FXML
    private Label lbScoreboard;
    
    @FXML
    void handleNormalGame(MouseEvent event) 
    {
        try 
        {
            root = FXMLLoader.load(getClass().getResource("/com/akeir/scene/view/FXMLSnakeGame.fxml"));
        } catch (IOException ex) {
            
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "EXCEPTION", "Error!", 0);
            return;
        }
        
        menu.hide();
        GlobalParamsImpl.GAME_MODE = GameMode.NORMAL;

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        scene.setOnKeyPressed(new KeyController());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setResizable(false);
        stage.setTitle("Akeir Snake Game");
        stage.setScene(scene);
        stage.showAndWait();
    }
    
    @FXML
    void handleGlitchGame(MouseEvent event) 
    {
        JOptionPane.showMessageDialog(null, "Not implemented yet... :(", "Error!", 1);
    }
    
    @FXML
    void handleTimerGame(MouseEvent event) 
    {
        try 
        {
            Pane parentRoot = FXMLLoader.load(getClass().getResource("/com/akeir/scene/view/FXMLSnakeGame.fxml"));
            
            root = FXMLLoader.load(getClass().getResource("/com/akeir/snake2/scene/view/FXMLTimerSnake.fxml"));
            root.getChildren();
            
        } catch (IOException ex) {
            
            Logger.getLogger(FXMLMenuController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "EXCEPTION", "Error!", 0);
            return;
        }
        
        menu.hide();
        GlobalParamsImpl.GAME_MODE = GameMode.NORMAL;

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        scene.setOnKeyPressed(new KeyController());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setResizable(false);
        stage.setTitle("Akeir Snake Game");
        stage.setScene(scene);
        stage.showAndWait();
    }
    
    @FXML
    void handleScaryGame(MouseEvent event) 
    {
        JOptionPane.showMessageDialog(null, "Not implemented yet... :(", "Error!", 1);
    }
    
    @FXML
    void handleScoreboard(MouseEvent event) 
    {
        JOptionPane.showMessageDialog(null, "Not implemented yet... :(", "Error!", 1);
    }
    
    @FXML
    void handleHighlight(MouseEvent event) 
    {
        ((Label) event.getSource()).setFont(Font.font("Kanit Bold", 24));
    }
    
    @FXML
    void handleLowlight(MouseEvent event) 
    {
        ((Label) event.getSource()).setFont(Font.font("Kanit Regular", 24));
    }
    
    @FXML
    void handleInitializeMenuVar(MouseEvent event) 
    {
        menu = (Stage) apMenu.getScene().getWindow();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

    }    
    
}
