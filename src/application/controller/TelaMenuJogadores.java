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

public class TelaMenuJogadores {
	
	private SelecaoDaoImpl selecaoDao;
	@FXML
	private ResourceBundle resources;
	
	@FXML
	private URL location;
	
	@FXML
	private Button btnCadastrarJogador;
	
	@FXML
	private Button btnDeletarJogador;
	
	@FXML
	private Button btnEditarJogador;
	
	@FXML
	private Button btnListarJogadores;
	
	@FXML
	private Button btnVoltar;
	
	private ArrayList <Selecao> listaSelecoes;

    public TelaMenuJogadores(SelecaoDaoImpl selecaoDao) {
    	this.selecaoDao = selecaoDao;
    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
    }

    @FXML
    void btnCadastrarJogadorAction(ActionEvent event) {

    }

    @FXML
    void btnDeletarJogadorAction(ActionEvent event) {

    }

    @FXML
    void btnEditarJogadorAction(ActionEvent event) {

    }

    @FXML
    void btnListarJogadoresAction(ActionEvent event) {

    }

    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaMenuCadastros controller = new TelaMenuCadastros(selecaoDao);
    	Main.trocaDeTela("/application/view/TelaMenuCadastros.fxml", controller, selecaoDao);
    }

    @FXML
    void initialize() {
        assert btnCadastrarJogador != null : "fx:id=\"btnCadastrarJogador\" was not injected: check your FXML file 'TelaMenuJogador.fxml'.";
        assert btnDeletarJogador != null : "fx:id=\"btnDeletarJogador\" was not injected: check your FXML file 'TelaMenuJogador.fxml'.";
        assert btnEditarJogador != null : "fx:id=\"btnEditarJogador\" was not injected: check your FXML file 'TelaMenuJogador.fxml'.";
        assert btnListarJogadores != null : "fx:id=\"btnListarJogadores\" was not injected: check your FXML file 'TelaMenuJogador.fxml'.";
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaMenuJogador.fxml'.";

    }
}