package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.model.PartidaPackage.Partida;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TelaMostrarPartida {

	private Partida partida;

    public TelaMostrarPartida(Partida partida) {
		this.partida = partida;
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
    private Button btnEditarPartida;

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
    void btnEditarPartidaAction(ActionEvent event) {

    }

    @FXML
    void btnVoltarAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert AmareloJogador10Time1 != null : "fx:id=\"AmareloJogador10Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert AmareloJogador10Time2 != null : "fx:id=\"AmareloJogador10Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert AmareloJogador11Time1 != null : "fx:id=\"AmareloJogador11Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert AmareloJogador11Time2 != null : "fx:id=\"AmareloJogador11Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert AmareloJogador1Time1 != null : "fx:id=\"AmareloJogador1Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert AmareloJogador1Time2 != null : "fx:id=\"AmareloJogador1Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert AmareloJogador2Time1 != null : "fx:id=\"AmareloJogador2Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert AmareloJogador2Time2 != null : "fx:id=\"AmareloJogador2Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert AmareloJogador3Time1 != null : "fx:id=\"AmareloJogador3Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert AmareloJogador3Time2 != null : "fx:id=\"AmareloJogador3Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert AmareloJogador4Time1 != null : "fx:id=\"AmareloJogador4Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert AmareloJogador4Time2 != null : "fx:id=\"AmareloJogador4Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert AmareloJogador5Time1 != null : "fx:id=\"AmareloJogador5Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert AmareloJogador5Time2 != null : "fx:id=\"AmareloJogador5Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert AmareloJogador6Time1 != null : "fx:id=\"AmareloJogador6Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert AmareloJogador6Time2 != null : "fx:id=\"AmareloJogador6Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert AmareloJogador7Time1 != null : "fx:id=\"AmareloJogador7Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert AmareloJogador7Time2 != null : "fx:id=\"AmareloJogador7Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert AmareloJogador8Time1 != null : "fx:id=\"AmareloJogador8Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert AmareloJogador8Time2 != null : "fx:id=\"AmareloJogador8Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert AmareloJogador9Time1 != null : "fx:id=\"AmareloJogador9Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert AmareloJogador9Time2 != null : "fx:id=\"AmareloJogador9Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert VermelhoJogador1Time1 != null : "fx:id=\"VermelhoJogador1Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert VermelhoJogador1Time2 != null : "fx:id=\"VermelhoJogador1Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert VermelhoJogador2Time1 != null : "fx:id=\"VermelhoJogador2Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert VermelhoJogador2Time2 != null : "fx:id=\"VermelhoJogador2Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert VermelhoJogador3Time1 != null : "fx:id=\"VermelhoJogador3Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert VermelhoJogador3Time2 != null : "fx:id=\"VermelhoJogador3Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert VermelhoJogador4Time1 != null : "fx:id=\"VermelhoJogador4Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert VermelhoJogador4Time2 != null : "fx:id=\"VermelhoJogador4Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert btnCancelarPartida != null : "fx:id=\"btnCancelarPartida\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert btnEditarPartida != null : "fx:id=\"btnEditarPartida\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert btnVoltar != null : "fx:id=\"btnVoltar\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert data != null : "fx:id=\"data\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert estadio != null : "fx:id=\"estadio\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog10Time1 != null : "fx:id=\"golJog10Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog10Time2 != null : "fx:id=\"golJog10Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog11Time1 != null : "fx:id=\"golJog11Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog11Time2 != null : "fx:id=\"golJog11Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog1Time1 != null : "fx:id=\"golJog1Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog1Time2 != null : "fx:id=\"golJog1Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog2Time1 != null : "fx:id=\"golJog2Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog2Time2 != null : "fx:id=\"golJog2Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog3Time1 != null : "fx:id=\"golJog3Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog3Time2 != null : "fx:id=\"golJog3Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog4Time1 != null : "fx:id=\"golJog4Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog4Time2 != null : "fx:id=\"golJog4Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog5Time1 != null : "fx:id=\"golJog5Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog5Time2 != null : "fx:id=\"golJog5Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog6Time1 != null : "fx:id=\"golJog6Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog6Time2 != null : "fx:id=\"golJog6Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog7Time1 != null : "fx:id=\"golJog7Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog7Time2 != null : "fx:id=\"golJog7Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog8Time1 != null : "fx:id=\"golJog8Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog8Time2 != null : "fx:id=\"golJog8Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog9Time1 != null : "fx:id=\"golJog9Time1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert golJog9Time2 != null : "fx:id=\"golJog9Time2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert gols1 != null : "fx:id=\"gols1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert gols2 != null : "fx:id=\"gols2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert horario != null : "fx:id=\"horario\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert nomeSelecao1 != null : "fx:id=\"nomeSelecao1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert nomeSelecao114111 != null : "fx:id=\"nomeSelecao114111\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert nomeSelecao2 != null : "fx:id=\"nomeSelecao2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert nomeSelecao3 != null : "fx:id=\"nomeSelecao3\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert nomeSelecao4 != null : "fx:id=\"nomeSelecao4\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert redCards1 != null : "fx:id=\"redCards1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert redCards2 != null : "fx:id=\"redCards2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert yellowcards1 != null : "fx:id=\"yellowcards1\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        assert yellowcards2 != null : "fx:id=\"yellowcards2\" was not injected: check your FXML file 'TelaMostrarPartida.fxml'.";
        
        
        data.setText(partida.getData());
        estadio.setText(partida.getLocal());
        horario.setText(partida.getHorario());
        nomeSelecao1.setText(partida.getSelecao1());
        nomeSelecao2.setText(partida.getSelecao2());
        nomeSelecao3.setText(partida.getSelecao1());
        nomeSelecao4.setText(partida.getSelecao2());
        gols1.setText(Integer.toString(partida.getGolsSelecao1().size()));
        gols2.setText(Integer.toString(partida.getGolsSelecao2().size()));
        
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
        
        for(int i =0;i <partida.getGolsSelecao1().size();i++)
        {
        	labelsJogadoresGolstime1.get(i).setText(partida.getGolsSelecao1().get(i).get(i));
        }
        
        for(int i =0;i <partida.getGolsSelecao2().size();i++)
        {
        	labelsJogadoresGolstime2.get(i).setText(partida.getGolsSelecao2().get(i).get(i));
        }
        
        for(int i =0;i <partida.getCartoesAmarelosSelecao1().size();i++)
        {
        	 labelsYellowCardstime2.get(i).setText(partida.getCartoesAmarelosSelecao1().get(i).get(i));
        }
        
        for(int i =0;i <partida.getCartoesAmarelosSelecao2().size();i++)
        {
        	 labelsYellowCardstime2.get(i).setText(partida.getCartoesAmarelosSelecao2().get(i).get(i));
        }


        for(int i =0;i <partida.getCartoesVermelhosSelecao1().size();i++)
        {
        	labelsRedCardstime1.get(i).setText(partida.getCartoesVermelhosSelecao1().get(i).get(i));
        }
        
        for(int i =0;i <partida.getCartoesVermelhosSelecao2().size();i++)
        {
        	labelsRedCardstime2.get(i).setText(partida.getCartoesVermelhosSelecao2().get(i).get(i));
        }
    }

    
        
        
    }


