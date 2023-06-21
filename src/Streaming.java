import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Streaming {
	static Scanner sc = new Scanner(System.in);
	private Map<String, Cliente> clientes;
	private Map<String, Midia> midias;
	private Cliente clienteLogado;
	private Cliente clienteQueViuMaiorQuantidade = null;


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

	public void avaliar(Midia midia) {
		avaliarMidia(clienteLogado, midia);
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

public void relatoriosGerenciais() {
	int opcao = opcoesRelatoriosGerenciais();
	
	switch (opcao) {
	case 1:
		System.out.println("O cliente que assistiu mais mídias é o: " + this.clientes.values().stream()
							.max((c,c1) -> Integer.compare(c.getAssistidas().size(), c1.getAssistidas().size()))
							.get().getNome()
							);
		System.out.println("Ele assistiu: " + this.clientes.values().stream()
							.max((c,c1) -> Integer.compare(c.getAssistidas().size(), c1.getAssistidas().size()))
							.get().getAssistidas().size());

		break;
	case 2:
		System.out.println("O cliente que possui o maior número de avaliações é o: " + this.clientes.values().stream()
							.max((c,c1) -> Integer.compare(c.getQuatidadeAvaliacoes(), c1.getQuatidadeAvaliacoes()))
							.get().getNome()
							);
		System.out.println("Ele possui: " + this.clientes.values().stream()
											.max((c,c1) -> Integer.compare(c.getQuatidadeAvaliacoes(), c1.getQuatidadeAvaliacoes()))
							.get().getQuatidadeAvaliacoes() + " avaliações.");
		break;
	case 3:
		List<Midia> midiasMaisAvaliadas = this.clientes.values().stream()
								.flatMap(c -> c.getMidiasQueAvaliei().stream())
								.filter(m -> m.getVizualizacoes() >= 100)
								.collect(Collectors.toList()).stream()
								.sorted(Comparator.comparingDouble(Midia::getAvaliacaoMedia).reversed())
								.limit(10)
								.collect(Collectors.toList());

		midiasMaisAvaliadas.stream()
							.forEach(
								m -> System.out.println(m.getNome())
							);
		break;
	case 4:
		long clientes15Mais = this.clientes.values().stream()
															.filter(c -> c.getQuatidadeAvaliacoes() >= 15)
															.count();
				System.out.println("A porcentagem dos clientes com pelo menos 15 avaliação: " + ((clientes15Mais*100) / this.clientes.size()));
		break;
	case 5:
		System.out.println("As 10 mídias com mais visualizações: ");
			this.midias.values().stream()
								.sorted(Comparator.comparingDouble(Midia::getVizualizacoes).reversed())
								.limit(10)
								.forEach(
									m -> System.out.println(m.getNome())
								);
		break;
	case 6:
		System.out.println("Selecione o gênero desejado: ");
			
		for (GenerosMidias genero : GenerosMidias.values()) {
			System.out.printf("%d - %s \n", genero.ordinal()+1, genero.getGenero());
		}

		int opc = Integer.parseInt(sc.nextLine());
			
			System.out.println("As 10 mídias com mais visualizações: ");
			this.midias.values().stream()
								.filter(m -> m.getGenero().equals(GenerosMidias.getGeneroPorIndex(opc)))
								.sorted(Comparator.comparingDouble(Midia::getVizualizacoes).reversed())
								.limit(10)
								.forEach(
									m -> System.out.println(m.getNome())
								);
		break;
	case 7:
		System.out.println("Selecione o gênero desejado: ");
		
		for (GenerosMidias genero : GenerosMidias.values()) {
			System.out.printf("%d - %s \n", genero.ordinal()+1, genero.getGenero());
		}

		int opt = Integer.parseInt(sc.nextLine());
		
		List<Midia> midiasMaisAvaliadasPorGenero = this.clientes.values().stream()
									.flatMap(c -> c.getMidiasQueAvaliei().stream())
									.filter(m -> m.getVizualizacoes() >= 100)
									.collect(Collectors.toList()).stream()
									.sorted(Comparator.comparingDouble(Midia::getAvaliacaoMedia).reversed())
									.limit(10)
									.collect(Collectors.toList());

			midiasMaisAvaliadasPorGenero.stream()
								.filter(m -> m.getGenero().equals(GenerosMidias.getGeneroPorIndex(opt)))
								.forEach(
									m -> System.out.println(m.getNome())
								);
		
	break;
	}
	
}
	
	private Object compareTo() {
		return null;
	}

	public static Integer opcoesRelatoriosGerenciais() {
		int opcao;
		System.out.println("Escolha o número do  relatório gerencial que deseja consultar: \n"
				+ "1 - Qual cliente assistiu mais mídias, e quantas mídias; \n"
				+ "2 - Qual cliente tem mais avaliações, e quantas avaliações; \n"
				+ "3 - Quais são as 10 mídias com a melhor média de avaliações e que tenham sido vistas pelo menos 100 vezes, apresentadas em ordem decrescente;\n" 
				+ "4 - Qual a porcentagem dos clientes com pelo menos 15 avaliações;\n" 
				+ "5 - Quais são as 10 mídias com mais visualizações, em ordem decrescente;\n"
				+ "6 - Quais são as 10 mídias com mais visualizações, em ordem decrescente e por gênero\n"
				+ "7 - Quais são as 10 mídias com a melhor média de avaliações e que tenham sido vistas pelo menos 100 vezes, apresentadas em ordem decrescente por gênero\n");
		opcao = sc.nextInt();
		return opcao;
	}

}
