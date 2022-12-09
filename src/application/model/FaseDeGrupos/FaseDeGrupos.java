package application.model.FaseDeGrupos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.model.PartidaPackage.Partida;
import application.model.PartidaPackage.PartidaDaoImpl;
import application.model.SelecaoPackage.Selecao;
import application.model.SelecaoPackage.SelecaoDaoImpl;

public class FaseDeGrupos extends PartidaDaoImpl{
	SelecaoDaoImpl selecao = new SelecaoDaoImpl();
	PartidaDaoImpl partida = new PartidaDaoImpl(selecao.getListaSelecoes());
	public FaseDeGrupos(ArrayList<Selecao> selecoes) {
		super(selecoes);
		selecao.setListaSelecoes(selecoes);
	}
	public static  Map<String,List<Partida>> partidas = new HashMap<String,List<Partida>>();
	public static  Map<String,List<Selecao>> grupos = new HashMap<String,List<Selecao>>();
	

	
	private List<String> organizaGrupo(String grupo){
		
		List<String> grupoSelecao = new ArrayList<>();
		for(Selecao selecao: SelecaoDaoImpl.listaSelecoes) {
			if(selecao.getGrupo().equals(grupo)) {
				grupoSelecao.add(selecao.getNome());
			}
		}
		return grupoSelecao;
	}
	
	public void geraPartidas() throws InterruptedException {
		String[] grupos = {"A","B","C","D","E","F","G","H"};
		for (int i = 0; i < grupos.length; i++) {
			List<String> grupoSelecao = organizaGrupo(grupos[i]);
			List<Partida> partidaGrupo= new ArrayList<Partida>();
			if(grupoSelecao.isEmpty() || grupoSelecao.size()<=4) {
				for(int c = 0; c < grupoSelecao.size(); c++) {
					for(int j = c+1; j < (grupoSelecao.size()); j++) {
						String selecao1 = grupoSelecao.get(c);
						String selecao2 = grupoSelecao.get(j);
						Partida jogo = new Partida(selecao1,selecao2);
						jogo.setCodigo(this.partida.geraid());
						partidaGrupo.add(jogo);
						this.partidas.put(grupos[i], partidaGrupo);
					}
				}
			}
		}
	}
	public boolean verificaPartidas(String grupo) {
		String[] grupos = {"A","B","C","D","E","F","G","H"};
		for (int i = 0; i < grupos.length; i++) {
			List<Partida> jogo = partidas.get(grupo);
			int controle = 0;
			for (int j = 0; j < jogo.size(); j++) {
				if(jogo.get(j).isSituacao()) {
					controle = 1;
				}
			}
			if(controle == 0) {
				return false;
			}
		}
		return true;
	}
	
	public boolean formaGrupo() {
		String[] grupos = {"A","B","C","D","E","F","G","H"};
		for (int i = 0; i < grupos.length; i++) {
			List<Selecao> grupoSelecao = new ArrayList<>();
			if(selecao.getListaSelecoes().size() > 0) {
				for(Selecao selecao: selecao.getListaSelecoes()) {
					if(selecao.getGrupo().equals(grupos[i])) {
						grupoSelecao.add(selecao);
					}
				}
				this.grupos.put(grupos[i], grupoSelecao);
			}
			else {
				return false;
			}

		}
		return true;
	}

	
	public boolean imprimeGrupos(){

		System.out.println("[Lista de Grupos]");
		String[] grupos = {"A","B","C","D","E","F","G","H"};
		if(!selecao.getListaSelecoes().isEmpty()) {
			for (int i = 0; i < grupos.length; i++) {
				System.out.printf("[%d] Grupo %s\n",i,grupos[i]);
				for(Selecao selecao: selecao.getListaSelecoes()) {
					if(selecao.getGrupo().equals(grupos[i])) {
						System.out.printf("-%s\n",selecao.getNome());
					}

				}
				System.out.println("-------------");
			}
			System.out.println("");
			return true;
		}
		return false;
	}
	
	public boolean pontuacao(Partida partida) {
		int IndiceSelecao1 = selecao.buscaSelecao(partida.getSelecao1());
		int IndiceSelecao2 = selecao.buscaSelecao(partida.getSelecao2());
		if((IndiceSelecao1 != -1) && (IndiceSelecao2 != -1)){
			final Selecao selecao2 = selecao.getListaSelecoes().get(IndiceSelecao2);
			final Selecao selecao1 = selecao.getListaSelecoes().get(IndiceSelecao1);
			
			int golsSelecao1 = this.partida.somaConteudo(partida.getGolsSelecao1());
			int cartoesVermelhosSelecao1 = this.partida.somaConteudo(partida.getCartoesVermelhosSelecao1());
			int cartoesAmarelosSelecao1 = this.partida.somaConteudo(partida.getCartoesAmarelosSelecao1());

			selecao1.setGolsMarcados(golsSelecao1);
			selecao1.setQuantidadeCartoesAmarelos(cartoesAmarelosSelecao1);
			selecao1.setQuantidadeCartoesVermelhos(cartoesVermelhosSelecao1);

			int golsSelecao2 = this.partida.somaConteudo(partida.getGolsSelecao2());
			int cartoesVermelhosSelecao2 = this.partida.somaConteudo(partida.getCartoesVermelhosSelecao2());
			int cartoesAmarelosSelecao2 = this.partida.somaConteudo(partida.getCartoesAmarelosSelecao2());

			selecao2.setGolsMarcados(golsSelecao2);
			selecao2.setQuantidadeCartoesAmarelos(cartoesAmarelosSelecao2);
			selecao2.setQuantidadeCartoesVermelhos(cartoesVermelhosSelecao2);
			selecao1.setGolsSofridos(golsSelecao2);
			selecao2.setGolsSofridos(golsSelecao1);

			List<Selecao> selecaoGrupo= grupos.get(selecao1.getGrupo());
			if(golsSelecao1 > golsSelecao2) {
				selecao1.setVitoria("1");
				selecao1.setPontos(3);
				selecao2.setDerrota("1");
				Collections.sort(selecaoGrupo);
			}

			else if(golsSelecao2 > golsSelecao1){
				selecao2.setVitoria("1");
				selecao2.setPontos(3);
				selecao1.setDerrota("1");
				Collections.sort(selecaoGrupo);
			}

			else if(golsSelecao2 == golsSelecao1){
				selecao2.setPontos(1);
				selecao1.setPontos(1);
				selecao1.setEmpate("1");
				selecao2.setEmpate("1");
				Collections.sort(selecaoGrupo);
			}
			return true;
		}
		return false;
	}
}
