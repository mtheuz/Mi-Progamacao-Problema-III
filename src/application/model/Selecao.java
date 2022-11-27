package application.model;

import java.util.ArrayList;
import java.util.List;

import application.model.Jogador;
import application.model.Tecnico;
/**
 * A classe <b> Selecao</b> serve para criar um objeto que será um cadastro de uma Seleção da copa do mundo no sistema.
 * @author Mailson
 *	@since 2022
 */
public class Selecao {
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
	private int gols;

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
	
}