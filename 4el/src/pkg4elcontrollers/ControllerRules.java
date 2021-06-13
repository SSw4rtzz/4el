package pkg4elcontrollers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class ControllerRules {
    
    public void back(ActionEvent event) throws IOException{
        Parent rules = FXMLLoader.load(getClass().getResource("/pkg4elcontrollers/ViewMain.fxml"));
        Scene ruleScene = new Scene(rules, 650,500);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(ruleScene);
        stage.setTitle("4el");
        stage.show();
    }

    //Começa jogo
    public void play(ActionEvent event) throws IOException{
        Parent game = FXMLLoader.load(getClass().getResource("/pkg4elcontrollers/ViewGame.fxml"));
        Scene gameScene = new Scene(game, 650,500);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(gameScene);
        stage.setTitle("Jogar");
        stage.show();
    }
}
