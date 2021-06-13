package pkg4elcontrollers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pkg4el.game.Game;


public class ControllerGame implements Initializable{
    
    @FXML
    VBox painelJogo;
    FileChooser fileChooser = new FileChooser();
    
    @FXML public GridPane root;  
    
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
        Button posicao = (Button) event.getSource();
        String textButton = posicao.getText(); //get texto do botão
        int nButton = Integer.parseInt(textButton); //Numero do botão
            event.getSource();
            
            //Imprime os botões e faz disable a colunas cheias
            switch(nButton){
                case 0:
                    root.add(new Circle(200, 200, 25, activePlayerColor), nButton, pos1);                    
                    game.boardF(activePlayer, 0);
                    pos1-=1;
                    changeActivePlayer();
                    if (pos1<0){
                        posicao.setDisable(true);
                    }
                    break;
                    
                case 1:
                    root.add(new Circle(200, 200, 25, activePlayerColor), nButton, pos2);
                    game.boardF(activePlayer, 1);
                    pos2-=1;
                    changeActivePlayer();
                    if (pos2<0){
                        posicao.setDisable(true);
                    }
                    break;
                    
                case 2:
                    root.add(new Circle(200, 200, 25, activePlayerColor), nButton, pos3);
                    game.boardF(activePlayer, 2);
                    pos3-=1;
                    changeActivePlayer();
                    if (pos3<0){
                        posicao.setDisable(true);
                    }
                    break;
                    
                case 3:
                    root.add(new Circle(200, 200, 25, activePlayerColor), nButton, pos4);
                    game.boardF(activePlayer, 3);
                    pos4-=1;
                    changeActivePlayer();
                    if (pos4<0){
                        posicao.setDisable(true);
                    }
                    break;
                    
                case 4:
                    root.add(new Circle(200, 200, 25, activePlayerColor), nButton, pos5);
                    game.boardF(activePlayer, 4);
                    pos5-=1;
                    changeActivePlayer();
                    if (pos5<0){
                        posicao.setDisable(true);
                    }
                    break;
                     
                case 5:
                    root.add(new Circle(200, 200, 25, activePlayerColor), nButton, pos6);
                    game.boardF(activePlayer, 5);
                    pos6-=1;
                    changeActivePlayer();
                    if (pos6<0){
                        posicao.setDisable(true);
                    }
                    break;
                     
                case 6:
                    root.add(new Circle(200, 200, 25, activePlayerColor), nButton, pos7);
                    game.boardF(activePlayer, 6);
                    pos7-=1;
                    changeActivePlayer();
                    if (pos7<0){
                        posicao.setDisable(true);
                    }
                    break;
                }
            }
    
    @FXML 
    private Label pactive;
    //Troca de jogador de forma alternada
    public void changeActivePlayer() {
        if (game.winner(activePlayer)){
            pactive.setText("Jogador " + activePlayer + " ganhou!");
        } else if (activePlayer == player1) {
            activePlayer = player2;
            activePlayerColor = player2Color;
            pactive.setText("Jogador 2");
        } else {
            activePlayer = player1;
            activePlayerColor = player1Color;
            pactive.setText("Jogador 1");
        }
    }

    //Volta a trás no programa
    public void back(ActionEvent event) throws IOException{
        game.saveFile();
        Parent rules = FXMLLoader.load(getClass().getResource("/pkg4elcontrollers/ViewMain.fxml"));
        Scene ruleScene = new Scene(rules, 650,600);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(ruleScene);
        stage.setTitle("4el");
        stage.show();
    }

    //Sai do programa
    public Button exit;
    public void exit(ActionEvent event) {
    game.saveFile();
    Stage stage = (Stage) exit.getScene().getWindow();
    stage.close();
    }
    
    public void initialize(URL location, ResourceBundle arg1) {
    }
 
}
