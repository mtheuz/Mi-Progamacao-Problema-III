package application.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ControllerSemiFinal  implements Initializable{
	private List<Label> ListaLabel = new ArrayList<Label>();
    @FXML
    private Pane pane3;

    @FXML
    private Label labelOpcao3;

    @FXML
    private Pane pane4;

    @FXML
    private Label labelOpcao4;

    @FXML
    private Pane pane2;

    @FXML
    private Label labelOpcao2;

    @FXML
    private Pane pane1;

    @FXML
    private Label labelOpcao1;

    @FXML
    private Label clickSelecao1Nome;

    @FXML
    private Label clickSelecao2Nome;

    @FXML
    private Label clickSelecao1Placar;

    @FXML
    private Label clickSelecao2Placar;

    @FXML
    private Label clickSelecao1Nome2;

    @FXML
    private Label clickSelecao2Nome2;

    @FXML
    private Label clickSelecao1Placar2;

    @FXML
    private Label clickSelecao2Placar2;

    @FXML
    private Label clickSelecao1Nome4;

    @FXML
    private Label clickSelecao2Nome4;

    @FXML
    private Label clickSelecao1Placar4;

    @FXML
    private Label clickSelecao2Placar4;

    @FXML
    private Label clickSelecao1Nome3;

    @FXML
    private Label clickSelecao2Nome3;

    @FXML
    private Label clickSelecao1Placar3;

    @FXML
    private Label clickSelecao2Placar3;

    @FXML
    private Button partida2;

    @FXML
    private Button partida4;

    @FXML
    private Button partida3;

    @FXML
    private Button partida1;
    
    FaseDeGrupos fase;
    SelecaoDaoImpl selecaoDao;
    public ControllerSemiFinal(FaseDeGrupos fase, SelecaoDaoImpl selecaoDao) {
		this.fase = fase;
		this.selecaoDao = selecaoDao;
		Eliminatoria.tranforsmaEmEliminatoria(Eliminatoria.semiFinal);
	}
    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaPartida controller = new TelaPartida(selecaoDao,fase);
   	 	Main.trocaDeTela("/application/view/Partida/TelaPartidas.fxml", controller, null);
    }
    @FXML
    void buttonPartida1(MouseEvent event) throws IOException {
    	
    	if(Eliminatoria.semiFinal!= null) {
    		if(Eliminatoria.semiFinal.get(0).isSituacao() == false) {
    			ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(Eliminatoria.semiFinal.get(0),this.selecaoDao, fase,"SemiFinal");
    			Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
    		}
    		else {
    			Main.trocaDeTela("/application/view/Partida/MostrarPartida.fxml", null, null);
    		}
    	}
    }

    @FXML
    void buttonPartida2(MouseEvent event) throws IOException {
    	if(Eliminatoria.semiFinal != null) {
    		if(Eliminatoria.semiFinal.get(1).isSituacao() == false) {
    			ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(Eliminatoria.semiFinal.get(1),this.selecaoDao, fase,"SemiFinal");
    			Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
    		}
    		else {
    			Main.trocaDeTela("/application/view/Partida/MostrarPartida.fxml", null, null);
    		}
    	}
    }


    @FXML
    void entrarBotao(MouseEvent event) {
    	if(event.getTarget().toString().equals("Button[id=partida1, styleClass=button]''")) {
    		pane1.setVisible(true);
    		if(Eliminatoria.semiFinal.get(0).isSituacao() == true) {
    			labelOpcao1.setText("Click para vizualizar");
    		}
    	}
    	if(event.getTarget().toString().equals("Button[id=partida2, styleClass=button]''")) {
    		pane2.setVisible(true);
    		if(Eliminatoria.semiFinal.get(1).isSituacao() == true) {
    			labelOpcao2.setText("Click para vizualizar");
    		}
    	}
    }
    	

    @FXML
    void sairBotao(MouseEvent event) {
    	if(event.getTarget().toString().equals("Button[id=partida1, styleClass=button]''")) {
			pane1.setVisible(false);
			if(Eliminatoria.semiFinal.get(0).isSituacao() == true) {
				labelOpcao1.setText("Click para cadastrar");
			}
    	}
    	if(event.getTarget().toString().equals("Button[id=partida2, styleClass=button]''")) {
			pane2.setVisible(false);
			if(Eliminatoria.oitavas.get(1).isSituacao() == true) {
				labelOpcao2.setText("Click para cadastrar");
			}
 
    }

}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ListaLabel.add(clickSelecao1Nome);
		ListaLabel.add(clickSelecao2Nome);
		ListaLabel.add(clickSelecao1Placar);
		ListaLabel.add(clickSelecao2Placar);
		
		ListaLabel.add(clickSelecao1Nome2);
		ListaLabel.add(clickSelecao2Nome2);
		ListaLabel.add(clickSelecao1Placar2);
		ListaLabel.add(clickSelecao2Placar2);
		
	
		int i = 0;
		for (Partida partida : Eliminatoria.semiFinal) {
			this.ListaLabel.get(i).setText(partida.getSelecao1());
			this.ListaLabel.get(i+1).setText(partida.getSelecao2());
			this.ListaLabel.get(i+2).setText(partida.getPlacarSelecao1());
			this.ListaLabel.get(i+3).setText(partida.getPlacarSelecao2());
			i += 4;
		}
		
	}
    }

