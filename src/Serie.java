public class Serie extends Midia {
    private int quantEpisodios;

    public Serie() {}

    public Serie(String idMidia, String nome, String dataLancamento) {
        super(idMidia, nome, dataLancamento);
    }

    @Override
    public IStringConverter converterToObject(String dados) {
        String[] valores = dados.split(";");
	 	return new Serie(valores[0], valores[1], valores[2]);
    }
    
}
