package application.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.model.JogadorPackage.Jogador;
import application.model.SelecaoPackage.Selecao;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TelaCadastrarJogador {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCadastrarJogadores;

    @FXML
    private Button btnVoltar;

    @FXML
    private ChoiceBox<String> choiceBoxSelecoes;

    @FXML
    private Label labelNomeSelecao;

    @FXML
    private Label labelRestante;

    @FXML
    private Label labelTotal;

    private String[] posicoes = {"Goleiro","Defensor", "Lateral Esquerdo", "Lateral Direito", "Volante", "Meio Campista","Atacante"};
    
    @FXML
    private TextField nomeJogador;

    @FXML
    private Label label;
    
    private static String nomeDaSelecao;
    
    private SelecaoDaoImpl selecaoDao;
    
    private ArrayList <Selecao> listaSelecoes;
    
   public TelaCadastrarJogador(SelecaoDaoImpl selecaoDao, String selecao)
   {
	   	this.selecaoDao = selecaoDao;
   		listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = this.selecaoDao.getListaSelecoes();
		nomeDaSelecao = selecao;
		
   }
    
    @FXML
    void btnCadastrarJogadoresAction(ActionEvent event) throws IOException {
    	String nomeJogador = this.nomeJogador.getText();
		String posicao = this.choiceBoxSelecoes.getValue();
		
		if(nomeJogador!= null && nomeJogador != "")
		{
			if(posicao!= null && posicao != "")
			{
				Jogador jogador = new Jogador(nomeJogador);
				jogador.setPosicao(posicao);
				int indice = selecaoDao.buscaSelecao(nomeDaSelecao);
				listaSelecoes.get(indice).getListaJogadores().add(jogador);
				TelaCadastrarJogador controller = new TelaCadastrarJogador(this.selecaoDao, TelaCadastrarJogador.nomeDaSelecao);
	    		Main.trocaDeTela("/application/view/Jogador/TelaCadastrarJogador.fxml",controller, selecaoDao);
				
			}
			else
				label.setText("Escolha a Posição");
		}
		else
			label.setText("Digite o nome do Jogador");
    }

    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaCadastrarSelecao controller = new TelaCadastrarSelecao(selecaoDao);
    	Main.trocaDeTela("/application/view/Selecao/TelaCadastrarSelecao.fxml", controller, this.selecaoDao);
    }

    @FXML
    void initialize() {
        assert btnCadastrarJogadores != null : "fx:id=\"btnCadastrarJogadores\" was not injected: check your FXML file 'TelaCadastrarJogador.fxml'.";
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaCadastrarJogador.fxml'.";
        assert choiceBoxSelecoes != null : "fx:id=\"choiceBoxSelecoes\" was not injected: check your FXML file 'TelaCadastrarJogador.fxml'.";
        assert labelNomeSelecao != null : "fx:id=\"labelNomeSelecao\" was not injected: check your FXML file 'TelaCadastrarJogador.fxml'.";
        assert labelRestante != null : "fx:id=\"labelRestante\" was not injected: check your FXML file 'TelaCadastrarJogador.fxml'.";
        assert labelTotal != null : "fx:id=\"labelTotal\" was not injected: check your FXML file 'TelaCadastrarJogador.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'TelaCadastrarSelecao.fxml'.";
        assert nomeJogador != null : "fx:id=\"nomeJogador\" was not injected: check your FXML file 'TelaCadastrarJogador.fxml'.";
        
        labelNomeSelecao.setText(nomeDaSelecao);
        
        choiceBoxSelecoes.getItems().addAll(posicoes);
        
        
        int indice = this.selecaoDao.buscaSelecao(this.nomeDaSelecao);
        int total = listaSelecoes.get(indice).getListaJogadores().size();
		String total1 = Integer.toString(total);
		labelTotal.setText(total1);
		int restante = 26 -  listaSelecoes.get(indice).getListaJogadores().size();
		String restante1 = Integer.toString(restante);
		labelRestante.setText(restante1);
    }

}
