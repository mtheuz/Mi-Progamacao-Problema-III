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
    
    public TelaPartida(SelecaoDaoImpl selecaoDao) {
    	this.selecaoDao = selecaoDao;
    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
		
    }
    
    @FXML
    void btnAbrirFaseDeGrupos(ActionEvent event) throws IOException {
    	TelaFaseDeGrupos controller = new TelaFaseDeGrupos(selecaoDao);
    	Main.trocaDeTela("/application/view/Partida/TelaFaseDeGrupos.fxml", controller, selecaoDao);
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

