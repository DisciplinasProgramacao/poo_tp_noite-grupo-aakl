public class Audiencia implements IStringConverter{
    private int login;
    private int idSerie;
    private String estado;

    public Audiencia(String login, String idString, String estado) {
        this.login = Integer.valueOf(login);
        this.idSerie = Integer.valueOf(idSerie);
        this.estado = estado;
    }

    @Override
    public IStringConverter converterToObject(String dados) {
        String[] valor = dados.split(";");
        return new Audiencia(valor[0], valor[1], valor[2]);
    }

    @Override
    public int getChave() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getChave'");
    }
    
}
