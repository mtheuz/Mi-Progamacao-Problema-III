package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.model.Eliminatoria.Eliminatoria;
import application.model.FaseDeGrupos.FaseDeGrupos;
import application.model.JogadorPackage.JogadorDaoImpl;
import application.model.SelecaoPackage.Selecao;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class TelaPartida{
	@FXML
	private Button quartasDeFinal;

	@FXML
	private Label quartasDeFinalLabel;

	@FXML
	private Button semiFinal;

	@FXML
	private Label semiFinalLabel;

	@FXML
	private Button terceiroLugar;

	@FXML
	private Label terceiroLugarLabel;

	@FXML
	private Button Final;

	@FXML
	private Label finalLabel;
    @FXML
    private Button btnAbrirFaseDeGrupos;

    @FXML
    private Button oitavasDeFinal;

    @FXML
    private Label oitavasDeFinalLabel;

    @FXML
    private Button voltar;

 
    private ArrayList <Selecao> listaSelecoes;
    
    private SelecaoDaoImpl selecao;
    private FaseDeGrupos fase;
    
    public TelaPartida(SelecaoDaoImpl selecao,FaseDeGrupos fase) {
    	this.selecao = selecao;
    	this.fase = fase;
    }

    
    @FXML
    void btnAbrirFaseDeGruposAction(ActionEvent event) throws IOException {
    	TelaTabelaDeGrupos controller = new TelaTabelaDeGrupos(selecao,fase);
    	Main.trocaDeTela("/application/view/Partida/TelaTodasPartidas.fxml", controller, null);
    }
    
    @FXML
    void btnabrirFinal(ActionEvent event) throws IOException {
    	ControllerFinal controller = new ControllerFinal(fase,selecao);
    	Main.trocaDeTela("/application/view/Partida/Final.fxml", controller, null);
    }

    @FXML
    void btnabrirOitavas(ActionEvent event) throws IOException {
    	ControllerOitavasDeFinal controller = new ControllerOitavasDeFinal(fase,selecao);
    	Main.trocaDeTela("/application/view/Partida/OitavasDeFinal.fxml", controller, null);
    }

    @FXML
    void btnabrirQuartas(ActionEvent event) throws IOException {
    	ControllerQuartas controller = new ControllerQuartas(fase,selecao);
    	Main.trocaDeTela("/application/view/Partida/QuartasDeFinal.fxml", controller, null);
    }

    @FXML
    void btnabrirSemiFinal(ActionEvent event) throws IOException {
    	ControllerSemiFinal controller = new ControllerSemiFinal(fase,selecao);
    	Main.trocaDeTela("/application/view/Partida/SemiFinal.fxml", controller, null);
    }

    @FXML
    void btnabrirTerceiroLugar(ActionEvent event) throws IOException {
    	ControllerTerceiroLugar controller = new ControllerTerceiroLugar(fase,selecao);
    	Main.trocaDeTela("/application/view/Partida/TerceiroLugar.fxml", controller, null);
    	
    }
   
    @FXML
    void initialize() {
    
    	if(fase.verificaPartidas()) {

    		oitavasDeFinal.setDisable(false);
    		oitavasDeFinalLabel.setDisable(false);
    	};
    	if(Eliminatoria.verificaPartidas(Eliminatoria.oitavas)) {
    		quartasDeFinal.setDisable(false);
    		quartasDeFinalLabel.setDisable(false);
    	}
    	if(Eliminatoria.verificaPartidas(Eliminatoria.quartas)) {
    		semiFinal.setDisable(false);
    		semiFinalLabel.setDisable(false);
    	}
    	if(Eliminatoria.verificaPartidas(Eliminatoria.semiFinal)) {
    		Final.setDisable(false);
    		finalLabel.setDisable(false);
    		
    		terceiroLugar.setDisable(false);
    		terceiroLugarLabel.setDisable(false);
    	}
    }
}

