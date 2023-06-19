import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streaming {

	private Map<String, Cliente> clientes;
	private Map<String, Midia> midias;
	private Cliente clienteLogado;


	public Streaming() {
		inicializar();
	}

	public void inicializar() {
		carregarDados();
		List<String> audiencia = carregarAudiencia();
		preencherAudiencia(audiencia);
	}

	private void carregarDados() {
		LeitorCSV leitor = new LeitorCSV<IStringConverter>();

		clientes = leitor.lerCSV(new Cliente(), "dados/POO_Espectadores.csv");
		midias = leitor.lerCSV(new Serie(), "dados/POO_Series.csv");
		midias.putAll(leitor.lerCSV(new Filme(), "dados/POO_Filmes.csv"));
	}

	private List<String> carregarAudiencia() {
		return LeitorCSV.lerCSV("dados/POO_Audiencia.csv");
	}

	private void preencherAudiencia(List<String> dadosAudiencia) {
		String[] valores;
		for (String audiencia : dadosAudiencia) {
			valores = audiencia.split(";");
			Cliente cliente = clientes.get(valores[0]);
			Midia serie = midias.get(valores[2]);
			if (cliente != null && serie != null) {
				if (valores[1].equals("A")) {
					registrarReproducao(cliente, serie);
				} else {
					cliente.registraInteresse(serie);
				}
			}

		}
	}

	

	private void registrarReproducao(Cliente cliente, Midia serie) {
		cliente.registraAssistida(serie);
	}

	public boolean autenticacao(String login, String senha) {
		boolean autendicado = false;
		
		if(clientes.containsKey(login)) {
			if(clientes.get(login).getSenha().equals(senha)) {
				clienteLogado = clientes.get(login);
				autendicado = true;
			}
		}
		return autendicado;
	}


	public List<Midia> buscarMidiasPorGenero(String genero) {

		return this.midias.values().stream()
				.filter(serie -> genero.equalsIgnoreCase(serie.getNome())).collect(Collectors.toList());
	}

	public List<Midia> buscarMidiasPorIdioma(String idioma) {
		return this.midias.values().stream()
				.filter(serie -> idioma.equalsIgnoreCase(serie.getIdioma())).collect(Collectors.toList());
	}

	public List<Serie> buscarSeriesAssistida(Cliente cliente) {
		return this.buscarSeriesAssistida(cliente);
	}

	public List<Serie> buscarSeriesInteresse(Cliente cliente) {
		return this.buscarSeriesInteresse(cliente);
	}

	public Midia buscaMidiaNalista(String nome, boolean ehAssistida) {
		Midia midia;
		if(ehAssistida) {
			midia = clienteLogado.buscaMidiaAssistida(nome);
		}
		else {
			midia = clienteLogado.buscaMidiaInteresse(nome);
		}
		return midia;
	}

	public void addMidiaAlista(String nome, boolean jaAssitida) throws Exception {
		Midia midia = this.midias.get(nome);
		if(midia == null) {
			throw new Exception("Mídia não encontrada");
		}
		
		ehlancamento(midia);
		if(jaAssitida) {
			clienteLogado.adicionarAssistida(midia);
		}
		else {
			clienteLogado.adicionarInteresse(midia);
		}
	}

	private void ehlancamento(Midia midia) throws Exception {
		if(midia.isLancamento() && !lancamentoPodeSerReproduzido()){
			throw new Exception("Usuário não tem permissão para assistir lançamentos.");
		}
	}

	private boolean lancamentoPodeSerReproduzido() {
		return this.clienteLogado.gCategoria().equals(Categorias.PROFISSIONAL) ? true : false;
	}

	public void marcarInteresse(String nome) {
		Midia serie = this.midias.get(nome);
		this.clienteLogado.getInteresses().add(serie);
	}

	public void removerinteresse(Cliente cliente) {

	}



	public void avaliarMidia(Cliente cliente, Midia midia)
	{
		if(!cliente.verificaSeAvaliou(midia))
		{
			System.out.print("Informe uma nota para esta mídia: ");
			int nota = Integer.parseInt(App.sc.nextLine());
			Avaliacao a = new Avaliacao(nota);
			
			if(cliente.getTipoCliente().toLowerCase().equals("especialista"))
			{
				System.out.print("Adicione um comentário: ");
				String comentario = App.sc.nextLine();
				a.addComentario(comentario);
			}
			cliente.addAvaliadas(midia);
			midia.avaliarMidia(a);
		} else {
			System.out.println("Esta mídia já foi avaliada por " + cliente.getNome());
		}
		
	}
	
//	public void removerInteresse(String nome){
//		Serie serie = this.series.get(nome);
//		this.clienteLogado.getInteresses().removeIf(serie -> nome.equalsIgnoreCase(serie.getNome()));
//����}

}
