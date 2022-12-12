package application.model.Eliminatoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import application.model.PartidaPackage.Partida;
import application.model.PartidaPackage.PartidaDaoImpl;
import application.model.SelecaoPackage.Selecao;
import application.model.SelecaoPackage.SelecaoDaoImpl;

public class Eliminatoria{
	
	static SelecaoDaoImpl selecaoDao = new SelecaoDaoImpl();
	private static Map<String,List<Selecao>> grupos;
	public static Map<String, List<Selecao>> getGrupos() {
		return grupos;
	}
	public static void setGrupos(Map<String, List<Selecao>> grupos) {
		Eliminatoria.grupos = grupos;
	}
	public static List<Partida> oitavas;
	public static List<Partida> quartas;
	public static List<Partida> semiFinal;
	public static Partida terceiroLugar;
	public static Partida Final;
	
	public Eliminatoria(ArrayList<Selecao> selecoes, Map<String,List<Selecao>> grupos) {
		Eliminatoria.grupos = grupos;
		Eliminatoria.oitavas = new ArrayList<Partida>();
		Eliminatoria.quartas = new ArrayList<Partida>();
		Eliminatoria.semiFinal = new ArrayList<Partida>();
		
	}
	public static boolean verificaPartidas(List<Partida> disputas) {
		if(disputas != null && disputas.size() != 0) {
		for (int i = 0; i < disputas.size(); i++) {
			if(disputas.get(i).isSituacao() == false) {
				return false;
			}
		}
		}else {
			return false;
		}
		return true;
	}


	public static void tranforsmaEmEliminatoria(List<Partida> disputas) {
		if(disputas != null) {
			for (int i = 0; i < disputas.size(); i++) {
				disputas.get(i).setEliminatoria(true);;
			}
		}
	}
	public static boolean OitavasDeFinal(Map<String,List<Selecao>> gruposSelecoes) {
		String[] grupos = {"A","B","C","D","E","F","G","H"};
		for (int i = 0; i < (grupos.length-1); i+=2) {
			if(Eliminatoria.grupos.size() > 0){
				String selecao1 = gruposSelecoes.get(grupos[i]).get(0).getNome();
				String selecao2 = gruposSelecoes.get(grupos[i+1]).get(1).getNome();

				String selecao3 = gruposSelecoes.get(grupos[i]).get(1).getNome();
				String selecao4 = gruposSelecoes.get(grupos[i+1]).get(0).getNome();

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
	
	
	public static boolean Quartas(){
		if(verificaPartidas(Eliminatoria.oitavas)) {
			for (int i = 0; i < (Eliminatoria.oitavas.size()); i+= 4) {
				String selecao1 = Eliminatoria.oitavas.get(i).getVencedor();
				String selecao2 = Eliminatoria.oitavas.get(i+2).getVencedor();
				
				String selecao3 = Eliminatoria.oitavas.get(i+1).getVencedor();
				String selecao4 = Eliminatoria.oitavas.get(i+3).getVencedor();
				Partida partida = new Partida(selecao1,selecao2);
				Partida partida2 = new Partida(selecao3,selecao4);
				Eliminatoria.quartas.add(partida);
				Eliminatoria.quartas.add(partida2);
				}
			}else {
				return false;
			}
		return true;
		}
	
	public static boolean SemiFinal(){
		if(verificaPartidas(Eliminatoria.quartas)) {
			for (int i = 0; i < (Eliminatoria.quartas.size()-1); i+=2) {
				String selecao1 = Eliminatoria.quartas.get(i).getVencedor();
				String selecao2 = Eliminatoria.quartas.get(i+1).getVencedor();
				Partida partida = new Partida(selecao1,selecao2);
				Eliminatoria.semiFinal.add(partida);
			}
		}
		else {
			return false;
		}
		return true;
	}
	public static boolean Final() {
		if(verificaPartidas(Eliminatoria.semiFinal)) {
			String selecao1 = Eliminatoria.semiFinal.get(0).getVencedor();
			String selecao2 = Eliminatoria.semiFinal.get(1).getVencedor();
			Partida Final = new Partida(selecao1,selecao2);
			Eliminatoria.Final = Final;
		}else {
			return false;
		}
		return true;
	}
	public static boolean TerceiroLugar() {
		if(verificaPartidas(Eliminatoria.semiFinal)) {
			String selecaoperdodora1 = Eliminatoria.semiFinal.get(0).getPerdedor();
			String selecaoperdodora2 = Eliminatoria.semiFinal.get(1).getPerdedor();
			Partida terceiroLugar = new Partida(selecaoperdodora1,selecaoperdodora2);
			Eliminatoria.terceiroLugar = terceiroLugar;
		}else {
			return false;
		}
		return true;
	}
}
