package application.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.Eliminatoria.Eliminatoria;
import application.model.FaseDeGrupos.FaseDeGrupos;
import application.model.PartidaPackage.Partida;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DisputaDePenaltys implements Initializable{
	
	Partida partida;
	String endereco;
	SelecaoDaoImpl selecaoDao;
	FaseDeGrupos fase;
	@FXML
    private Label selecao2nome;

    @FXML
    private Button selecao2;

    @FXML
    private Label btnProximaFase2;

    @FXML
    private Label selecao1Nome;

    @FXML
    private Button selecao1;

	public DisputaDePenaltys(Partida partida, String endereco, SelecaoDaoImpl selecaoDao, FaseDeGrupos fase) {
		this.partida = partida;
		this.endereco = endereco;
		this.fase = fase;
		this.selecaoDao = selecaoDao;
		
	}
    
    @FXML
    void btnselecao1(ActionEvent event) throws IOException {
    	partida.setVencedor(partida.getSelecao1());
    	partida.setPerdedor(partida.getSelecao2());
    	
    	switch (endereco) {
		case "OitavasDeFinal":
    		ControllerOitavasDeFinal controller = new ControllerOitavasDeFinal(fase,selecaoDao);
    		Main.trocaDeTela("/application/view/Partida/OitavasDeFinal.fxml", controller, event);
			break;
		case "QuartasDeFinal":
    		ControllerQuartas controllerQuartas = new ControllerQuartas(fase,selecaoDao);
    		Main.trocaDeTela("/application/view/Partida/QuartasDeFinal.fxml", controllerQuartas, event);
			break;
			
		case "SemiFinal":
    		ControllerSemiFinal controllerSemi= new ControllerSemiFinal(fase,selecaoDao);
    		Main.trocaDeTela("/application/view/Partida/SemiFinal.fxml", controllerSemi, event);
			break;
		case "Final":
			ControllerFinal controllerFinal= new ControllerFinal(fase,selecaoDao);
    		Main.trocaDeTela("/application/view/Partida/Final.fxml", controllerFinal, event);
			break;
		default:
			break;
			}
    }

    @FXML
    void btnselecao2(ActionEvent event) throws IOException {
    	partida.setVencedor(partida.getSelecao2());
    	partida.setPerdedor(partida.getSelecao1());
    	switch (endereco) {
		case "OitavasDeFinal":
    		ControllerOitavasDeFinal controller = new ControllerOitavasDeFinal(fase,selecaoDao);
    		Main.trocaDeTela("/application/view/Partida/OitavasDeFinal.fxml", controller, event);
			break;
		case "QuartasDeFinal":
			ControllerQuartas controllerQuartas = new ControllerQuartas(fase,selecaoDao);
    		Main.trocaDeTela("/application/view/Partida/QuartasDeFinal.fxml", controllerQuartas, event);
			break;
			
		case "SemiFinal":
			ControllerSemiFinal controllerSemi= new ControllerSemiFinal(fase,selecaoDao);
    		Main.trocaDeTela("/application/view/Partida/SemiFinal.fxml", controllerSemi, event);
			break;
		case "TerceiroLugar":
			ControllerTerceiroLugar controllerTerceiroLugar= new ControllerTerceiroLugar(fase,selecaoDao);
    		Main.trocaDeTela("/application/view/Partida/TerceiroLugar.fxml", controllerTerceiroLugar, null);
			break;
			
		case "Final":
			ControllerFinal controllerFinal= new ControllerFinal(fase,selecaoDao);
    		Main.trocaDeTela("/application/view/Partida/Final.fxml", controllerFinal, event);
			break;
		default:
			break;
			}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		selecao1Nome.setText(partida.getSelecao1());
    	selecao2nome.setText(partida.getSelecao2());
		
	}

}
