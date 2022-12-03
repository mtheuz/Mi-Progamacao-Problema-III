package application.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import application.model.SelecaoPackage.Selecao;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TelaEditarSelecao {

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnVoltar;
    
    @FXML
    private Label label; 
    
    @FXML
    private ChoiceBox<String> choiceBoxSelecoes;

    private SelecaoDaoImpl selecaoDao;
    
    private ArrayList <Selecao> listaSelecoes;
    
    @FXML
    private TextField NovoNomeSelecao;
    
    @FXML
	public void initialize() {
    	
    	String[] nomesSelecoes = new String[32];
    	for(int i =0; i < listaSelecoes.size(); i++)
    	{
    		nomesSelecoes[i] = listaSelecoes.get(i).getNome();
    	}
    	choiceBoxSelecoes.getItems().addAll(nomesSelecoes);
    	
    	 assert NovoNomeSelecao != null : "fx:id=\"NovoNomeSelecao\" was not injected: check your FXML file 'TelaEditarSelecao.fxml'.";
         assert btnSalvar != null : "fx:id=\"btnSalvar\" was not injected: check your FXML file 'TelaEditarSelecao.fxml'.";
         assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaEditarSelecao.fxml'.";
         assert choiceBoxSelecoes != null : "fx:id=\"choiceBoxSelecoes\" was not injected: check your FXML file 'TelaEditarSelecao.fxml'.";
         assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'TelaEditarSelecao.fxml'.";
    }
    public TelaEditarSelecao(SelecaoDaoImpl selecaoDao) 
    {
    	this.selecaoDao = selecaoDao;
    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
    }
		

	@FXML
    void btnSalvarAction(ActionEvent event) {
		
		String selecao = this.choiceBoxSelecoes.getValue();
		String novoNome = this.NovoNomeSelecao.getText();
		if( selecao!= null)
		{
			if(novoNome!=null && novoNome != "")
			{
				int indice = selecaoDao.buscaSelecao(selecao);
				if(indice!= -1)
				{
					selecaoDao.editarSelecao(novoNome, indice);
					label.setText("Seleção Editada com Sucesso!");
				}
				
			}
			else
				label.setText("Digite um novo nome");
		}
		else
			label.setText("Escolha uma Seleção");
    }

    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaMenuSelecao controller = new TelaMenuSelecao(this.selecaoDao);
    	Main.trocaDeTela("/application/view/Selecao/TelaMenuSelecao.fxml",controller, selecaoDao);
    }

}
