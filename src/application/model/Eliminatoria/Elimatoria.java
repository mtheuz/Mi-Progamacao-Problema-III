package application.model.Eliminatoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import application.model.PartidaPackage.Partida;
import application.model.PartidaPackage.PartidaDaoImpl;
import application.model.SelecaoPackage.Selecao;

public class Elimatoria{
	
	private Map<String,List<Selecao>> grupos;
	private List<Partida> oitavas;
	private List<Partida> quartas;
	private List<Partida> semiFinal;
	private Partida terceiroLugar;
	private Partida Final;
	
	public Elimatoria(ArrayList<Selecao> selecoes, Map<String,List<Selecao>> grupos) {
		this.grupos = grupos;
		this.oitavas = new ArrayList<Partida>();
	}
	public boolean verificaPartidas(List<Partida> disputas) {
		for (int i = 0; i < disputas.size(); i++) {
			if(disputas.get(i).isSituacao() == false) {
				return false;
			}
		}
		return true;
	}
	public boolean OitavasDeFinal() {
		String[] grupos = {"A","B","C","D","E","F","G","H"};
		for (int i = 0; i < (grupos.length-1); i+=2) {
			if(this.grupos.size() > 0){
				String selecao1 = this.grupos.get(grupos[i]).get(0).getNome();
				String selecao2 = this.grupos.get(grupos[i+1]).get(1).getNome();

				String selecao3 = this.grupos.get(grupos[i]).get(1).getNome();
				String selecao4 = this.grupos.get(grupos[i+1]).get(0).getNome();

				Partida partida1 = new Partida(selecao1,selecao2);
				Partida partida2 = new Partida(selecao3,selecao4);
				oitavas.add(partida1);
				oitavas.add(partida2);
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	
	public boolean Quartas(){
		if(verificaPartidas(this.oitavas)) {
			for (int i = 0; i < (this.oitavas.size()-1); i+=2) {
				String selecao1 = this.oitavas.get(i).getVencedor();
				String selecao2 = this.oitavas.get(i+1).getVencedor();
				Partida partida = new Partida(selecao1,selecao2);
				this.quartas.add(partida);
				}
			}else {
				return false;
			}
		return true;
		}
	
	public boolean SemiFinal(){
		if(verificaPartidas(this.quartas) && verificaPartidas(this.oitavas)) {
			for (int i = 0; i < (this.quartas.size()-1); i+=2) {
				String selecao1 = this.quartas.get(i).getVencedor();
				String selecao2 = this.quartas.get(i+1).getVencedor();
				Partida partida = new Partida(selecao1,selecao2);
				this.semiFinal.add(partida);
			}
		}
		else {
			return false;
		}
		return true;
	}
	public boolean Final() {
		if(verificaPartidas(this.semiFinal) && verificaPartidas(this.quartas) && verificaPartidas(this.oitavas)) {
			String selecao1 = this.semiFinal.get(0).getVencedor();
			String selecao2 = this.semiFinal.get(1).getVencedor();
			String selecaoperdodora1 = this.semiFinal.get(0).getPerdedor();
			String selecaoperdodora2 = this.semiFinal.get(1).getPerdedor();
			Partida Final = new Partida(selecao1,selecao2);
			Partida terceiroLugar = new Partida(selecaoperdodora1,selecaoperdodora2);

			this.Final = Final;
			this.terceiroLugar = terceiroLugar;
		}else {
			return false;
		}
		return true;
	}
}
