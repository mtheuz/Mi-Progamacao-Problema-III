package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.model.SelecaoPackage.Selecao;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TelaMenuTecnicos
{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCadastrarTecnico;

    @FXML
    private Button btnDeletarTecnico;

    @FXML
    private Button btnEditarTecnico;

    @FXML
    private Button btnListarTecnico;

    @FXML
    private Button btnVoltar;
    

    @FXML
    private Label label;
    
    private SelecaoDaoImpl selecaoDao;
    private ArrayList <Selecao> listaSelecoes;

    public TelaMenuTecnicos(SelecaoDaoImpl selecaoDao) {
		this.selecaoDao = selecaoDao;
		this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
	}

	@FXML
    void btnCadastrarTecnicoAction(ActionEvent event) throws IOException {
		if(selecaoDao.getListaSelecoes().size()>0)
		{
			
			TelaEscolherSelecaoCadastrarTecnico controller = new TelaEscolherSelecaoCadastrarTecnico(selecaoDao);
			Main.trocaDeTela("/application/view/Tecnico/TelaEscolherSelecaoCadastrarTecnico.fxml", controller, selecaoDao);
	
		}
		else
			label.setText("Nenhuma seleção Cadastrada");
	}
    @FXML
    void btnDeletarTecnicoAction(ActionEvent event) throws IOException {
    	if(selecaoDao.getListaSelecoes().size()>0)
    	{
		    if(selecaoDao.getListaSelecoes().get(0).getTecnico()!=null)
		    {
		    	TelaRemoverTecnico controller = new TelaRemoverTecnico(selecaoDao);
		    	Main.trocaDeTela("/application/view/Tecnico/TelaRemoverTecnico.fxml", controller, selecaoDao);
		    }
		    else
				label.setText("Nenhum Técnico Cadastrado");
    	}
    	else
			label.setText("Nenhuma seleção Cadastrada");
    	
    }
    @FXML
    void btnEditarTecnicoACtion(ActionEvent event) throws IOException {
    	if(selecaoDao.getListaSelecoes().size()>0)
    	{
    		if(selecaoDao.getListaSelecoes().get(0).getTecnico()!=null)
    		{	
    			TelaEscolherSelecaoEditarTecnico controller = new TelaEscolherSelecaoEditarTecnico(selecaoDao);
    			Main.trocaDeTela("/application/view/Tecnico/TelaEscolherSelecaoEditarTecnico.fxml", controller, selecaoDao);
    		}
    		else
    			label.setText("Nenhum Técnico Cadastrado");
    	}
    	else
			label.setText("Nenhuma seleção Cadastrada");
    }
    @FXML
    void btnListarTecnicoAction(ActionEvent event) throws IOException {
    	if(selecaoDao.getListaSelecoes().size()>0)
    	{
    		if(selecaoDao.getListaSelecoes().get(0).getTecnico()!=null)
    		{
	    		TelaListarTecnicos controller = new TelaListarTecnicos(selecaoDao);
	    		Main.trocaDeTela("/application/view/Tecnico/TelaListarTecnico.fxml", controller, selecaoDao);
    		}
    		else
    			label.setText("Nenhum Técnico Cadastrado");
    	}
    	else
			label.setText("Nenhuma seleção Cadastrada");
    	
    }
    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaMenuCadastros controller = new TelaMenuCadastros(selecaoDao);
    	Main.trocaDeTela("/application/view/TelaMenuCadastros.fxml", controller, selecaoDao);
    }

    @FXML
    void initialize() {
        assert btnCadastrarTecnico != null : "fx:id=\"btnCadastrarTecnico\" was not injected: check your FXML file 'TelaMenuTecnico.fxml'.";
        assert btnDeletarTecnico != null : "fx:id=\"btnDeletarTecnico\" was not injected: check your FXML file 'TelaMenuTecnico.fxml'.";
        assert btnEditarTecnico != null : "fx:id=\"btnEditarTecnico\" was not injected: check your FXML file 'TelaMenuTecnico.fxml'.";
        assert btnListarTecnico != null : "fx:id=\"btnListarTecnico\" was not injected: check your FXML file 'TelaMenuTecnico.fxml'.";
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaMenuTecnico.fxml'.";

    }

}
