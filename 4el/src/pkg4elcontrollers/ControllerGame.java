package pkg4elcontrollers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import pkg4el.game.Game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class ControllerGame implements Initializable{
    
    @FXML private GridPane root;    
    
    Game game = new Game();
    int pos1=5; int pos2=5; int pos3=5; int pos4=5; int pos5=5; int pos6=5; int pos7=5; //Posição de jogo
    
    Paint player1Color = Color.BLUE;
    Paint player2Color = Color.RED;
    Paint activePlayerColor = player1Color;
    int player1 = 1; int player2 = 2;
    int activePlayer = player1;
    
    @FXML
    //Insere as pecas no grid consoante o numero presente no text do botão
    void inserirPecas(ActionEvent event) {
        Button p1 = (Button) event.getSource();
        String textButton = p1.getText(); //get texto do botão
        int nButton = Integer.parseInt(textButton); //Numero do botão
            event.getSource();
            
            //Imprime os botões
            switch(nButton){
                case 0:
                   
                    root.add(new Circle(200, 200, 25, activePlayerColor), nButton, pos1);                    
                    game.boardTest(activePlayer, 0);
                    pos1-=1;
                    changeActivePlayer();
                    break;
                     
                case 1:
                   
                    root.add(new Circle(200, 200, 25, activePlayerColor), nButton, pos2);
                    game.boardTest(activePlayer, 1);
                    pos2-=1;
                    changeActivePlayer();
                    break;
                    
                case 2:
                    
                    root.add(new Circle(200, 200, 25, activePlayerColor), nButton, pos3);
                    game.boardTest(activePlayer, 2);
                    pos3-=1;
                    changeActivePlayer();
                    break;
                    
                case 3:
                   
                    root.add(new Circle(200, 200, 25, activePlayerColor), nButton, pos4);
                    game.boardTest(activePlayer, 3);
                    pos4-=1;
                    changeActivePlayer();
                    break;
                    
                case 4:
                    
                    root.add(new Circle(200, 200, 25, activePlayerColor), nButton, pos5);
                    game.boardTest(activePlayer, 4);
                    pos5-=1;
                    changeActivePlayer();
                    break;
                     
                case 5:
                    
                    root.add(new Circle(200, 200, 25, activePlayerColor), nButton, pos6);
                    game.boardTest(activePlayer, 5);
                    pos6-=1;
                    changeActivePlayer();
                    break;
                     
                case 6:
                    
                        root.add(new Circle(200, 200, 25, activePlayerColor), nButton, pos7);
                        game.boardTest(activePlayer, 6);
                        pos7-=1;
                        changeActivePlayer();
                        break;
                        
                    }
                }
    
    //Para colocar depois noutra Class
    

    //Troca de jogador de forma alternada
    public void changeActivePlayer() {
        if (game.winner(activePlayer)){
            System.out.print("Jogador " + activePlayer + " ganhou!");
        } else if (activePlayer == player1) {
            activePlayer = player2;
            activePlayerColor = player2Color;
        } else {
            activePlayer = player1;
            activePlayerColor = player1Color;
        }
    }
    

    //Sai do programa
    public Button exit;
    public void exit(ActionEvent event) {
    Stage stage = (Stage) exit.getScene().getWindow();
    stage.close();
    }
    
    public void initialize(URL location, ResourceBundle arg1) {}
 
}
