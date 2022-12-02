package application.controller;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.model.SelecaoPackage.Selecao;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TelaCadastrarSelecao {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Label labelRestante;

    @FXML
    private Label labelTotal; 
    
    private SelecaoDaoImpl selecaoDao;
    
    private ArrayList <Selecao> listaSelecoes;
    
    
    public TelaCadastrarSelecao(SelecaoDaoImpl selecaoDao) {
    	this.selecaoDao = selecaoDao;
    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
	}

	@FXML
    void initialize() {
		assert labelRestante != null : "fx:id=\"labelRestante\" was not injected: check your FXML file 'TelaCadastrarSelecao.fxml'.";
        assert labelTotal != null : "fx:id=\"labelTotal\" was not injected: check your FXML file 'TelaCadastrarSelecao.fxml'.";
		int total = listaSelecoes.size();
		String total1 = Integer.toString(total);
		labelTotal.setText("10");
    }

}
