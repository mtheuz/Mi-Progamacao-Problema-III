package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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

    public TelaFaseDeGrupos(SelecaoDaoImpl selecaoDao) {
		this.selecaoDao = selecaoDao;
		this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
	}

	@FXML
    void btnAbrirTelaSelecaoAction(ActionEvent event) {

    }

    @FXML
    void btnCadastrarPartidaAction(ActionEvent event) {

    }

    @FXML
    void btnVoltarAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
       
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaFaseDeGrupos.fxml'.";

    }

}
