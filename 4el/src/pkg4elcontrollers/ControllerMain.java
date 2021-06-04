/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4elcontrollers;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class ControllerMain {

    //Começa jogo
    public void play(ActionEvent event) throws IOException{
        Parent game = FXMLLoader.load(getClass().getResource("/pkg4elcontrollers/ViewGame.fxml"));
        Scene gameScene = new Scene(game, 900,600);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(gameScene);
        stage.setTitle("Jogar");
        stage.show();
    }
    
    public void about(){
        System.out.println("Acerca");

    }
    
    //Muda de cena para mostrar as regras
    public void rules(ActionEvent event) throws IOException{
        Parent rules = FXMLLoader.load(getClass().getResource("/pkg4elcontrollers/ViewRules.fxml"));
       
        Scene ruleScene = new Scene(rules, 900,600);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(ruleScene);
        stage.setTitle("Regras");
        stage.show();
    }
    
    public void credits(){
        System.out.println("Creditos");
        
    }
    
    //Sai do programa - ** Poderia ficar também Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); ** Para decidir ainda
    public Button exit;
    public void exit(ActionEvent event) {
    Stage stage = (Stage) exit.getScene().getWindow();
    stage.close();
    }
}
