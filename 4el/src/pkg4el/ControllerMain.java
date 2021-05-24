/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4el;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author rubensw4rtz
 */
public class ControllerMain {
    public void jogar(){
        System.out.println("Jogar");
    }
    
    public void acerca(){
        System.out.println("Acerca");

    }
    

    //Muda de cena, neste caso mostra as regras
    public void regras(ActionEvent event) throws IOException{
        Parent rules = FXMLLoader.load(getClass().getResource("ViewRules.fxml"));
        Scene ruleScene = new Scene(rules, 600,400);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(ruleScene);
        stage.setTitle("Regras");
        stage.show();
    }
    
    public void creditos(){
        System.out.println("Creditos");
    }
    
    //Sai do programa - ** Poderia ficar também Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); ** Para decidir ainda
    public Button exit;
    public void exit(ActionEvent event) {
    Stage stage = (Stage) exit.getScene().getWindow();
    stage.close();
    }
}
