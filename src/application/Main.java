package application;
	

import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.net.URL;

import application.controller.TelaCadastrarSelecao;
import application.controller.TelaInicio;
import application.controller.TelaMenuCadastros;
import application.controller.TelaMenuSelecao;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application { 
	
	private static Stage stage;
	private static Scene telaInicial; 
	private static Scene telaMenuCadastros;
	private static Scene telaMenuSelecoes;
	private static Scene telaCadastroSelecoes;
	private static Scene telaCadastrarSelecao;
	
	@Override
	public void start(Stage primaryStage) throws IOException { 
		stage = primaryStage;
		FXMLLoader loader = new FXMLLoader();
		URL xmlURL = getClass().getResource("/application/view/TelaInicio.fxml");
		loader.setController(new TelaInicio());
		loader.setLocation(xmlURL);
		Parent parent = loader.load();
		telaInicial = new Scene(parent);
		//
        //Controller controllerTelaInicial = loader.getController();
		primaryStage.setScene(telaInicial); 
		primaryStage.show();
	}	
	public static void trocaDeTela(String escolha,Object conteudo) throws IOException {

        switch (escolha){
            case "TelaInical":
                stage.setScene(telaInicial);
               break;
            
            case "TelaMenuCadastro":
                SelecaoDaoImpl selecaoDao =  (SelecaoDaoImpl) conteudo;
            	FXMLLoader fxmlLoaderTelaMenuCadastro = new FXMLLoader(Main.class.getResource("/application/view/TelaMenuCadastros.fxml"));
                fxmlLoaderTelaMenuCadastro.setController(new TelaMenuCadastros(selecaoDao));
                telaMenuCadastros = new Scene(fxmlLoaderTelaMenuCadastro.load());
                
                //Controller controllerTelaMenuCadastros = fxmlLoaderTelaMenuCadastro.getController();
                stage.setScene(telaMenuCadastros);
                break;
                
            case "TelaMenuSelecoes":
                selecaoDao =  (SelecaoDaoImpl) conteudo;
            	FXMLLoader fxmlLoaderTelaMenuSelecoes = new FXMLLoader(Main.class.getResource("/application/view/Selecao/TelaMenuSelecao.fxml"));
            	fxmlLoaderTelaMenuSelecoes.setController(new TelaMenuSelecao(selecaoDao));
                telaMenuSelecoes = new Scene(fxmlLoaderTelaMenuSelecoes.load());
                
                //Controller controllerTelaMenuCadastros = fxmlLoaderTelaMenuCadastro.getController();
                stage.setScene(telaMenuSelecoes);
                break;
            
            case "Tela cadastro selecoes":
                FXMLLoader fxmlLoaderTelaCadastroSelecoes = new FXMLLoader(Main.class.getResource("/application/view/TelaInicio.fxml"));
                telaCadastroSelecoes = new Scene(fxmlLoaderTelaCadastroSelecoes.load(), 600, 400);
                //fxmlLoaderTelaCadastroSelecoes.setController(new TelaInicio());
                //Controller controllerTelaCadastroSelecoes = fxmlLoaderTelaCadastroSelecoes.getController();
                stage.setScene(telaCadastroSelecoes);
                break;
           
            case "TelaCadastrarSelecao":
            	selecaoDao =  (SelecaoDaoImpl) conteudo;
            	FXMLLoader fxmlLoaderTelaCadastrarSelecao = new FXMLLoader(Main.class.getResource("/application/view/Selecao/TelaCadastrarSelecao.fxml"));
                fxmlLoaderTelaCadastrarSelecao.setController(new TelaCadastrarSelecao(selecaoDao));
                telaCadastrarSelecao= new Scene(fxmlLoaderTelaCadastrarSelecao.load());
                
                //Controller controllerTelaMenuCadastros = fxmlLoaderTelaMenuCadastro.getController();
                stage.setScene(telaCadastrarSelecao);
                break;
        }
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}