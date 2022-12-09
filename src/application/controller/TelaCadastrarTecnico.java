package application.controller;

import java.io.IOException;
import java.util.ArrayList;

import application.Main;
import application.model.SelecaoPackage.Selecao;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TelaCadastrarTecnico {

	@FXML
	private Button btnCadastrar;

    @FXML
    private Button btnVoltar;

    @FXML
    private Label labelNomeSelecao;

    @FXML
    private TextField nomeTecnico;
    
    @FXML
    private Label label;
    
    private SelecaoDaoImpl selecaoDao;
    
    private ArrayList <Selecao> listaSelecoes;
    
    private String selecao;
    
    public TelaCadastrarTecnico(SelecaoDaoImpl selecaoDao, String selecao)
    {
    	this.selecaoDao = selecaoDao;
    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
		this.selecao = selecao;
    }

    @FXML
    void btnCadastrarAction(ActionEvent event) {
    	String novoNome = nomeTecnico.getText();
    	if(novoNome!= null & novoNome != "")
    	{
    		int indice = selecaoDao.buscaSelecao(selecao);
    		listaSelecoes.get(indice).getTecnico().setNome(novoNome);
    		label.setText("Técnico Cadastrado!");
    	}
    	else
    		label.setText("Digite um nome");
    }

    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaEscolherSelecaoCadastrarTecnico controller = new TelaEscolherSelecaoCadastrarTecnico(selecaoDao);
		Main.trocaDeTela("/application/view/Tecnico/TelaEscolherSelecaoCadastrarTecnico.fxml", controller, selecaoDao);
    }

    @FXML
    void initialize() {
    	assert btnCadastrar != null : "fx:id=\"btnCadastrar\" was not injected: check your FXML file 'TelaCadastrarTecnico.fxml'.";
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaCadastrarTecnico.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'TelaCadastrarTecnico.fxml'.";
        assert labelNomeSelecao != null : "fx:id=\"labelNomeSelecao\" was not injected: check your FXML file 'TelaCadastrarTecnico.fxml'.";
        assert nomeTecnico != null : "fx:id=\"nomeTecnico\" was not injected: check your FXML file 'TelaCadastrarTecnico.fxml'.";

        labelNomeSelecao.setText(selecao);
    }
}
