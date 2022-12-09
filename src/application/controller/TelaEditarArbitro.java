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

public class TelaEditarArbitro {

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnVoltar;
    
    @FXML
    private Label label; 
    
    @FXML
    private ChoiceBox<String> choiceBoxArbitros;

    private SelecaoDaoImpl selecaoDao;
    
    private ArrayList <Selecao> listaSelecoes;
    
    @FXML
    private TextField NovoNomeArbitro;
    
    @FXML
	public void initialize() {
    	
    	String[] nomesArbitros = new String[12];
    	for(int i =0; i < TelaInicio.listaArbitros.size(); i++)
    	{
    		nomesArbitros[i] = TelaInicio.listaArbitros.get(i).getNome();
    	}
    	choiceBoxArbitros.getItems().addAll(nomesArbitros);
    	
    	 assert NovoNomeArbitro != null : "fx:id=\"NovoNomeSelecao\" was not injected: check your FXML file 'TelaEditarSelecao.fxml'.";
         assert btnSalvar != null : "fx:id=\"btnSalvar\" was not injected: check your FXML file 'TelaEditarSelecao.fxml'.";
         assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaEditarSelecao.fxml'.";
         assert choiceBoxArbitros != null : "fx:id=\"choiceBoxSelecoes\" was not injected: check your FXML file 'TelaEditarSelecao.fxml'.";
         assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'TelaEditarSelecao.fxml'.";
    }
    public TelaEditarArbitro(SelecaoDaoImpl selecaoDao) 
    {
    	this.selecaoDao = selecaoDao;
    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
    }
		

	@FXML
    void btnSalvarAction(ActionEvent event) {
		
		String selecao = this.choiceBoxArbitros.getValue();
		String novoNome = this.NovoNomeArbitro.getText();
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
    	TelaMenuArbitro controller = new TelaMenuArbitro(this.selecaoDao);
    	Main.trocaDeTela("/application/view/Arbitro/TelaMenuArbitro.fxml",controller, selecaoDao);
    }

}
