package application;
	

import java.io.IOException;
import java.lang.ModuleLayer.Controller;
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
		URL xmlURL = getClass().getResource("/application/view/TelaInicio.fxml");
		loader.setLocation(xmlURL);
		Parent parent = loader.load();
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene); 
		primaryStage.show();
	}	

	public static void trocaDeTela(String endereco,Object conteudo) throws IOException {
		FXMLLoader loaderFXML = new FXMLLoader(Main.class.getResource(endereco));
        Scene tela = new Scene(loaderFXML.load());
        //fxmlLoaderTelaSelecoes.setController(new TelaInicio());
        //Controller controllerTelaInicio = fxmlLoaderTelaSelecoes.getController();
        stage.setScene(tela);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}