public enum GenerosMidias {
    
    ACAO ("Ação"),
    ANIME ("Anime"),
    AVENTURA ("Aventura"),
    DOCUMENTARIO ("Documentario"),
    DRAMA ("Drama"),
    POLICIAL ("Policial"),
    SUSPENSE ("Suspense"),
    ROMANCE ("Romance"), 
    COMEDIA ("Comedia");

    private String genero;

    private GenerosMidias(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return this.genero;
    }
}
