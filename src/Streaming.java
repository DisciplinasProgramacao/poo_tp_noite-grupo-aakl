import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streaming {

	private Map<String, Cliente> clientes;
	private Map<String, Serie> series;
	private Cliente clienteLogado;
	

	public Streaming() {
		inicializar();
	}

	public void inicializar()
	{
		carregarDados();
		List<String> audiencia = carregarAudiencia();
		preencherAudiencia(audiencia);
		System.out.println("testado");
	}

	private void carregarDados() {
		LeitorCSV leitor = new LeitorCSV<IStringConverter>();

		clientes = leitor.lerCSV(new Cliente(), "dados/POO_Espectadores.csv");
		series = leitor.lerCSV(new Serie(), "dados/POO_Series.csv");
	} 

	private List<String> carregarAudiencia() {
		return LeitorCSV.lerCSV("dados/POO_Audiencia.csv");
	}

	private void preencherAudiencia(List<String> dadosAudiencia) {
		String[] valores;
		for (String audiencia : dadosAudiencia) {
			valores = audiencia.split(";");
			Cliente cliente = clientes.get(valores[0]);
			Serie serie = series.get(valores[2]);
			if(cliente != null && serie != null) {
				if(valores[1].equals("A")) 
				{
					serie.incrementarReproducoes();
					cliente.adicionarAssistida(serie);
				}
				else
				{
					cliente.adicionarInteresse(serie);
				}
			}
			
		}
	}

	public boolean autenticacao(String login, String senha) {
		return this.clienteLogado.getSenha().equals(senha) 
				&& this.clienteLogado.getLogin().equals(login);
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
