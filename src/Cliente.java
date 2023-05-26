import java.util.*;

public class Cliente implements IStringConverter{

	private int login;
	private String nome;
	private String senha;
	private List<Serie> assistidas;
	private List<Serie> interesses;

	public Cliente(String nome, String login, String senha) {
		this.nome = nome;
		this.login = Integer.valueOf(login);
		this.senha = senha;
	}

	public Cliente() {}

	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
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

	@Override
	public IStringConverter converterToObject(String dados) {
		String[] valores = dados.split(";");
		return new Cliente(valores[0], valores[1], valores[2]);
	}

	@Override
	public int getChave() {
		return login;
	}

}
