
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
	
public abstract class Midia implements IStringConverter{

	private String idMidia;
	private String nome;
	private String genero;
	private ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
	private String idioma;
	private int contReproducoes = 0;
	private LocalDate dataLancamento;
	private List<String> generos;
	private List<String> idiomas;
	private double avaliacaoMedia;
	private int soma;
	private boolean isLancamento;

	public Midia() {}

	public Midia(String idMidia, String nome, String dataLancamento) {
		this.idMidia = idMidia;
		this.nome = nome;
		this.dataLancamento = Utils.converteStringParaData(dataLancamento);
	}

	/**
	 * Este método calcula a média das avaliações de uma mídia
	 */
	public void calculaMediaAvaliacoes()
	{
		this.soma = this.avaliacoes.stream().mapToInt(i -> i.getNota()).sum();
		if(this.avaliacoes.size() != 0) {
			this.avaliacaoMedia = soma/this.avaliacoes.size();
		}
	}

	public String getID() {
		return idMidia;
	}
	
	public void avaliarMidia(Avaliacao avaliacao)
	{
		this.avaliacoes.add(avaliacao);
	}



	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public void incrementarReproducoes () {
		this.contReproducoes +=1;
	}

	public abstract IStringConverter converterToObject(String dados);

	@Override
	public String getChave() {
		return this.nome;
	}

	/**
	 * Retorna a média das avaliações desta mídia
	 * @return double
	 */
	public double getAvaliacaoMedia() {
		return avaliacaoMedia;
	}

	public boolean isLancamento() {
		return isLancamento;
	}

	public int getVizualizacoes(){
        return this.contReproducoes;
    }


	public String getGenero() {
			return genero;
	}

}