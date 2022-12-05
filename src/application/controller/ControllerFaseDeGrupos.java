package application.controller;
import java.io.IOException;
import java.util.ArrayList;

import application.Main;
import application.model.FaseDeGrupos.FaseDeGrupos;
import application.model.SelecaoPackage.Selecao;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerFaseDeGrupos {

    @FXML
    private Button cadastrarPartidas;

    @FXML
    private Button listarPartidas;

    @FXML
    private Button classificacao;

    @FXML
    private Button voltar;
    
    private FaseDeGrupos faseDeGrupos;
    
    void btnCadastrarPartidas(ActionEvent event) throws IOException {
    	Main.trocaDeTela("/application/view/Partida/TelaTodasPartidas.fxml", null);
    }

}
