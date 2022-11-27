package application;
	

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application { 
	
	
	
	@Override
	public void start(Stage primaryStage) throws IOException { 

		FXMLLoader loader = new FXMLLoader();
		URL xmlURL = getClass().getResource("/application/view/TelaInicio.fxml");
		loader.setLocation(xmlURL);
		
		Parent parent = loader.load();
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}