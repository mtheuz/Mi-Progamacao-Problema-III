package application.model.SelecaoPackage;

import java.util.ArrayList;
import java.util.List;

import application.model.JogadorPackage.Jogador;
import application.model.TecnicoPackage.Tecnico;
/**
 * A classe <b> Selecao</b> serve para criar um objeto que será um cadastro de uma Seleção da copa do mundo no sistema.
 * @author Mailson
 *	@since 2022
 */
public class Selecao implements Comparable<Selecao>{
	/**
	 * Atributo grupo indica em que grupo a selção está
	 */
	private String grupo;

	/**
	 * Atributo nome da Seleção
	 */
	private String nome;
	/**
	 * Lista onde são salvos os cadastros de Jogadores da Seleção
	 */
	private List<Jogador> listaJogadores;
	/**
	 * Atributo técnico é um objeto da classe Tecnico
	 */
	private Tecnico tecnico;
	
	private int pontos;
	private String vitoria;
	private String derrota;
	private String empate;
	private int golsMarcados;
	private int golsSofridos;
	private int saldoGols = golsMarcados - golsSofridos;
	public int getSaldoGols() {
		return saldoGols;
	}

	public void setSaldoGols(int saldoGols) {
		this.saldoGols = saldoGols;
	}


	private int quantidadeCartoesAmarelos;
	private int quantidadeCartoesVermelhos;
	public int getGolsMarcados() {
		return golsMarcados;
	}

	public void setGolsMarcados(int golsMarcados) {
		this.golsMarcados += golsMarcados;
	}


	public int getGolsSofridos() {
		return golsSofridos;
	}


	public void setGolsSofridos(int golsSofridos) {
		this.golsSofridos += golsSofridos;
	}

	public int getQuantidadeCartoesAmarelos() {
		return quantidadeCartoesAmarelos;
	}


	public void setQuantidadeCartoesAmarelos(int quantidadeCartoesAmarelos) {
		this.quantidadeCartoesAmarelos += quantidadeCartoesAmarelos;
	}


	public int getQuantidadeCartoesVermelhos() {
		return quantidadeCartoesVermelhos;
	}


	public void setQuantidadeCartoesVermelhos(int quantidadeCartoesVermelhos) {
		this.quantidadeCartoesVermelhos += quantidadeCartoesVermelhos;
	}
	
	public String getEmpate() {
		return empate;
	}


	public void setEmpate(String empate) {
		this.empate = empate;
	}


	public int getPontos() {
		return pontos;
	}


	public void setPontos(int pontos) {
		this.pontos += pontos;
	}


	public String getVitoria() {
		return vitoria;
	}


	public void setVitoria(String vitoria) {
		this.vitoria = vitoria;
	}


	public String getDerrota() {
		return derrota;
	}


	public void setDerrota(String derrota) {
		this.derrota = derrota;
	}
	
	
	public Selecao()
	{

		
		this.listaJogadores = new ArrayList<Jogador>();
		this.nome = "";

	}
	
	
	/**
	 * Construtor padrão da classe 
	 */

	public Selecao(String nomeSelecao, String grupo) {
		this.listaJogadores = new ArrayList<Jogador>();
		this.nome = nomeSelecao;
		this.grupo = grupo;
		this.tecnico = new Tecnico();
		this.derrota = "0";
		this.empate ="0";
		this.vitoria = "0";
		this.golsMarcados = 0;
		this.golsSofridos = 0;
		tecnico.setNome("Sem Tecnico");
	}
	/**
	 * Consultar o nome da seleção 
	 * @return String
	 */
	public String getNome() {
	return nome;
	}
	/**
	 * Setar o nome da seleção
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Consultar o objeto Tecnico da seleção
	 * @return
	 */
	public Tecnico getTecnico() {
		return tecnico;
	}
	/**
	 * Setar o Objeto Tecnico da Seleção
	 * @param tecnico
	 */
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	/**
	 * Consultar a lista de jogadores da Seleção
	 * @return
	 */
	public List<Jogador> getListaJogadores() {
		return listaJogadores;
	}

	/**
	 * Definir a lista de jogadores da Seleção
	 * @param listaJogadores
	 */
	public void setListaJogadores(List<Jogador> listaJogadores) {
		this.listaJogadores = listaJogadores;
	}
	
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}


	@Override
	public int compareTo(Selecao other) {
		if(this.pontos > other.pontos) {
			return -1;
		}
		else if(this.pontos < other.pontos) {
			return 1;
		}
		else if(this.pontos == other.pontos) {
			if(this.saldoGols > other.saldoGols) {
				return -1;
			}
			else if(this.saldoGols < other.saldoGols) {
				return 1;
			}
			else {
				if(this.quantidadeCartoesVermelhos < other.quantidadeCartoesVermelhos) {
					return -1;
				}
				else if(this.quantidadeCartoesVermelhos > other.quantidadeCartoesVermelhos) {
					return 1;
				}
				else {
					if(this.quantidadeCartoesAmarelos < other.quantidadeCartoesAmarelos) {
						return -1;
					}
					else if(this.quantidadeCartoesAmarelos > other.quantidadeCartoesAmarelos) {
						return 1;
					}
					
				}
			}
		}
		
		
		
		return 0;
	}
	
}