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

public class Game {
    int board[][] = new int[6][7];

    //Cria uma matriz 6 por 7 e consuante o jogador e a posição altera-se
    public int[][] boardTest(int player, int pos){
    int ocup = 5;
    int peca = 0;
         for (int l = 0; l < board.length; l++){
            for (int c = 0; c < board.length; c++){
                if(c == pos && peca == 0){
                    if(board[5][pos]==0){
                        board[5][pos] = player;
                        peca = 1; //Indicação de que já foi colocado
                      // Procura inserir a peça num espaço livre da mesma coluna
                    } else if(peca == 0) {
                        while(board[ocup][pos]!=0){
                            ocup--;
                        };
                        board[ocup][pos]=player;
                        peca = 1;
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
        int count;
        
        //checka colunas
        for (int y = 0; y < board.length; y++) {
            count = 0;
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x] == player) {
                    count++;
                }
            }
            if (count == 4) {
                return true;
            }
        }
        
        //checka linhas
        for (int x = 0; x < board[0].length; x++) {
            count = 0;
            for (int y = 0; y < board.length; y++) {
                if (board[y][x] == player) {
                    count++;
                }
            }
            if (count == 4) {
                return true;
            }
        }
        return false;

    }
}