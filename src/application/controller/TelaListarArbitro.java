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

public class TelaListarArbitro {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnVoltar;

    @FXML
    private Label labelArbitro1;

    @FXML
    private Label labelArbitro10;

    @FXML
    private Label labelArbitro2;

    @FXML
    private Label labelArbitro3;

    @FXML
    private Label labelArbitro4;

    @FXML
    private Label labelArbitro5;

    @FXML
    private Label labelArbitro6;

    @FXML
    private Label labelArbitro7;

    @FXML
    private Label labelArbitro8;

    @FXML
    private Label labelArbitro9;

	private SelecaoDaoImpl selecaoDao;

	private ArrayList<Selecao> listaSelecoes;
    
    public TelaListarArbitro(SelecaoDaoImpl selecaoDao) 
    {
    	this.selecaoDao = selecaoDao;
    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
    }

    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaMenuArbitro controller = new TelaMenuArbitro(this.selecaoDao);
    	Main.trocaDeTela("/application/view/Arbitro/TelaMenuArbitro.fxml",controller, selecaoDao);
    }

    @FXML
    void initialize() {
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaListarArbitro.fxml'.";
        assert labelArbitro1 != null : "fx:id=\"labelArbitro1\" was not injected: check your FXML file 'TelaListarArbitro.fxml'.";
        assert labelArbitro10 != null : "fx:id=\"labelArbitro10\" was not injected: check your FXML file 'TelaListarArbitro.fxml'.";
        assert labelArbitro2 != null : "fx:id=\"labelArbitro2\" was not injected: check your FXML file 'TelaListarArbitro.fxml'.";
        assert labelArbitro3 != null : "fx:id=\"labelArbitro3\" was not injected: check your FXML file 'TelaListarArbitro.fxml'.";
        assert labelArbitro4 != null : "fx:id=\"labelArbitro4\" was not injected: check your FXML file 'TelaListarArbitro.fxml'.";
        assert labelArbitro5 != null : "fx:id=\"labelArbitro5\" was not injected: check your FXML file 'TelaListarArbitro.fxml'.";
        assert labelArbitro6 != null : "fx:id=\"labelArbitro6\" was not injected: check your FXML file 'TelaListarArbitro.fxml'.";
        assert labelArbitro7 != null : "fx:id=\"labelArbitro7\" was not injected: check your FXML file 'TelaListarArbitro.fxml'.";
        assert labelArbitro8 != null : "fx:id=\"labelArbitro8\" was not injected: check your FXML file 'TelaListarArbitro.fxml'.";
        assert labelArbitro9 != null : "fx:id=\"labelArbitro9\" was not injected: check your FXML file 'TelaListarArbitro.fxml'.";
        
        ArrayList<Label> labelsArbitros = new ArrayList<Label>();
        
        labelsArbitros.add(labelArbitro1);
        labelsArbitros.add(labelArbitro2);
        labelsArbitros.add(labelArbitro3);
        labelsArbitros.add(labelArbitro4);
        labelsArbitros.add(labelArbitro5);
        labelsArbitros.add(labelArbitro6);
        labelsArbitros.add(labelArbitro7);
        labelsArbitros.add(labelArbitro8);
        labelsArbitros.add(labelArbitro9);
        labelsArbitros.add(labelArbitro10);
        
        if(TelaInicio.listaArbitros.size()!=0)
        {
	        for(int i = 0; i<TelaInicio.listaArbitros.size();i++)    
	        {
	        	labelsArbitros.get(i).setText(TelaInicio.listaArbitros.get(i).getNome());
	        	
	        }
    
        }
    }
}
