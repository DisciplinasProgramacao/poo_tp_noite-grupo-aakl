import java.util.*;

public class Cliente {
    
    private int login;
    private String senha;
    private List<Serie> assistidas;
    private List<Serie> interesses;

    public Cliente(int login, String senha){
        this.login = login;
        this.senha = senha;
        assistidas = new ArrayList<>();
        interesses = new ArrayList<>();
    }

    public boolean buscarSerieAssistida(Serie serie){
            if(assistidas.contains(serie)){
                return true;
            }
            
            return false;
    }

    public boolean buscarSerieInteresse(Serie serie){
        if(interesses.contains(serie)){
            return true;
        }
        
        return false;
    }

    public void adicionarAssistida(Serie serie){
        if(assistidas.contains(serie)){
            System.out.println("Série já adicionada!");
        }
        else{
            this.assistidas.add(serie);
        }
    }

    public void adicionarInteresse(Serie serie){
        if (interesses.contains(serie)){
            System.out.println("Série já adicionada!");
        }
        else{
            this.interesses.add(serie);
        }
    }

    public void removerInteresse(Serie serie){
        if(interesses.contains(serie)){
            interesses.remove(serie);
        }
        else{
            System.out.println("Série não está contida na lista!");
        }
    }
}
