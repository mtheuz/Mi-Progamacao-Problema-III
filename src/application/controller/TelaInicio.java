package application.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import application.Main;
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
    private Label label;
    
    private int num;
   

    SelecaoDaoImpl selecaoDao = new SelecaoDaoImpl();
    //JogadorDaoImpl jogadorDao = new JogadorDaoImpl(selecaoDao.getListaSelecoes());
    
    @FXML
    void btnCarregarPreSetAction(ActionEvent event) throws IOException {

    	selecaoDao.leArquivoSelecoes();
    	//jogadorDao.transformaEmMap();
    	label.setText("Pré Set Carregado com sucesso");
    	
    }
    @FXML

    void btnAbrirTelaSelecaoAction(ActionEvent event) throws IOException {
    	Main.trocaDeTela("/application/view/Jogador/TelaMenuCadastro.fxml", null);
    }
    
    @FXML
    void initialize() {
        assert btnCadastrarSelecoes != null : "fx:id=\"btnCadastrarSelecoes\" was not injected: check your FXML file 'TelaInicio.fxml'.";
        assert btnCarregarPreSet != null : "fx:id=\"btnCarregarPreSet\" was not injected: check your FXML file 'TelaInicio.fxml'.";
        
    }
}
