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

public class TelaEditarTecnico {

	@FXML
	private Button btnSalvar;

    @FXML
    private Button btnVoltar;
    
    @FXML
    private Label label;
    
    @FXML
    private Label labelNomeSelecao;

    @FXML
    private TextField nomeTecnico;
    
    private SelecaoDaoImpl selecaoDao;
    
    private ArrayList <Selecao> listaSelecoes;
    
    private String selecao;
    
    public TelaEditarTecnico(SelecaoDaoImpl selecaoDao, String selecao)
    {
    	this.selecaoDao = selecaoDao;
    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
		this.selecao = selecao;
    }

    @FXML
    void btnSalvarAction(ActionEvent event) {
    	String novoNome = nomeTecnico.getText();
    	if(novoNome!= null & novoNome != "")
    	{
    		int indice = selecaoDao.buscaSelecao(selecao);
    		listaSelecoes.get(indice).getTecnico().setNome(novoNome);
    		label.setText("Técnico Editado!");
    	}
    	else
    		label.setText("Digite um nome");
    }

    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaEscolherSelecaoEditarTecnico controller = new TelaEscolherSelecaoEditarTecnico(selecaoDao);
		Main.trocaDeTela("/application/view/Tecnico/TelaEscolherSelecaoEditarTecnico.fxml", controller, selecaoDao);
    }

    @FXML
    void initialize() {
    	assert btnSalvar != null : "fx:id=\"btnSalvar\" was not injected: check your FXML file 'TelaEditarTecnico.fxml'.";
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaEditarTecnico.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'TelaEditarTecnico.fxml'.";
        assert labelNomeSelecao != null : "fx:id=\"labelNomeSelecao\" was not injected: check your FXML file 'TelaEditarTecnico.fxml'.";
        assert nomeTecnico != null : "fx:id=\"nomeTecnico\" was not injected: check your FXML file 'TelaEditarTecnico.fxml'.";

        labelNomeSelecao.setText(selecao);
    }
}
