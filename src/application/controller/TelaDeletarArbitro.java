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

public class TelaDeletarArbitro {

    @FXML
    private Button btnDeletar;

    @FXML
    private Button btnVoltar;
    
    @FXML
    private Label label; 
    
    @FXML
    private ChoiceBox<String> choiceBoxArbitros;

    private SelecaoDaoImpl selecaoDao;
    
    private ArrayList <Selecao> listaSelecoes;
    
  
    
    @FXML
	public void initialize() {
    	
    	String[] nomesArbitros = new String[12];
    	for(int i =0; i < TelaInicio.listaArbitros.size(); i++)
    	{
    		nomesArbitros[i] = TelaInicio.listaArbitros.get(i).getNome();
    	}
    	choiceBoxArbitros.getItems().addAll(nomesArbitros);
    	
    	 
         assert btnDeletar != null : "fx:id=\"btnSalvar\" was not injected: check your FXML file 'TelaEditarSelecao.fxml'.";
         assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaEditarSelecao.fxml'.";
         assert choiceBoxArbitros != null : "fx:id=\"choiceBoxSelecoes\" was not injected: check your FXML file 'TelaEditarSelecao.fxml'.";
         assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'TelaEditarSelecao.fxml'.";
    }
    public TelaDeletarArbitro(SelecaoDaoImpl selecaoDao) 
    {
    	this.selecaoDao = selecaoDao;
    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
    }
		

	@FXML
    void btnDeletarAction(ActionEvent event) {
		
		String arbitro = this.choiceBoxArbitros.getValue();
		
		if( arbitro!= null)
		{
			for(int i = 0; i <TelaInicio.listaArbitros.size(); i++)
			{
				if(TelaInicio.listaArbitros.get(i).getNome().equals(arbitro))
				{
					TelaInicio.listaArbitros.remove(i);
					label.setText("Árbitro Removido!");
				}
			}
		}
			
				
		
		else
		{
			label.setText("Escolha um Árbitro");
		}

	}
    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaMenuArbitro controller = new TelaMenuArbitro(this.selecaoDao);
    	Main.trocaDeTela("/application/view/Arbitro/TelaMenuArbitro.fxml",controller, selecaoDao);
    }

}
