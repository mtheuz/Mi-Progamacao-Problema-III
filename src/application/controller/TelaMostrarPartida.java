package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.model.Eliminatoria.Eliminatoria;
import application.model.FaseDeGrupos.FaseDeGrupos;
import application.model.JogadorPackage.JogadorDaoImpl;
import application.model.PartidaPackage.Partida;
import application.model.PartidaPackage.PartidaDaoImpl;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TelaMostrarPartida {

	private Partida partida;
	private SelecaoDaoImpl selecaoDao;
	private FaseDeGrupos fase;
	private String endereco;
	
    public TelaMostrarPartida(FaseDeGrupos fase, SelecaoDaoImpl selecaoDao, Partida partida, String endereco ) {
		this.selecaoDao = selecaoDao;
    	this.partida = partida;
    	this.fase = fase;
    	this.endereco = endereco;
    	
    }
   
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label AmareloJogador10Time1;

    @FXML
    private Label AmareloJogador10Time2;

    @FXML
    private Label AmareloJogador11Time1;

    @FXML
    private Label AmareloJogador11Time2;

    @FXML
    private Label AmareloJogador1Time1;

    @FXML
    private Label AmareloJogador1Time2;

    @FXML
    private Label AmareloJogador2Time1;

    @FXML
    private Label AmareloJogador2Time2;

    @FXML
    private Label AmareloJogador3Time1;

    @FXML
    private Label AmareloJogador3Time2;

    @FXML
    private Label AmareloJogador4Time1;

    @FXML
    private Label AmareloJogador4Time2;

    @FXML
    private Label AmareloJogador5Time1;

    @FXML
    private Label AmareloJogador5Time2;

    @FXML
    private Label AmareloJogador6Time1;

    @FXML
    private Label AmareloJogador6Time2;

    @FXML
    private Label AmareloJogador7Time1;

    @FXML
    private Label AmareloJogador7Time2;

    @FXML
    private Label AmareloJogador8Time1;

    @FXML
    private Label AmareloJogador8Time2;

    @FXML
    private Label AmareloJogador9Time1;

    @FXML
    private Label AmareloJogador9Time2;

    @FXML
    private Label VermelhoJogador1Time1;

    @FXML
    private Label VermelhoJogador1Time2;

    @FXML
    private Label VermelhoJogador2Time1;

    @FXML
    private Label VermelhoJogador2Time2;

    @FXML
    private Label VermelhoJogador3Time1;

    @FXML
    private Label VermelhoJogador3Time2;

    @FXML
    private Label VermelhoJogador4Time1;

    @FXML
    private Label VermelhoJogador4Time2;

    @FXML
    private Button btnCancelarPartida;
    
    @FXML
    private Button btnCancelarPartida1;

    @FXML
    private Button btnEditarPartida;
    
    @FXML
    private Button btnEditarPartida1;

    @FXML
    private Button btnVoltar;

    @FXML
    private Label data;

    @FXML
    private Label estadio;

    @FXML
    private Label golJog10Time1;

    @FXML
    private Label golJog10Time2;

    @FXML
    private Label golJog11Time1;

    @FXML
    private Label golJog11Time2;

    @FXML
    private Label golJog1Time1;

    @FXML
    private Label golJog1Time2;

    @FXML
    private Label golJog2Time1;

    @FXML
    private Label golJog2Time2;

    @FXML
    private Label golJog3Time1;

    @FXML
    private Label golJog3Time2;

    @FXML
    private Label golJog4Time1;

    @FXML
    private Label golJog4Time2;

    @FXML
    private Label golJog5Time1;

    @FXML
    private Label golJog5Time2;

    @FXML
    private Label golJog6Time1;

    @FXML
    private Label golJog6Time2;

    @FXML
    private Label golJog7Time1;

    @FXML
    private Label golJog7Time2;

    @FXML
    private Label golJog8Time1;

    @FXML
    private Label golJog8Time2;

    @FXML
    private Label golJog9Time1;

    @FXML
    private Label golJog9Time2;

    @FXML
    private Label gols1;

    @FXML
    private Label gols2;

    @FXML
    private Label horario;

    @FXML
    private Label nomeSelecao1;

    @FXML
    private Label nomeSelecao114111;

    @FXML
    private Label nomeSelecao2;

    @FXML
    private Label nomeSelecao3;

    @FXML
    private Label nomeSelecao4;

    @FXML
    private Label redCards1;

    @FXML
    private Label redCards2;

    @FXML
    private Label yellowcards1;

    @FXML
    private Label yellowcards2;
    
   
    @FXML
    void btnCancelarPartidaAction(ActionEvent event) throws IOException {
    	PartidaDaoImpl.deletar(partida);
    	TelaMostrarPartida controller = new TelaMostrarPartida(fase, selecaoDao, partida, endereco);
		Main.trocaDeTela("/application/view/Partida/TelaMostrarPartida.fxml", controller, null);
    }

    @FXML
    void btnEditarPartidaAction(ActionEvent event) throws IOException {
    	ControllerCadastroPartida cadastroPartida = new ControllerCadastroPartida(this.partida, selecaoDao, null, null);
		Main.trocaDeTela("/application/view/Partida/CadastroDePartida.fxml", cadastroPartida, null);
    }

    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaPartida controller = new TelaPartida(selecaoDao, fase);
    	Main.trocaDeTela("/application/view/Partida/TelaPartidas.fxml", controller, selecaoDao);
    }

    @FXML
    void initialize() {
        
        
        
        data.setText(partida.getData());
        estadio.setText(partida.getLocal());
        horario.setText(partida.getHorario());
        nomeSelecao1.setText(partida.getSelecao1());
        nomeSelecao2.setText(partida.getSelecao2());
        nomeSelecao3.setText(partida.getSelecao1());
        nomeSelecao4.setText(partida.getSelecao2());
        gols1.setText(partida.getPlacarSelecao1());
        gols2.setText(partida.getPlacarSelecao2());
        
        ArrayList<Label> labelsJogadoresGolstime1= new ArrayList<Label>();
        labelsJogadoresGolstime1.add( golJog1Time1);
        labelsJogadoresGolstime1.add( golJog2Time1);
        labelsJogadoresGolstime1.add( golJog3Time1);
        labelsJogadoresGolstime1.add( golJog4Time1);
        labelsJogadoresGolstime1.add( golJog5Time1);
        labelsJogadoresGolstime1.add( golJog6Time1);
        labelsJogadoresGolstime1.add( golJog7Time1);
        labelsJogadoresGolstime1.add( golJog8Time1);
        labelsJogadoresGolstime1.add( golJog9Time1);
        labelsJogadoresGolstime1.add( golJog10Time1);
        labelsJogadoresGolstime1.add( golJog11Time1);
        
        ArrayList<Label> labelsJogadoresGolstime2= new ArrayList<Label>();
        
        labelsJogadoresGolstime2.add( golJog1Time2);
        labelsJogadoresGolstime2.add( golJog2Time2);
        labelsJogadoresGolstime2.add( golJog3Time2);
        labelsJogadoresGolstime2.add( golJog4Time2);
        labelsJogadoresGolstime2.add( golJog5Time2);
        labelsJogadoresGolstime2.add( golJog6Time2);
        labelsJogadoresGolstime2.add( golJog7Time2);
        labelsJogadoresGolstime2.add( golJog8Time2);
        labelsJogadoresGolstime2.add( golJog9Time2);
        labelsJogadoresGolstime2.add( golJog10Time2);
        labelsJogadoresGolstime2.add( golJog11Time2);
        
        
        ArrayList<Label> labelsYellowCardstime1= new ArrayList<Label>();
        labelsYellowCardstime1.add(AmareloJogador1Time1);
        labelsYellowCardstime1.add(AmareloJogador2Time1);
        labelsYellowCardstime1.add(AmareloJogador3Time1);
        labelsYellowCardstime1.add(AmareloJogador4Time1);
        labelsYellowCardstime1.add(AmareloJogador5Time1);
        labelsYellowCardstime1.add(AmareloJogador6Time1);
        labelsYellowCardstime1.add(AmareloJogador7Time1);
        labelsYellowCardstime1.add(AmareloJogador8Time1);
        labelsYellowCardstime1.add(AmareloJogador9Time1);
        labelsYellowCardstime1.add(AmareloJogador10Time1);
        labelsYellowCardstime1.add(AmareloJogador11Time1);
        
        
        ArrayList<Label> labelsYellowCardstime2= new ArrayList<Label>();
        
        labelsYellowCardstime2.add(AmareloJogador1Time2);
        labelsYellowCardstime2.add(AmareloJogador2Time2);
        labelsYellowCardstime2.add(AmareloJogador3Time2);
        labelsYellowCardstime2.add(AmareloJogador4Time2);
        labelsYellowCardstime2.add(AmareloJogador5Time2);
        labelsYellowCardstime2.add(AmareloJogador6Time2);
        labelsYellowCardstime2.add(AmareloJogador7Time2);
        labelsYellowCardstime2.add(AmareloJogador8Time2);
        labelsYellowCardstime2.add(AmareloJogador9Time2);
        labelsYellowCardstime2.add(AmareloJogador10Time2);
        labelsYellowCardstime2.add(AmareloJogador11Time2);
        
        ArrayList<Label> labelsRedCardstime1= new ArrayList<Label>();
        
        labelsRedCardstime1.add(VermelhoJogador1Time1);
        labelsRedCardstime1.add(VermelhoJogador2Time1);
        labelsRedCardstime1.add(VermelhoJogador3Time1);
        labelsRedCardstime1.add(VermelhoJogador4Time1);
        
        ArrayList<Label> labelsRedCardstime2= new ArrayList<Label>();
        
        labelsRedCardstime2.add(VermelhoJogador1Time2);
        labelsRedCardstime2.add(VermelhoJogador2Time2);
        labelsRedCardstime2.add(VermelhoJogador3Time2);
        labelsRedCardstime2.add(VermelhoJogador4Time2);
        
        int selecao1 = selecaoDao.buscaSelecao(this.partida.getSelecao1());
        int selecao2 = selecaoDao.buscaSelecao(this.partida.getSelecao2());
       
       
        
        for(int i =0;i <partida.getGolsSelecao1().size();i++)
        {
             int jogador = JogadorDaoImpl.buscarJogador(partida.getGolsSelecao1().get(i).get(0));
             labelsJogadoresGolstime1.get(i).setText(selecaoDao.getListaSelecoes().get(selecao1).getListaJogadores().get(jogador).getNome());
        }
        
        for(int i =0;i <partida.getGolsSelecao2().size();i++)
        {
        	int jogador = JogadorDaoImpl.buscarJogador(partida.getGolsSelecao2().get(i).get(0));
        	labelsJogadoresGolstime2.get(i).setText(selecaoDao.getListaSelecoes().get(selecao2).getListaJogadores().get(jogador).getNome());
        }
        
        for(int i =0;i <partida.getCartoesAmarelosSelecao1().size();i++)
        {
        	int jogador = JogadorDaoImpl.buscarJogador(partida.getCartoesAmarelosSelecao1().get(i).get(0));
        	labelsYellowCardstime1.get(i).setText(selecaoDao.getListaSelecoes().get(selecao1).getListaJogadores().get(jogador).getNome());
        	 
        }
        
        for(int i =0;i <partida.getCartoesAmarelosSelecao2().size();i++)
        {
        	int jogador = JogadorDaoImpl.buscarJogador(partida.getCartoesAmarelosSelecao2().get(i).get(0)); 
        	labelsYellowCardstime2.get(i).setText(selecaoDao.getListaSelecoes().get(selecao2).getListaJogadores().get(jogador).getNome());
        }

        
        for(int i =0;i <partida.getCartoesVermelhosSelecao1().size();i++)
        {
        	int jogador = JogadorDaoImpl.buscarJogador(partida.getCartoesVermelhosSelecao1().get(i).get(0));
        	labelsRedCardstime1.get(i).setText(selecaoDao.getListaSelecoes().get(selecao1).getListaJogadores().get(jogador).getNome());
        }
        
        for(int i =0;i <partida.getCartoesVermelhosSelecao2().size();i++)
        {
        	int jogador = JogadorDaoImpl.buscarJogador(partida.getCartoesVermelhosSelecao2().get(i).get(0));
        	labelsRedCardstime2.get(i).setText(selecaoDao.getListaSelecoes().get(selecao2).getListaJogadores().get(jogador).getNome());
        }
    
        
        switch(endereco)
        {
        	case "fase de grupos":
        	if(fase.verificaPartidas())
        	{
        		btnEditarPartida.setDisable(true);
        		btnCancelarPartida.setDisable(true);
        		btnEditarPartida1.setDisable(true);
        		btnCancelarPartida1.setDisable(true);
        		
        	}
        	break;
        	case "oitavas":
            	if(Eliminatoria.verificaPartidas(Eliminatoria.oitavas))
            	{
            		btnEditarPartida.setDisable(true);
            		btnCancelarPartida.setDisable(true);
            		btnEditarPartida1.setDisable(true);
            		btnCancelarPartida1.setDisable(true);
            		
            	}
            	break;
        	case "quartas":
            	if(Eliminatoria.verificaPartidas(Eliminatoria.oitavas))
            	{
            		btnEditarPartida.setDisable(true);
            		btnCancelarPartida.setDisable(true);
            		btnEditarPartida1.setDisable(true);
            		btnCancelarPartida1.setDisable(true);
            	}
            	break;
        	case "semi":
            	if(Eliminatoria.verificaPartidas(Eliminatoria.oitavas))
            	{
            		btnEditarPartida.setDisable(true);
            		btnCancelarPartida.setDisable(true);
            		btnEditarPartida1.setDisable(true);
            		btnCancelarPartida1.setDisable(true);
            	}
        	case "final":
            	if(Eliminatoria.Final.isSituacao()==true)
            	{
            		btnEditarPartida.setDisable(true);
            		btnCancelarPartida.setDisable(true);
            		btnEditarPartida1.setDisable(true);
            		btnCancelarPartida1.setDisable(true);
            	}
            	break;
        	case "terceiro lugar":
            	if(Eliminatoria.TerceiroLugar()==true)
            	{
            		btnEditarPartida.setDisable(true);
            		btnCancelarPartida.setDisable(true);
            		btnEditarPartida1.setDisable(true);
            		btnCancelarPartida1.setDisable(true);
            	}
            	break;
        }
    }
        
    }


