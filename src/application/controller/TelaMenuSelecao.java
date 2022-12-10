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
import javafx.scene.control.Label;

public class TelaMenuSelecao {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btnVoltar;

    @FXML
    private Label label;
    
    @FXML
    private Button btnCadastrarSelecao;
    
    @FXML
    private Button btnEditarSelecao;
    
    @FXML
    private Button btnListarSelecao;
    
    @FXML
    private Button btnRemoverSelecao;

    private SelecaoDaoImpl selecaoDao;
    
    private ArrayList <Selecao> listaSelecoes;

    public TelaMenuSelecao(SelecaoDaoImpl selecaoDao) {
    	this.selecaoDao = selecaoDao;
    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
    }

    @FXML
    void btnRemoverSelecaoAction(ActionEvent event) throws IOException {
    	if(listaSelecoes.size()>0)
    	{
	    	TelaRemoverSelecao controller = new TelaRemoverSelecao(selecaoDao);
	    	Main.trocaDeTela("/application/view/Selecao/TelaRemoverSelecao.fxml",controller, this.selecaoDao);
    
    	}
    	else
    		label.setText("Nenhuma Seleção Cadastrada");
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
    	if(listaSelecoes.size()>0)
    	{
	    	TelaEditarSelecao controller = new TelaEditarSelecao(selecaoDao);
	    	Main.trocaDeTela("/application/view/Selecao/TelaEditarSelecao.fxml", controller, this.selecaoDao);
    
    	}
    	else
    		label.setText("Nenhuma Seleção Cadastrada");
    }

    @FXML
    void btnListarSelecaoAction(ActionEvent event) throws IOException {
    	if(listaSelecoes.size()>0)
    	{
	    	TelaListarSelecoes controller = new TelaListarSelecoes(selecaoDao);
	    	Main.trocaDeTela("/application/view/Selecao/TelaListarSelecao.fxml", controller, this.selecaoDao);
    	}
    	else
    		label.setText("Nenhuma Seleção Cadastrada");
    }
    @FXML
    void initialize() {
    	assert btnCadastrarSelecao != null : "fx:id=\"btnCadastrarSelecao\" was not injected: check your FXML file 'TelaMenuSelecao.fxml'.";
        assert btnEditarSelecao != null : "fx:id=\"btnEditarSelecao\" was not injected: check your FXML file 'TelaMenuSelecao.fxml'.";
        assert btnListarSelecao != null : "fx:id=\"btnListarSelecao\" was not injected: check your FXML file 'TelaMenuSelecao.fxml'.";
        assert btnRemoverSelecao != null : "fx:id=\"btnRemoverSelecao\" was not injected: check your FXML file 'TelaMenuSelecao.fxml'.";
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaMenuSelecao.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'TelaMenuSelecao.fxml'.";
    }

}

