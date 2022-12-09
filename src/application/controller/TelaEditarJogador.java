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

public class TelaEditarJogador {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnVoltar;

    @FXML
    private ChoiceBox<String> choiceBoxPosicoes;

    private String[] posicoes = {"Goleiro","Defensor", "Lateral Esquerdo", "Lateral Direito", "Volante", "Meio Campista","Atacante"};
    
    @FXML
    private Label labelNomeJogador;

    @FXML
    private Label labelNomeSelecao;

    @FXML
    private TextField nomeJogador;
    
    @FXML
    private Label label;
    
    private ArrayList <Selecao> listaSelecoes;
    
    private String selecao;
    
    private String jogador;
    
    private SelecaoDaoImpl selecaoDao;
    public TelaEditarJogador(SelecaoDaoImpl selecaoDao, String selecao, String jogador) {
    	
    	this.jogador = jogador;
    	this.selecao = selecao;
    	this.selecaoDao = selecaoDao;
    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
	}

    @FXML
    void btnSalvarAction(ActionEvent event) {
    	String novoNome = nomeJogador.getText();
    	if(novoNome != null && novoNome != "")
    	{
    		String posicao = choiceBoxPosicoes.getValue();
    		if(posicao != null)
    		{
    			int indice = selecaoDao.buscaSelecao(selecao);
    			ArrayList <Jogador> listaJogadores = (ArrayList<Jogador>) selecaoDao.getListaSelecoes().get(indice).getListaJogadores();
    			for(int i =0; i < listaJogadores.size(); i++)
    			{
    				if(listaJogadores.get(i).getNome().equals(jogador))
    				{
    					listaJogadores.get(i).setNome(novoNome);
    					listaJogadores.get(i).setPosicao(posicao);
    					label.setText("Cadastro Atualizado!");
    				}
    			}
    		}
    		else
    			label.setText("Escolha uma posição");
    	}
    	else
    		label.setText("Digite um novo nome");
    }

    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaEscolherEditarJogador controller = new TelaEscolherEditarJogador(this.selecaoDao);
		Main.trocaDeTela("/application/view/Jogador/TelaEscolherEditarJogador.fxml",controller, selecaoDao);
    }

    @FXML
    void initialize() {
        assert btnSalvar != null : "fx:id=\"btnSalvar\" was not injected: check your FXML file 'TelaEditarJogador.fxml'.";
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaEditarJogador.fxml'.";
        assert choiceBoxPosicoes != null : "fx:id=\"choiceBoxSelecoes\" was not injected: check your FXML file 'TelaEditarJogador.fxml'.";
        assert labelNomeJogador != null : "fx:id=\"labelNomeJogaodor\" was not injected: check your FXML file 'TelaEditarJogador.fxml'.";
        assert labelNomeSelecao != null : "fx:id=\"labelNomeSelecao1\" was not injected: check your FXML file 'TelaEditarJogador.fxml'.";
        assert nomeJogador != null : "fx:id=\"nomeJogador\" was not injected: check your FXML file 'TelaEditarJogador.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'TelaEditarJogador.fxml'.";labelNomeJogador.setText(jogador);
        labelNomeSelecao.setText(selecao);
        choiceBoxPosicoes.getItems().addAll(posicoes);
    }

}
