package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import application.model.FaseDeGrupos.FaseDeGrupos;
import application.model.JogadorPackage.Jogador;
import application.model.JogadorPackage.JogadorDaoImpl;
import application.model.PartidaPackage.Partida;
import application.model.PartidaPackage.PartidaDaoImpl;
import application.model.SelecaoPackage.Selecao;
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
    private Label erroGolsSelecao1;
    @FXML
    private Label erroCVSelecao1;
    @FXML
    private Label erroGolsSelecao2;
    @FXML
    private Label erroCVSelecao2;
    @FXML
    private TextField placarSelecao1;
    @FXML
    private Label erroCASelecao1;
    
    @FXML
    private Label erroCASelecao2;
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
    private TextField cartaoAmareloSelecao2;

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
    private ChoiceBox<String> choiceBoxJogadoresSelecao1CV;

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
    private ChoiceBox<String> choiceBoxJogadoresSelecao2CV;

    @FXML
    private ChoiceBox<String> choiceBoxJogadoresSelecao2;
    
    private List<String> jogadoresSelecao1;
    private List<String> jogadoresSelecao2;
    private Partida partida;
	private FaseDeGrupos fase;
	private String estadio;
	ControllerCadastroPartida(Partida partida){
		this.partida = partida;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.fase = new FaseDeGrupos(SelecaoDaoImpl.listaSelecoes);
		SelecaoDaoImpl selecaoDao = new SelecaoDaoImpl();
		int selecao1 = selecaoDao.buscaSelecao(this.partida.getSelecao1());
		int selecao2 = selecaoDao.buscaSelecao(this.partida.getSelecao2());
		
		
		System.out.println(this.partida.getSelecao1());
		System.out.println(this.partida.getSelecao2());
		System.out.println(SelecaoDaoImpl.listaSelecoes.get(0).getNome());
		
		this.jogadoresSelecao1 = new ArrayList<String>(); 
		this.jogadoresSelecao2 = new ArrayList<String>();
		
		choiceBoxEstadios.getItems().addAll(PartidaDaoImpl.estadios);
		choiceBoxEstadios.setValue("ESCOLHA O ESTADIO");
		choiceBoxEstadios.setOnAction(e -> clickChoiceBoxEstadios(choiceBoxEstadios));
		for (Jogador jogador : SelecaoDaoImpl.listaSelecoes.get(selecao1).getListaJogadores()) {
			this.jogadoresSelecao1.add(jogador.getNome());
		}
		
		for (Jogador jogador : SelecaoDaoImpl.listaSelecoes.get(selecao2).getListaJogadores()) {
			this.jogadoresSelecao2.add(jogador.getNome());
		}
		
		choiceBoxJogadoresSelecao1G.getItems().addAll(this.jogadoresSelecao1);
		choiceBoxJogadoresSelecao1G.setValue("ESCOLHA O JOGADOR");
		choiceBoxJogadoresSelecao1G.setOnAction(e -> clickChoiceBoxEstadios(choiceBoxEstadios));
		
		choiceBoxJogadoresSelecao1CA.getItems().addAll(this.jogadoresSelecao1);
		choiceBoxJogadoresSelecao1CA.setValue("ESCOLHA O JOGADOR");
		choiceBoxJogadoresSelecao1CA.setOnAction(e -> clickChoiceBoxEstadios(choiceBoxEstadios));
		
		choiceBoxJogadoresSelecao1.getItems().addAll(this.jogadoresSelecao1);
		choiceBoxJogadoresSelecao1.setValue("ESCOLHA O JOGADOR");
		choiceBoxJogadoresSelecao1.setOnAction(e -> clickChoiceBoxEstadios(choiceBoxEstadios));
		
		choiceBoxJogadoresSelecao2G.getItems().addAll(this.jogadoresSelecao2);
		choiceBoxJogadoresSelecao2G.setValue("ESCOLHA O JOGADOR");
		choiceBoxJogadoresSelecao2G.setOnAction(e -> clickChoiceBoxEstadios(choiceBoxEstadios));
		
		choiceBoxJogadoresSelecao2CA.getItems().addAll(this.jogadoresSelecao2);
		choiceBoxJogadoresSelecao2CA.setValue("ESCOLHA O JOGADOR");
		choiceBoxJogadoresSelecao2CA.setOnAction(e -> clickChoiceBoxEstadios(choiceBoxEstadios));
		
		choiceBoxJogadoresSelecao2.getItems().addAll(this.jogadoresSelecao2);
		choiceBoxJogadoresSelecao2.setValue("ESCOLHA O JOGADOR");
		choiceBoxJogadoresSelecao2.setOnAction(e -> clickChoiceBoxEstadios(choiceBoxEstadios));
		
		
	}
	
	public void clickChoiceBoxEstadios(ChoiceBox<String> choiceBoxEstadios) {
		String estadio = choiceBoxEstadios.getValue();
		this.estadio = estadio;
		
		
	}
	
	@FXML
	void clickbuttonCASelecao1(Event event) {
		String cartao = cartaoAmareloSelecao1.getText();
		String jogadorSelecao1Gol = choiceBoxJogadoresSelecao1CA.getValue();
		//FAZER FUNÇÃO PARA BUSCAR CODIGO JOGADOR
		if(!fase.inputCartosAmarelosSelecao1(partida, cartao, jogadorSelecao1Gol)) 
			erroCASelecao1.setText("Quantidade de Cartôes não coerente");
		
	}
	
	void clickbuttonCVSelecao1(Event event) {
		String jogadorSelecao1Gol = choiceBoxJogadoresSelecao1CV.getValue();
		//FAZER FUNÇÃO PARA BUSCAR CODIGO JOGADOR
		if(!fase.inputCartosVermelhoSelecao1(partida,jogadorSelecao1Gol)) 
			erroCVSelecao1.setText("Quantidade de Gols não coerente");
		
	}
	
	@FXML
	void clickbuttonGolsSelecao1(Event event) {
		String gols = golsSelecao1.getText();
		String jogadorSelecao1Gol = choiceBoxJogadoresSelecao1G.getValue();
		//FAZER FUNÇÃO PARA BUSCAR CODIGO JOGADOR
		if(Integer.parseInt(gols) <= Integer.parseInt(placarSelecao1.getText()) 
				&& Integer.parseInt(gols) <= fase.somaConteudo(partida.getGolsSelecao1())) {
			fase.inputGolsSelecao1(partida, gols, jogadorSelecao1Gol);
		}else {
			erroGolsSelecao1.setText("Quantidade de Gols não coerente");
		}
	}
	@FXML
	void clickbuttonCASelecao2(Event event) {
		String cartoes = cartaoAmareloSelecao2.getText();
		String jogadorSelecao1Gol = choiceBoxJogadoresSelecao2CA.getValue();
		//FAZER FUNÇÃO PARA BUSCAR CODIGO JOGADOR
		if(!fase.inputCartosAmarelosSelecao2(partida, cartoes, jogadorSelecao1Gol)) 
			erroCASelecao2.setText("Quantidade de Cartôes não coerente");
		
	}
	
	void clickbuttonCVSelecao2(Event event) {
		String jogadorSelecao1Gol = choiceBoxJogadoresSelecao2CV.getValue();
		//FAZER FUNÇÃO PARA BUSCAR CODIGO JOGADOR
		if(!fase.inputCartosVermelhoSelecao2(partida,jogadorSelecao1Gol)) 
			erroCVSelecao2.setText("Quantidade de Gols não coerente");
		
	}
	
	@FXML
	void clickbuttonGolsSelecao2(Event event) {
		String gols = golsSelecao2.getText();
		String jogadorSelecao2Gol = choiceBoxJogadoresSelecao2G.getValue();
		//FAZER FUNÇÃO PARA BUSCAR CODIGO JOGADOR
		if(Integer.parseInt(gols) <= Integer.parseInt(placarSelecao2.getText()) 
				&& Integer.parseInt(gols) <= fase.somaConteudo(partida.getGolsSelecao2())) {
			fase.inputGolsSelecao2(partida, gols, jogadorSelecao2Gol);
		}else {
			erroGolsSelecao2.setText("Quantidade de Gols não coerente");
		}
	}
	
	@FXML
	void clickCadastrar(Event event) {
		partida.setLocal(estadio);
		partida.setData(dia.getText() + "/" + mes.getText() + "/" + ano.getText());
		partida.setHorario(hora.getText() + ":" + minuto.getText());
		partida.setSituacao(true);
		fase.pontuacao(partida);
	}
	
	@FXML
	void btnVoltarAction(Event event) throws IOException {
		Main.trocaDeTela("/application/view/Partida/TelaTodasPartidas.fxml", null, null);
	}

}

