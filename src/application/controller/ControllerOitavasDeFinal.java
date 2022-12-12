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

public class ControllerOitavasDeFinal implements Initializable{

    

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
    private Pane pane5;
    @FXML
    private Pane pane6;
    @FXML
    private Pane pane7;
    @FXML
    private Pane pane8;

    @FXML
    private Label labelOpcao1;
    @FXML
    private Label labelOpcao5;
    @FXML
    private Label labelOpcao6;
    @FXML
    private Label labelOpcao7;
    @FXML
    private Label labelOpcao8;

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

  
    @FXML
    private Label clickSelecao1Nome5;

    @FXML
    private Label clickSelecao2Nome5;

    @FXML
    private Label clickSelecao1Placar5;

    @FXML
    private Label clickSelecao2Placar5;

    @FXML
    private Label clickSelecao1Nome6;

    @FXML
    private Label clickSelecao2Nome6;

    @FXML
    private Label clickSelecao1Placar6;

    @FXML
    private Label clickSelecao2Placar6;

    @FXML
    private Label clickSelecao1Nome8;

    @FXML
    private Label clickSelecao2Nome8;

    @FXML
    private Label clickSelecao1Placar8;

    @FXML
    private Label clickSelecao2Placar8;

    @FXML
    private Label clickSelecao1Nome7;

    @FXML
    private Label clickSelecao2Nome7;

    @FXML
    private Label clickSelecao1Placar7;

    @FXML
    private Label clickSelecao2Placar7;

    @FXML
    private Button partida8;

    @FXML
    private Button partida7;

    @FXML
    private Button partida5;
    @FXML
    private List<Label> ListaLabel = new ArrayList<Label>();
    @FXML
    private Button partida6;
    FaseDeGrupos fase;
    SelecaoDaoImpl selecaoDao;
    private final String faseCadastro = "OitavasDeFinal";
    
    public ControllerOitavasDeFinal(FaseDeGrupos fase, SelecaoDaoImpl selecaoDao) {
		this.fase = fase;
		this.selecaoDao = selecaoDao;
		Eliminatoria.tranforsmaEmEliminatoria(Eliminatoria.oitavas);
		
		
	}
    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaPartida controller = new TelaPartida(selecaoDao,fase);
   	 	Main.trocaDeTela("/application/view/Partida/TelaPartidas.fxml", controller, null);
    }
    @FXML
    void buttonPartida1(MouseEvent event) throws IOException {
    	
    	if(Eliminatoria.oitavas != null) {
    		if(Eliminatoria.oitavas.get(0).isSituacao() == false) {
    			ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(Eliminatoria.oitavas.get(0),this.selecaoDao, fase,faseCadastro);
    			Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
    		}
    		else {
    			Main.trocaDeTela("/application/view/Partida/MostrarPartida.fxml", null, null);
    		}
    	}
    }

    @FXML
    void buttonPartida2(MouseEvent event) throws IOException {
    	if(Eliminatoria.oitavas != null) {
    		if(Eliminatoria.oitavas.get(1).isSituacao() == false) {
    			ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(Eliminatoria.oitavas.get(1),this.selecaoDao, fase,faseCadastro);
    			Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
    		}
    		else {
    			Main.trocaDeTela("/application/view/Partida/MostrarPartida.fxml", null, null);
    		}
    	}
    }


    @FXML
    void buttonPartida3(MouseEvent event) throws IOException {
    	if(Eliminatoria.oitavas != null) {
    		if(Eliminatoria.oitavas.get(2).isSituacao() == false) {
    			ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(Eliminatoria.oitavas.get(2),this.selecaoDao, fase,faseCadastro);
    			Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
    		}
    		else {
    			Main.trocaDeTela("/application/view/Partida/MostrarPartida.fxml", null, null);
    		}
    	}
    }

    @FXML
    void buttonPartida4(MouseEvent event) throws IOException {
    	if(Eliminatoria.oitavas != null) {
    		if(Eliminatoria.oitavas.get(3).isSituacao() == false) {
    			ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(Eliminatoria.oitavas.get(3),this.selecaoDao, fase,faseCadastro);
    			Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
    		}
    		else {
    			Main.trocaDeTela("/application/view/Partida/MostrarPartida.fxml", null, null);
    		}
    	}

    }
    
    @FXML
    void buttonPartida5(MouseEvent event) throws IOException {
    	if(Eliminatoria.oitavas != null) {
    		if(Eliminatoria.oitavas.get(4).isSituacao() == false) {
    			ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(Eliminatoria.oitavas.get(4),this.selecaoDao, fase,faseCadastro);
    			Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
    		}
    		else {
    			Main.trocaDeTela("/application/view/Partida/MostrarPartida.fxml", null, null);
    		}
    	}
    }

    @FXML
    void buttonPartida6(MouseEvent event) throws IOException {
    	if(Eliminatoria.oitavas != null) {
    		if(Eliminatoria.oitavas.get(5).isSituacao() == false) {
    			ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(Eliminatoria.oitavas.get(5),this.selecaoDao, fase,faseCadastro);
    			Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
    		}
    		else {
    			Main.trocaDeTela("/application/view/Partida/MostrarPartida.fxml", null, null);
    		}
    	}
    }

    @FXML
    void buttonPartida7(MouseEvent event) throws IOException {
    	if(Eliminatoria.oitavas != null) {
    		if(Eliminatoria.oitavas.get(6).isSituacao() == false) {
    			ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(Eliminatoria.oitavas.get(6),this.selecaoDao, fase,faseCadastro);
    			Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
    		}
    		else {
    			Main.trocaDeTela("/application/view/Partida/MostrarPartida.fxml", null, null);
    		}
    	}
    }

    @FXML
    void buttonPartida8(MouseEvent event) throws IOException {
    	if(Eliminatoria.oitavas != null) {
    		if(Eliminatoria.oitavas.get(7).isSituacao() == false) {
    			ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(Eliminatoria.oitavas.get(7),this.selecaoDao, fase,faseCadastro);
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
			if(Eliminatoria.oitavas.get(0).isSituacao() == true) {
				labelOpcao1.setText("Click para vizualizar");
			}
    	}
    	if(event.getTarget().toString().equals("Button[id=partida2, styleClass=button]''")) {
			pane2.setVisible(true);
			if(Eliminatoria.oitavas.get(1).isSituacao() == true) {
				labelOpcao2.setText("Click para vizualizar");
			}
    	}
    	if(event.getTarget().toString().equals("Button[id=partida3, styleClass=button]''")) {
			pane3.setVisible(true);
			if(Eliminatoria.oitavas.get(2).isSituacao() == true) {
				labelOpcao3.setText("Click para vizualizar");
			}
    	}
    	if(event.getTarget().toString().equals("Button[id=partida4, styleClass=button]''")) {
			pane4.setVisible(true);
			if(Eliminatoria.oitavas.get(3).isSituacao() == true) {
				labelOpcao4.setText("Click para vizualizar");
			}
    	}
    	if(event.getTarget().toString().equals("Button[id=partida5, styleClass=button]''")) {
			pane5.setVisible(true);
			if(Eliminatoria.oitavas.get(4).isSituacao() == true) {
				labelOpcao5.setText("Click para vizualizar");
			}
    	}
    	if(event.getTarget().toString().equals("Button[id=partida6, styleClass=button]''")) {
			pane6.setVisible(true);
			if(Eliminatoria.oitavas.get(5).isSituacao() == true) {
				labelOpcao6.setText("Click para vizualizar");
			}
    	}
    	if(event.getTarget().toString().equals("Button[id=partida7, styleClass=button]''")) {
			pane7.setVisible(true);
			if(Eliminatoria.oitavas.get(6).isSituacao() == true) {
				labelOpcao7.setText("Click para vizualizar");
			}
    	}
    	if(event.getTarget().toString().equals("Button[id=partida8, styleClass=button]''")) {
			pane8.setVisible(true);
			if(Eliminatoria.oitavas.get(7).isSituacao() == true) {
				labelOpcao8.setText("Click para vizualizar");
			}
    	}
    	

    }

    @FXML
    void sairBotao(MouseEvent event) {
    	if(event.getTarget().toString().equals("Button[id=partida1, styleClass=button]''")) {
			pane1.setVisible(false);
			if(Eliminatoria.oitavas.get(0).isSituacao() == true) {
				labelOpcao1.setText("Click para cadastrar");
			}
    	}
    	if(event.getTarget().toString().equals("Button[id=partida2, styleClass=button]''")) {
			pane2.setVisible(false);
			if(Eliminatoria.oitavas.get(1).isSituacao() == true) {
				labelOpcao2.setText("Click para cadastrar");
			}
    	}
    	if(event.getTarget().toString().equals("Button[id=partida3, styleClass=button]''")) {
			pane3.setVisible(false);
			if(Eliminatoria.oitavas.get(2).isSituacao() == true) {
				labelOpcao3.setText("Click para cadastrar");
			}
    	}
    	if(event.getTarget().toString().equals("Button[id=partida4, styleClass=button]''")) {
			pane4.setVisible(false);
			if(Eliminatoria.oitavas.get(3).isSituacao() == true) {
				labelOpcao4.setText("Click para cadastrar");
			}
    	}
    	if(event.getTarget().toString().equals("Button[id=partida5, styleClass=button]''")) {
			pane5.setVisible(false);
			if(Eliminatoria.oitavas.get(4).isSituacao() == true) {
				labelOpcao5.setText("Click para cadastrar");
			}
    	}
    	if(event.getTarget().toString().equals("Button[id=partida6, styleClass=button]''")) {
			pane6.setVisible(false);
			if(Eliminatoria.oitavas.get(5).isSituacao() == true) {
				labelOpcao6.setText("Click para cadastrar");
			}
    	}
    	if(event.getTarget().toString().equals("Button[id=partida7, styleClass=button]''")) {
			pane7.setVisible(false);
			if(Eliminatoria.oitavas.get(6).isSituacao() == true) {
				labelOpcao7.setText("Click para cadastrar");
			}
    	}
    	if(event.getTarget().toString().equals("Button[id=partida8, styleClass=button]''")) {
			pane8.setVisible(false);
			if(Eliminatoria.oitavas.get(7).isSituacao() == true) {
				labelOpcao8.setText("Click para cadastrar");
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
		
		ListaLabel.add(clickSelecao1Nome3);
		ListaLabel.add(clickSelecao2Nome3);
		ListaLabel.add(clickSelecao1Placar3);
		ListaLabel.add(clickSelecao2Placar3);
		
		ListaLabel.add(clickSelecao1Nome4);
		ListaLabel.add(clickSelecao2Nome4);
		ListaLabel.add(clickSelecao1Placar4);
		ListaLabel.add(clickSelecao2Placar4);
		
		ListaLabel.add(clickSelecao1Nome5);
		ListaLabel.add(clickSelecao2Nome5);
		ListaLabel.add(clickSelecao1Placar5);
		ListaLabel.add(clickSelecao2Placar5);
		
		ListaLabel.add(clickSelecao1Nome6);
		ListaLabel.add(clickSelecao2Nome6);
		ListaLabel.add(clickSelecao1Placar6);
		ListaLabel.add(clickSelecao2Placar6);
		
		ListaLabel.add(clickSelecao1Nome7);
		ListaLabel.add(clickSelecao2Nome7);
		ListaLabel.add(clickSelecao1Placar7);
		ListaLabel.add(clickSelecao2Placar7);
		
		ListaLabel.add(clickSelecao1Nome8);
		ListaLabel.add(clickSelecao2Nome8);
		ListaLabel.add(clickSelecao1Placar8);
		ListaLabel.add(clickSelecao2Placar8);
		int i = 0;;
		for (Partida partida : Eliminatoria.oitavas) {
			this.ListaLabel.get(i).setText(partida.getSelecao1());
			this.ListaLabel.get(i+1).setText(partida.getSelecao2());
			this.ListaLabel.get(i+2).setText(partida.getPlacarSelecao1());
			this.ListaLabel.get(i+3).setText(partida.getPlacarSelecao2());
			i += 4;
		}
		
	}
    
    

}

