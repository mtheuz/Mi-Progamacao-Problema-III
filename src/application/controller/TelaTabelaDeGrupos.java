package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import application.model.FaseDeGrupos.FaseDeGrupos;
import application.model.JogadorPackage.JogadorDaoImpl;
import application.model.PartidaPackage.Partida;
import application.model.PartidaPackage.PartidaDaoImpl;
import application.model.SelecaoPackage.Selecao;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class TelaTabelaDeGrupos implements Initializable{

   
	@FXML
    private Label clickSelecao1Nome;
    @FXML
    private Pane pane3;

    @FXML
    private Label labelOpcao3;

    @FXML
    private Pane pane5;

    @FXML
    private Label labelOpcao5;

    @FXML
    private Pane pane6;

    @FXML
    private Label labelOpcao6;

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
    private Label grupo;

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
    private ChoiceBox<String> choicebox;
    
    @FXML
    private Button partida1;

    @FXML
    private Button partida2;
    
    private String grupoChoicebox; 

    
    @FXML
    private List<Label> ListaLabel = new ArrayList<Label>();
    private ArrayList <Selecao> listaSelecoes;
    private FaseDeGrupos fase;
    
    private final String enderecoCadastro = "TelaTodasPartidas";
    public SelecaoDaoImpl selecaoDao;
    
    private String[] gruposNome = {"GRUPO A", "GRUPO B","GRUPO C","GRUPO D","GRUPO E","GRUPO F","GRUPO G","GRUPO H"};
    
    public TelaTabelaDeGrupos(SelecaoDaoImpl selecaoDao, FaseDeGrupos fase) {
		this.selecaoDao = selecaoDao;
		this.fase = fase;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		choicebox.getItems().addAll(gruposNome);
		choicebox.setValue("ESCOLHA O GRUPO");
		choicebox.setOnAction(e -> checkchoicebox(choicebox));
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
		this.grupoChoicebox = "ESCOLHA O GRUPO";
		int i;
		if( FaseDeGrupos.partidas.get("A") != null) {
			List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
			i = 0;
			for (Partida partida : listaPartida) {
				this.ListaLabel.get(i).setText(partida.getSelecao1());
				this.ListaLabel.get(i+1).setText(partida.getSelecao2());
				this.ListaLabel.get(i+2).setText(partida.getPlacarSelecao1());
				this.ListaLabel.get(i+3).setText(partida.getPlacarSelecao2());
				i += 4;
			}}
	
		
	}
	@FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
	 TelaPartida controller = new TelaPartida(selecaoDao,fase);
	 Main.trocaDeTela("/application/view/Partida/TelaPartidas.fxml", controller, null);
    }
	
	@FXML
    void clickClassificacao(ActionEvent event) throws IOException {
		ControllerClassificacao controller= new ControllerClassificacao(fase, selecaoDao);
		Main.trocaDeTela("/application/view/Partida/Classificacoes.fxml", controller, null);
    }

	
	@FXML
    void buttonPartida1(MouseEvent event) throws IOException {
		switch (this.grupoChoicebox) {
		case "ESCOLHA O GRUPO" :
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
				if(listaPartida.get(0).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(0),this.selecaoDao, fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(0), "fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO A" :
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
				if(listaPartida.get(0).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(0),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(0),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO B":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("B");
				if(listaPartida.get(0).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(0),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(0),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO C":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("C");
				if(listaPartida.get(0).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(0),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(0),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;

		default:
			break;
		case "GRUPO D":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("D");
				if(listaPartida.get(0).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(0),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(0),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO E":
			if( FaseDeGrupos.partidas.get("E") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("E");
				if(listaPartida.get(0).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(0),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(0),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO F":
			if( FaseDeGrupos.partidas.get("F") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("F");
				if(listaPartida.get(0).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(0),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(0),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO G":
			if( FaseDeGrupos.partidas.get("G") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("G");
				if(listaPartida.get(0).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(0),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(0),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO H":
			if( FaseDeGrupos.partidas.get("H") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("H");
				if(listaPartida.get(0).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(0),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(0),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		}
		
		
    }
	@FXML
    void buttonPartida2(MouseEvent event) throws IOException {
		switch (this.grupoChoicebox) {
		case "ESCOLHA O GRUPO" :
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
				if(listaPartida.get(1).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(1),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(1),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO A":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
				if(listaPartida.get(1).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(1),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(1),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO B":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("B");
				if(listaPartida.get(1).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(1),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(1),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO C":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("C");
				if(listaPartida.get(1).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(1),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(1),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;

		default:
			break;
		case "GRUPO D":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("D");
				if(listaPartida.get(1).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(1),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(1),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO E":
			if( FaseDeGrupos.partidas.get("E") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("E");
				if(listaPartida.get(1).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(1),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(1),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO F":
			if( FaseDeGrupos.partidas.get("F") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("F");
				if(listaPartida.get(1).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(1),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(1),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO G":
			if( FaseDeGrupos.partidas.get("G") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("G");
				if(listaPartida.get(1).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(1),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(1),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO H":
			if( FaseDeGrupos.partidas.get("H") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("H");
				if(listaPartida.get(1).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(1),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", null, null);
				}
			}
			break;
		}
		
		
    }
	
	@FXML
    void buttonPartida3(MouseEvent event) throws IOException {
		switch (this.grupoChoicebox) {
		case "ESCOLHA O GRUPO" :
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
				if(listaPartida.get(2).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(2),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(2),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO A":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
				if(listaPartida.get(2).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(2),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(2),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO B":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("B");
				if(listaPartida.get(2).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(2),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(2),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO C":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("C");
				if(listaPartida.get(2).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(2),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(2),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;

		default:
			break;
		case "GRUPO D":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("D");
				if(listaPartida.get(2).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(2),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(2),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO E":
			if( FaseDeGrupos.partidas.get("E") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("E");
				if(listaPartida.get(2).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(2),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(2),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO F":
			if( FaseDeGrupos.partidas.get("F") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("F");
				if(listaPartida.get(2).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(2),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(2),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO G":
			if( FaseDeGrupos.partidas.get("G") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("G");
				if(listaPartida.get(2).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(2),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(2),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO H":
			if( FaseDeGrupos.partidas.get("H") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("H");
				if(listaPartida.get(2).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(2),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(2),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/MostrarPartida.fxml", controller, null);
				}
			}
			break;
		}
		
		
    }
	@FXML
    void buttonPartida4(MouseEvent event) throws IOException {
		switch (this.grupoChoicebox) {
		case "ESCOLHA O GRUPO" :
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
				if(listaPartida.get(3).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(3),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					Main.trocaDeTela("/application/view/Partida/MostrarPartida.fxml", null, null);
				}
			}
			break;
		case "GRUPO A":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
				if(listaPartida.get(3).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(3),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(3),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO B":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("B");
				if(listaPartida.get(3).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(3),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(3),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO C":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("C");
				if(listaPartida.get(3).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(3),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(3),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;

		default:
			break;
		case "GRUPO D":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("D");
				if(listaPartida.get(3).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(3),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(3),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO E":
			if( FaseDeGrupos.partidas.get("E") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("E");
				if(listaPartida.get(3).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(3),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(3),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO F":
			if( FaseDeGrupos.partidas.get("F") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("F");
				if(listaPartida.get(3).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(3),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(3),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO G":
			if( FaseDeGrupos.partidas.get("G") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("G");
				if(listaPartida.get(3).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(3),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(3),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO H":
			if( FaseDeGrupos.partidas.get("H") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("H");
				if(listaPartida.get(3).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(3),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(3),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		}
		
		
    }
	
	@FXML
    void buttonPartida5(MouseEvent event) throws IOException {
		switch (this.grupoChoicebox) {
		case "ESCOLHA O GRUPO" :
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
				if(listaPartida.get(4).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(4),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(4),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO A":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
				if(listaPartida.get(4).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(4),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(4),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO B":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("B");
				if(listaPartida.get(4).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(4),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(4),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO C":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("C");
				if(listaPartida.get(4).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(4),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(4),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
			
		case "GRUPO D":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("D");
				if(listaPartida.get(4).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(4),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(4),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
			
		case "GRUPO E":
			if( FaseDeGrupos.partidas.get("E") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("E");
				if(listaPartida.get(4).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(4),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(4),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO F":
			if( FaseDeGrupos.partidas.get("F") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("F");
				if(listaPartida.get(4).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(4),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(4),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO G":
			if( FaseDeGrupos.partidas.get("G") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("G");
				if(listaPartida.get(4).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(4),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(4),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO H":
			if( FaseDeGrupos.partidas.get("H") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("H");
				if(listaPartida.get(4).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(4),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(4),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		default:
			break;
		}
		
		
    }
	@FXML
    void buttonPartida6(MouseEvent event) throws IOException {
		switch (this.grupoChoicebox) {
		case "ESCOLHA O GRUPO" :
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
				if(listaPartida.get(5).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(5),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(5),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO A":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
				if(listaPartida.get(5).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(5),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(5),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO B":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("B");
				if(listaPartida.get(5).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(5),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(5),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO C":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("C");
				if(listaPartida.get(5).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(5),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(5),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
			
		case "GRUPO D":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("D");
				if(listaPartida.get(5).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(5),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(5),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
			
		case "GRUPO E":
			if( FaseDeGrupos.partidas.get("E") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("E");
				if(listaPartida.get(5).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(5),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(5),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO F":
			if( FaseDeGrupos.partidas.get("F") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("F");
				if(listaPartida.get(5).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(5),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(5),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO G":
			if( FaseDeGrupos.partidas.get("G") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("G");
				if(listaPartida.get(5).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(5),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(5),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		case "GRUPO H":
			if( FaseDeGrupos.partidas.get("H") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("H");
				if(listaPartida.get(5).isSituacao() == false) {
					ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(listaPartida.get(5),this.selecaoDao,fase,enderecoCadastro);
					Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
				}
				else {
					TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, listaPartida.get(5),"fase de grupos");
					Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
				}
			}
			break;
		default:
			break;
		}
		
		
    }
	@FXML
    void entrarBotao(MouseEvent event) {

		if(event.getTarget().toString().equals("Button[id=partida1, styleClass=button]''")) {
			pane1.setVisible(true);
			switch (this.grupoChoicebox) {
			case "ESCOLHA O GRUPO" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(0).isSituacao() == true) {
						labelOpcao1.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO A" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(0).isSituacao() == true) {
						labelOpcao1.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO B":
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("B");
					if(listaPartida.get(0).isSituacao() == true) {
						labelOpcao1.setText("Click para vizualizar");
					}
				}
			case "GRUPO C":
				if( FaseDeGrupos.partidas.get("C") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("C");
					if(listaPartida.get(0).isSituacao() == true) {
						labelOpcao1.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO D":
				if( FaseDeGrupos.partidas.get("D") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("D");
					if(listaPartida.get(0).isSituacao() == true) {
						labelOpcao1.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO E":
				if( FaseDeGrupos.partidas.get("E") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("E");
					if(listaPartida.get(0).isSituacao() == true) {
						labelOpcao1.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO F":
				if( FaseDeGrupos.partidas.get("F") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("F");
					if(listaPartida.get(0).isSituacao() == true) {
						labelOpcao1.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO G":
				if( FaseDeGrupos.partidas.get("G") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("G");
					if(listaPartida.get(0).isSituacao() == true) {
						labelOpcao1.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO H":
				if( FaseDeGrupos.partidas.get("H") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("H");
					if(listaPartida.get(0).isSituacao() == true) {
						labelOpcao1.setText("Click para vizualizar");
					}
				}
				break;

			}

		}
		else if(event.getTarget().toString().equals("Button[id=partida2, styleClass=button]''")){
			pane2.setVisible(true);
			switch (this.grupoChoicebox) {
			case "ESCOLHA O GRUPO" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(1).isSituacao() == true) {
						labelOpcao2.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO A" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(1).isSituacao() == true) {
						labelOpcao2.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO B":
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("B");
					if(listaPartida.get(1).isSituacao() == true) {
						labelOpcao2.setText("Click para vizualizar");
					}
				}
			case "GRUPO C":
				if( FaseDeGrupos.partidas.get("C") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("C");
					if(listaPartida.get(1).isSituacao() == true) {
						labelOpcao2.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO D":
				if( FaseDeGrupos.partidas.get("D") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("D");
					if(listaPartida.get(1).isSituacao() == true) {
						labelOpcao2.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO E":
				if( FaseDeGrupos.partidas.get("E") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("E");
					if(listaPartida.get(1).isSituacao() == true) {
						labelOpcao2.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO F":
				if( FaseDeGrupos.partidas.get("F") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("F");
					if(listaPartida.get(1).isSituacao() == true) {
						labelOpcao2.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO G":
				if( FaseDeGrupos.partidas.get("G") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("G");
					if(listaPartida.get(1).isSituacao() == true) {
						labelOpcao2.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO H":
				if( FaseDeGrupos.partidas.get("H") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("H");
					if(listaPartida.get(1).isSituacao() == true) {
						labelOpcao2.setText("Click para vizualizar");
					}
				}
				break;

			}
		}
		else if(event.getTarget().toString().equals("Button[id=partida3, styleClass=button]''")){
			pane3.setVisible(true);
			switch (this.grupoChoicebox) {
			case "ESCOLHA O GRUPO" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(2).isSituacao() == true) {
						labelOpcao3.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO A" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(2).isSituacao() == true) {
						labelOpcao3.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO B":
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("B");
					if(listaPartida.get(2).isSituacao() == true) {
						labelOpcao3.setText("Click para vizualizar");
					}
				}
			case "GRUPO C":
				if( FaseDeGrupos.partidas.get("C") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("C");
					if(listaPartida.get(2).isSituacao() == true) {
						labelOpcao3.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO D":
				if( FaseDeGrupos.partidas.get("D") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("D");
					if(listaPartida.get(2).isSituacao() == true) {
						labelOpcao3.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO E":
				if( FaseDeGrupos.partidas.get("E") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("E");
					if(listaPartida.get(2).isSituacao() == true) {
						labelOpcao3.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO F":
				if( FaseDeGrupos.partidas.get("F") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("F");
					if(listaPartida.get(2).isSituacao() == true) {
						labelOpcao3.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO G":
				if( FaseDeGrupos.partidas.get("G") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("G");
					if(listaPartida.get(2).isSituacao() == true) {
						labelOpcao3.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO H":
				if( FaseDeGrupos.partidas.get("H") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("H");
					if(listaPartida.get(2).isSituacao() == true) {
						labelOpcao3.setText("Click para vizualizar");
					}
				}
				break;

			}
		}
		else if(event.getTarget().toString().equals("Button[id=partida4, styleClass=button]''")){
			pane4.setVisible(true);
			switch (this.grupoChoicebox) {
			case "ESCOLHA O GRUPO" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO A" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO B":
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("B");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para vizualizar");
					}
				}
			case "GRUPO C":
				if( FaseDeGrupos.partidas.get("C") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("C");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO D":
				if( FaseDeGrupos.partidas.get("D") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("D");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO E":
				if( FaseDeGrupos.partidas.get("E") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("E");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO F":
				if( FaseDeGrupos.partidas.get("F") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("F");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO G":
				if( FaseDeGrupos.partidas.get("G") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("G");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO H":
				if( FaseDeGrupos.partidas.get("H") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("H");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para vizualizar");
					}
				}
				break;

			}
		}
		else if(event.getTarget().toString().equals("Button[id=partida5, styleClass=button]''")){
			pane5.setVisible(true);
			switch (this.grupoChoicebox) {
			case "ESCOLHA O GRUPO" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(4).isSituacao() == true) {
						labelOpcao5.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO A" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(4).isSituacao() == true) {
						labelOpcao5.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO B":
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("B");
					if(listaPartida.get(4).isSituacao() == true) {
						labelOpcao5.setText("Click para vizualizar");
					}
				}
			case "GRUPO C":
				if( FaseDeGrupos.partidas.get("C") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("C");
					if(listaPartida.get(4).isSituacao() == true) {
						labelOpcao5.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO D":
				if( FaseDeGrupos.partidas.get("D") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("D");
					if(listaPartida.get(4).isSituacao() == true) {
						labelOpcao5.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO E":
				if( FaseDeGrupos.partidas.get("E") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("E");
					if(listaPartida.get(4).isSituacao() == true) {
						labelOpcao5.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO F":
				if( FaseDeGrupos.partidas.get("F") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("F");
					if(listaPartida.get(4).isSituacao() == true) {
						labelOpcao5.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO G":
				if( FaseDeGrupos.partidas.get("G") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("G");
					if(listaPartida.get(4).isSituacao() == true) {
						labelOpcao5.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO H":
				if( FaseDeGrupos.partidas.get("H") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("H");
					if(listaPartida.get(4).isSituacao() == true) {
						labelOpcao5.setText("Click para vizualizar");
					}
				}
				break;

			}
		}
		else if(event.getTarget().toString().equals("Button[id=partida6, styleClass=button]''")){
			pane6.setVisible(true);
			switch (this.grupoChoicebox) {
			case "ESCOLHA O GRUPO" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(0).isSituacao() == true) {
						labelOpcao6.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO A" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(0).isSituacao() == true) {
						labelOpcao6.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO B":
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("B");
					if(listaPartida.get(0).isSituacao() == true) {
						labelOpcao6.setText("Click para vizualizar");
					}
				}
			case "GRUPO C":
				if( FaseDeGrupos.partidas.get("C") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("C");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO D":
				if( FaseDeGrupos.partidas.get("D") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("D");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO E":
				if( FaseDeGrupos.partidas.get("E") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("E");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO F":
				if( FaseDeGrupos.partidas.get("F") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("F");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO G":
				if( FaseDeGrupos.partidas.get("G") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("G");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para vizualizar");
					}
				}
				break;
			case "GRUPO H":
				if( FaseDeGrupos.partidas.get("H") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("H");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para vizualizar");
					}
				}
				break;

			}
		}
    }
	
	@FXML
    void sairBotao(MouseEvent event) {
		if(event.getTarget().toString().equals("Button[id=partida1, styleClass=button]''")) {
			pane1.setVisible(false);
			switch (this.grupoChoicebox) {
			case "ESCOLHA O GRUPO" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(0).isSituacao() == true) {
						labelOpcao1.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO A" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(0).isSituacao() == true) {
						labelOpcao1.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO B":
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("B");
					if(listaPartida.get(0).isSituacao() == true) {
						labelOpcao1.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO C":
				if( FaseDeGrupos.partidas.get("C") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("C");
					if(listaPartida.get(0).isSituacao() == true) {
						labelOpcao1.setText("Click para cadastrar");
					}
				}
			case "GRUPO D":
				if( FaseDeGrupos.partidas.get("D") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("D");
					if(listaPartida.get(0).isSituacao() == true) {
						labelOpcao1.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO E":
				if( FaseDeGrupos.partidas.get("E") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("E");
					if(listaPartida.get(0).isSituacao() == true) {
						labelOpcao1.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO F":
				if( FaseDeGrupos.partidas.get("F") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("F");
					if(listaPartida.get(0).isSituacao() == true) {
						labelOpcao1.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO G":
				if( FaseDeGrupos.partidas.get("G") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("G");
					if(listaPartida.get(0).isSituacao() == true) {
						labelOpcao1.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO H":
				if( FaseDeGrupos.partidas.get("H") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("H");
					if(listaPartida.get(0).isSituacao() == true) {
						labelOpcao1.setText("Click para cadastrar");
					}
				}
				break;
			

			}
		}
		else if(event.getTarget().toString().equals("Button[id=partida2, styleClass=button]''")){
			pane2.setVisible(false);
			switch (this.grupoChoicebox) {
			case "ESCOLHA O GRUPO" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(1).isSituacao() == true) {
						labelOpcao2.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO A" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(1).isSituacao() == true) {
						labelOpcao2.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO B":
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("B");
					if(listaPartida.get(1).isSituacao() == true) {
						labelOpcao2.setText("Click para cadastrar");
					}
				}
			case "GRUPO C":
				if( FaseDeGrupos.partidas.get("C") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("C");
					if(listaPartida.get(1).isSituacao() == true) {
						labelOpcao2.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO D":
				if( FaseDeGrupos.partidas.get("D") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("D");
					if(listaPartida.get(1).isSituacao() == true) {
						labelOpcao2.setText("Click para cadastrar");
					}
				}
			case "GRUPO E":
				if( FaseDeGrupos.partidas.get("E") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("E");
					if(listaPartida.get(1).isSituacao() == true) {
						labelOpcao2.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO F":
				if( FaseDeGrupos.partidas.get("F") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("F");
					if(listaPartida.get(1).isSituacao() == true) {
						labelOpcao2.setText("Click para cadastrar");
					}
				}
			case "GRUPO G":
				if( FaseDeGrupos.partidas.get("G") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("G");
					if(listaPartida.get(1).isSituacao() == true) {
						labelOpcao2.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO H":
				if( FaseDeGrupos.partidas.get("H") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("H");
					if(listaPartida.get(1).isSituacao() == true) {
						labelOpcao2.setText("Click para cadastrar");
					}
				}
				break;

			}
		}
		else if(event.getTarget().toString().equals("Button[id=partida3, styleClass=button]''")){
			pane3.setVisible(false);
			switch (this.grupoChoicebox) {
			case "ESCOLHA O GRUPO" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(2).isSituacao() == true) {
						labelOpcao3.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO A" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(2).isSituacao() == true) {
						labelOpcao3.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO B":
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("B");
					if(listaPartida.get(2).isSituacao() == true) {
						labelOpcao3.setText("Click para cadastrar");
					}
				}
			case "GRUPO C":
				if( FaseDeGrupos.partidas.get("C") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("C");
					if(listaPartida.get(2).isSituacao() == true) {
						labelOpcao3.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO D":
				if( FaseDeGrupos.partidas.get("D") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("D");
					if(listaPartida.get(2).isSituacao() == true) {
						labelOpcao3.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO E":
				if( FaseDeGrupos.partidas.get("E") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("E");
					if(listaPartida.get(2).isSituacao() == true) {
						labelOpcao3.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO F":
				if( FaseDeGrupos.partidas.get("F") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("F");
					if(listaPartida.get(2).isSituacao() == true) {
						labelOpcao3.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO G":
				if( FaseDeGrupos.partidas.get("G") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("G");
					if(listaPartida.get(2).isSituacao() == true) {
						labelOpcao3.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO H":
				if( FaseDeGrupos.partidas.get("H") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("H");
					if(listaPartida.get(2).isSituacao() == true) {
						labelOpcao3.setText("Click para cadastrar");
					}
				}
				break;

			}
		}
		else if(event.getTarget().toString().equals("Button[id=partida4, styleClass=button]''")){
			pane4.setVisible(false);
			switch (this.grupoChoicebox) {
			case "ESCOLHA O GRUPO" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(3).isSituacao() == true) {
						labelOpcao4.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO A" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(3).isSituacao() == true) {
						labelOpcao4.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO B":
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("B");
					if(listaPartida.get(3).isSituacao() == true) {
						labelOpcao4.setText("Click para cadastrar");
					}
				}
			case "GRUPO C":
				if( FaseDeGrupos.partidas.get("C") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("C");
					if(listaPartida.get(3).isSituacao() == true) {
						labelOpcao4.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO D":
				if( FaseDeGrupos.partidas.get("D") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("D");
					if(listaPartida.get(3).isSituacao() == true) {
						labelOpcao4.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO E":
				if( FaseDeGrupos.partidas.get("E") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("E");
					if(listaPartida.get(3).isSituacao() == true) {
						labelOpcao4.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO F":
				if( FaseDeGrupos.partidas.get("F") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("F");
					if(listaPartida.get(3).isSituacao() == true) {
						labelOpcao4.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO G":
				if( FaseDeGrupos.partidas.get("G") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("G");
					if(listaPartida.get(3).isSituacao() == true) {
						labelOpcao4.setText("Click para cadastrar");
					}
				}
				
			case "GRUPO H":
				if( FaseDeGrupos.partidas.get("H") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("H");
					if(listaPartida.get(3).isSituacao() == true) {
						labelOpcao4.setText("Click para cadastrar");
					}
				}
				break;
			}
		}
		else if(event.getTarget().toString().equals("Button[id=partida5, styleClass=button]''")){
			pane5.setVisible(false);
			switch (this.grupoChoicebox) {
			case "ESCOLHA O GRUPO" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(4).isSituacao() == true) {
						labelOpcao5.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO A" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(4).isSituacao() == true) {
						labelOpcao5.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO B":
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("B");
					if(listaPartida.get(4).isSituacao() == true) {
						labelOpcao5.setText("Click para cadastrar");
					}
				}
			case "GRUPO C":
				if( FaseDeGrupos.partidas.get("C") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("C");
					if(listaPartida.get(4).isSituacao() == true) {
						labelOpcao5.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO D":
				if( FaseDeGrupos.partidas.get("D") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("D");
					if(listaPartida.get(4).isSituacao() == true) {
						labelOpcao5.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO E":
				if( FaseDeGrupos.partidas.get("E") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("E");
					if(listaPartida.get(4).isSituacao() == true) {
						labelOpcao5.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO F":
				if( FaseDeGrupos.partidas.get("F") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("F");
					if(listaPartida.get(4).isSituacao() == true) {
						labelOpcao5.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO G":
				if( FaseDeGrupos.partidas.get("G") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("G");
					if(listaPartida.get(4).isSituacao() == true) {
						labelOpcao5.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO H":
				if( FaseDeGrupos.partidas.get("H") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("H");
					if(listaPartida.get(4).isSituacao() == true) {
						labelOpcao5.setText("Click para cadastrar");
					}
				}
				break;

			}
		}
		else if(event.getTarget().toString().equals("Button[id=partida6, styleClass=button]''")){
			pane6.setVisible(false);
			switch (this.grupoChoicebox) {
			case "ESCOLHA O GRUPO" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO A" :
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO B":
				if( FaseDeGrupos.partidas.get("A") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("B");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO C":
				if( FaseDeGrupos.partidas.get("C") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("C");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO D":
				if( FaseDeGrupos.partidas.get("D") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("D");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO E":
				if( FaseDeGrupos.partidas.get("E") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("E");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO F":
				if( FaseDeGrupos.partidas.get("F") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("F");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO G":
				if( FaseDeGrupos.partidas.get("G") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("G");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para cadastrar");
					}
				}
				break;
			case "GRUPO H":
				if( FaseDeGrupos.partidas.get("H") != null) {
					List<Partida> listaPartida = FaseDeGrupos.partidas.get("H");
					if(listaPartida.get(5).isSituacao() == true) {
						labelOpcao6.setText("Click para cadastrar");
					}
				}
				break;

			}
		}
    }
	
	
	public void checkchoicebox(ChoiceBox<String> choicebox) {
		this.grupoChoicebox = choicebox.getValue();
		grupo.setText(this.grupoChoicebox);
		int i;
		switch (this.grupoChoicebox) {
		
		case "GRUPO A":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
				i = 0;
				for (Partida partida : listaPartida) {
					this.ListaLabel.get(i).setText(partida.getSelecao1());
					this.ListaLabel.get(i+1).setText(partida.getSelecao2());
					this.ListaLabel.get(i+2).setText(partida.getPlacarSelecao1());
					this.ListaLabel.get(i+3).setText(partida.getPlacarSelecao2());
					i += 4;
				}
			}
			break;
		case "GRUPO B":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartidaB = FaseDeGrupos.partidas.get("B");
				i = 0;
				for (Partida partida : listaPartidaB) {

					this.ListaLabel.get(i).setText(partida.getSelecao1());
					this.ListaLabel.get(i+1).setText(partida.getSelecao2());
					this.ListaLabel.get(i+2).setText(partida.getPlacarSelecao1());
					this.ListaLabel.get(i+3).setText(partida.getPlacarSelecao2());
					i += 4;

				}}
			break;
		case "GRUPO C":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartidaC = FaseDeGrupos.partidas.get("C");
				i = 0;
				for (Partida partida : listaPartidaC) {
					this.ListaLabel.get(i).setText(partida.getSelecao1());
					this.ListaLabel.get(i+1).setText(partida.getSelecao2());
					this.ListaLabel.get(i+2).setText(partida.getPlacarSelecao1());
					this.ListaLabel.get(i+3).setText(partida.getPlacarSelecao2());
					i += 4;
				}}
			break;
		case "GRUPO D":
			if( FaseDeGrupos.partidas.get("A") != null) {
			List<Partida> listaPartidaD = FaseDeGrupos.partidas.get("D");
			i = 0;
			for (Partida partida : listaPartidaD) {
					this.ListaLabel.get(i).setText(partida.getSelecao1());
					this.ListaLabel.get(i+1).setText(partida.getSelecao2());
					this.ListaLabel.get(i+2).setText(partida.getPlacarSelecao1());
					this.ListaLabel.get(i+3).setText(partida.getPlacarSelecao2());
					i += 4;
			}}
			break;
		case "GRUPO E":
			if( FaseDeGrupos.partidas.get("A") != null) {
			List<Partida> listaPartidaE = FaseDeGrupos.partidas.get("E");
			i = 0;
			for (Partida partida : listaPartidaE) {
					this.ListaLabel.get(i).setText(partida.getSelecao1());
					this.ListaLabel.get(i+1).setText(partida.getSelecao2());
					this.ListaLabel.get(i+2).setText(partida.getPlacarSelecao1());
					this.ListaLabel.get(i+3).setText(partida.getPlacarSelecao2());
					i += 4;
			}}
			break;
		case "GRUPO F":
			if( FaseDeGrupos.partidas.get("A") != null) {
			List<Partida> listaPartidaF = FaseDeGrupos.partidas.get("F");
			i = 0;
			for (Partida partida : listaPartidaF) {

					this.ListaLabel.get(i).setText(partida.getSelecao1());
					this.ListaLabel.get(i+1).setText(partida.getSelecao2());
					this.ListaLabel.get(i+2).setText(partida.getPlacarSelecao1());
					this.ListaLabel.get(i+3).setText(partida.getPlacarSelecao2());
					i += 4;
			}}
			break;
		case "GRUPO G":
			if( FaseDeGrupos.partidas.get("A") != null) {
			List<Partida> listaPartidaG = FaseDeGrupos.partidas.get("G");
			i = 0;
			for (Partida partida : listaPartidaG) {
					this.ListaLabel.get(i).setText(partida.getSelecao1());
					this.ListaLabel.get(i+1).setText(partida.getSelecao2());
					this.ListaLabel.get(i+2).setText(partida.getPlacarSelecao1());
					this.ListaLabel.get(i+3).setText(partida.getPlacarSelecao2());
					i += 4;
			}}
			break;
		case "GRUPO H":
			if( FaseDeGrupos.partidas.get("A") != null) {
			List<Partida> listaPartidaH = FaseDeGrupos.partidas.get("H");
			i = 0;
			for (Partida partida : listaPartidaH) {
					this.ListaLabel.get(i).setText(partida.getSelecao1());
					this.ListaLabel.get(i+1).setText(partida.getSelecao2());
					this.ListaLabel.get(i+2).setText(partida.getPlacarSelecao1());
					this.ListaLabel.get(i+3).setText(partida.getPlacarSelecao2());
					i += 4;
			}}
			break;

		default:
			break;
		}
	}
}
