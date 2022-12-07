package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.model.FaseDeGrupos.FaseDeGrupos;
import application.model.JogadorPackage.Jogador;
import application.model.JogadorPackage.JogadorDaoImpl;
import application.model.PartidaPackage.PartidaDaoImpl;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerCadastroPartida implements Initializable{

    @FXML
    private TextField placarSelecao1;

    @FXML
    private TextField placarSelecao2;

    @FXML
    private TextField hora;

    @FXML
    private TextField minuto;

    @FXML
    private TextField dia;

    @FXML
    private TextField mes;

    @FXML
    private TextField ano;

    @FXML
    private TextField cartaoAmareloSelecao1;

    @FXML
    private TextField cartaoVermelhosSelecao1;

    @FXML
    private TextField golsSelecao1;

    @FXML
    private Label nomeSelecao1;

    @FXML
    private Label nomeSelecao2;

    @FXML
    private ChoiceBox<String> choiceBoxEstadios;

    @FXML
    private ChoiceBox<String> choiceBoxJogadoresSelecao1G;

    @FXML
    private Button buttonGolsSelecao1;

    @FXML
    private ChoiceBox<String> choiceBoxJogadoresSelecao1CA;

    @FXML
    private Button buttonCartoesAmarelosSelecao1;

    @FXML
    private ChoiceBox<String> choiceBoxJogadoresSelecao1;

    @FXML
    private Button buttonCartoesVermelhosSelecao1;

    @FXML
    private TextField golsSelecao2;

    @FXML
    private ChoiceBox<String> choiceBoxJogadoresSelecao2G;

    @FXML
    private ChoiceBox<String> choiceBoxJogadoresSelecao2CA;

    @FXML
    private ChoiceBox<String> choiceBoxJogadoresSelecao2;
    
    private List<String> jogadores;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		JogadorDaoImpl jogadorDao = new JogadorDaoImpl(SelecaoDaoImpl.listaSelecoes);
		FaseDeGrupos fase = new FaseDeGrupos(selecao.getListaSelecoes());
		PartidaDaoImpl partidaDao = new PartidaDaoImpl(SelecaoDaoImpl.listaSelecoes); 
		
		try {
			selecao.leArquivoSelecoes();
			jogadorDao.transformaEmMap();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			fase.geraPartidas();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		this.jogadores = new ArrayList<String>(); 
		choiceBoxEstadios.getItems().addAll(PartidaDaoImpl.estadios);
		choiceBoxEstadios.setValue("ESCOLHA O ESTADIO");
		choiceBoxEstadios.setOnAction(e -> clickChoiceBoxEstadios(choiceBoxEstadios));
		for (Jogador jogador : SelecaoDaoImpl.listaSelecoes.get(0).getListaJogadores()) {
			this.jogadores.add(jogador.getNome());
		}
		
		choiceBoxJogadoresSelecao1G.getItems().addAll(this.jogadores);
		choiceBoxJogadoresSelecao1G.setValue("ESCOLHA O JOGADOR");
		choiceBoxJogadoresSelecao1G.setOnAction(e -> clickChoiceBoxEstadios(choiceBoxEstadios));
		
		choiceBoxJogadoresSelecao1CA.getItems().addAll(this.jogadores);
		choiceBoxJogadoresSelecao1CA.setValue("ESCOLHA O JOGADOR");
		choiceBoxJogadoresSelecao1CA.setOnAction(e -> clickChoiceBoxEstadios(choiceBoxEstadios));
		
		choiceBoxJogadoresSelecao1.getItems().addAll(this.jogadores);
		choiceBoxJogadoresSelecao1.setValue("ESCOLHA O JOGADOR");
		choiceBoxJogadoresSelecao1.setOnAction(e -> clickChoiceBoxEstadios(choiceBoxEstadios));
		
		choiceBoxJogadoresSelecao2G.getItems().addAll(this.jogadores);
		choiceBoxJogadoresSelecao2G.setValue("ESCOLHA O JOGADOR");
		choiceBoxJogadoresSelecao2G.setOnAction(e -> clickChoiceBoxEstadios(choiceBoxEstadios));
		
		choiceBoxJogadoresSelecao2CA.getItems().addAll(this.jogadores);
		choiceBoxJogadoresSelecao2CA.setValue("ESCOLHA O JOGADOR");
		choiceBoxJogadoresSelecao2CA.setOnAction(e -> clickChoiceBoxEstadios(choiceBoxEstadios));
		
		choiceBoxJogadoresSelecao2.getItems().addAll(this.jogadores);
		choiceBoxJogadoresSelecao2.setValue("ESCOLHA O JOGADOR");
		choiceBoxJogadoresSelecao2.setOnAction(e -> clickChoiceBoxEstadios(choiceBoxEstadios));
		
		
	}
	
	public void clickChoiceBoxEstadios(ChoiceBox<String> choiceBoxEstadios) {
		String estadio = choiceBoxEstadios.getValue();
		
	}
	
	@FXML
	void clickbuttonGolsSelecao1(Event event) {
		String gols = golsSelecao1.getText();
		choiceBoxJogadoresSelecao2G.getValue();
		
		
	}
	

}

