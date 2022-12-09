package application;
	

import java.io.IOException;
import java.net.URL;

import application.controller.ControllerCadastroPartida;
import application.controller.ControllerFaseDeGrupos;
import application.controller.TelaInicio;
import application.controller.TelaPartida;
import application.controller.TelaTabelaDeGrupos;
import application.model.SelecaoPackage.SelecaoDaoImpl;
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
		URL xmlURL = getClass().getResource("/application/view/Partida/TelaPartidas.fxml");
		loader.setController(new TelaPartida());
		loader.setLocation(xmlURL);
		Parent parent = loader.load();
		Scene telaInicial = new Scene(parent);
		primaryStage.setScene(telaInicial); 
		primaryStage.show();
	}	


	public static void trocaDeTela(String endereco,Object controller, Object conteudo) throws IOException {
		FXMLLoader loaderFXML = new FXMLLoader(Main.class.getResource(endereco));
		if(controller != null) {
			loaderFXML.setController(controller);
		}
		Scene tela = new Scene(loaderFXML.load());
        stage.setScene(tela);
	}


	public static void main(String[] args) {
		launch(args);
	}
}