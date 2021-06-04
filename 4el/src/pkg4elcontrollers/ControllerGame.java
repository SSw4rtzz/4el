package pkg4elcontrollers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pkg4el.game.Game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class ControllerGame implements Initializable{
    private int currentBoard = 0 ;
    private String a = "Teste";
    
    @FXML
    private ImageView pl1 = new ImageView(("/pkg4el/assets/peca_azul.png"));
    private BooleanProperty pecavisivel = new SimpleBooleanProperty(false);
    

    
    
    Game game = new Game();
    
    

    
    //Muda o texto da label ao carregar no botão mostrar
    @FXML Button mostra;
    @FXML
    void button_action(ActionEvent event){
        if(pecavisivel.get()){
            pecavisivel.set(false);
        } else {
            pecavisivel.set(true);
        }
        
        
    }
    
    
    //Funções para alterar a matriz em relação ao jogo
    public void test0(){
        game.boardTest(1, 0);
        System.out.println("Acerca");
    }
    
    public void test1(){
        game.boardTest(1, 1);
        System.out.println("Acerca");
    }
    
    public void test2(){
        game.boardTest(1, 2);
        System.out.println("Acerca");
    }
    
    public void test3(){
        game.boardTest(1, 3);
        System.out.println("Acerca");
    }
    
    public void test4(){
        game.boardTest(1, 4);
        System.out.println("Acerca");
    }

    //Sai do programa
    public Button exit;
    public void exit(ActionEvent event) {
    Stage stage = (Stage) exit.getScene().getWindow();
    stage.close();
    }
    
    public void initialize(URL location, ResourceBundle arg1) {
        pl1.visibleProperty().bind(pecavisivel);
    }
}
