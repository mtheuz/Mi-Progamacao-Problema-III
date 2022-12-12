package application.controller;
import java.io.IOException;

import application.Main;
import application.model.Eliminatoria.Eliminatoria;
import application.model.FaseDeGrupos.FaseDeGrupos;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class ControllerPerguntaProximaFase {
	FaseDeGrupos fase;
    SelecaoDaoImpl selecaoDao;
    String endereco;
    public ControllerPerguntaProximaFase(FaseDeGrupos fase, SelecaoDaoImpl selecaoDao, String endereco) {
    	
    	this.fase = fase;
		this.selecaoDao = selecaoDao;
		this.endereco = endereco;
		//this.eliminatoria = new Eliminatoria(SelecaoDaoImpl.listaSelecoes,FaseDeGrupos.grupos);
    	
    }

    @FXML
    private Button btnproximaFaze;

    @FXML
    private Label btnProximaFase;

    @FXML
    private Button proximaFase;

    @FXML
    void btnProximaFase(ActionEvent event) throws IOException {
    	
    	switch (endereco) {
    	
		case "OitavasDeFinal":
			Eliminatoria.OitavasDeFinal(FaseDeGrupos.grupos);
    		ControllerOitavasDeFinal controller = new ControllerOitavasDeFinal(fase,selecaoDao);
    		Main.trocaDeTela("/application/view/Partida/OitavasDeFinal.fxml", controller, null);
			break;
		case "QuartasDeFinal":
			Eliminatoria.Quartas();
    		ControllerQuartas controllerQuartas = new ControllerQuartas(fase,selecaoDao);
    		Main.trocaDeTela("/application/view/Partida/QuartasDeFinal.fxml", controllerQuartas, null);
			break;
			
		case "SemiFinal":
			Eliminatoria.SemiFinal();
			ControllerSemiFinal controllerSemi= new ControllerSemiFinal(fase,selecaoDao);
    		Main.trocaDeTela("/application/view/Partida/SemiFinal.fxml", controllerSemi, null);
			break;
			
		case "TerceiroLugar":
			Eliminatoria.TerceiroLugar();
			ControllerTerceiroLugar controllerTerceiroLugar= new ControllerTerceiroLugar(fase,selecaoDao);
    		Main.trocaDeTela("/application/view/Partida/TerceiroLugar.fxml", controllerTerceiroLugar, null);
			break;
			
		case "Final":
			Eliminatoria.Final();
			ControllerFinal controllerFinal= new ControllerFinal(fase,selecaoDao);
    		Main.trocaDeTela("/application/view/Partida/Final.fxml", controllerFinal, null);
			break;
		default:
			break;
		
    
    
}
    }
    }

