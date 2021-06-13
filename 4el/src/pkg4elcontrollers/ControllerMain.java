
package pkg4elcontrollers;

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
        Scene gameScene = new Scene(game, 650,600);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(gameScene);
        stage.setTitle("Jogar");
        stage.show();
    }
   
    //Carrega jogo guardado
    public void playLoad(ActionEvent event) throws IOException{
        Parent game = FXMLLoader.load(getClass().getResource("/pkg4elcontrollers/ViewGameLoad.fxml"));
        Scene gameScene = new Scene(game, 650,600);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(gameScene);
        stage.setTitle("Jogar");
        stage.show();
    }
    
    //Muda de cena para mostrar as regras
    public void rules(ActionEvent event) throws IOException{
        Parent rules = FXMLLoader.load(getClass().getResource("/pkg4elcontrollers/ViewRules.fxml"));
        Scene ruleScene = new Scene(rules, 650,600);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(ruleScene);
        stage.setTitle("Regras");
        stage.show();
    }
    
    public void about(ActionEvent event) throws IOException{
        Parent rules = FXMLLoader.load(getClass().getResource("/pkg4elcontrollers/ViewAbout.fxml"));
        Scene ruleScene = new Scene(rules, 650,600);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(ruleScene);
        stage.setTitle("Acerca");
        stage.show();
    }
    
    //Sai do programa
    public Button exit;
    public void exit(ActionEvent event) {
    Stage stage = (Stage) exit.getScene().getWindow();
    stage.close();
    }
}
