import java.util.*;

public class Cliente {

	private int login;
	private String senha;
	private List<Serie> assistidas;
	private List<Serie> interesses;

	public Cliente() {
	}

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

}
