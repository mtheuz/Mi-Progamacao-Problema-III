package application.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.FaseDeGrupos.FaseDeGrupos;
import application.model.PartidaPackage.Partida;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControllerRanking implements Initializable{

    @FXML
    private Label primeiroLugar;

    @FXML
    private Label segundoLugar;

    @FXML
    private Label terceiroLugar;

    @FXML
    private Button btnVoltar;
    Partida jogoFinal;
    Partida terceiroLugarDisputa;
    SelecaoDaoImpl selecaoDao;
    FaseDeGrupos fase;
    public ControllerRanking(Partida jogoFinal, Partida terceiroLugarDisputa, SelecaoDaoImpl selecaoDao, FaseDeGrupos fase) {
		this.jogoFinal = jogoFinal;
		this.terceiroLugarDisputa = terceiroLugarDisputa;
		this.selecaoDao =selecaoDao;
		this.fase = fase;
	}
    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
    	TelaPartida controller = new TelaPartida(selecaoDao,fase);
   	 	Main.trocaDeTela("/application/view/Partida/TelaPartidas.fxml", controller, null);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		primeiroLugar.setText(jogoFinal.getVencedor());
		segundoLugar.setText(jogoFinal.getPerdedor());
		terceiroLugar.setText(terceiroLugarDisputa.getVencedor());
		
	}

}
