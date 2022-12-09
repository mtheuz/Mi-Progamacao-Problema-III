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

public class TelaListarJogadores {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnVoltar;

    @FXML
    private Label labelCod1;

    @FXML
    private Label labelCod10;

    @FXML
    private Label labelCod11;

    @FXML
    private Label labelCod12;

    @FXML
    private Label labelCod13;

    @FXML
    private Label labelCod14;

    @FXML
    private Label labelCod15;

    @FXML
    private Label labelCod16;

    @FXML
    private Label labelCod17;

    @FXML
    private Label labelCod18;

    @FXML
    private Label labelCod19;

    @FXML
    private Label labelCod2;

    @FXML
    private Label labelCod20;

    @FXML
    private Label labelCod21;

    @FXML
    private Label labelCod22;

    @FXML
    private Label labelCod23;

    @FXML
    private Label labelCod24;

    @FXML
    private Label labelCod25;

    @FXML
    private Label labelCod26;

    @FXML
    private Label labelCod3;

    @FXML
    private Label labelCod4;

    @FXML
    private Label labelCod5;

    @FXML
    private Label labelCod6;

    @FXML
    private Label labelCod7;

    @FXML
    private Label labelCod8;

    @FXML
    private Label labelCod9;

    @FXML
    private Label labelNome1;

    @FXML
    private Label labelNome10;

    @FXML
    private Label labelNome11;

    @FXML
    private Label labelNome12;

    @FXML
    private Label labelNome13;

    @FXML
    private Label labelNome14;

    @FXML
    private Label labelNome15;

    @FXML
    private Label labelNome16;

    @FXML
    private Label labelNome17;

    @FXML
    private Label labelNome18;

    @FXML
    private Label labelNome19;

    @FXML
    private Label labelNome2;

    @FXML
    private Label labelNome20;

    @FXML
    private Label labelNome21;

    @FXML
    private Label labelNome22;

    @FXML
    private Label labelNome23;

    @FXML
    private Label labelNome24;

    @FXML
    private Label labelNome25;

    @FXML
    private Label labelNome26;

    @FXML
    private Label labelNome3;

    @FXML
    private Label labelNome4;

    @FXML
    private Label labelNome5;

    @FXML
    private Label labelNome6;

    @FXML
    private Label labelNome7;

    @FXML
    private Label labelNome8;

    @FXML
    private Label labelNome9;

    @FXML
    private Label labelNomeSelecao;

    @FXML
    private Label labelNomeSelecao1;

    @FXML
    private Label labelPosicao1;

    @FXML
    private Label labelPosicao10;

    @FXML
    private Label labelPosicao11;

    @FXML
    private Label labelPosicao12;

    @FXML
    private Label labelPosicao13;

    @FXML
    private Label labelPosicao14;

    @FXML
    private Label labelPosicao15;

    @FXML
    private Label labelPosicao16;

    @FXML
    private Label labelPosicao17;

    @FXML
    private Label labelPosicao18;

    @FXML
    private Label labelPosicao19;

    @FXML
    private Label labelPosicao2;

    @FXML
    private Label labelPosicao20;

    @FXML
    private Label labelPosicao21;

    @FXML
    private Label labelPosicao22;

    @FXML
    private Label labelPosicao23;

    @FXML
    private Label labelPosicao24;

    @FXML
    private Label labelPosicao25;

    @FXML
    private Label labelPosicao26;

    @FXML
    private Label labelPosicao3;

    @FXML
    private Label labelPosicao4;

    @FXML
    private Label labelPosicao5;

    @FXML
    private Label labelPosicao6;

    @FXML
    private Label labelPosicao7;

    @FXML
    private Label labelPosicao8;

    @FXML
    private Label labelPosicao9;
    
    private String selecao;
    private SelecaoDaoImpl selecaoDao;
    
    private ArrayList <Selecao> listaSelecoes;
    public TelaListarJogadores(SelecaoDaoImpl selecaoDao, String selecao) {
    	this.selecaoDao = selecaoDao;
    	this.listaSelecoes = new ArrayList<Selecao>();
		listaSelecoes = selecaoDao.getListaSelecoes();
		this.selecao = selecao;
	}

	@FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
		TelaEscolherSelecaoListarJogador controller = new TelaEscolherSelecaoListarJogador(selecaoDao);
    	Main.trocaDeTela("/application/view/Jogador/TelaEscolherSelecaoListarJogador.fxml", controller, selecaoDao);
    }

    @FXML
    void initialize() {
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod1 != null : "fx:id=\"labelCod1\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod10 != null : "fx:id=\"labelCod10\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod11 != null : "fx:id=\"labelCod11\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod12 != null : "fx:id=\"labelCod12\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod13 != null : "fx:id=\"labelCod13\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod14 != null : "fx:id=\"labelCod14\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod15 != null : "fx:id=\"labelCod15\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod16 != null : "fx:id=\"labelCod16\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod17 != null : "fx:id=\"labelCod17\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod18 != null : "fx:id=\"labelCod18\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod19 != null : "fx:id=\"labelCod19\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod2 != null : "fx:id=\"labelCod2\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod20 != null : "fx:id=\"labelCod20\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod21 != null : "fx:id=\"labelCod21\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod22 != null : "fx:id=\"labelCod22\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod23 != null : "fx:id=\"labelCod23\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod24 != null : "fx:id=\"labelCod24\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod25 != null : "fx:id=\"labelCod25\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod26 != null : "fx:id=\"labelCod26\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod3 != null : "fx:id=\"labelCod3\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod4 != null : "fx:id=\"labelCod4\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod5 != null : "fx:id=\"labelCod5\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod6 != null : "fx:id=\"labelCod6\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod7 != null : "fx:id=\"labelCod7\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod8 != null : "fx:id=\"labelCod8\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelCod9 != null : "fx:id=\"labelCod9\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome1 != null : "fx:id=\"labelNome1\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome10 != null : "fx:id=\"labelNome10\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome11 != null : "fx:id=\"labelNome11\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome12 != null : "fx:id=\"labelNome12\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome13 != null : "fx:id=\"labelNome13\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome14 != null : "fx:id=\"labelNome14\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome15 != null : "fx:id=\"labelNome15\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome16 != null : "fx:id=\"labelNome16\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome17 != null : "fx:id=\"labelNome17\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome18 != null : "fx:id=\"labelNome18\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome19 != null : "fx:id=\"labelNome19\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome2 != null : "fx:id=\"labelNome2\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome20 != null : "fx:id=\"labelNome20\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome21 != null : "fx:id=\"labelNome21\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome22 != null : "fx:id=\"labelNome22\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome23 != null : "fx:id=\"labelNome23\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome24 != null : "fx:id=\"labelNome24\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome25 != null : "fx:id=\"labelNome25\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome26 != null : "fx:id=\"labelNome26\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome3 != null : "fx:id=\"labelNome3\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome4 != null : "fx:id=\"labelNome4\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome5 != null : "fx:id=\"labelNome5\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome6 != null : "fx:id=\"labelNome6\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome7 != null : "fx:id=\"labelNome7\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome8 != null : "fx:id=\"labelNome8\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNome9 != null : "fx:id=\"labelNome9\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNomeSelecao != null : "fx:id=\"labelNomeSelecao\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelNomeSelecao1 != null : "fx:id=\"labelNomeSelecao1\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao1 != null : "fx:id=\"labelPosicao1\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao10 != null : "fx:id=\"labelPosicao10\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao11 != null : "fx:id=\"labelPosicao11\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao12 != null : "fx:id=\"labelPosicao12\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao13 != null : "fx:id=\"labelPosicao13\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao14 != null : "fx:id=\"labelPosicao14\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao15 != null : "fx:id=\"labelPosicao15\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao16 != null : "fx:id=\"labelPosicao16\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao17 != null : "fx:id=\"labelPosicao17\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao18 != null : "fx:id=\"labelPosicao18\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao19 != null : "fx:id=\"labelPosicao19\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao2 != null : "fx:id=\"labelPosicao2\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao20 != null : "fx:id=\"labelPosicao20\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao21 != null : "fx:id=\"labelPosicao21\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao22 != null : "fx:id=\"labelPosicao22\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao23 != null : "fx:id=\"labelPosicao23\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao24 != null : "fx:id=\"labelPosicao24\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao25 != null : "fx:id=\"labelPosicao25\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao26 != null : "fx:id=\"labelPosicao26\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao3 != null : "fx:id=\"labelPosicao3\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao4 != null : "fx:id=\"labelPosicao4\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao5 != null : "fx:id=\"labelPosicao5\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao6 != null : "fx:id=\"labelPosicao6\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao7 != null : "fx:id=\"labelPosicao7\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao8 != null : "fx:id=\"labelPosicao8\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        assert labelPosicao9 != null : "fx:id=\"labelPosicao9\" was not injected: check your FXML file 'TelaListarJogadores.fxml'.";
        labelNomeSelecao.setText(selecao);
        
        
        ArrayList<Label> labelsCods= new ArrayList<Label>();
        labelsCods.add(labelCod1);
        labelsCods.add(labelCod2);
        labelsCods.add(labelCod3);
        labelsCods.add(labelCod4);
        labelsCods.add(labelCod5);
        labelsCods.add(labelCod6);
        labelsCods.add(labelCod7);
        labelsCods.add(labelCod8);
        labelsCods.add(labelCod9);
        labelsCods.add(labelCod10);
        labelsCods.add(labelCod11);
        labelsCods.add(labelCod12);
        labelsCods.add(labelCod13);
        labelsCods.add(labelCod14);
        labelsCods.add(labelCod15);
        labelsCods.add(labelCod16);
        labelsCods.add(labelCod17);
        labelsCods.add(labelCod18);
        labelsCods.add(labelCod19);
        labelsCods.add(labelCod20);
        labelsCods.add(labelCod21);
        labelsCods.add(labelCod22);
        labelsCods.add(labelCod23);
        labelsCods.add(labelCod24);
        labelsCods.add(labelCod25);
        labelsCods.add(labelCod26);
        
        ArrayList<Label> labelsNomes= new ArrayList<Label>();
        
        labelsNomes.add(labelNome1);
        labelsNomes.add(labelNome2);
        labelsNomes.add(labelNome3);
        labelsNomes.add(labelNome4);
        labelsNomes.add(labelNome5);
        labelsNomes.add(labelNome6);
        labelsNomes.add(labelNome7);
        labelsNomes.add(labelNome8);
        labelsNomes.add(labelNome9);
        labelsNomes.add(labelNome10);
        labelsNomes.add(labelNome11);
        labelsNomes.add(labelNome12);
        labelsNomes.add(labelNome13);
        labelsNomes.add(labelNome14);
        labelsNomes.add(labelNome15);
        labelsNomes.add(labelNome16);
        labelsNomes.add(labelNome17);
        labelsNomes.add(labelNome18);
        labelsNomes.add(labelNome19);
        labelsNomes.add(labelNome20);
        labelsNomes.add(labelNome21);
        labelsNomes.add(labelNome22);
        labelsNomes.add(labelNome23);
        labelsNomes.add(labelNome24);
        labelsNomes.add(labelNome25);
        labelsNomes.add(labelNome26);
        
        
        ArrayList<Label> labelsPosicoes= new ArrayList<Label>();
        
        labelsPosicoes.add(labelPosicao1);
        labelsPosicoes.add(labelPosicao2);
        labelsPosicoes.add(labelPosicao3);
        labelsPosicoes.add(labelPosicao4);
        labelsPosicoes.add(labelPosicao5);
        labelsPosicoes.add(labelPosicao6);
        labelsPosicoes.add(labelPosicao7);
        labelsPosicoes.add(labelPosicao8);
        labelsPosicoes.add(labelPosicao9);
        labelsPosicoes.add(labelPosicao10);
        labelsPosicoes.add(labelPosicao11);
        labelsPosicoes.add(labelPosicao12);
        labelsPosicoes.add(labelPosicao13);
        labelsPosicoes.add(labelPosicao14);
        labelsPosicoes.add(labelPosicao15);
        labelsPosicoes.add(labelPosicao16);
        labelsPosicoes.add(labelPosicao17);
        labelsPosicoes.add(labelPosicao18);
        labelsPosicoes.add(labelPosicao19);
        labelsPosicoes.add(labelPosicao20);
        labelsPosicoes.add(labelPosicao21);
        labelsPosicoes.add(labelPosicao22);
        labelsPosicoes.add(labelPosicao23);
        labelsPosicoes.add(labelPosicao24);
        labelsPosicoes.add(labelPosicao25);
        labelsPosicoes.add(labelPosicao26);
        
        int indice = selecaoDao.buscaSelecao(selecao);
        for(int i =0; i<listaSelecoes.get(indice).getListaJogadores().size();i++)
    	{
        	labelsNomes.get(i).setText(listaSelecoes.get(indice).getListaJogadores().get(i).getNome());
			labelsCods.get(i).setText(listaSelecoes.get(indice).getListaJogadores().get(i).getCode());
			labelsPosicoes.get(i).setText(listaSelecoes.get(indice).getListaJogadores().get(i).getPosicao());
    	}
        
    }

}

