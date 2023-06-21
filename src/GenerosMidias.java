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

    public static GenerosMidias getGeneroPorIndex(int index){
        
        GenerosMidias generoEscolhido = null;
        int i = 0;

        for (GenerosMidias genero : GenerosMidias.values()) {
            if(index - 1 == i){
               generoEscolhido = genero;
            }
            i++;
        }
        return generoEscolhido; 
    }
}