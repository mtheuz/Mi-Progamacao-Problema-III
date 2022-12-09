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

public class TelaFaseDeGrupos{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnVoltar;

	private SelecaoDaoImpl selecaoDao;

	private ArrayList<Selecao> listaSelecoes;

    public TelaFaseDeGrupos() {
		//this.selecaoDao = selecaoDao;
		//this.listaSelecoes = new ArrayList<Selecao>();
		this.listaSelecoes = SelecaoDaoImpl.listaSelecoes;
	}

	@FXML
    void btnAbrirTelaSelecaoAction(ActionEvent event) {

    }

    @FXML
    void btnCadastrarPartidaAction(ActionEvent event) {

    }

    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaPartida controller = new TelaPartida();
    	Main.trocaDeTela("/application/view/Partida/TelaPartidas.fxml", controller, selecaoDao);
    }

    @FXML
    void initialize() {
       
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaFaseDeGrupos.fxml'.";

    }

}
