package application;
	

import java.io.IOException;
import java.net.URL;
import application.controller.TelaInicio;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application { 
	
	private static Stage stage;

	@Override
	public void start(Stage primaryStage) throws IOException { 
		stage = primaryStage;
		FXMLLoader loader = new FXMLLoader();
		URL xmlURL = getClass().getResource("/application/view/Jogador/TelaCadastrarJogador.fxml");
		loader.setLocation(xmlURL);
		loader.setController(new TelaInicio());
		Parent parent = loader.load();
		Scene telaInicial = new Scene(parent);
		primaryStage.setScene(telaInicial); 
		primaryStage.show();
	}	

	public static void trocaDeTela(String endereco,Object controller) throws IOException {
		FXMLLoader loaderFXML = new FXMLLoader(Main.class.getResource(endereco));
        Scene tela = new Scene(loaderFXML.load());
        loaderFXML.setController(controller);
        stage.setScene(tela);
	}

	public static void main(String[] args) {
		launch(args);
	}
}