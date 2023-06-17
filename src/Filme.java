public class Filme extends Midia{
    private int duracaoSegundos;

    public Filme() {}

    public Filme(String idMidia, String nome, String dataLancamento, String duracaoSegundos) {
        super(idMidia, nome, dataLancamento);
        
        try {
            this.duracaoSegundos = Integer.parseInt(duracaoSegundos);
        } catch (NumberFormatException e) {
            System.out.printf("Erro ao converter para inteiro o parametro: ", duracaoSegundos);
        }
    }

    @Override
    public IStringConverter converterToObject(String dados) {
        String[] valores = dados.split(";");
	 	return new Filme(valores[0], valores[1], valores[2], valores[3]);
    }
}
