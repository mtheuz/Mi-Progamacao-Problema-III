package application.controller;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import application.model.FaseDeGrupos.FaseDeGrupos;
import application.model.JogadorPackage.JogadorDaoImpl;
import application.model.SelecaoPackage.Selecao;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class ControllerClassificacao implements Initializable{

    @FXML
    private Label grupoTitle;

    @FXML
    private Label grupoLabel;

    @FXML
    private Label selecao1;

    @FXML
    private Label selecao2;

    @FXML
    private Label selecao3;

    @FXML
    private Label selecao4;

    @FXML
    private Label selecao1pts;

    @FXML
    private Label selecao2pts;
    
    @FXML
    private Label selecao4pts;

    @FXML
    private Label selecao3pts;

    @FXML
    private Label selecao1V;

    @FXML
    private Label selecao2V;

    @FXML
    private Label selecao3V;

    @FXML
    private Label selecao4V;

    @FXML
    private Label selecao1D;

    @FXML
    private Label selecao2D;

    @FXML
    private Label selecao3D;

    @FXML
    private Label selecao4D;

    @FXML
    private Label selecao1E;

    @FXML
    private Label selecao2E;

    @FXML
    private Label selecao3E;

    @FXML
    private Label selecao4E;

    @FXML
    private Label selecao1Sg;

    @FXML
    private Label selecao2Sg;

    @FXML
    private Label selecao3Sg;

    @FXML
    private Label selecao4Sg;

    @FXML
    private ChoiceBox<String> grupos;
    
    FaseDeGrupos fase;
    SelecaoDaoImpl selecaoDao;
    private String[] gruposNome = {"GRUPO A", "GRUPO B","GRUPO C","GRUPO D","GRUPO E","GRUPO F","GRUPO G","GRUPO H"};

    public ControllerClassificacao(FaseDeGrupos fase, SelecaoDaoImpl selecaoDao) {
		this.fase = fase;
		this.selecaoDao = selecaoDao;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		grupos.getItems().addAll(gruposNome);
		grupos.setValue("GRUPO A");
		grupoTitle.setText("GRUPO A");
		grupoLabel.setText("GRUPO A");
		
		if(FaseDeGrupos.grupos.get("A") != null) {
			List<Selecao> listaSelecao = FaseDeGrupos.grupos.get("A");
			selecao1.setText(listaSelecao.get(0).getNome());
			selecao1D.setText(listaSelecao.get(0).getDerrota());
			selecao1E.setText(listaSelecao.get(0).getEmpate());
			selecao1V.setText(listaSelecao.get(0).getVitoria());
			selecao1pts.setText(Integer.toString(listaSelecao.get(0).getPontos()));
			selecao1Sg.setText(Integer.toString(listaSelecao.get(0).getSaldoGols()));
			
			selecao2.setText(listaSelecao.get(1).getNome());
			selecao2D.setText(listaSelecao.get(1).getDerrota());
			selecao2E.setText(listaSelecao.get(1).getEmpate());
			selecao2V.setText(listaSelecao.get(1).getVitoria());
			selecao2pts.setText(Integer.toString(listaSelecao.get(1).getPontos()));
			selecao2Sg.setText(Integer.toString(listaSelecao.get(1).getSaldoGols()));
			
			selecao3.setText(listaSelecao.get(2).getNome());
			selecao3D.setText(listaSelecao.get(2).getDerrota());
			selecao3E.setText(listaSelecao.get(2).getEmpate());
			selecao3V.setText(listaSelecao.get(2).getVitoria());
			selecao3pts.setText(Integer.toString(listaSelecao.get(2).getPontos()));
			selecao3Sg.setText(Integer.toString(listaSelecao.get(2).getSaldoGols()));
			
			selecao4.setText(listaSelecao.get(3).getNome());
			selecao4D.setText(listaSelecao.get(3).getDerrota());
			selecao4E.setText(listaSelecao.get(3).getEmpate());
			selecao4V.setText(listaSelecao.get(3).getVitoria());
			selecao4pts.setText(Integer.toString(listaSelecao.get(3).getPontos()));
			selecao4Sg.setText(Integer.toString(listaSelecao.get(3).getSaldoGols()));
		}
		grupos.setOnAction(e -> checkchoicebox(grupos));
		
	}
	 	@FXML
	    void btnVoltarAction(ActionEvent event) throws IOException {
		 TelaTabelaDeGrupos controller = new TelaTabelaDeGrupos(selecaoDao, fase);
		Main.trocaDeTela("/application/view/Partida/TelaTodasPartidas.fxml", controller, null);
	    }

	public void checkchoicebox(ChoiceBox<String> choicebox) {
		String grupoChoiceBox = choicebox.getValue();
		grupoTitle.setText(grupoChoiceBox);
		grupoLabel.setText(grupoChoiceBox);
		
		
		switch (grupoChoiceBox) {
		case "GRUPO A":
			if(FaseDeGrupos.grupos.get("A") != null) {
			List<Selecao> listaSelecao = FaseDeGrupos.grupos.get("A");
			selecao1.setText(listaSelecao.get(0).getNome());
			selecao1D.setText(listaSelecao.get(0).getDerrota());
			selecao1E.setText(listaSelecao.get(0).getEmpate());
			selecao1V.setText(listaSelecao.get(0).getVitoria());
			selecao1pts.setText(Integer.toString(listaSelecao.get(0).getPontos()));
			selecao1Sg.setText(Integer.toString(listaSelecao.get(0).getSaldoGols()));
			
			selecao2.setText(listaSelecao.get(1).getNome());
			selecao2D.setText(listaSelecao.get(1).getDerrota());
			selecao2E.setText(listaSelecao.get(1).getEmpate());
			selecao2V.setText(listaSelecao.get(1).getVitoria());
			selecao2pts.setText(Integer.toString(listaSelecao.get(1).getPontos()));
			selecao2Sg.setText(Integer.toString(listaSelecao.get(1).getSaldoGols()));
			
			selecao3.setText(listaSelecao.get(2).getNome());
			selecao3D.setText(listaSelecao.get(2).getDerrota());
			selecao3E.setText(listaSelecao.get(2).getEmpate());
			selecao3V.setText(listaSelecao.get(2).getVitoria());
			selecao3pts.setText(Integer.toString(listaSelecao.get(2).getPontos()));
			selecao3Sg.setText(Integer.toString(listaSelecao.get(2).getSaldoGols()));
			
			selecao4.setText(listaSelecao.get(3).getNome());
			selecao4D.setText(listaSelecao.get(3).getDerrota());
			selecao4E.setText(listaSelecao.get(3).getEmpate());
			selecao4V.setText(listaSelecao.get(3).getVitoria());
			selecao4pts.setText(Integer.toString(listaSelecao.get(3).getPontos()));
			selecao4Sg.setText(Integer.toString(listaSelecao.get(3).getSaldoGols()));
			}
			break;
			
		case "GRUPO B":
			if(FaseDeGrupos.grupos.get("B") != null) {
			List<Selecao> listaSelecao = FaseDeGrupos.grupos.get("B");
			selecao1.setText(listaSelecao.get(0).getNome());
			selecao1D.setText(listaSelecao.get(0).getDerrota());
			selecao1E.setText(listaSelecao.get(0).getEmpate());
			selecao1V.setText(listaSelecao.get(0).getVitoria());
			selecao1pts.setText(Integer.toString(listaSelecao.get(0).getPontos()));
			selecao1Sg.setText(Integer.toString(listaSelecao.get(0).getSaldoGols()));
			
			selecao2.setText(listaSelecao.get(1).getNome());
			selecao2D.setText(listaSelecao.get(1).getDerrota());
			selecao2E.setText(listaSelecao.get(1).getEmpate());
			selecao2V.setText(listaSelecao.get(1).getVitoria());
			selecao2pts.setText(Integer.toString(listaSelecao.get(1).getPontos()));
			selecao2Sg.setText(Integer.toString(listaSelecao.get(1).getSaldoGols()));
			
			selecao3.setText(listaSelecao.get(2).getNome());
			selecao3D.setText(listaSelecao.get(2).getDerrota());
			selecao3E.setText(listaSelecao.get(2).getEmpate());
			selecao3V.setText(listaSelecao.get(2).getVitoria());
			selecao3pts.setText(Integer.toString(listaSelecao.get(2).getPontos()));
			selecao3Sg.setText(Integer.toString(listaSelecao.get(2).getSaldoGols()));
			
			selecao4.setText(listaSelecao.get(3).getNome());
			selecao4D.setText(listaSelecao.get(3).getDerrota());
			selecao4E.setText(listaSelecao.get(3).getEmpate());
			selecao4V.setText(listaSelecao.get(3).getVitoria());
			selecao4pts.setText(Integer.toString(listaSelecao.get(3).getPontos()));
			selecao4Sg.setText(Integer.toString(listaSelecao.get(3).getSaldoGols()));
			}
			break;
			
		case "GRUPO C":
			if(FaseDeGrupos.grupos.get("C") != null) {
			List<Selecao> listaSelecao = FaseDeGrupos.grupos.get("C");
			selecao1.setText(listaSelecao.get(0).getNome());
			selecao1D.setText(listaSelecao.get(0).getDerrota());
			selecao1E.setText(listaSelecao.get(0).getEmpate());
			selecao1V.setText(listaSelecao.get(0).getVitoria());
			selecao1pts.setText(Integer.toString(listaSelecao.get(0).getPontos()));
			selecao1Sg.setText(Integer.toString(listaSelecao.get(0).getSaldoGols()));
			
			selecao2.setText(listaSelecao.get(1).getNome());
			selecao2D.setText(listaSelecao.get(1).getDerrota());
			selecao2E.setText(listaSelecao.get(1).getEmpate());
			selecao2V.setText(listaSelecao.get(1).getVitoria());
			selecao2pts.setText(Integer.toString(listaSelecao.get(1).getPontos()));
			selecao2Sg.setText(Integer.toString(listaSelecao.get(1).getSaldoGols()));
			
			selecao3.setText(listaSelecao.get(2).getNome());
			selecao3D.setText(listaSelecao.get(2).getDerrota());
			selecao3E.setText(listaSelecao.get(2).getEmpate());
			selecao3V.setText(listaSelecao.get(2).getVitoria());
			selecao3pts.setText(Integer.toString(listaSelecao.get(2).getPontos()));
			selecao3Sg.setText(Integer.toString(listaSelecao.get(2).getSaldoGols()));
			
			selecao4.setText(listaSelecao.get(3).getNome());
			selecao4D.setText(listaSelecao.get(3).getDerrota());
			selecao4E.setText(listaSelecao.get(3).getEmpate());
			selecao4V.setText(listaSelecao.get(3).getVitoria());
			selecao4pts.setText(Integer.toString(listaSelecao.get(3).getPontos()));
			selecao4Sg.setText(Integer.toString(listaSelecao.get(3).getSaldoGols()));
			}
			break;
			
		case "GRUPO D":
			if(FaseDeGrupos.grupos.get("D") != null) {
			List<Selecao> listaSelecao = FaseDeGrupos.grupos.get("D");
			selecao1.setText(listaSelecao.get(0).getNome());
			selecao1D.setText(listaSelecao.get(0).getDerrota());
			selecao1E.setText(listaSelecao.get(0).getEmpate());
			selecao1V.setText(listaSelecao.get(0).getVitoria());
			selecao1pts.setText(Integer.toString(listaSelecao.get(0).getPontos()));
			selecao1Sg.setText(Integer.toString(listaSelecao.get(0).getSaldoGols()));
			
			selecao2.setText(listaSelecao.get(1).getNome());
			selecao2D.setText(listaSelecao.get(1).getDerrota());
			selecao2E.setText(listaSelecao.get(1).getEmpate());
			selecao2V.setText(listaSelecao.get(1).getVitoria());
			selecao2pts.setText(Integer.toString(listaSelecao.get(1).getPontos()));
			selecao2Sg.setText(Integer.toString(listaSelecao.get(1).getSaldoGols()));
			
			selecao3.setText(listaSelecao.get(2).getNome());
			selecao3D.setText(listaSelecao.get(2).getDerrota());
			selecao3E.setText(listaSelecao.get(2).getEmpate());
			selecao3V.setText(listaSelecao.get(2).getVitoria());
			selecao3pts.setText(Integer.toString(listaSelecao.get(2).getPontos()));
			selecao3Sg.setText(Integer.toString(listaSelecao.get(2).getSaldoGols()));
			
			selecao4.setText(listaSelecao.get(3).getNome());
			selecao4D.setText(listaSelecao.get(3).getDerrota());
			selecao4E.setText(listaSelecao.get(3).getEmpate());
			selecao4V.setText(listaSelecao.get(3).getVitoria());
			selecao4pts.setText(Integer.toString(listaSelecao.get(3).getPontos()));
			selecao4Sg.setText(Integer.toString(listaSelecao.get(3).getSaldoGols()));
			}
			break;
			
		case "GRUPO E":
			if(FaseDeGrupos.grupos.get("E") != null) {
			List<Selecao> listaSelecao = FaseDeGrupos.grupos.get("E");
			selecao1.setText(listaSelecao.get(0).getNome());
			selecao1D.setText(listaSelecao.get(0).getDerrota());
			selecao1E.setText(listaSelecao.get(0).getEmpate());
			selecao1V.setText(listaSelecao.get(0).getVitoria());
			selecao1pts.setText(Integer.toString(listaSelecao.get(0).getPontos()));
			selecao1Sg.setText(Integer.toString(listaSelecao.get(0).getSaldoGols()));
			
			selecao2.setText(listaSelecao.get(1).getNome());
			selecao2D.setText(listaSelecao.get(1).getDerrota());
			selecao2E.setText(listaSelecao.get(1).getEmpate());
			selecao2V.setText(listaSelecao.get(1).getVitoria());
			selecao2pts.setText(Integer.toString(listaSelecao.get(1).getPontos()));
			selecao2Sg.setText(Integer.toString(listaSelecao.get(1).getSaldoGols()));
			
			selecao3.setText(listaSelecao.get(2).getNome());
			selecao3D.setText(listaSelecao.get(2).getDerrota());
			selecao3E.setText(listaSelecao.get(2).getEmpate());
			selecao3V.setText(listaSelecao.get(2).getVitoria());
			selecao3pts.setText(Integer.toString(listaSelecao.get(2).getPontos()));
			selecao3Sg.setText(Integer.toString(listaSelecao.get(2).getSaldoGols()));
			
			selecao4.setText(listaSelecao.get(3).getNome());
			selecao4D.setText(listaSelecao.get(3).getDerrota());
			selecao4E.setText(listaSelecao.get(3).getEmpate());
			selecao4V.setText(listaSelecao.get(3).getVitoria());
			selecao4pts.setText(Integer.toString(listaSelecao.get(3).getPontos()));
			selecao4Sg.setText(Integer.toString(listaSelecao.get(3).getSaldoGols()));
			}
			break;
			
		case "GRUPO F":
			if(FaseDeGrupos.grupos.get("F") != null) {
			List<Selecao> listaSelecao = FaseDeGrupos.grupos.get("F");
			selecao1.setText(listaSelecao.get(0).getNome());
			selecao1D.setText(listaSelecao.get(0).getDerrota());
			selecao1E.setText(listaSelecao.get(0).getEmpate());
			selecao1V.setText(listaSelecao.get(0).getVitoria());
			selecao1pts.setText(Integer.toString(listaSelecao.get(0).getPontos()));
			selecao1Sg.setText(Integer.toString(listaSelecao.get(0).getSaldoGols()));
			
			selecao2.setText(listaSelecao.get(1).getNome());
			selecao2D.setText(listaSelecao.get(1).getDerrota());
			selecao2E.setText(listaSelecao.get(1).getEmpate());
			selecao2V.setText(listaSelecao.get(1).getVitoria());
			selecao2pts.setText(Integer.toString(listaSelecao.get(1).getPontos()));
			selecao2Sg.setText(Integer.toString(listaSelecao.get(1).getSaldoGols()));
			
			selecao3.setText(listaSelecao.get(2).getNome());
			selecao3D.setText(listaSelecao.get(2).getDerrota());
			selecao3E.setText(listaSelecao.get(2).getEmpate());
			selecao3V.setText(listaSelecao.get(2).getVitoria());
			selecao3pts.setText(Integer.toString(listaSelecao.get(2).getPontos()));
			selecao3Sg.setText(Integer.toString(listaSelecao.get(2).getSaldoGols()));
			
			selecao4.setText(listaSelecao.get(3).getNome());
			selecao4D.setText(listaSelecao.get(3).getDerrota());
			selecao4E.setText(listaSelecao.get(3).getEmpate());
			selecao4V.setText(listaSelecao.get(3).getVitoria());
			selecao4pts.setText(Integer.toString(listaSelecao.get(3).getPontos()));
			selecao4Sg.setText(Integer.toString(listaSelecao.get(3).getSaldoGols()));
			}
			break;
			
		case "GRUPO G":
			if(FaseDeGrupos.grupos.get("G") != null) {
			List<Selecao> listaSelecao = FaseDeGrupos.grupos.get("G");
			selecao1.setText(listaSelecao.get(0).getNome());
			selecao1D.setText(listaSelecao.get(0).getDerrota());
			selecao1E.setText(listaSelecao.get(0).getEmpate());
			selecao1V.setText(listaSelecao.get(0).getVitoria());
			selecao1pts.setText(Integer.toString(listaSelecao.get(0).getPontos()));
			selecao1Sg.setText(Integer.toString(listaSelecao.get(0).getSaldoGols()));
			
			selecao2.setText(listaSelecao.get(1).getNome());
			selecao2D.setText(listaSelecao.get(1).getDerrota());
			selecao2E.setText(listaSelecao.get(1).getEmpate());
			selecao2V.setText(listaSelecao.get(1).getVitoria());
			selecao2pts.setText(Integer.toString(listaSelecao.get(1).getPontos()));
			selecao2Sg.setText(Integer.toString(listaSelecao.get(1).getSaldoGols()));
			
			selecao3.setText(listaSelecao.get(2).getNome());
			selecao3D.setText(listaSelecao.get(2).getDerrota());
			selecao3E.setText(listaSelecao.get(2).getEmpate());
			selecao3V.setText(listaSelecao.get(2).getVitoria());
			selecao3pts.setText(Integer.toString(listaSelecao.get(2).getPontos()));
			selecao3Sg.setText(Integer.toString(listaSelecao.get(2).getSaldoGols()));
			
			selecao4.setText(listaSelecao.get(3).getNome());
			selecao4D.setText(listaSelecao.get(3).getDerrota());
			selecao4E.setText(listaSelecao.get(3).getEmpate());
			selecao4V.setText(listaSelecao.get(3).getVitoria());
			selecao4pts.setText(Integer.toString(listaSelecao.get(3).getPontos()));
			selecao4Sg.setText(Integer.toString(listaSelecao.get(3).getSaldoGols()));
			}
			break;
			
		case "GRUPO H":
			if(FaseDeGrupos.grupos.get("H") != null) {
			List<Selecao> listaSelecao = FaseDeGrupos.grupos.get("H");
			selecao1.setText(listaSelecao.get(0).getNome());
			selecao1D.setText(listaSelecao.get(0).getDerrota());
			selecao1E.setText(listaSelecao.get(0).getEmpate());
			selecao1V.setText(listaSelecao.get(0).getVitoria());
			selecao1pts.setText(Integer.toString(listaSelecao.get(0).getPontos()));
			selecao1Sg.setText(Integer.toString(listaSelecao.get(0).getSaldoGols()));
			
			selecao2.setText(listaSelecao.get(1).getNome());
			selecao2D.setText(listaSelecao.get(1).getDerrota());
			selecao2E.setText(listaSelecao.get(1).getEmpate());
			selecao2V.setText(listaSelecao.get(1).getVitoria());
			selecao2pts.setText(Integer.toString(listaSelecao.get(1).getPontos()));
			selecao2Sg.setText(Integer.toString(listaSelecao.get(1).getSaldoGols()));
			
			selecao3.setText(listaSelecao.get(2).getNome());
			selecao3D.setText(listaSelecao.get(2).getDerrota());
			selecao3E.setText(listaSelecao.get(2).getEmpate());
			selecao3V.setText(listaSelecao.get(2).getVitoria());
			selecao3pts.setText(Integer.toString(listaSelecao.get(2).getPontos()));
			selecao3Sg.setText(Integer.toString(listaSelecao.get(2).getSaldoGols()));
			
			selecao4.setText(listaSelecao.get(3).getNome());
			selecao4D.setText(listaSelecao.get(3).getDerrota());
			selecao4E.setText(listaSelecao.get(3).getEmpate());
			selecao4V.setText(listaSelecao.get(3).getVitoria());
			selecao4pts.setText(Integer.toString(listaSelecao.get(3).getPontos()));
			selecao4Sg.setText(Integer.toString(listaSelecao.get(3).getSaldoGols()));
			}
			break;
		default:
			
			break;
		}
	}
}

