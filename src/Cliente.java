import java.util.*;

public class Cliente implements IStringConverter{

	private String login;
	private String nome;
	private String senha;
	private List<Serie> assistidas = new ArrayList<Serie>(50);
	private List<Serie> interesses = new ArrayList<Serie>(50);

	public Cliente(String nome, String login, String senha) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	public Cliente() {}	 
	

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

	public List<Serie> getAssistidas() {
		return assistidas;
	}

	public void setAssistidas(List<Serie> assistidas) {
		this.assistidas = assistidas;
	}

	public List<Serie> getInteresses() {
		return interesses;
	}

	public void setInteresses(List<Serie> interesses) {
		this.interesses = interesses;
	}

	public void adicionarInteresse(Serie serie) {
		this.interesses.add(serie);
	}

	public void adicionarAssistida(Serie serie) {
		this.assistidas.add(serie);
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

}
