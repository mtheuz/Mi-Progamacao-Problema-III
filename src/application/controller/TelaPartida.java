package application.controller;

import java.io.IOException;
import java.util.ArrayList;

import application.Main;
import application.model.FaseDeGrupos.FaseDeGrupos;
import application.model.SelecaoPackage.Selecao;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TelaPartida {

    @FXML
    private Button btnAbrirFaseDeGrupos;

    @FXML
    private Button otavasDeFinla;

    @FXML
    private Button quartasDeFinal;

    @FXML
    private Button voltar;

    @FXML
    private Button semiFinal;

    @FXML
    private Button terceiroLugar;
    
    @FXML
    private Button Final;
    
    private ArrayList <Selecao> listaSelecoes;
    
    private SelecaoDaoImpl selecaoDao;
    private FaseDeGrupos fase;

    
    public TelaPartida() {
    	SelecaoDaoImpl selecao = new SelecaoDaoImpl();
    	try {
			selecao.leArquivoSelecoes();
			System.out.println(SelecaoDaoImpl.listaSelecoes.size());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    	System.out.println(SelecaoDaoImpl.listaSelecoes.size());
    	this.listaSelecoes =SelecaoDaoImpl.listaSelecoes;

    	System.out.println(SelecaoDaoImpl.listaSelecoes.size());
    	FaseDeGrupos fase = new FaseDeGrupos(this.listaSelecoes);
		try {
			System.out.println(SelecaoDaoImpl.listaSelecoes.size());
			fase.geraPartidas();
			System.out.println(SelecaoDaoImpl.listaSelecoes.size());
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		
    }
    
    @FXML
    void btnAbrirFaseDeGruposAction(ActionEvent event) throws IOException {
    	TelaTabelaDeGrupos controller = new TelaTabelaDeGrupos();
    	Main.trocaDeTela("/application/view/Partida/TelaTodasPartidas.fxml", controller, null);
    }
   
    @FXML
    void initialize() {
    	
        assert btnAbrirFaseDeGrupos != null : "fx:id=\"FaseDeGruos\" was not injected: check your FXML file 'TelaPartidas.fxml'.";
        assert Final != null : "fx:id=\"Final\" was not injected: check your FXML file 'TelaPartidas.fxml'.";
        assert otavasDeFinla != null : "fx:id=\"otavasDeFinla\" was not injected: check your FXML file 'TelaPartidas.fxml'.";
        assert quartasDeFinal != null : "fx:id=\"quartasDeFinal\" was not injected: check your FXML file 'TelaPartidas.fxml'.";
        assert semiFinal != null : "fx:id=\"semiFinal\" was not injected: check your FXML file 'TelaPartidas.fxml'.";
        assert terceiroLugar != null : "fx:id=\"terceiroLugar\" was not injected: check your FXML file 'TelaPartidas.fxml'.";
        assert voltar != null : "fx:id=\"voltar\" was not injected: check your FXML file 'TelaPartidas.fxml'.";
        
    }
    

}

