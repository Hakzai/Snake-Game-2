/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akeir.snake2.scene.fxml;

import com.akeir.controller.KeyController;
import com.akeir.helper.Utils;
import com.akeir.scene.controller.SnakeGameController;
import com.akeir.snake2.global.GameMode;
import com.akeir.snake2.global.GlobalParamsImpl;
import com.akeir.snake2.scene.controller.SnakeTimerController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
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
    private Scene scene;

    private Stage menu;
    
    private KeyController keyboardActions = new KeyController();

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
        root = new SnakeGameController();
        GlobalParamsImpl.GAME_MODE = GameMode.NORMAL;
        
        startGame();
    }
    
    @FXML
    void handleGlitchGame(MouseEvent event) 
    {
        JOptionPane.showMessageDialog(null, "Not implemented yet... :(", "Error!", 1);
    }
    
    @FXML
    void handleTimerGame(MouseEvent event) 
    {
        root = new SnakeTimerController();
        GlobalParamsImpl.GAME_MODE = GameMode.TIMER;
        
        startGame();
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
        ((Label) event.getSource()).setFont(Font.loadFont(getClass().getResource("/com/akeir/snake2/resources/fonts/Kanit-Bold.ttf").toExternalForm(), 24.0));
    }
    
    @FXML
    void handleLowlight(MouseEvent event) 
    {
        ((Label) event.getSource()).setFont(Font.loadFont(getClass().getResource("/com/akeir/snake2/resources/fonts/Kanit-Regular.ttf").toExternalForm(), 24.0));
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
        lbSelectGame.setFont(Font.loadFont(getClass().getResource("/com/akeir/snake2/resources/fonts/Bug2K.ttf").toExternalForm(), 48.0));
    }    
    
    private void startGame()
    {
        menu.hide();
        
        if(null == scene)
        {
            scene = new Scene(root);
        }
        scene.setRoot(root);
        
        Stage stage = new Stage();
        
        scene.setOnKeyPressed(keyboardActions);
        scene.setOnKeyReleased(keyboardActions);
        stage.setOnCloseRequest(event -> {
            System.out.println("Message exit");
            Utils.DO_CRASH();
        });
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setResizable(false);
        stage.setTitle("Akeir Snake Game");
        stage.setScene(scene);
        stage.showAndWait();
    }
}
