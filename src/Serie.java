
import java.util.List;

public class Serie {

	private String nome;
	private String genero;
	private String idioma;
	private Integer contReproducoes;
	private List<String> generos;
	private List<String> idiomas;

	public Serie() {
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
	
}