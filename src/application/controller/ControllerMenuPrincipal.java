import java.awt.event.ActionEvent;

import application.Main;
import application.model.FaseDeGrupos.FaseDeGrupos;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerMenuPrincipal {

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnPartida;

    @FXML
    private Button btnPesquias;

    @FXML
    private Button btnTecnicos;

    @FXML
    private Button btnArbitros;

    @FXML
    void btnVoltarAction(ActionEvent event) {

    }

    @FXML
    void clickArbitro(ActionEvent event) {

    }

    @FXML
    void clickPartida(ActionEvent event) {
    	FaseDeGrupos faseDeGrupos = new FaseDeGrupos(SelecaoDaoImpl.listaSelecoes);
    	faseDeGrupos.geraPartidas();
    	Main.trocaDeTela("/application/view/Partida/TelaPartidas.fxml", null);
    }

    @FXML
    void clickPesquisa(ActionEvent event) {

    }

    @FXML
    void clickTecnico(ActionEvent event) {

    }

}

