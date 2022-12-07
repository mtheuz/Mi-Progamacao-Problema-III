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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class TelaRemoverSelecao{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDeletar;

    @FXML
    private Button btnVoltar;

    @FXML
    private ChoiceBox<String> choiceBoxSelecoes;

    @FXML
    private Label label;
    
    private SelecaoDaoImpl selecaoDao;
    
    private ArrayList <Selecao> listaSelecoes;

    
    public TelaRemoverSelecao(SelecaoDaoImpl selecaoDao)
    {
    	this.selecaoDao = selecaoDao;
    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
    }
    
    @FXML
    void btnDeletarAction(ActionEvent event) {
    	String selecao = this.choiceBoxSelecoes.getValue();
    	selecaoDao.removerSelecao(selecao);
    	label.setText("Seleção Removida!");
    }

    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaMenuSelecao controller = new TelaMenuSelecao(this.selecaoDao);
    	Main.trocaDeTela("/application/view/Selecao/TelaMenuSelecao.fxml",controller, selecaoDao);
    }

    @FXML
    void initialize() {
        
    	String[] nomesSelecoes = new String[32];
    	for(int i =0; i < listaSelecoes.size(); i++)
    	{
    		nomesSelecoes[i] = listaSelecoes.get(i).getNome();
    	}
    	choiceBoxSelecoes.getItems().addAll(nomesSelecoes);
    	
    	assert btnDeletar != null : "fx:id=\"btnDeletar\" was not injected: check your FXML file 'TelaRemoverSelecao.fxml'.";
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaRemoverSelecao.fxml'.";
        assert choiceBoxSelecoes != null : "fx:id=\"choiceBoxSelecoes\" was not injected: check your FXML file 'TelaRemoverSelecao.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'TelaRemoverSelecao.fxml'.";

    }

}

