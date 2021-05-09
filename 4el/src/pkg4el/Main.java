/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4el;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author rubensw4rtz
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
            Button btn1 = new Button("Olá mundinho");
            StackPane root = new StackPane();
            root.getChildren().add(btn1);
            Scene scene = new Scene(root, 600,400);
            stage.setScene(scene);
            stage.setTitle("Teste");
            stage.show();
        }
    
    public static void main(String[] args){
        launch(args);
    }
    
}
