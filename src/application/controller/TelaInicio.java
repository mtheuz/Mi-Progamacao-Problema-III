package application.controller;
import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import application.Main;
import application.model.ArbitroPackage.Arbitro;
import application.model.JogadorPackage.JogadorDaoImpl;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TelaInicio{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btnCadastrarSelecoes;

    @FXML
    private Button btnAbrirMenuCadastros;
    
    @FXML
    private Button btnCarregarPreSet;
    
    @FXML
    private Button btnIniciarFaseDeGrupos;
    
    @FXML
    private Label label;
    
    private int num;
   
    
    
    
    SelecaoDaoImpl selecaoDao = new SelecaoDaoImpl();
    JogadorDaoImpl jogadorDao = new JogadorDaoImpl(selecaoDao.getListaSelecoes());
    
    public static ArrayList<Arbitro> listaArbitros = new ArrayList<Arbitro>();
    
    @FXML
    void btnCarregarPreSetAction(ActionEvent event) throws IOException {
    	selecaoDao.leArquivoSelecoes();
    	jogadorDao.transformaEmMap();
    	label.setText("Pré Set Carregado com sucesso!");
    	
    }
    
    
    @FXML
    void btnIniciarFaseDeGruposAction(ActionEvent event) throws IOException {
    	TelaPartida controller = new TelaPartida();
    	Main.trocaDeTela("/application/view/Partida/TelaPartidas.fxml", controller, selecaoDao);
    	
    }

    @FXML

    void btnAbrirTelaMenuCadastrosAction(ActionEvent event) throws IOException {
    	TelaMenuCadastros controller = new TelaMenuCadastros(selecaoDao);
    	Main.trocaDeTela("/application/view/TelaMenuCadastros.fxml", controller, selecaoDao);
    	
    }
    
    @FXML
    void initialize() {
    	assert btnAbrirMenuCadastros != null : "fx:id=\"btnAbrirMenuCadastros\" was not injected: check your FXML file 'TelaInicio.fxml'.";
        assert btnCadastrarSelecoes != null : "fx:id=\"btnCadastrarSelecoes\" was not injected: check your FXML file 'TelaInicio.fxml'.";
        assert btnCarregarPreSet != null : "fx:id=\"btnCarregarPreSet\" was not injected: check your FXML file 'TelaInicio.fxml'.";
        assert btnIniciarFaseDeGrupos != null : "fx:id=\"btnIniciarFaseDeGrupos\" was not injected: check your FXML file 'TelaInicio.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'TelaInicio.fxml'.";
    }
}
