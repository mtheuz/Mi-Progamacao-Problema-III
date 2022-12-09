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

public class TelaEscolherSelecaoEditarTecnico {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEditarTecnico;

    @FXML
    private Button btnVoltar;

    @FXML
    private ChoiceBox<String> choiceBoxSelecoes;

    @FXML
    private Label label;
    
    private SelecaoDaoImpl selecaoDao;
    
    private ArrayList <Selecao> listaSelecoes;
    
    public TelaEscolherSelecaoEditarTecnico(SelecaoDaoImpl selecaoDao)
    {
    	this.selecaoDao = selecaoDao;
    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
    }
    
    
    @FXML
    void btnEditarTecnicoAction(ActionEvent event) throws IOException {
    	String selecao = choiceBoxSelecoes.getValue();
    	TelaEditarTecnico controller = new TelaEditarTecnico(this.selecaoDao, selecao);
    	Main.trocaDeTela("/application/view/Tecnico/TelaEditarTecnico.fxml",controller, selecaoDao);
    }

    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaMenuTecnicos controller = new TelaMenuTecnicos(this.selecaoDao);
    	Main.trocaDeTela("/application/view/Tecnico/TelaMenuTecnico.fxml",controller, selecaoDao);
    }

    @FXML
    void initialize() {
    	String[] nomesSelecoes = new String[32];
    	for(int i =0; i < listaSelecoes.size(); i++)
    	{
    		nomesSelecoes[i] = listaSelecoes.get(i).getNome();
    	}
    	choiceBoxSelecoes.getItems().addAll(nomesSelecoes);
    	
    	assert btnEditarTecnico!= null : "fx:id=\"btnCadastrarJogador\" was not injected: check your FXML file 'TelaEscolherSelecaoCadastrarJogador.fxml'.";
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaEscolherSelecaoCadastrarJogador.fxml'.";
        assert choiceBoxSelecoes != null : "fx:id=\"choiceBoxSelecoes\" was not injected: check your FXML file 'TelaEscolherSelecaoCadastrarJogador.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'TelaEscolherSelecaoCadastrarJogador.fxml'.";
        
    }

}
