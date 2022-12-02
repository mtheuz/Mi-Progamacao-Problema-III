package application.controller;

import java.awt.Menu;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.JogadorPackage.JogadorDaoImpl;
import application.model.SelecaoPackage.SelecaoDAO;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TelaInicio{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btnCadastrarSelecoes;

    @FXML
    private Button btnAbrirMenuSelecao;
    
    @FXML
    private Button btnCarregarPreSet;
    
    @FXML
    private Label label;
    
    private int num;
   

    SelecaoDaoImpl selecaoDao = new SelecaoDaoImpl();
    //JogadorDaoImpl jogadorDao = new JogadorDaoImpl(selecaoDao.getListaSelecoes());
    
    @FXML
    void btnCarregarPreSetAction(ActionEvent event) throws IOException {

    	selecaoDao.leArquivoSelecoes();
    	//jogadorDao.transformaEmMap();
    	label.setText("Pré Set Carregado com sucesso");
    	
    }
    @FXML
    void btnAbrirTelaSelecaoAction(ActionEvent event) throws IOException {
    	Main.trocaDeTela("/application/view/Jogador/TelaMenuJogador.fxml", null);
    	System.out.println(num);
    }
    
    @FXML
    void initialize() {
        assert btnCadastrarSelecoes != null : "fx:id=\"btnCadastrarSelecoes\" was not injected: check your FXML file 'TelaInicio.fxml'.";
        assert btnCarregarPreSet != null : "fx:id=\"btnCarregarPreSet\" was not injected: check your FXML file 'TelaInicio.fxml'.";
        
    }
}
