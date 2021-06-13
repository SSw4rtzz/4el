/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                                                 *
 *                 444444444                     lllllll           *
 *                4::::::::4                     l:::::l           *
 *               4:::::::::4                     l:::::l           *
 *              4::::44::::4                     l:::::l           *
 *             4::::4 4::::4      eeeeeeeeeeee    l::::l           *
 *            4::::4  4::::4    ee::::::::::::ee  l::::l           *
 *           4::::4   4::::4   e::::::eeeee:::::eel::::l           *
 *          4::::444444::::444e::::::e     e:::::el::::l           *
 *          4::::::::::::::::4e:::::::eeeee::::::el::::l           *
 *          4444444444:::::444e:::::::::::::::::e l::::l           *
 *                    4::::4  e::::::eeeeeeeeeee  l::::l           *
 *                    4::::4  e:::::::e           l::::l           *
 *                    4::::4  e::::::::e         l::::::l          *
 *                  44::::::44 e::::::::eeeeeeee l::::::l          *
 *                  4::::::::4  ee:::::::::::::e l::::::l          *
 *                  4444444444    eeeeeeeeeeeeee llllllll          *
 *             @author Ruben Anastácio & Tiago Carvalho            *
 *                                                                 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


package pkg4el.game;
import java.io.IOException;
import java.io.PrintWriter;
import pkg4elcontrollers.ControllerGame;

public class Game {
    public int board[][] = new int[6][7];
    ControllerGame controllerGame;
    private int activePlayer = 0;

    //Cria uma matriz 6 por 7 e consoante o jogador e a posição altera-se
    public int[][] boardF(int player, int pos){
    int ocup = 5;
    int peca = 0;
         for (int l = 0; l < board.length; l++){
            for (int c = 0; c < board[l].length; c++){
                if(c == pos && peca == 0){
                    try{
                    if(board[5][pos]==0){
                        board[5][pos] = player;
                        peca = 1; //Indicação de que já foi colocado não volta a entrar nestes ciclos e imprime apenas a board
                      // Procura inserir a peça num espaço livre da mesma coluna
                    } else if(peca == 0) {
                        while(board[ocup][pos]!=0){
                            ocup--;
                        };
                        board[ocup][pos]=player;
                        peca = 1;
                    }
                    } catch(ArrayIndexOutOfBoundsException exception){
                        break;
                    }
                }
            System.out.print(board[l][c] + " "); //imprime caracter a caracter  
            }
           System.out.println(" ");
        }
         return board;
    }


//Determina quando e que jogador ganhou
public boolean winner(int player) {
        //checka colunas
        for (int l = 0; l < board.length; l++) {
            for (int c = 0; c < board[l].length; c++) {
                try{
                if (board[l][c] == player && board[l][c+1] == player && board[l][c+2] == player && board[l][c+3] == player) {
                        return true;
                }
                } catch(ArrayIndexOutOfBoundsException exception){
                    break;
                }
            }
        }
        //checka linhas
        for (int c = 0; c < board.length; c++) {
            for (int l = 0; l < board.length; l++) {
                try{
                    if (board[l][c] == player && board[l-1][c] == player && board[l-2][c] == player && board[l-3][c] == player) {
                        return true;
                    }
                } catch(ArrayIndexOutOfBoundsException exception){
                    break;
                }
               
            }
        }
        //checka diagonal Direita
        for (int c = 0; c < board.length; c++) {
            for (int l = 0; l < board.length; l++) {
                try{
                    if (board[l][c] == player && board[l-1][c+1] == player && board[l-2][c+2] == player && board[l-3][c+3] == player) {
                         return true;
                     }
                } catch(ArrayIndexOutOfBoundsException exception){
                        break;
                    }
            }
        }
        //checka diagonal Esquerda
        for (int c = 0; c < board.length; c++) {
            for (int l = 0; l < board.length; l++) {
               try{
                    if (board[l][c] == player && board[l-1][c-1] == player && board[l-2][c-2] == player && board[l-3][c-3] == player) {
                        return true;
                    }
                } catch(ArrayIndexOutOfBoundsException exception){
                    break;
                }
            }
        }
        return false;
    }

    //Guarda a matriz do jogo atual num ficheiro Jogo.txt
    public void saveFile() {
        try{
            PrintWriter writer = new PrintWriter("Jogo.txt", "UTF-8");
            for (int l = board.length-1; l >= 0; l--) {
                for (int c = 0; c < board[l].length; c++) {
                    writer.print(board[l][c] + " ");
                }
                writer.println(" ");
            }  
            writer.close();
        } catch(IOException ex) {
            System.out.print("Erro ao gravar o jogo");
        }
    }
}