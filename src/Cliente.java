import java.util.*;
/**
	 * IMPLEMENTAÇÃO DAS REGRAS PARA AVALIAÇÃO DE MIDIAS:
	 * 
	 * 1- UMA MIDIA TEM SUA AVALIAÇÃO MÉDIA; OK
	 * 2- UM CLIENTE NÃO PODE AVALIAR A MESMA MÍDIA DUAS VEZES; OK
	 * 3- CLIENTERS PODEM SER REGULARES OU ESPECIALISTAS, E ESTES ÚLTIMOS PODEM ADICIONAR COMENTÁRIOS À AVALIAÇÃO
	 */
public class Cliente implements IStringConverter {
	private String tipoCliente = "Regular";
	private String login;
	private String nome;
	private String senha;
	private int visualizacoes = 0;
	private ArrayList<Midia> midiasQueAvaliei = new ArrayList<Midia>();
	private List<Midia> assistidas = new ArrayList<Midia>(50);
	private List<Midia> interesses = new ArrayList<Midia>(50);

	public Cliente(String nome, String login, String senha) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	public Cliente() {}	 
	
	
	public boolean verificaSeAvaliou(Midia midia)
	{
		for (Midia m : midiasQueAvaliei) {
			return m.getChave().equals(midia.getChave()) ? true : false;
		}
		return false;
	}
	public void addAvaliadas(Midia midia)
	{
		this.midiasQueAvaliei.add(midia);
	}

	private void alterarTipo()
	{
		this.tipoCliente = "Especialista";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Midia> getAssistidas() {
		return assistidas;
	}

	public void setAssistidas(List<Midia> assistidas) {
		this.assistidas = assistidas;
	}

	public List<Midia> getInteresses() {
		return interesses;
	}

	public void setInteresses(List<Midia> interesses) {
		this.interesses = interesses;
	}

	public void adicionarInteresse(Midia serie) {
		this.interesses.add(serie);
	}

	public void adicionarAssistida(Midia serie) {
		this.assistidas.add(serie);
		this.atualizaVisualizacao();
	}
	/**
	 * Atualiza visualização da série
	 */
	private void atualizaVisualizacao()
	{
		this.visualizacoes++;
	}

	@Override
	public IStringConverter converterToObject(String dados) {
		String[] valores = dados.split(";");
		return new Cliente(valores[0], valores[1], valores[2]);
	}

	@Override
	public String getChave() {
		return login;
	}

	/**
	 * Retorna o tipo de cliente
	 * @return String
	 */
	public String getTipoCliente() {
		return tipoCliente;
	}

	/**
	 * Retorna o nome do cliente
	 * @return String
	 */
	public String getNome() {
		return nome;
	}

}
