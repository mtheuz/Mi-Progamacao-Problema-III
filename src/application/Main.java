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
	private static Scene telaInicial; 
	private static Scene telaSelecoes;
	private static Scene telaCadastroSelecoes;
	
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
	
	public static void trocaDeTela(String escolha,Object conteudo) throws IOException {

        switch (escolha){
            case "Tela inical":
                stage.setScene(telaInicial);
               break;
            case "Tela selecoes":
                FXMLLoader fxmlLoaderTelaSelecoes = new FXMLLoader(Main.class.getResource("/application/view/TelaInicio.fxml"));
                telaSelecoes = new Scene(fxmlLoaderTelaSelecoes.load(), 600, 400);
                fxmlLoaderTelaSelecoes.setController(new TelaInicio());
                Controller controllerTelaInicio = fxmlLoaderTelaSelecoes.getController();
                stage.setScene(telaSelecoes);
                break;
                
            case "Tela cadastro selecoes":
                FXMLLoader fxmlLoaderTelaCadastroSelecoes = new FXMLLoader(Main.class.getResource("/application/view/TelaInicio.fxml"));
                telaCadastroSelecoes = new Scene(fxmlLoaderTelaCadastroSelecoes.load(), 600, 400);
                fxmlLoaderTelaCadastroSelecoes.setController(new TelaInicio());
                Controller controllerTelaCadastroSelecoes = fxmlLoaderTelaCadastroSelecoes.getController();
                stage.setScene(telaCadastroSelecoes);
                break;
        }
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}