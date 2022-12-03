package application.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.model.SelecaoPackage.Selecao;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import application.model.TecnicoPackage.Tecnico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaCadastrarSelecao {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Label labelRestante;

    @FXML
    private Label labelTotal; 
    
    @FXML
    private Button btnCadastrarJogadores;
    
    @FXML
    private Label label;
    
    @FXML
    private TextField nomeSelecao;

    @FXML
    private TextField nomeTecnico;
    
    @FXML
    private Button btnVoltar;
    
    private SelecaoDaoImpl selecaoDao;
    
    private ArrayList <Selecao> listaSelecoes;
    
    
    public TelaCadastrarSelecao(SelecaoDaoImpl selecaoDao) {
    	this.selecaoDao = selecaoDao;
    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
	}

    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaMenuSelecao controller = new TelaMenuSelecao(this.selecaoDao);
    	Main.trocaDeTela("/application/view/Selecao/TelaMenuSelecao.fxml",controller, selecaoDao);
    }
    
    @FXML
    void btnCadastrarJogadoresAction(ActionEvent event) throws IOException {
    	String selecao = this.nomeSelecao.getText();
		String nomeTecnico = this.nomeTecnico.getText();
		
		
		
		if(selecao!= null && selecao!="")
		{
			if(nomeTecnico!= null && nomeTecnico != "")
			{
				boolean resultado = selecaoDao.ComparaSelecao(selecao);
				if(resultado == true)
				{
					Selecao selecaoo = new Selecao();
					selecaoo.setNome(nomeTecnico);
					Tecnico tecnico = new Tecnico();
					tecnico.setNome(nomeTecnico);
					selecaoo.setTecnico(tecnico);
					selecaoDao.getListaSelecoes().add(selecaoo);
					
					TelaCadastrarJogador controller = new TelaCadastrarJogador(this.selecaoDao, selecao);
					Main.trocaDeTela("/application/view/Jogador/TelaCadastrarJogador.fxml",controller, selecaoDao);
				} 
				else 
				{
					int indice = selecaoDao.buscaSelecao(selecao);
					if(listaSelecoes.get(indice).getListaJogadores().size() >25)
					{
						label.setText("Lista de Jogadores Completa!");
					}
					else
					{
						TelaCadastrarJogador controller = new TelaCadastrarJogador(this.selecaoDao, selecao);
						Main.trocaDeTela("/application/view/Jogador/TelaCadastrarJogador.fxml",controller, selecaoDao);
					}
					
					
			}
			}
			else
				label.setText("Digite o nome do Técnico");
		}
		else
			label.setText("Digite o nome da Seleção");
    }

		
    
   

	@FXML
    void initialize() {
    	 assert btnCadastrarJogadores != null : "fx:id=\"btnCadastrarJogadores\" was not injected: check your FXML file 'TelaCadastrarSelecao.fxml'.";
         assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaCadastrarSelecao.fxml'.";
         assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'TelaCadastrarSelecao.fxml'.";
         assert labelRestante != null : "fx:id=\"labelRestante\" was not injected: check your FXML file 'TelaCadastrarSelecao.fxml'.";
         assert labelTotal != null : "fx:id=\"labelTotal\" was not injected: check your FXML file 'TelaCadastrarSelecao.fxml'.";
         assert nomeSelecao != null : "fx:id=\"nomeSelecao\" was not injected: check your FXML file 'TelaCadastrarSelecao.fxml'.";
         assert nomeTecnico != null : "fx:id=\"nomeTecnico\" was not injected: check your FXML file 'TelaCadastrarSelecao.fxml'.";

		int total = listaSelecoes.size();
		String total1 = Integer.toString(total);
		labelTotal.setText(total1);
		int restante = 32 -  listaSelecoes.size();
		String restante1 = Integer.toString(restante);
		labelRestante.setText(restante1);
    }

}
