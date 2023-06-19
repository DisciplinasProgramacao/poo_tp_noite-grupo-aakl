public enum Categorias {
    REGULAR("Regular", false),
    ESPECIALISTA("Especialista", true),
    PROFISSIONAL("Profissional", true);

    private boolean comentarioHabilitado;
    private String categoria;

    private Categorias(String categoria, boolean comentarioHabilitado) {
        this.categoria = categoria;
        this.comentarioHabilitado = comentarioHabilitado;
    }

    public static Categorias defineCategoria(Cliente cliente) {
        if(cliente.isProfissional()) {
            return PROFISSIONAL;            
        }
        else if(cliente.getQuatidadeAvaliacoes() > 5) {
            return ESPECIALISTA;
        }
        else {
            return REGULAR;
        }
    }
}
