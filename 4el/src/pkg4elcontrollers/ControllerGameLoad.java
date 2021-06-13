package pkg4elcontrollers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
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


public class ControllerGameLoad implements Initializable{
    
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
                    game.boardTest(activePlayer, 0);
                    pos1-=1;
                    changeActivePlayer();
                    if (pos1<0){
                        posicao.setDisable(true);
                    }
                    break;
                    
                case 1:
                    root.add(new Circle(200, 200, 25, activePlayerColor), nButton, pos2);
                    game.boardTest(activePlayer, 1);
                    pos2-=1;
                    changeActivePlayer();
                    if (pos2<0){
                        posicao.setDisable(true);
                    }
                    break;
                    
                case 2:
                    root.add(new Circle(200, 200, 25, activePlayerColor), nButton, pos3);
                    game.boardTest(activePlayer, 2);
                    pos3-=1;
                    changeActivePlayer();
                    if (pos3<0){
                        posicao.setDisable(true);
                    }
                    break;
                    
                case 3:
                    root.add(new Circle(200, 200, 25, activePlayerColor), nButton, pos4);
                    game.boardTest(activePlayer, 3);
                    pos4-=1;
                    changeActivePlayer();
                    if (pos4<0){
                        posicao.setDisable(true);
                    }
                    break;
                    
                case 4:
                    root.add(new Circle(200, 200, 25, activePlayerColor), nButton, pos5);
                    game.boardTest(activePlayer, 4);
                    pos5-=1;
                    changeActivePlayer();
                    if (pos5<0){
                        posicao.setDisable(true);
                    }
                    break;
                     
                case 5:
                    root.add(new Circle(200, 200, 25, activePlayerColor), nButton, pos6);
                    game.boardTest(activePlayer, 5);
                    pos6-=1;
                    changeActivePlayer();
                    if (pos6<0){
                        posicao.setDisable(true);
                    }
                    break;
                     
                case 6:
                    root.add(new Circle(200, 200, 25, activePlayerColor), nButton, pos7);
                    game.boardTest(activePlayer, 6);
                    pos7-=1;
                    changeActivePlayer();
                    if (pos7<0){
                        posicao.setDisable(true);
                    }
                    break;
                }
            }
    
    //Para colocar depois noutra Class
    
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
        int countPlayer1 = 0; int countPlayer2 = 0;
        try (Scanner scanner = new Scanner(new File("Jogo.txt"))) {
            while (scanner.hasNext()){
                for (int l = 0; l < 6; l++) {
                    for (int c = 0; c < 7; c++) {
                        var h = scanner.nextInt();
                        System.out.print(h + " ");
                        activePlayer = h;

                        if (activePlayer == 1){
                            activePlayerColor = Color.BLUE;
                            countPlayer1++;
                        } else if(activePlayer == 2){
                            activePlayerColor = Color.RED;
                            countPlayer2++;
                        }

                        if(h != 0){
                           switch(c){
                            case 0:
                                root.add(new Circle(200, 200, 25, activePlayerColor), 0, pos1);                    
                                game.boardTest(activePlayer, 0);
                                pos1-=1;
                                break;

                            case 1:
                                root.add(new Circle(200, 200, 25, activePlayerColor), 1, pos2);
                                game.boardTest(activePlayer, 1);
                                pos2-=1;
                                break;

                            case 2:
                                root.add(new Circle(200, 200, 25, activePlayerColor), 2, pos3);
                                game.boardTest(activePlayer, 2);
                                pos3-=1;
                                break;

                            case 3:
                                root.add(new Circle(200, 200, 25, activePlayerColor), c, pos4);
                                game.boardTest(activePlayer, 3);
                                pos4-=1;
                                changeActivePlayer();
                                break;

                            case 4:
                                root.add(new Circle(200, 200, 25, activePlayerColor), c, pos5);
                                game.boardTest(activePlayer, 4);
                                pos5-=1;
                                changeActivePlayer();

                                break;

                            case 5:
                                root.add(new Circle(200, 200, 25, activePlayerColor), c, pos6);
                                game.boardTest(activePlayer, 5);
                                pos6-=1;
                                changeActivePlayer();

                                break;

                            case 6:
                                root.add(new Circle(200, 200, 25, activePlayerColor), c, pos7);
                                game.boardTest(activePlayer, 6);
                                pos7-=1;
                                changeActivePlayer();

                                break;
                            }
                        }
                    }
                    System.out.println(" ");
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        if(countPlayer1<=countPlayer2){
            System.out.println(countPlayer1 + " - " + countPlayer2);
                activePlayer = 1;
                activePlayerColor = Color.BLUE;
            } else {
                activePlayer = 2;
                activePlayerColor = Color.RED;
            }
    }
 
}
