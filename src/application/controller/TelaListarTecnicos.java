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

public class TelaListarTecnicos {
	
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnVoltar;

    @FXML
    private Label labelSelecao1;

    @FXML
    private Label labelSelecao10;

    @FXML
    private Label labelSelecao11;

    @FXML
    private Label labelSelecao12;

    @FXML
    private Label labelSelecao13;

    @FXML
    private Label labelSelecao14;

    @FXML
    private Label labelSelecao15;

    @FXML
    private Label labelSelecao16;

    @FXML
    private Label labelSelecao17;

    @FXML
    private Label labelSelecao18;

    @FXML
    private Label labelSelecao19;

    @FXML
    private Label labelSelecao2;

    @FXML
    private Label labelSelecao20;

    @FXML
    private Label labelSelecao21;

    @FXML
    private Label labelSelecao22;

    @FXML
    private Label labelSelecao23;

    @FXML
    private Label labelSelecao24;

    @FXML
    private Label labelSelecao25;

    @FXML
    private Label labelSelecao26;

    @FXML
    private Label labelSelecao27;

    @FXML
    private Label labelSelecao28;

    @FXML
    private Label labelSelecao29;

    @FXML
    private Label labelSelecao3;

    @FXML
    private Label labelSelecao30;

    @FXML
    private Label labelSelecao31;

    @FXML
    private Label labelSelecao32;

    @FXML
    private Label labelSelecao4;

    @FXML
    private Label labelSelecao5;

    @FXML
    private Label labelSelecao6;

    @FXML
    private Label labelSelecao7;

    @FXML
    private Label labelSelecao8;

    @FXML
    private Label labelSelecao9;

    @FXML
    private Label labelTecnico1;

    @FXML
    private Label labelTecnico10;

    @FXML
    private Label labelTecnico11;

    @FXML
    private Label labelTecnico12;

    @FXML
    private Label labelTecnico13;

    @FXML
    private Label labelTecnico14;

    @FXML
    private Label labelTecnico15;

    @FXML
    private Label labelTecnico16;

    @FXML
    private Label labelTecnico17;

    @FXML
    private Label labelTecnico18;

    @FXML
    private Label labelTecnico19;

    @FXML
    private Label labelTecnico2;

    @FXML
    private Label labelTecnico20;

    @FXML
    private Label labelTecnico21;

    @FXML
    private Label labelTecnico22;

    @FXML
    private Label labelTecnico23;

    @FXML
    private Label labelTecnico24;

    @FXML
    private Label labelTecnico25;

    @FXML
    private Label labelTecnico26;

    @FXML
    private Label labelTecnico27;

    @FXML
    private Label labelTecnico28;

    @FXML
    private Label labelTecnico29;

    @FXML
    private Label labelTecnico3;

    @FXML
    private Label labelTecnico30;

    @FXML
    private Label labelTecnico31;

    @FXML
    private Label labelTecnico32;

    @FXML
    private Label labelTecnico4;

    @FXML
    private Label labelTecnico5;

    @FXML
    private Label labelTecnico6;

    @FXML
    private Label labelTecnico7;

    @FXML
    private Label labelTecnico8;

    @FXML
    private Label labelTecnico9;

    private SelecaoDaoImpl selecaoDao;
    
    private ArrayList <Selecao> listaSelecoes;
    
    public TelaListarTecnicos (SelecaoDaoImpl selecaoDao)
	{
    	this.selecaoDao = selecaoDao;
    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
	}
    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaMenuTecnicos controller = new TelaMenuTecnicos(this.selecaoDao);
    	Main.trocaDeTela("/application/view/Tecnico/TelaMenuTecnico.fxml",controller, selecaoDao);
    }

    @FXML
    void initialize() {
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao1 != null : "fx:id=\"labelSelecao1\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao10 != null : "fx:id=\"labelSelecao10\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao11 != null : "fx:id=\"labelSelecao11\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao12 != null : "fx:id=\"labelSelecao12\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao13 != null : "fx:id=\"labelSelecao13\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao14 != null : "fx:id=\"labelSelecao14\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao15 != null : "fx:id=\"labelSelecao15\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao16 != null : "fx:id=\"labelSelecao16\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao17 != null : "fx:id=\"labelSelecao17\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao18 != null : "fx:id=\"labelSelecao18\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao19 != null : "fx:id=\"labelSelecao19\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao2 != null : "fx:id=\"labelSelecao2\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao20 != null : "fx:id=\"labelSelecao20\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao21 != null : "fx:id=\"labelSelecao21\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao22 != null : "fx:id=\"labelSelecao22\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao23 != null : "fx:id=\"labelSelecao23\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao24 != null : "fx:id=\"labelSelecao24\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao25 != null : "fx:id=\"labelSelecao25\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao26 != null : "fx:id=\"labelSelecao26\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao27 != null : "fx:id=\"labelSelecao27\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao28 != null : "fx:id=\"labelSelecao28\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao29 != null : "fx:id=\"labelSelecao29\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao3 != null : "fx:id=\"labelSelecao3\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao30 != null : "fx:id=\"labelSelecao30\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao31 != null : "fx:id=\"labelSelecao31\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao32 != null : "fx:id=\"labelSelecao32\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao4 != null : "fx:id=\"labelSelecao4\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao5 != null : "fx:id=\"labelSelecao5\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao6 != null : "fx:id=\"labelSelecao6\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao7 != null : "fx:id=\"labelSelecao7\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao8 != null : "fx:id=\"labelSelecao8\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelSelecao9 != null : "fx:id=\"labelSelecao9\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico1 != null : "fx:id=\"labelTecnico1\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico10 != null : "fx:id=\"labelTecnico10\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico11 != null : "fx:id=\"labelTecnico11\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico12 != null : "fx:id=\"labelTecnico12\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico13 != null : "fx:id=\"labelTecnico13\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico14 != null : "fx:id=\"labelTecnico14\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico15 != null : "fx:id=\"labelTecnico15\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico16 != null : "fx:id=\"labelTecnico16\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico17 != null : "fx:id=\"labelTecnico17\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico18 != null : "fx:id=\"labelTecnico18\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico19 != null : "fx:id=\"labelTecnico19\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico2 != null : "fx:id=\"labelTecnico2\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico20 != null : "fx:id=\"labelTecnico20\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico21 != null : "fx:id=\"labelTecnico21\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico22 != null : "fx:id=\"labelTecnico22\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico23 != null : "fx:id=\"labelTecnico23\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico24 != null : "fx:id=\"labelTecnico24\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico25 != null : "fx:id=\"labelTecnico25\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico26 != null : "fx:id=\"labelTecnico26\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico27 != null : "fx:id=\"labelTecnico27\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico28 != null : "fx:id=\"labelTecnico28\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico29 != null : "fx:id=\"labelTecnico29\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico3 != null : "fx:id=\"labelTecnico3\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico30 != null : "fx:id=\"labelTecnico30\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico31 != null : "fx:id=\"labelTecnico31\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico32 != null : "fx:id=\"labelTecnico32\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico4 != null : "fx:id=\"labelTecnico4\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico5 != null : "fx:id=\"labelTecnico5\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico6 != null : "fx:id=\"labelTecnico6\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico7 != null : "fx:id=\"labelTecnico7\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico8 != null : "fx:id=\"labelTecnico8\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        assert labelTecnico9 != null : "fx:id=\"labelTecnico9\" was not injected: check your FXML file 'TelaListarSelecao.fxml'.";
        
        
        ArrayList<Label> labelsSelecoes = new ArrayList<Label>();
        
        labelsSelecoes.add(labelSelecao1);
        labelsSelecoes.add(labelSelecao2);
        labelsSelecoes.add(labelSelecao3);
        labelsSelecoes.add(labelSelecao4);
        labelsSelecoes.add(labelSelecao5);
        labelsSelecoes.add(labelSelecao6);
        labelsSelecoes.add(labelSelecao7);
        labelsSelecoes.add(labelSelecao8);
        labelsSelecoes.add(labelSelecao9);
        labelsSelecoes.add(labelSelecao10);
        labelsSelecoes.add(labelSelecao11);
        labelsSelecoes.add(labelSelecao12);
        labelsSelecoes.add(labelSelecao13);
        labelsSelecoes.add(labelSelecao14);
        labelsSelecoes.add(labelSelecao15);
        labelsSelecoes.add(labelSelecao16);
        labelsSelecoes.add(labelSelecao17);
        labelsSelecoes.add(labelSelecao18);
        labelsSelecoes.add(labelSelecao19);
        labelsSelecoes.add(labelSelecao20);
        labelsSelecoes.add(labelSelecao21);
        labelsSelecoes.add(labelSelecao22);
        labelsSelecoes.add(labelSelecao23);
        labelsSelecoes.add(labelSelecao24);
        labelsSelecoes.add(labelSelecao25);
        labelsSelecoes.add(labelSelecao26);
        labelsSelecoes.add(labelSelecao27);
        labelsSelecoes.add(labelSelecao28);
        labelsSelecoes.add(labelSelecao29);
        labelsSelecoes.add(labelSelecao30);
        labelsSelecoes.add(labelSelecao31);
        labelsSelecoes.add(labelSelecao32);
        
        ArrayList<Label> labelsTecnicos = new ArrayList<Label>();
        
        labelsTecnicos.add(labelTecnico1);
        labelsTecnicos.add(labelTecnico2);
        labelsTecnicos.add(labelTecnico3);
        labelsTecnicos.add(labelTecnico4);
        labelsTecnicos.add(labelTecnico5);
        labelsTecnicos.add(labelTecnico6);
        labelsTecnicos.add(labelTecnico7);
        labelsTecnicos.add(labelTecnico8);
        labelsTecnicos.add(labelTecnico9);
        labelsTecnicos.add(labelTecnico10);
        labelsTecnicos.add(labelTecnico11);
        labelsTecnicos.add(labelTecnico12);
        labelsTecnicos.add(labelTecnico13);
        labelsTecnicos.add(labelTecnico14);
        labelsTecnicos.add(labelTecnico15);
        labelsTecnicos.add(labelTecnico16);
        labelsTecnicos.add(labelTecnico17);
        labelsTecnicos.add(labelTecnico18);
        labelsTecnicos.add(labelTecnico19);
        labelsTecnicos.add(labelTecnico20);
        labelsTecnicos.add(labelTecnico21);
        labelsTecnicos.add(labelTecnico22);
        labelsTecnicos.add(labelTecnico23);
        labelsTecnicos.add(labelTecnico24);
        labelsTecnicos.add(labelTecnico25);
        labelsTecnicos.add(labelTecnico26);
        labelsTecnicos.add(labelTecnico27);
        labelsTecnicos.add(labelTecnico28);
        labelsTecnicos.add(labelTecnico29);
        labelsTecnicos.add(labelTecnico30);
        labelsTecnicos.add(labelTecnico31);
        labelsTecnicos.add(labelTecnico32);
        
        
        
        if(listaSelecoes.size()!=0)
        {
        	for(int i =0; i<listaSelecoes.size();i++)
        	{
        		if(listaSelecoes.get(i)!= null)
        		{
        			labelsSelecoes.get(i).setText(listaSelecoes.get(i).getNome());
        			labelsTecnicos.get(i).setText(listaSelecoes.get(i).getTecnico().getNome());
        		}
        	}
        	
        	
        
        }
        
        
        
        
        
        
        
      
        
        
    }

}
