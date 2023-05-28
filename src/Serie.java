
import java.time.LocalDate;
import java.util.List;

public class Serie implements IStringConverter{

	private String idSerie;
	private String nome;
	private String genero;
	private String idioma;
	private int contReproducoes = 0;
	private LocalDate dataLancamento;
	private List<String> generos;
	private List<String> idiomas;

	public Serie() {}

	public Serie(String idSerie, String nome, String dataLancamento) {
		this.idSerie = idSerie;
		this.nome = nome;
		this.dataLancamento = Utils.converteStringParaData(dataLancamento);
	}

	public String getNome() {
		return nome;
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

	@Override
	public IStringConverter converterToObject(String dados) {
		String[] valores = dados.split(";");
		return new Serie(valores[0], valores[1], valores[2]);
	}

	@Override
	public String getChave() {
		return idSerie;
	}
	
}