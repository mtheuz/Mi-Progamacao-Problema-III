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

public class TelaEscolherSelecaoCadastrarTecnico {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCadastrarTecnico;

    @FXML
    private Button btnVoltar;

    @FXML
    private ChoiceBox<String> choiceBoxSelecoes;

    @FXML
    private Label label;
    
    private SelecaoDaoImpl selecaoDao;
    
    private ArrayList <Selecao> listaSelecoes;
    
    public TelaEscolherSelecaoCadastrarTecnico(SelecaoDaoImpl selecaoDao)
    {
    	this.selecaoDao = selecaoDao;
    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
    }
    
    @FXML
    void btnCadastrarTecnicoAction(ActionEvent event) throws IOException {
    	String selecao = choiceBoxSelecoes.getValue();
    	
    	if(selecao != null && selecao != "")
	    	{
    		int indice = selecaoDao.buscaSelecao(selecao);
	    	if(listaSelecoes.get(indice).getTecnico().getNome().equals("Sem Tecnico"))
	    	{
	    		TelaCadastrarTecnico controller = new TelaCadastrarTecnico(this.selecaoDao, selecao);
	    		Main.trocaDeTela("/application/view/Tecnico/TelaCadastrarTecnico.fxml",controller, selecaoDao);
	    	}
	    	else
	    		label.setText("Já existe um Ténico Cadastrado");
    	}
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
    	
    	assert btnCadastrarTecnico!= null : "fx:id=\"btnCadastrarJogador\" was not injected: check your FXML file 'TelaEscolherSelecaoCadastrarJogador.fxml'.";
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaEscolherSelecaoCadastrarJogador.fxml'.";
        assert choiceBoxSelecoes != null : "fx:id=\"choiceBoxSelecoes\" was not injected: check your FXML file 'TelaEscolherSelecaoCadastrarJogador.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'TelaEscolherSelecaoCadastrarJogador.fxml'.";
        
    }

}
