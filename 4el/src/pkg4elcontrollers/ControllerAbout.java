package pkg4elcontrollers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerAbout {
    public void back(ActionEvent event) throws IOException{
        Parent rules = FXMLLoader.load(getClass().getResource("/pkg4elcontrollers/ViewMain.fxml"));
        Scene ruleScene = new Scene(rules, 650,500);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(ruleScene);
        stage.setTitle("4el");
        stage.show();
    }
}
