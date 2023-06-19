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
	
//	public void removerInteresse(String nome){
//		Serie serie = this.series.get(nome);
//		this.clienteLogado.getInteresses().removeIf(serie -> nome.equalsIgnoreCase(serie.getNome()));
//����}


	public void relatoriosGerenciais() {
		int opcao = opcoesRelatorioGerenciais();
		
		switch (opcao) {
		/*case 1:
			this.clientes.values().forEach(c -> {

				if(c.getAssistidas().size() > this.clienteQueViuMaiorQuantidade.getAssistidas().size()) {
					clienteQueViuMaiorQantidade = c;
				}
			});
			System.out.println("O cliente que assistiu a maior quantidade de mídias é : " + this.clienteQueViuMaiorQuantidade.getLogin() + "\n" +
								"E assistiu um total de : " + this.clienteQueViuMaiorQuantidade.quantidadeTotalMidiaAssistida());
			break;
		case 2:
			Cliente clienteMaisAvaliacao = this.clientes.values().stream()
										.collect(Collectors.maxBy(Comparator.comparingInt(Cliente:: getAvaliacao))).orElse(new Cliente());
			System.out.println("O cliente que possui o maior numero de avaliações é : " + clienteMaisAvaliacao.getLogin() + "\n" +
					"E tem um total de : " + clienteMaisAvaliacao.getAvaliacao());
			break;
		case 3:
			Integer quantidade = this.clientes.values().stream()
			.filter(c -> c.getAvaliacao() >= 15).collect(Collectors.reducing(0, e -> 1, Integer::sum));
			Integer total = (quantidade/this.clientes.values().size())*100;
			System.out.println("A porcentagem de clientes com pelo menos 15 avaliações é de:  " + total);
			break;*/
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		}
		
	}
	
	private Object compareTo() {
		return null;
	}

	public static Integer opcoesRelatorioGerenciais() {
		int opcao;
		System.out.println("Escolha o número do  relatório gerencial que deseja consultar: \n"
				+ "1 - Qual cliente assistiu mais mídias, e quantas mídias; \n"
				+ "2 - Qual cliente tem mais avaliações, e quantas avaliações; \n"
				+ "3 - Quais são as 10 mídias com a melhor média de avaliações e que tenham sido vistas pelo menos 100 vezes, apresentadas em ordem decrescente;\n" 
				+ "4 - Qual a porcentagem dos clientes com pelo menos 15 avaliações;\n" 
				+ "5 - Quais são as 10 mídias com mais visualizações, em ordem decrescente;\n"
				+ "6 - Quais são as 10 mídias com mais visualizações, em ordem decrescente e por gênero\n"
				+ "7 - Quais são as 10 mídias com a melhor média de avaliações e que tenham sido vistas pelo menos 100 vezes, apresentadas em ordem decrescentee por gênero\n");
		opcao = sc.nextInt();
		return opcao;
	}

}
