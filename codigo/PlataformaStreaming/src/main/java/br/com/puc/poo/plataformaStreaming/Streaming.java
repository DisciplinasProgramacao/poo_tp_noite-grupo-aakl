package br.com.puc.poo.plataformaStreaming;
import java.util.*;

public class Streaming {
    
   // private HashMap<int, Cliente> clientes;
    private HashMap<String, Serie> series;
    private Cliente clienteLogado;

    public Streaming(){

    }

    public boolean autenticacao(int login, String senha){
		return false;

    }

    public Serie buscarSeriePorNome(String nome){
		return null;

    }

    public Serie buscarSeriePorGenero(String genero){
		return null;
        
    }

    public Serie buscarSeriePorIdioma(String idioma){
		return null;
        
    }

    public Serie buscarSerieAssistida(String nome){
		return null;
        
    }

    public Serie buscarSerieInteresse(String nome){
		return null;
        
    }

    public void marcarAssistida(String nome){

    }

    public void marcarInteresse(String nome){
        
    }

    public void removerInteresse(String nome){
        
    }
    
}
