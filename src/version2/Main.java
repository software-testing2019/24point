package src.version2;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		  try {
	            // Read file fxml and draw interface.
	            Parent root = FXMLLoader.load(getClass()
	                    .getResource("version2Gui.fxml"));

	            primaryStage.setTitle("24-point Game");
	            primaryStage.setScene(new Scene(root));
	            primaryStage.show(); 

	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
