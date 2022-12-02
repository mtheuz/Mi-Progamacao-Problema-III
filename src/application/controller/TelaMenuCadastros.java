package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.model.SelecaoPackage.Selecao;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TelaMenuCadastros {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAbrirMenuArbitros;

    @FXML
    private Button btnAbrirMenuSelecao;

    @FXML
    private Button btnAbrirMenuTecnicos;

    @FXML
    private Button btnAbrrMenuJogadores;

    @FXML
    private Button btnVoltar;
    
    private SelecaoDaoImpl selecaoDao;
    
    private ArrayList <Selecao> listaSelecoes;
    
   
    public TelaMenuCadastros(SelecaoDaoImpl selecaoDao) {
    	this.selecaoDao = selecaoDao;
    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
	}

	@FXML
    void btnAbrirTelaArbitrosAction(ActionEvent event) {
		
    }

    @FXML
    void btnAbrirTelaJogadoresAction(ActionEvent event) {

    }

    @FXML
    void btnAbrirTelaSelecaoAction(ActionEvent event) throws IOException {
    	Main.trocaDeTela("TelaMenuSelecoes", selecaoDao);
    }

    @FXML
    void btnAbrirTelaTecnicosAction(ActionEvent event) {

    }

    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	Main.trocaDeTela("TelaInical", null);
    }

    @FXML
    void initialize() {
        assert btnAbrirMenuArbitros != null : "fx:id=\"btnAbrirMenuArbitros\" was not injected: check your FXML file 'TelaMenuCadastros.fxml'.";
        assert btnAbrirMenuSelecao != null : "fx:id=\"btnAbrirMenuSelecao\" was not injected: check your FXML file 'TelaMenuCadastros.fxml'.";
        assert btnAbrirMenuTecnicos != null : "fx:id=\"btnAbrirMenuTecnicos\" was not injected: check your FXML file 'TelaMenuCadastros.fxml'.";
        assert btnAbrrMenuJogadores != null : "fx:id=\"btnAbrrMenuJogadores\" was not injected: check your FXML file 'TelaMenuCadastros.fxml'.";
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaMenuCadastros.fxml'.";

    }

}
