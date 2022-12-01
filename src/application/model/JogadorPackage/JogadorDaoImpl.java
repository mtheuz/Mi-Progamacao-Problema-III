package application.model.JogadorPackage;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import application.model.SelecaoPackage.Selecao;
import application.model.SelecaoPackage.SelecaoDaoImpl;
import application.model.TratamentoDeExcecoesPackage.TratamentosExcecoes;

/**
 *  A classe <b> JogadorDaoImpl </b> é responsável pelo CRUD de objetos da classe Árbitro
 * @author Mailson
 *	@since 2022
 */
public class JogadorDaoImpl implements JogadorDAO{
	SelecaoDaoImpl selecao = new SelecaoDaoImpl();
	private String[] posicoes = {"Goleiro", "Zagueiro","Lateral", "Volante", "Meio-Campo", "Atacante"};
	/**
	 * Construtor padrão da classe <b> JogadorDaoImpl </b>
	 * @param selecoes
	 */
	public JogadorDaoImpl(ArrayList<Selecao> selecoes) {
		
		selecao.setListaSelecoes(selecoes);
	
	}
	
@Override	

public void cadastrarUmJogador() 
	{
	TratamentosExcecoes tratamento = new TratamentosExcecoes();
	Scanner entrada = new Scanner(System.in);
	System.out.println("Em qual selecao deseja cadastrar um novo jogador?");
	selecao.listarSelecao();
	System.out.println("Digite o indice referente a selecao que deseja cadastrar um novo jogador");
	int escolha = tratamento.validaInt(0,selecao.getListaSelecoes().size());
	ArrayList<Selecao> listaSelecoes = selecao.getListaSelecoes();
	Selecao selecao = listaSelecoes.get(escolha);
	if(selecao.getListaJogadores().size()<26)
	{
		System.out.printf("Cadastro de novo jogador na selecao %s\n", selecao.getNome());
		System.out.println("Digite o nome do Jogador: ");
		String nome = tratamento.EntradaString();
		
		listarPosicoes();
		int indicePosicao = tratamento.validaInt(0,6);
		String posicao = posicoes[indicePosicao];
		//cria o objeto jogador
		Jogador novoJogador = new Jogador(nome);
		novoJogador.setPosicao(posicao);
		try {
			novoJogador.setCode(geraid(novoJogador));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		inserirJogador(novoJogador,selecao.getNome()); 
		
	}
	else
	{
		System.out.println("A lista de jogadores desta selecao ja esta completa!");
	}
	
	}
	
	
	/**
	 * O método cadastrar é responsável por cadastrar a quantidade desejada de jogadores em uma Seleção no sistema
	 */
	public void cadastrar(String nomeJoagador,String nomeDaSelecao) {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		Scanner entrada = new Scanner(System.in);

		//boolean listar = selecao.listarSelecao();
		String selecaoInput = "";
		int quantidadeJogadores = 0;
	
		if(selecao.getListaSelecoes().size()> 0) {
		selecao.listarSelecao();
		System.out.println("Digite o indice da Selecao que deseja inserir o jogador");
		int selecaobusca = tratamento.validaInt(0, 26);
		selecaoInput = nomeDaSelecao;
		System.out.println("Digite a quantidade de jogadores que deseja cadastrar");
		quantidadeJogadores = entrada.nextInt();
		}
		//verifica se já existe selecao escolhida
		if(nomeDaSelecao != null) {
		if(!selecao.ComparaSelecao(selecaoInput)) { 
				
				System.out.println("Digite o nome do Jogador: ");
				String nome = nomeJoagador;
				
				listarPosicoes();
				int indicePosicao = tratamento.validaInt(0,6);
				String posicao = posicoes[indicePosicao];
				
				//cria o objeto jogador
				Jogador novoJogador = new Jogador(nome);
				novoJogador.setPosicao(posicao);
				inserirJogador(novoJogador,selecaoInput); 
				
		}
		}
		else {
			System.out.println("Ainda nao foram cadastradas Selecoes no sistema");
		}
	}
	

	/**
	 * O método inserirJogador é responsável por inserir o Jogador na lista de jogadores
	 */
	
	public void inserirJogadorJson(String nomeJoagador,String nomeDaSelecao) {
		Jogador novoJogador = new Jogador(nomeJoagador); 
		inserirJogador(novoJogador,nomeDaSelecao);
	}

	public void cadastrarNaselecao(String nomeSelecao) {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite a quantidade de jogadores que deseja cadastrar");
		int quantidadeJogadores = tratamento.validaInt();
		if(quantidadeJogadores<=26)
		{
			//verifica se já existe selecao escolhida
				for (int i = 0; i < quantidadeJogadores; i++) {
					System.out.println("==== Cadastro de Jogador ====");
					System.out.println("Digite o nome do Jogador: ");
					String nome = tratamento.EntradaString();
					
					listarPosicoes();
					int indicePosicao = tratamento.validaInt(0,6);
					String posicao = posicoes[indicePosicao];
					
					//cria o objeto jogador
					Jogador novoJogador = new Jogador(nome); 
					novoJogador.setPosicao(posicao);
					//insere na lista de jogadores na seleçao
					inserirJogador(novoJogador,nomeSelecao); 
				}
	}
		else
		System.out.println("Quantidade superior ao permitido para uma selecao na copa (22 jogadores)");
	}
	//Insere o Jogador na lista de jogadores 

	@Override
	public boolean inserirJogador(Jogador jogador, String nomeSelecao) {
		final int numeroTotalDeJogadores = 26;
		int selecaoBusca = selecao.buscaSelecao(nomeSelecao);


		//verifica se a lista de jogadores já está cheiajogadores 
		if(selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores().size() < numeroTotalDeJogadores) {
			//Verifica se o jogador já foi cadastrado
			if(comparaJogador(jogador,nomeSelecao))
				System.out.println("Esse jogador já foi cadastrado");
			else {
				try {
					jogador.setCode(geraid(jogador));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores().add(jogador);
				//System.out.println("Jogador inserido na base de dados seu codigo e "+ jogador.getCode());
				return true;
			}
		}else
			return false;
		
		 return false;
		
	}
		
		
		
	
	
	/**
	 * O método deletarJogador é responsável por excluir o jogador da lista de jogadores
	 */
	@Override
	public boolean deletarJogador(String codigo,String selecaoBusca) {
		int index = buscarJogador(codigo);
		int Busca = selecao.buscaSelecao(selecaoBusca);
		if(Busca != -1) {
			if(index !=1) {
			selecao.getListaSelecoes().get(Busca).getListaJogadores().remove(index);
			System.out.println("Jogador deletado com sucesso!\n");
			return true;
			}
		}
			System.out.println("Esse jogador ainda nao foi cadastrado!\n");
			return false; 
		
	}

	/**
	 * O método atualizarDadosJogador é responsável por editar um jogador da lista de jogadores
	 */


	
	
	public boolean atualizarNome(String codigo, String nomeSelecao, String alteracao) {
		int index = buscarJogador(codigo); 
		int selecaoBusca = selecao.buscaSelecao(nomeSelecao);
		final List<Jogador> listaJogadores = selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores();
		listaJogadores.get(index).setNome(alteracao);
		System.out.println("O jogador foi atualizado na base dados!");
		return true;
	}
	
	public boolean atulizarCartoesAmarelos(String codigo, String nomeSelecao, String alteracao) {
		int index = buscarJogador(codigo); 
		int selecaoBusca = selecao.buscaSelecao(nomeSelecao);
		final List<Jogador> listaJogadores = selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores();			
		listaJogadores.get(index).setCartoesAmarelos(Integer.parseInt(alteracao));
		System.out.println("O jogador foi atualizado na base dados!");
		return true;
	}
	
	public boolean atualizarCartoesVermelhos(String codigo, String nomeSelecao, String alteracao) {
		int index = buscarJogador(codigo); 
		int selecaoBusca = selecao.buscaSelecao(nomeSelecao);
		final List<Jogador> listaJogadores = selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores();
		listaJogadores.get(index).setCartoesVermelhos(Integer.parseInt(alteracao));
		System.out.println("O jogador foi atualizado na base dados!");
		return true;
	}
	
	public boolean atualizarGolsMarcados(String codigo, String nomeSelecao, String alteracao) {
		int index = buscarJogador(codigo); 
		int selecaoBusca = selecao.buscaSelecao(nomeSelecao);
		final List<Jogador> listaJogadores = selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores();
		if(listaJogadores.get(index).getGolsMarcados() != 0) {
			listaJogadores.get(index).setGolsMarcados(Integer.parseInt(alteracao));
			System.out.println("O jogador foi atualizado na base dados!");
			return true;
		}
		else {
			return false;
	}
		}
	

	/**
	 * A função gerarid gera um id para ser usado como codigo no cadastro de jogador
	 * O id é gerado pela data e hora do cadastro
	 * @param jogador
	 * @return String
	 * @throws InterruptedException 
	 */

	//Gera o id do jogador com base na data

	private String geraid(Jogador jogador) throws InterruptedException {
		LocalDateTime dataagr = LocalDateTime.now();
		Thread.sleep(10);
	    DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyHHmmnn");
	    String coddate = dataagr.format(formato);
		return coddate;
	}
	


	/**
	 * Essa função busca e retorna o índice um cadastro de um jogador na lista
	 * @param codigo
	 * @return int
	 */


	public int buscarJogador(String codigo) {
		final List<Selecao> listaSelecao = selecao.getListaSelecoes();
		for(int index = 0; index < listaSelecao.size();index++) {
			var listaJogador = listaSelecao.get(index).getListaJogadores();
			for (int ijogador = 0; ijogador < listaJogador.size(); ijogador++) {
				if(listaJogador.get(ijogador).getCode().equals(codigo)) {
					return ijogador;
				}
				
			}
		
	}
		return -1;
	}
	
	public boolean verificaExistencia(String codigo) {
		final List<Selecao> listaSelecao = selecao.getListaSelecoes();
		for(int index = 0; index < listaSelecao.size();index++) {
			var listaJogador = listaSelecao.get(index).getListaJogadores();
			for (int ijogador = 0; ijogador < listaJogador.size(); ijogador++) {
				if(listaJogador.get(ijogador).getCode().equals(codigo)) {
					return true;
				}
				
			}
		
	}
		return false;
	}

	/**
	 * O método listarjogadoresDados lista os jogadores e seus dados cadastrados no sistema
	 */

	//Lista todos os jogadores

	@Override
	public boolean listarJogadoresDados(int selecaoBusca) {
		System.out.printf("Lista de jogadores [%s]:",selecao.getListaSelecoes().get(selecaoBusca).getNome());
		System.out.println("\n");
		if(selecaoBusca != -1) {
			if(selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores().size()> 0) {
				for(Jogador jogador: selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores()) {
					System.out.printf("Id: %s \n"
							+ "Nome: %s \n"
							+ "Posicao: %s"
							+ "\nGols marcados: %d"
							+ "\nQuantidade de cartoes Amarelos: %d"
							+ "\nQuantidade de cartoes vermelhos: %d\n"
							,jogador.getCode(),
							jogador.getNome(),
							jogador.getPosicao(),
							jogador.getGolsMarcados(),
							jogador.getCartoesAmarelos(),
							jogador.getCartoesVermelhos());
					System.out.println("------------------------------------------");
				}
			}
			else {
				return false;
			}
		}
		else {
			return true;
		}
		return true;
	}
	
		

	/**
	 * O método listarJogadores lista os jogadores cadastrados no sistema
	 */

	

	@Override
	public void listarJogadores(String nomeSelecao) {
		int selecaoBusca = selecao.buscaSelecao(nomeSelecao);
		System.out.printf("Lista de jogadores da Selecao [%s]\n", nomeSelecao);
		System.out.println("--------------------------------------------");
		if(selecaoBusca != -1) {
			if(selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores().size()> 0) {
			for(Jogador jogador: selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores()) {
				System.out.printf("%s - %s\n",jogador.getCode(), jogador.getNome());
				
				}
			}
			else {
				System.out.println("Nao existe jogador cadastrado");
			}
		}
		else {
			System.out.println("Selecao nao cadastrada");
		}
		System.out.println("");
	}

	/**
	 * O método imprimirJogador imprime os dados de um objeto do tipo Jogador
	 */

	public String retornaJogadorNome(String codigo,List<Selecao> listaSelecao) {
		String nome = "";
		for(int index = 0; index < listaSelecao.size();index++) {
			for (int ijogador = 0; ijogador < listaSelecao.get(index).getListaJogadores().size(); ijogador++) {
				if(listaSelecao.get(index).getListaJogadores().get(ijogador).getCode().equals(codigo)) {
					Jogador jogador = listaSelecao.get(index).getListaJogadores().get(ijogador);
					nome = jogador.getNome();
				
					}
				}
			}
			return nome;
		}
	

	@Override
	public void imprimirJogador(String codigo) {
		for(int index = 0; index < selecao.getListaSelecoes().size();index++) {
			for (int ijogador = 0; ijogador < selecao.getListaSelecoes().get(index).getListaJogadores().size(); ijogador++) {
				if(selecao.getListaSelecoes().get(index).getListaJogadores().get(ijogador).getCode().equals(codigo)) {
					Jogador jogador = selecao.getListaSelecoes().get(index).getListaJogadores().get(ijogador);
					System.out.printf("%s - %s \n"
							+ "Posicao: %s"
							+ "\nGols marcados: %d"
							+ "\nQuantidade de cartoes Amarelos: %d"
							+ "\nQuantidade de cartoes vermelhos: %d\n"
							,jogador.getCode(),
							jogador.getNome(),
							jogador.getPosicao(),
							jogador.getGolsMarcados(),
							jogador.getCartoesAmarelos(),
							jogador.getCartoesVermelhos());
					System.out.println("------------------------------------------");
				}	
			}
				
		}
		
	}
	/**
	 * O método listarPosicoes mostra as posições em que os jogadores atuam e podem ser cadastrados
	 */
	@Override
	public void listarPosicoes() {
		System.out.println("Digite o indice de  acordo com a sua posicao:\n");
		for(int i= 0; i<posicoes.length; i++)
		{
			System.out.printf("[%d]"+ " - " + posicoes[i]+"\n",i);
		}
		
	}


	/**
	 * Função para comparar 
	 * @param jogador
	 * @param nomeSelecao
	 * @return boolean
	 */



	private boolean comparaJogador(Jogador jogador, String nomeSelecao) {
		int selecaoBusca = selecao.buscaSelecao(nomeSelecao);
		final List<Jogador> listaJogadores = selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores();
		if(listaJogadores != null) {
			for(Jogador player : listaJogadores) {
				if(player.equals(jogador)){
					return true;
				}
		}
		if(selecao.getListaSelecoes()!= null)
		{
			return false;
		}
			
		for(Jogador player : selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores()) {
			if(player.equals(jogador)){
				return true;
			}
		}}
		return false;
	}
	
	public void transformaEmMap() {  
		
		ObjectMapper mapper = new ObjectMapper();
	    File fileObj = new File("selecoesJogadores.json");  
	    try {   
	        Map<String, List<String>> mapJson = mapper.readValue(  
	                fileObj, new TypeReference<Map<String, List<String>>>() {  
	        }); 
	        for (int i = 0; i < selecao.getListaSelecoes().size(); i++) {
	        	String nomeSelecao = "";
				for (Map.Entry<String, List<String>> selecaoMap : mapJson.entrySet()) {
					nomeSelecao = selecaoMap.getKey();
					if(selecao.getListaSelecoes().get(i).getNome().equals(selecaoMap.getKey())) {
						for(int j =0; j< selecaoMap.getValue().size();j++) {
							inserirJogadorJson(selecaoMap.getValue().get(j),selecaoMap.getKey());
						}
					}
				}
			}
	      
	        
	    } catch (Exception e) {   
	        e.printStackTrace();  
	    }   
	    }

	@Override
	public void editarJogador() 
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		Scanner entrada = new Scanner(System.in);
		
		
		selecao.listarSelecao();
		System.out.println("Digite o indice da selecao que deseja editar um jogador");
		int indiceSelecao = tratamento.validaInt(0,selecao.getListaSelecoes().size());
		
		
		if(selecao.getListaSelecoes().get(indiceSelecao).getListaJogadores().size()>0)
		{
			listarJogadores(selecao.getListaSelecoes().get(indiceSelecao).getNome());
			System.out.println("Digite o Codigo do jogador: ");
			String codigo = entrada.next();
			imprimirJogador(selecao.getListaSelecoes().get(indiceSelecao).getNome());
			imprimirJogador(codigo);
			
			System.out.println("Opcoes para update");
			System.out.println("1- Editar nome, 2- Editar Posicao");
			System.out.println("Digite a opcao que deseja alterar: ");
			
			int opcao = tratamento.validaInt(1,2);
			
			if(opcao == 1) {
				
				
				System.out.println("Digite o novo nome do jogador: ");
				String nome = tratamento.EntradaString();
				ArrayList<Selecao> listaSelecoes =selecao.getListaSelecoes();
				for(Selecao selecao : listaSelecoes)
				{
					for(Jogador jogador : selecao.getListaJogadores())
					{
						if(jogador.getCode().equals(codigo))
						{
							jogador.setNome(nome);
							System.out.println("Nome atualizado com sucesso!");
						}
					}
				}
				
			}
			
			else if(opcao == 2) {
				
				
				
				listarPosicoes();
				System.out.println("Digite a nova posicao: ");
				int posicao = tratamento.validaInt(0,5);
				String pos = posicoes[posicao];
				ArrayList<Selecao> listaSelecoes =selecao.getListaSelecoes();
				for(Selecao selecao : listaSelecoes)
				{
					for(Jogador jogador : selecao.getListaJogadores())
					{
						if(jogador.getCode().equals(codigo))
						{
							jogador.setPosicao(pos);
							System.out.println("Posicao atualizada com sucesso!");
						}
					}
				}
				
				
			}
			
		}	
		else
			System.out.println("Sem jogadores cadastrados nesta selecao");
	
	
	}
}
	

	


