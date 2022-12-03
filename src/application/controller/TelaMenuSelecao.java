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

public class TelaMenuSelecao {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btnVoltar;
    
    @FXML
    private Button btnCadastrarSelecao;
    
    @FXML
    private Button btnEditarSelecao;
    
    private SelecaoDaoImpl selecaoDao;
    
    private ArrayList <Selecao> listaSelecoes;

    public TelaMenuSelecao(SelecaoDaoImpl selecaoDao) {
    	this.selecaoDao = selecaoDao;
    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
    }
    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaMenuCadastros controller = new TelaMenuCadastros(selecaoDao);
    	Main.trocaDeTela("/application/view/TelaMenuCadastros.fxml",controller, this.selecaoDao);
    }
    
    @FXML
    void btnCadastrarSelecaoAction(ActionEvent event) throws IOException {
    	TelaCadastrarSelecao controller = new TelaCadastrarSelecao(selecaoDao);
    	Main.trocaDeTela("/application/view/Selecao/TelaCadastrarSelecao.fxml", controller, this.selecaoDao);
    }
    @FXML
    void btnEditarSelecaoAction(ActionEvent event) throws IOException {
    	TelaEditarSelecao controller = new TelaEditarSelecao(selecaoDao);
    	Main.trocaDeTela("/application/view/Selecao/TelaEditarSelecao.fxml", controller, this.selecaoDao);
    }
    @FXML
    void initialize() {

    }

}

