package application.model.PartidaPackage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import application.model.JogadorPackage.JogadorDaoImpl;
import application.model.SelecaoPackage.Selecao;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import application.model.TratamentoDeExcecoesPackage.TratamentosExcecoes;

public class PartidaDaoImpl implements PartidaDAO{
	protected SelecaoDaoImpl selecao = new SelecaoDaoImpl();
	TratamentosExcecoes tratamento = new TratamentosExcecoes();
	
	protected static Map<String,List<Partida>> partidas = new HashMap<String,List<Partida>>();
	
	public static String[] estadios = {"Al Bayt", "Khalifa International", "Al Thumama", "Ahmad Bin Ali",
			"Lusail", "Ras Abu Aboud (974)", "Education City", "Al Janoub"};
	
	public String[] getEstadios() {
		return estadios;
	}
	public Map<String,List<Partida>> getPartidas() {
		return partidas; 
	}
	public PartidaDaoImpl(ArrayList<Selecao> selecoes){
		selecao.setListaSelecoes(selecoes);  
	}
	
	private JogadorDaoImpl jogadores = new JogadorDaoImpl(selecao.getListaSelecoes());

	public boolean inputGolsSelecao1(Partida partida, String gols, String codigo) {
		JogadorDaoImpl jogadores = new JogadorDaoImpl(selecao.getListaSelecoes());
		if(jogadores.verificaExistencia(codigo)) {
			List<String> gols1 = new ArrayList<String>();
			gols1.add(codigo);
			gols1.add(gols);
			jogadores.atualizarGolsMarcados(codigo, partida.getSelecao1(), gols);
			partida.setGolsSelecao1(gols1);
			return true;
		}else {
			System.err.println("Jogador nao Cadastrado");
			return false;
		}
	}
	public boolean inputGolsSelecao2(Partida partida, String gols, String codigo) {
		JogadorDaoImpl jogadores = new JogadorDaoImpl(selecao.getListaSelecoes());
		if(jogadores.verificaExistencia(codigo)) {
			List<String> gols2 = new ArrayList<String>();
			gols2.add(codigo);
			gols2.add(gols);
			jogadores.atualizarGolsMarcados(codigo, partida.getSelecao2(), gols);
			partida.setGolsSelecao2(gols2);
			return true;

		}else {
			System.err.println("Jogador nao Cadastrado");
			return false;
		}
	}
	
	public boolean inputCartosAmarelosSelecao1(Partida partida, String cartaoAmarelo, String codigo) {
		JogadorDaoImpl jogadores = new JogadorDaoImpl(selecao.getListaSelecoes());
		List<String> cartoesAmarelos = new ArrayList<String>();
		if( Integer.parseInt(cartaoAmarelo) <= 2) {
		cartoesAmarelos.add(codigo);
		cartoesAmarelos.add(cartaoAmarelo);
		if(jogadores.verificaExistencia(codigo)) {
			jogadores.atulizarCartoesAmarelos(codigo, partida.getSelecao1(), cartaoAmarelo);
			partida.setCartoesAmarelosSelecao1(cartoesAmarelos);
			return true;
		}
		else {
			return false;
		}
		}
		return false;

	}
	public boolean inputCartosVermelhoSelecao1(Partida partida, String codigo) {
		JogadorDaoImpl jogadores = new JogadorDaoImpl(selecao.getListaSelecoes());
		List<String> cartoesVermelhos = new ArrayList<String>();
		cartoesVermelhos.add(codigo);
		cartoesVermelhos.add("1");
		if(jogadores.verificaExistencia(codigo)) {
			jogadores.atualizarCartoesVermelhos(codigo, partida.getSelecao1(), "1");
			partida.setCartoesVermelhosSelecao1(cartoesVermelhos);
			return true;
		}
		else {
			return false;
		}

	}
	
	public boolean inputCartosAmarelosSelecao2(Partida partida, String cartaoAmarelo, String codigo) {
		JogadorDaoImpl jogadores = new JogadorDaoImpl(selecao.getListaSelecoes());
		List<String> cartoesAmarelos = new ArrayList<String>();
		if( Integer.parseInt(cartaoAmarelo) <= 2) {
		cartoesAmarelos.add(codigo);
		cartoesAmarelos.add(cartaoAmarelo);
		if(jogadores.verificaExistencia(codigo)) {
			jogadores.atulizarCartoesAmarelos(codigo, partida.getSelecao2(), cartaoAmarelo);
			partida.setCartoesAmarelosSelecao2(cartoesAmarelos);
			return true;
		}
		else {
			return false;
		}
	}
		return false;

	}

	public boolean inputCartosVermelhoSelecao2(Partida partida, String codigo) {
		JogadorDaoImpl jogadores = new JogadorDaoImpl(selecao.getListaSelecoes());
		List<String> cartoesVermelhos = new ArrayList<String>();
		cartoesVermelhos.add(codigo);
		cartoesVermelhos.add("1");
		if(jogadores.verificaExistencia(codigo)) {
			jogadores.atualizarCartoesVermelhos(codigo, partida.getSelecao2(), "1");
			partida.setCartoesVermelhosSelecao2(cartoesVermelhos);
			return true;
		}
		else {
			return false;
		}

	}

	public void listarLocal() {
		System.out.println("[Digite o local da partida]");
		for (int i = 0; i < estadios.length; i++) {
			System.out.printf("[%d]%s\n",i,estadios[i]);
		}
	}
	
	@Override
	public boolean inserir(String dia, String mes, String ano, String hora, String minuto, String local, Partida partida) {
		if(verificaCadastroCompleto(partida.getSelecao1()) && verificaCadastroCompleto(partida.getSelecao2()))
		{	
			String data = dia + "/" + mes + "/" + ano;
			String horap = hora + ":" + minuto;
			partida.setData(data);
			partida.setHorario(horap);
			partida.setLocal(local);
			partida.setSituacao(true);
			return true;
		}
		else {
			return false;
			}
		}


	protected boolean verificaCadastroCompleto(String nome) {
		ArrayList<Selecao> listaSelecoes = selecao.getListaSelecoes();
		for(Selecao selecao : listaSelecoes)
		{
			if(selecao.getNome().equals(nome))
			{
				if(selecao.getListaJogadores().size()>0)
					return true;
				else
					return false;
			}
		}
		return false;
	}

	
	public static boolean deletar(Partida partida) {
		if(partida != null) {
			partida.setPlacarSelecao1("X");
			partida.setPlacarSelecao2("X");
			partida.setData("");
			partida.setData("");
			partida.setHorario("");
			partida.setLocal("");
			partida.setSituacao(false);
			PartidaDaoImpl.resetaListasPartida(partida.getCartoesAmarelosSelecao1());
			PartidaDaoImpl.resetaListasPartida(partida.getCartoesAmarelosSelecao2());
			PartidaDaoImpl.resetaListasPartida(partida.getCartoesVermelhosSelecao1());
			PartidaDaoImpl.resetaListasPartida(partida.getCartoesVermelhosSelecao2());
			PartidaDaoImpl.resetaListasPartida(partida.getGolsSelecao1());
			PartidaDaoImpl.resetaListasPartida(partida.getGolsSelecao2());
			return true;
		}
		return false;
	}
	
	public String geraid() throws InterruptedException {
		LocalDateTime dataagr = LocalDateTime.now();
		Thread.sleep(10);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyHHmmnn");
		String coddate = dataagr.format(formato);
		return coddate;
	}
	
	
	public int somaConteudo(List<List<String>> listaGols) {
		int gols = 0;
		if(!listaGols.isEmpty()) {
			for(List<String> jogador: listaGols) {
				gols += Integer.parseInt(jogador.get(1));
			}
			return gols;
		}
		return 0;
	}

		

	private static void resetaListasPartida(List<List<String>> lista) {
		for(List<String> jogador: lista) {
			jogador.set(1, "0");
		}
	}

	public static Partida findPartida(String codigo) {
		Partida dPartida = null;
		for (Map.Entry<String, List<Partida>> partida : partidas.entrySet()) {
			for (int i = 0; i < partida.getValue().size(); i++) {
				if(partida.getValue().get(i).getCodigo().equals(codigo)) {
					dPartida = partida.getValue().get(i);
					;
				}
			}
		}
		return dPartida;
	}
	
	public void atualizarData(Partida partida, String dia, String mes, String ano) {
		partida.setData(dia + "/" + mes + "/" + ano);
	}

	public void atualizarHora(Partida partida, String hora, String minuto) {
		partida.setHorario(hora + ":" + minuto);
	}

	public void atualizarLocal(Partida partida, int local) {
		partida.setLocal(estadios[local]);
	}

	public boolean adicionarCartaoAmarelo(int cartao, List<String> jogador) {
		int valorCartao = Integer.parseInt(jogador.get(1));
		if(valorCartao < 2 && (cartao <= 2 && cartao >0)) {
			int soma = cartao + valorCartao;
			String conversao = Integer.toString(soma);
			jogador.set(1, conversao);
			return true;
		}else {
			System.err.println("Nao e possivel adicionar mais cartao, limite por partida atingido");
			return false;
		}
	}

	public boolean retirarCartaoAmarelo(int cartao, List<String> jogador) {
		int valorCartao = Integer.parseInt(jogador.get(1));
		if(valorCartao > 0 && (cartao <= valorCartao) && valorCartao >= cartao) {
			int soma = valorCartao - cartao;
			String conversao = Integer.toString(soma);
			jogador.set(1, conversao);
			return true;
		}else {
			System.err.println("Nao e possivel adicionar mais cartao, limite por partida atingido");
			return false;
		}
	}

	public boolean adicionarCartaoVemelho( List<String> jogador) {
		int valorCartao = Integer.parseInt(jogador.get(1));
		if(valorCartao == 0) {
			jogador.set(1, "1");
			return true;
		}else {
			System.err.println("Nao e possivel adicionar mais carteo, limite por partida atingido");
			return false;
		}
	}

	public boolean retirarCartaoVemelho( List<String> jogador) {
		int valorCartao = Integer.parseInt(jogador.get(1));
		if(valorCartao == 1) {
			jogador.set(1, "0");
			return true;

		}else {
			System.err.println("Nao e possivel retirar cartao!");
			return false;
		}

	}
	
	public boolean adicionarGols(int gol,List<String> jogador) {
		int valorGol = Integer.parseInt(jogador.get(1));
		int soma = gol + valorGol;
		String conversao = Integer.toString(soma);
		jogador.set(1, conversao);
		return true;
	}
	
	public boolean retirarGols(int gol,List<String> jogador) {
		int valorGol = Integer.parseInt(jogador.get(1));
		if(valorGol > 0 && (gol <= valorGol)) {
			int soma = valorGol - gol;
			String conversao = Integer.toString(soma);
			jogador.set(1, conversao);
			return true;
			}else {
				System.err.println("Nao e possivel retirar gols");
				return false;
			}
	}
	@Override
	public void listarPartida(String grupo) {
		// TODO Auto-generated method stub
		
	}
}


