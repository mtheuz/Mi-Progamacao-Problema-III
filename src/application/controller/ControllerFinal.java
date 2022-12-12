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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ControllerFinal implements Initializable{

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
    public ControllerFinal(FaseDeGrupos fase, SelecaoDaoImpl selecaoDao) {
		this.fase = fase;
		this.selecaoDao = selecaoDao;
	}
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {

    	Partida partida = Eliminatoria.Final;
    	partida.setEliminatoria(true);
    	clickSelecao1Nome.setText(partida.getSelecao1());
    	clickSelecao2Nome.setText(partida.getSelecao2());
    	clickSelecao1Placar.setText(partida.getPlacarSelecao1());
    	clickSelecao2Placar.setText(partida.getPlacarSelecao2());
		
	}
    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaPartida controller = new TelaPartida(selecaoDao,fase);
   	 	Main.trocaDeTela("/application/view/Partida/TelaPartidas.fxml", controller, null);
    }
    @FXML
    void buttonPartida1(MouseEvent event) throws IOException {
    	
    	if(Eliminatoria.Final!= null) {
    		if(Eliminatoria.Final.isSituacao() == false) {
    			ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(Eliminatoria.Final,this.selecaoDao, fase,"Final");
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
    		if(Eliminatoria.Final.isSituacao() == true) {
    			labelOpcao1.setText("Click para vizualizar");
    		}
    	}

    }
    	

    @FXML
    void sairBotao(MouseEvent event) {
    	if(event.getTarget().toString().equals("Button[id=partida1, styleClass=button]''")) {
			pane1.setVisible(false);
			if(Eliminatoria.Final.isSituacao() == true) {
				labelOpcao1.setText("Click para cadastrar");
			}
    	}
 
    }

}
    

