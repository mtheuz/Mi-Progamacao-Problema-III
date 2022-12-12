package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import application.Main;
import application.model.Eliminatoria.Eliminatoria;
import application.model.FaseDeGrupos.FaseDeGrupos;
import application.model.PartidaPackage.Partida;
import application.model.PartidaPackage.PartidaDaoImpl;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerCadastroPartida implements Initializable{
	@FXML
    private Label situacaoCadastro;
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
    private Button btnVoltar1;
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
    private TextField cartaoAmarelosSelecao1;
    
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
    private String[] jogadoresSelecao1;
    private String[] jogadoresSelecao2;
    private String endereco;
    private Partida partida;
	private FaseDeGrupos fase;
	private String estadio;
	SelecaoDaoImpl selecaoDao;
	private  Map<String,String> codigoSelecao1 = new HashMap<String,String>();
	private  Map<String,String> codigoSelecao2 = new HashMap<String,String>();
	
	ControllerCadastroPartida(Partida partida, SelecaoDaoImpl selecaoDao, FaseDeGrupos fase,String endereco){
		Eliminatoria.setGrupos(FaseDeGrupos.grupos);
		this.partida = partida;
		this.selecaoDao = selecaoDao;
		this.jogadoresSelecao1 = new String[30];
		this.jogadoresSelecao2 = new String[30];
		this.fase = fase;
		this.endereco = endereco;
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nomeSelecao1.setText(partida.getSelecao1());
		nomeSelecao2.setText(partida.getSelecao2());
		this.fase = new FaseDeGrupos(SelecaoDaoImpl.listaSelecoes);
		int selecao1 = selecaoDao.buscaSelecao(this.partida.getSelecao1());
		int selecao2 = selecaoDao.buscaSelecao(this.partida.getSelecao2());
		
		if(selecao1 != -1 && selecao2 != -1) {
		choiceBoxEstadios.getItems().addAll(PartidaDaoImpl.estadios);
		choiceBoxEstadios.setValue("ESCOLHA O ESTADIO");
		choiceBoxEstadios.setOnAction(e -> clickChoiceBoxEstadios(choiceBoxEstadios));
		String nome;
		String codigo;
		for(int i =0; i < selecaoDao.getListaSelecoes().get(selecao1).getListaJogadores().size(); i++)
    	{
			jogadoresSelecao1[i] = selecaoDao.getListaSelecoes().get(selecao1).getListaJogadores().get(i).getNome();
			nome = selecaoDao.getListaSelecoes().get(selecao1).getListaJogadores().get(i).getNome();
			codigo = selecaoDao.getListaSelecoes().get(selecao1).getListaJogadores().get(i).getCode();
;			codigoSelecao1.put(nome, codigo);
    	}
		for(int i =0; i < selecaoDao.getListaSelecoes().get(selecao2).getListaJogadores().size(); i++)
    	{
			jogadoresSelecao2[i] = selecaoDao.getListaSelecoes().get(selecao2).getListaJogadores().get(i).getNome();
			nome = selecaoDao.getListaSelecoes().get(selecao2).getListaJogadores().get(i).getNome();
			codigo = selecaoDao.getListaSelecoes().get(selecao2).getListaJogadores().get(i).getCode();
;			codigoSelecao2.put(nome, codigo);
    	}
  
		
		
		choiceBoxJogadoresSelecao1G.getItems().addAll(this.jogadoresSelecao1);
		choiceBoxJogadoresSelecao1G.setValue("ESCOLHA O JOGADOR");

		
		choiceBoxJogadoresSelecao1CA.getItems().addAll(this.jogadoresSelecao1);
		choiceBoxJogadoresSelecao1CA.setValue("ESCOLHA O JOGADOR");
	
		
		choiceBoxJogadoresSelecao1CV.getItems().addAll(this.jogadoresSelecao1);
		choiceBoxJogadoresSelecao1CV.setValue("ESCOLHA O JOGADOR");
	
		
		choiceBoxJogadoresSelecao2G.getItems().addAll(this.jogadoresSelecao2);
		choiceBoxJogadoresSelecao2G.setValue("ESCOLHA O JOGADOR");

		
		choiceBoxJogadoresSelecao2CA.getItems().addAll(this.jogadoresSelecao2);
		choiceBoxJogadoresSelecao2CA.setValue("ESCOLHA O JOGADOR");

		choiceBoxJogadoresSelecao2CV.getItems().addAll(this.jogadoresSelecao2);
		choiceBoxJogadoresSelecao2CV.setValue("ESCOLHA O JOGADOR");
		
		}
	}
	
	public void clickChoiceBoxEstadios(ChoiceBox<String> choiceBoxEstadios) {
		String estadio = choiceBoxEstadios.getValue();
		this.estadio = estadio;
		
		
	}
	
	@FXML
	void clickbuttonCASelecao1(Event event) {
		String cartao = cartaoAmarelosSelecao1.getText();
		String jogadorSelecao1CartaoAmarelo = choiceBoxJogadoresSelecao1CA.getValue();
		String codigo = codigoSelecao1.get(jogadorSelecao1CartaoAmarelo);
		if(!fase.inputCartosAmarelosSelecao1(partida, cartao, codigo)) 
			erroCASelecao1.setText("Quantidade de Cartôes não coerente");
		else {
			erroCASelecao1.setText("Cartões adicionado ao jogador");
		}
		
	}
	@FXML
	void clickbuttonCVSelecao1(ActionEvent event) {
		String jogadorSelecao1CartaoVermelho = choiceBoxJogadoresSelecao1CV.getValue();
		String codigo = codigoSelecao1.get(jogadorSelecao1CartaoVermelho);
		System.out.println(codigo);
		if(!fase.inputCartosVermelhoSelecao1(partida,codigo)) 
			erroCVSelecao1.setText("Quantidade de Cartões não coerente");
		else {
			erroCVSelecao1.setText("Cartões adicionado ao jogador");
		}
	}
	
	@FXML
	void clickbuttonGolsSelecao1(Event event) {
		if(placarSelecao1.getText() != "" ) {
		String gols = golsSelecao1.getText();
		String jogadorSelecao1Gol = choiceBoxJogadoresSelecao1G.getValue();
		String codigo = codigoSelecao1.get(jogadorSelecao1Gol);
		if(Integer.parseInt(placarSelecao1.getText()) == 0){
			erroGolsSelecao2.setText("A " + nomeSelecao2 + " não fez gol");
		}
		else if((Integer.parseInt(gols) <= Integer.parseInt(placarSelecao1.getText()))
				&& (Integer.parseInt(gols) <= (Integer.parseInt(placarSelecao1.getText())- fase.somaConteudo(partida.getGolsSelecao1())))) {
			fase.inputGolsSelecao1(partida, gols, codigo);
			erroGolsSelecao1.setText("Gols adicionado ao jogador");
		}else {
			erroGolsSelecao1.setText("Quantidade de Gols não coerente");
		}
		}
	}
	
	@FXML
	void clickbuttonCASelecao2(Event event) {
		String cartoes = cartaoAmareloSelecao2.getText();
		String jogadorSelecao2Gol = choiceBoxJogadoresSelecao2CA.getValue();
		String codigo = codigoSelecao2.get(jogadorSelecao2Gol);
		fase.inputCartosAmarelosSelecao2(partida, cartoes, codigo);
			
		
		
	}
	@FXML
	void clickbuttonCVSelecao2(Event event) {
		String jogadorSelecao2CartaoVermelho = choiceBoxJogadoresSelecao2CV.getValue();
		String codigo = codigoSelecao2.get(jogadorSelecao2CartaoVermelho);
		fase.inputCartosVermelhoSelecao2(partida,codigo);
		erroGolsSelecao2.setText("Gols adicionado ao jogador");
		System.out.println(codigo);
			
		
	}
	
	@FXML
	void clickbuttonGolsSelecao2(Event event) {
		if(placarSelecao2.getText() != "" ){
		String gols = golsSelecao2.getText();
		String jogadorSelecao2Gol = choiceBoxJogadoresSelecao2G.getValue();
		String codigo = codigoSelecao2.get(jogadorSelecao2Gol);
		if(Integer.parseInt(placarSelecao2.getText()) == 0){
			erroGolsSelecao2.setText("A " + nomeSelecao2 + " não fez gol");
		}
		else if((Integer.parseInt(gols) <= Integer.parseInt(placarSelecao2.getText()))
				&& (Integer.parseInt(gols) <= (Integer.parseInt(placarSelecao2.getText())- fase.somaConteudo(partida.getGolsSelecao2())))) {
			fase.inputGolsSelecao2(partida, gols, codigo);
			erroGolsSelecao2.setText("Gols adicionado ao jogador");
		}else {
			erroGolsSelecao2.setText("Quantidade de Gols não coerente");
		}
	}}
	
	@FXML
	void clickCadastrar(Event event) throws IOException {
		if(placarSelecao1.getText() != "" && placarSelecao2.getText() != "" 
				&& dia.getText() != "" && minuto.getText() != "" && ano.getText() != "") {
		partida.setLocal(estadio);
		partida.setData(dia.getText() + "/" + mes.getText() + "/" + ano.getText());
		partida.setHorario(hora.getText() + ":" + minuto.getText());
		partida.setSituacao(true);
		partida.setPlacarSelecao1(placarSelecao1.getText());
		partida.setPlacarSelecao2(placarSelecao2.getText());
		int selecaoGols1 = Integer.parseInt(placarSelecao1.getText());
		int selecaoGols2 = Integer.parseInt(placarSelecao2.getText());
		
		
		situacaoCadastro.setText("PARTIDA CADASTRADA!");
		if(partida.isEliminatoria()) {
			if(selecaoGols1 == selecaoGols2) {
					DisputaDePenaltys controller =  new DisputaDePenaltys(partida, endereco, selecaoDao, fase);
					Main.trocaDeTela("/application/view/Partida/empatePartida.fxml", controller, null);
			}else if(selecaoGols1 > selecaoGols2) {
				partida.setVencedor(partida.getSelecao1());
				partida.setPerdedor(partida.getSelecao2());
			}else if(selecaoGols1 < selecaoGols2) {
				partida.setVencedor(partida.getSelecao2());
				partida.setPerdedor(partida.getSelecao1());
			}
		}else {
			fase.pontuacao(partida,selecaoGols1,selecaoGols2);
		}
		
		switch (endereco) {
		case "TelaTodasPartidas":
			if(fase.verificaPartidas()) {
				ControllerPerguntaProximaFase controller = new ControllerPerguntaProximaFase(fase,selecaoDao,"OitavasDeFinal");
				Main.trocaDeTela("/application/view/Partida/PerguntaProximaFase.fxml", controller, null);
			}
			break;
		case "OitavasDeFinal":
			if(Eliminatoria.verificaPartidas(Eliminatoria.oitavas)) {
				ControllerPerguntaProximaFase controller = new ControllerPerguntaProximaFase(fase,selecaoDao,"QuartasDeFinal");
				Main.trocaDeTela("/application/view/Partida/PerguntaProximaFase.fxml", controller, null);
			}
			break;
		case "QuartasDeFinal":
			if(Eliminatoria.verificaPartidas(Eliminatoria.quartas)) {
				ControllerPerguntaProximaFase controller = new ControllerPerguntaProximaFase(fase,selecaoDao,"SemiFinal");
				Main.trocaDeTela("/application/view/Partida/PerguntaProximaFase.fxml", controller, null);
			}
			break;
		case "SemiFinal":
			if(Eliminatoria.verificaPartidas(Eliminatoria.semiFinal)) {
				ControllerPerguntaProximaFase controller = new ControllerPerguntaProximaFase(fase,selecaoDao,"TerceiroLugar");
				Main.trocaDeTela("/application/view/Partida/PerguntaProximaFase.fxml", controller, null);
			}
			break;
		case "TerceiroLugar":
			if(Eliminatoria.verificaPartidas(Eliminatoria.semiFinal)) {
				ControllerPerguntaProximaFase controller = new ControllerPerguntaProximaFase(fase,selecaoDao,"Final");
				Main.trocaDeTela("/application/view/Partida/PerguntaProximaFase.fxml", controller, null);
			}
			break;
		case "Final":
			if(Eliminatoria.verificaPartidas(Eliminatoria.semiFinal)) {
				ControllerRanking controller = new ControllerRanking(Eliminatoria.Final,Eliminatoria.terceiroLugar,selecaoDao,fase);
				Main.trocaDeTela("/application/view/Partida/Raking.fxml", controller, null);
			}
			break;

		default:
			break;
		}
	} else {
		situacaoCadastro.setText("Cadastro incompleto");
	}
		
	}
	
	@FXML
	void btnVoltarAction(ActionEvent event) throws IOException {
		if(endereco == "TelaTodasPartidas") {
		TelaTabelaDeGrupos controller = new TelaTabelaDeGrupos(selecaoDao, fase);
		Main.trocaDeTela("/application/view/Partida/TelaTodasPartidas.fxml", controller, null);
		}
		else if(endereco == "OitavasDeFinal") {
			ControllerOitavasDeFinal controller = new ControllerOitavasDeFinal(fase,selecaoDao);
			Main.trocaDeTela("/application/view/Partida/OitavasDeFinal.fxml", controller, null);
		}
		else if(endereco == "QuartasDeFinal") {
			ControllerQuartas controller = new ControllerQuartas(fase,selecaoDao);
			Main.trocaDeTela("/application/view/Partida/QuartasDeFinal.fxml", controller, null);
		}
		else if(endereco == "SemiFinal") {
			ControllerSemiFinal controller = new ControllerSemiFinal(fase,selecaoDao);
			Main.trocaDeTela("/application/view/Partida/SemiFinal.fxml", controller, null);
		}
		
		else if(endereco == "TerceiroLugar") {
			ControllerTerceiroLugar controller = new ControllerTerceiroLugar(fase,selecaoDao);
			Main.trocaDeTela("/application/view/Partida/TerceiroLugar.fxml", controller, null);
		}
		else if(endereco == "Final") {
			ControllerFinal controller = new ControllerFinal(fase,selecaoDao);
			Main.trocaDeTela("/application/view/Partida/Final.fxml", controller, null);
		}
	}

}

