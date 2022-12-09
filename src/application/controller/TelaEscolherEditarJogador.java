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
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;

public class TelaEscolherEditarJogador {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField NovoNomeSelecao;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnVoltar;

    @FXML
    private ChoiceBox<String> choiceBoxSelecoes;

    @FXML
    private ChoiceBox<String> choiceBoxJogadores;
    
    @FXML
    private Label label;
    
    private ArrayList <Selecao> listaSelecoes;
    
    private SelecaoDaoImpl selecaoDao;
    
    private String nomeSelecao;

    @FXML
    void btnEditarAction(ActionEvent event) throws IOException {
    	String jogador = choiceBoxJogadores.getValue();
    	if(jogador != null && jogador != "")
    	{
    		TelaEditarJogador controller = new TelaEditarJogador(selecaoDao, nomeSelecao, jogador);
    		Main.trocaDeTela("/application/view/Jogador/TelaEditarJogador.fxml",controller, selecaoDao);
    	}
    	else
    		label.setText("Escolha uma Seleção");
    }
    @FXML
    void btnSelecionarSelecaoAction(ActionEvent event) {
    	choiceBoxJogadores.getItems().clear();
    	String selecao = choiceBoxSelecoes.getValue();
    	if(selecao!= null && selecao !="")
    	{
    		String[] nomesJogadores = new String[26];
    		int indice = selecaoDao.buscaSelecao(selecao);
        	for(int i =0; i < listaSelecoes.get(indice).getListaJogadores().size(); i++)
        	{
        		nomesJogadores[i] = listaSelecoes.get(indice).getListaJogadores().get(i).getNome();
        		
        	}
        	choiceBoxJogadores.getItems().addAll(nomesJogadores);
        	nomeSelecao = selecao;
        	
    	}
    	else
    		label.setText("Escolha uma Seleção");
    }

    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaMenuJogadores controller = new TelaMenuJogadores(this.selecaoDao);
    	Main.trocaDeTela("/application/view/Jogador/TelaMenuJogador.fxml",controller, selecaoDao);
    }
    public TelaEscolherEditarJogador(SelecaoDaoImpl selecaoDao) {
    	this.selecaoDao = selecaoDao;
    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
    }

    @FXML
    void initialize() {
    	
    	
    	String[] nomesSelecoes = new String[32];
    	for(int i =0; i < listaSelecoes.size(); i++)
    	{
    		nomesSelecoes[i] = listaSelecoes.get(i).getNome();
    	}
    	choiceBoxSelecoes.getItems().addAll(nomesSelecoes);
    	
    	assert NovoNomeSelecao != null : "fx:id=\"NovoNomeSelecao\" was not injected: check your FXML file 'TelaEditarJogador.fxml'.";
        assert btnEditar != null : "fx:id=\"btnSalvar\" was not injected: check your FXML file 'TelaEditarJogador.fxml'.";
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaEditarJogador.fxml'.";
        assert choiceBoxSelecoes != null : "fx:id=\"choiceBoxSelecoes\" was not injected: check your FXML file 'TelaEditarJogador.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'TelaEditarJogador.fxml'.";

    }

}

