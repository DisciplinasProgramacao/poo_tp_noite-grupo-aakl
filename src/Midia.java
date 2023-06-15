
import java.time.LocalDate;
import java.util.List;

public abstract class Midia implements IStringConverter{

	private String idMidia;
	private String nome;
	private String genero;
	private String idioma;
	private int contReproducoes = 0;
	private LocalDate dataLancamento;
	private List<String> generos;
	private List<String> idiomas;

	public Midia() {}

	public Midia(String idMidia, String nome, String dataLancamento) {
		this.idMidia = idMidia;
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

	public abstract IStringConverter converterToObject(String dados);

	@Override
	public String getChave() {
		return idMidia;
	}
}