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
    private Button FaseDeGruos;

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
    
    public TelaPartida(SelecaoDaoImpl selecaoDao) {

    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
    }
    
    @FXML
    void btnFaseDeGrupos(ActionEvent event) throws IOException {
    	Main.trocaDeTela("/application/view/Partida/TelaFaseDeGrupos.fxml", null);
    }
    

}

