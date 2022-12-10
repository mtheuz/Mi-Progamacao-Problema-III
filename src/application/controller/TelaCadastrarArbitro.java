package application.controller;

import java.io.IOException;
import java.util.ArrayList;

import application.Main;
import application.model.ArbitroPackage.Arbitro;
import application.model.SelecaoPackage.Selecao;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TelaCadastrarArbitro {

	@FXML
	private Button btnCadastrar;

    @FXML
    private Button btnVoltar;

   

    @FXML
    private TextField nomeArbitro;
    
    @FXML
    private Label label;
    
    private SelecaoDaoImpl selecaoDao;
    
    private ArrayList <Selecao> listaSelecoes;
    
    
    
    public TelaCadastrarArbitro(SelecaoDaoImpl selecaoDao)
    {
    	this.selecaoDao = selecaoDao;
    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
		
    }

    @FXML
    void btnCadastrarAction(ActionEvent event) throws IOException {
    	String nome = nomeArbitro.getText();
    	if(TelaInicio.listaArbitros.size() <= 10)
    	{
	    	if(nome != null && nome != "")
	    	{
	    		Arbitro arbitro = new Arbitro();
	    		arbitro.setNome(nome);
	    		TelaInicio.listaArbitros.add(arbitro);
	    		label.setText("Árbitro Cadastrado!");
	    		nomeArbitro.setText("");
	    		
	    	}
	    	else
	    		label.setText("Digite o Nome");
    	}
    	else
    	{
    		label.setText("Lista de Árbitro Completa!");

    	}

    }	
    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaMenuArbitro controller = new TelaMenuArbitro(selecaoDao);
		Main.trocaDeTela("/application/view/Arbitro/TelaMenuArbitro.fxml", controller, selecaoDao);
    }

    @FXML
    void initialize() {
    	assert btnCadastrar != null : "fx:id=\"btnCadastrar\" was not injected: check your FXML file 'TelaCadastrarTecnico.fxml'.";
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaCadastrarTecnico.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'TelaCadastrarTecnico.fxml'.";
        
        assert nomeArbitro != null : "fx:id=\"nomeTecnico\" was not injected: check your FXML file 'TelaCadastrarTecnico.fxml'.";

        
    }
}
