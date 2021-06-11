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

package pkg4el;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
            //Chama o ficheiro do cenário e cria o cenário
            Parent main = FXMLLoader.load(getClass().getResource("/pkg4elcontrollers/ViewMain.fxml"));
            Scene mainScene = new Scene(main, 900,600);
            stage.setScene(mainScene);
            stage.setTitle("4el");
            stage.show();
        }
    
    public static void main(String[] args){
        launch(args);    
    }
}
