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

public class TelaMenuArbitro
{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCadastrarTecnico;

    @FXML
    private Button btnDeletarTecnico;

    @FXML
    private Button btnEditarTecnico;
    
    @FXML
    private Label label;
    
    @FXML
    private Button btnListarTecnico;

    @FXML
    private Button btnVoltar;
    
    private SelecaoDaoImpl selecaoDao;
    private ArrayList <Selecao> listaSelecoes;

    public TelaMenuArbitro(SelecaoDaoImpl selecaoDao) {
		this.selecaoDao = selecaoDao;
		this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
	}

	@FXML
    void btnCadastrarArbitroAction(ActionEvent event) throws IOException {
		if(TelaInicio.listaArbitros.size()<9)
		{
			TelaCadastrarArbitro controller = new TelaCadastrarArbitro(selecaoDao);
			Main.trocaDeTela("/application/view/Arbitro/TelaCadastrarArbitro.fxml", controller, selecaoDao);
		}
		else
			label.setText("Lista Completa!");
	}

    @FXML
    void btnDeletarArbitroAction(ActionEvent event) throws IOException {
    	if(TelaInicio.listaArbitros.size()>0)
    	{
	    	TelaDeletarArbitro controller = new TelaDeletarArbitro(selecaoDao);
			Main.trocaDeTela("/application/view/Arbitro/TelaDeletarArbitro.fxml", controller, selecaoDao);
    	}
    	else
			label.setText("Nemhum Árbitro Cadastrado!");
    	
    }
    @FXML
    void btnEditarArbitroAction(ActionEvent event) throws IOException {
    	if(TelaInicio.listaArbitros.size()>0)
		{
    		TelaEditarArbitro controller = new TelaEditarArbitro(selecaoDao);
    		Main.trocaDeTela("/application/view/Arbitro/TelaEditarArbitro.fxml", controller, selecaoDao);
		}
    	else
			label.setText("Nemhum Árbitro Cadastrado!");
    	
    }
    @FXML
    void btnListarArbitroAction(ActionEvent event) throws IOException {
    	if(TelaInicio.listaArbitros.size()>0)
    	{
    		TelaListarArbitro controller = new TelaListarArbitro(selecaoDao);
    		Main.trocaDeTela("/application/view/Arbitro/TelaListarArbitro.fxml", controller, selecaoDao);
    	}
    	else
			label.setText("Nemhum Árbitro Cadastrado!");
    }

    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaMenuCadastros controller = new TelaMenuCadastros(selecaoDao);
    	Main.trocaDeTela("/application/view/TelaMenuCadastros.fxml", controller, selecaoDao);
    }

    @FXML
    void initialize() {
        assert btnCadastrarTecnico != null : "fx:id=\"btnCadastrarTecnico\" was not injected: check your FXML file 'TelaMenuTecnico.fxml'.";
        assert btnDeletarTecnico != null : "fx:id=\"btnDeletarTecnico\" was not injected: check your FXML file 'TelaMenuTecnico.fxml'.";
        assert btnEditarTecnico != null : "fx:id=\"btnEditarTecnico\" was not injected: check your FXML file 'TelaMenuTecnico.fxml'.";
        assert btnListarTecnico != null : "fx:id=\"btnListarTecnico\" was not injected: check your FXML file 'TelaMenuTecnico.fxml'.";
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaMenuTecnico.fxml'.";

    }

}
