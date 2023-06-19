public class Avaliacao {
    
    private int nota;
    private String comentario;

    public Avaliacao(int nota)
    {
        this.nota = nota;
    }

    public void addComentario(String comentario)
    {
        this.comentario = comentario;
    }
    
    /**
     * Retorna a nota desta avaliação
     * @return int
     */
    public int getNota()
    {
        return nota;
    }

    /**
     * Retorna o comentario desta avaliação
     * @return String
     */
    public String getComentario() {
        return comentario;
    }
}
