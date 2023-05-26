import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streaming {

	private Map<Integer, IStringConverter> clientes;
	private Map<String, Serie> series;
	private Cliente clienteLogado;
	private Map<Integer, Audiencia> audiencia;

	public void inicializar() {
		clientes = LeitorCSV.lerCSV(new Cliente(), null);
	}

	private void carregarDados(IStringConverter dado) {

	} 

	public boolean autenticacao(int login, String senha) {
		return this.clienteLogado.getSenha().equals(senha) 
				&& this.clienteLogado.getLogin() == login;
	}

	public Serie buscarSeriePorNome(String nome) {
		return this.series.get(nome);
	}

	public List<Serie> buscarSeriesPorGenero(String genero) {
		return this.series.values().stream()
				.filter(serie -> genero.equalsIgnoreCase(serie.getNome())).collect(Collectors.toList());
	}

	public List<Serie> buscarSeriesPorIdioma(String idioma) {
		return this.series.values().stream()
				.filter(serie -> idioma.equalsIgnoreCase(serie.getIdioma())).collect(Collectors.toList());
	}

	public List<Serie> buscarSeriesAssistida(Cliente cliente) {
		return cliente.getAssistidas();
	}

	public List<Serie> buscarSeriesInteresse(Cliente cliente) {
		return cliente.getInteresses();
	}

	public void marcarAssistida(String nome) {
		Serie serie = this.series.get(nome);
		serie.incrementarReproducoes();
		this.clienteLogado.getAssistidas().add(serie);
		
	}

	public void marcarInteresse(String nome) {
		Serie serie = this.series.get(nome);
		this.clienteLogado.getInteresses().add(serie);
	}

	public void removerinteresse(Cliente cliente) {
		
	}
	
//	public void removerInteresse(String nome){
//		Serie serie = this.series.get(nome);
//		this.clienteLogado.getInteresses().removeIf(serie -> nome.equalsIgnoreCase(serie.getNome()));
//����}

}
