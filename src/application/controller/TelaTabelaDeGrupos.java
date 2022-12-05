package application.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.model.FaseDeGrupos.FaseDeGrupos;
import application.model.JogadorPackage.JogadorDaoImpl;
import application.model.PartidaPackage.Partida;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class TelaTabelaDeGrupos implements Initializable{

    @FXML
    private Label clickSelecao1Nome;

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
    private List<Label> ListaLabel = new ArrayList<Label>();
    
    
    private FaseDeGrupos faseDeGrupos;
    
    private String[] gruposNome = {"GRUPO A", "GRUPO B","GRUPO C","GRUPO D","GRUPO E","GRUPO F","GRUPO G","GRUPO H"};

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Teste
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		JogadorDaoImpl jogador = new JogadorDaoImpl(selecao.getListaSelecoes());
		FaseDeGrupos fase = new FaseDeGrupos(selecao.getListaSelecoes());
		
		try {
			selecao.leArquivoSelecoes();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			fase.geraPartidas();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		//
		choicebox.getItems().addAll(gruposNome);
		choicebox.setValue("GRUPO A");
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
		
		int i;
		if( FaseDeGrupos.partidas.get("A") != null) {
			List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
			i = 0;
			for (Partida partida : listaPartida) {
				this.ListaLabel.get(i).setText(partida.getSelecao1());
				this.ListaLabel.get(i+1).setText(partida.getSelecao2());
				this.ListaLabel.get(i+2).setText("X");
				this.ListaLabel.get(i+3).setText("X");
				i += 4;
			}}
	
		
	}
	
	public void checkchoicebox(ChoiceBox<String> choicebox) {
		String grupoChoiceBox = choicebox.getValue();
		grupo.setText(grupoChoiceBox);
		int i;
		switch (grupoChoiceBox) {
		
		case "GRUPO A":
			if( FaseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartida = FaseDeGrupos.partidas.get("A");
				i = 0;
				for (Partida partida : listaPartida) {
					this.ListaLabel.get(i).setText(partida.getSelecao1());
					this.ListaLabel.get(i+1).setText(partida.getSelecao2());
					this.ListaLabel.get(i+2).setText("X");
					this.ListaLabel.get(i+3).setText("X");
					i += 4;
				}
			}
			break;
		case "GRUPO B":
			if( this.faseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartidaB = FaseDeGrupos.partidas.get("B");
				i = 0;
				for (Partida partida : listaPartidaB) {

					this.ListaLabel.get(i).setText(partida.getSelecao1());
					this.ListaLabel.get(i+1).setText(partida.getSelecao2());
					this.ListaLabel.get(i+2).setText("X");
					this.ListaLabel.get(i+3).setText("X");
					i += 4;

				}}
			break;
		case "GRUPO C":
			if( this.faseDeGrupos.partidas.get("A") != null) {
				List<Partida> listaPartidaC = FaseDeGrupos.partidas.get("C");
				i = 0;
				for (Partida partida : listaPartidaC) {
					this.ListaLabel.get(i).setText(partida.getSelecao1());
					this.ListaLabel.get(i+1).setText(partida.getSelecao2());
					this.ListaLabel.get(i+2).setText("X");
					this.ListaLabel.get(i+3).setText("X");
					i += 4;
				}}
			break;
		case "GRUPO D":
			if( this.faseDeGrupos.partidas.get("A") != null) {
			List<Partida> listaPartidaD = FaseDeGrupos.partidas.get("D");
			i = 0;
			for (Partida partida : listaPartidaD) {
					this.ListaLabel.get(i).setText(partida.getSelecao1());
					this.ListaLabel.get(i+1).setText(partida.getSelecao2());
					this.ListaLabel.get(i+2).setText("X");
					this.ListaLabel.get(i+3).setText("X");
					i += 4;
			}}
			break;
		case "GRUPO E":
			if( this.faseDeGrupos.partidas.get("A") != null) {
			List<Partida> listaPartidaE = FaseDeGrupos.partidas.get("E");
			i = 0;
			for (Partida partida : listaPartidaE) {
					this.ListaLabel.get(i).setText(partida.getSelecao1());
					this.ListaLabel.get(i+1).setText(partida.getSelecao2());
					this.ListaLabel.get(i+2).setText("X");
					this.ListaLabel.get(i+3).setText("X");
					i += 4;
			}}
			break;
		case "GRUPO F":
			if( this.faseDeGrupos.partidas.get("A") != null) {
			List<Partida> listaPartidaF = FaseDeGrupos.partidas.get("F");
			i = 0;
			for (Partida partida : listaPartidaF) {

					this.ListaLabel.get(i).setText(partida.getSelecao1());
					this.ListaLabel.get(i+1).setText(partida.getSelecao2());
					this.ListaLabel.get(i+2).setText("X");
					this.ListaLabel.get(i+3).setText("X");
					i += 4;
			}}
			break;
		case "GRUPO G":
			if( this.faseDeGrupos.partidas.get("A") != null) {
			List<Partida> listaPartidaG = FaseDeGrupos.partidas.get("G");
			i = 0;
			for (Partida partida : listaPartidaG) {
					this.ListaLabel.get(i).setText(partida.getSelecao1());
					this.ListaLabel.get(i+1).setText(partida.getSelecao2());
					this.ListaLabel.get(i+2).setText("X");
					this.ListaLabel.get(i+3).setText("X");
					i += 4;
			}}
			break;
		case "GRUPO H":
			if( this.faseDeGrupos.partidas.get("A") != null) {
			List<Partida> listaPartidaH = FaseDeGrupos.partidas.get("H");
			i = 0;
			for (Partida partida : listaPartidaH) {
					this.ListaLabel.get(i).setText(partida.getSelecao1());
					this.ListaLabel.get(i+1).setText(partida.getSelecao2());
					this.ListaLabel.get(i+2).setText("X");
					this.ListaLabel.get(i+3).setText("X");
					i += 4;
			}}
			break;

		default:
			break;
		}
	}
}
