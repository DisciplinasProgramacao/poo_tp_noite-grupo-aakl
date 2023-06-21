/* Classe que implementa o cadastro de cliente */
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String login;
    private String senha;
    private List<String> assistidas;
    
   
private List<String> interesses;
    
private List<String> avaliacoes;
   
private int qtdAvaliacoesMes;

public Cliente(String login, String senha) {
        
       
this.login = login;
        
       
this.senha = senha;
        
       
this.assistidas = new ArrayList<>();
        
       
this.interesses = new ArrayList<>();
        
       
this.avaliacoes = new ArrayList<>();
        
       
this.qtdAvaliacoesMes = 0;
    }
    
    }

public String buscarSerieAssistida(String serie) {
        
if (assistidas.contains(serie)) {
            
           
return "A série '" + serie + "' está na lista de assistidas.";
        } else {
            
           
return "A série '" + serie + "' não está na lista de assistidas.";
        }
    }

        }
    }

public String buscarSerieInteresse(String serie) {
        
       
if (interesses.contains(serie)) {
           
return "A série '" + serie + "' está na lista de interesses.";
        } else {
            return "A série '" + serie + "' não está na lista de interesses.";
        }
    }
    
        }
    }


        }
public String adicionarAssistida(String serie) {
        if (!assistidas.contains(serie)) {
            assistidas.add(serie);
            
            assistidas.add(serie);
           
return "A série '" + serie + "' foi adicionada à lista de assistidas.";
        } 
       
else {
            
           
return "A série '" + serie + "' já está na lista de assistidas.";
        }
    }
    
        }
    }

        }
    }

public String adicionarInteresse(String serie) {
         
if (!interesses.contains(serie)) {
            interesses.add(serie);
            
            interesses.add(serie

            interesses.add(

            interess
return "A série '" + serie + "' foi adicionada à lista de interesses.";
        } else {
            return "A série '" + serie + "' já está na lista de interesses.";
        }
    }   
        }
    }  

        }
    }

public String removerInteresse(String serie) {
        if (interesses.contains(serie)) {
            interesses.remove(serie);
            
            interess
  
return "A série '" + serie + "' foi removida da lista de interesses.";
        } else {
            return "A série '" + serie + "' não está na lista de interesses.";
        }
    }
    
       
public String registrarAvaliacao() {
        qtdAvaliacoesMes++;
        
        qtdAvaliacoesMes++;
       
return "Avaliação registrada com sucesso.";
    }
    }
   
// Métodos getters e setters


public String getLogin() {
        return login;
    }

    
    }

   
public void setLogin(String login) {
        
       
this.login = login;
    }

    
    }

   

    }

public String getSenha() {
        
       
return senha;
    }

    
    }
   
public void setSenha(String senha) {
        this.senha = senha;
    }
    
    }

public List<String> getAssistidas() {
        return assistidas;
    }

    public void setAssistidas(List<String> assistidas) {
        this.assistidas = assistidas;
    }

    public List<String> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<String> interesses) {
        
       
this.interesses = interesses;
    }

    
    }

public List<String> getAvaliacoes() {
        
       
return avaliacoes;
    }

    public void setAvaliacoes(List<String> avaliacoes) {
        
       
this.avaliacoes = avaliacoes;
    }

    public int getQtdAvaliacoesMes() {
        
       
return qtdAvaliacoesMes;
    }

    
    }
   
public

/* Classe que implementa series e filmes */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum Genero {
    ACAO,
    AVENTURA,
    COMEDIA,
    DRAMA,
    FANTASIA,
    FICCAO_CIENTIFICA,
    SUSPENSE,
    TERROR
}


    ACAO,
    AVENTURA,
    COMEDIA,
    DRAMA,
    FANTASIA,
    FICCAO_CIENTIFICA,
    SUSPENSE,
   

    ACAO,
    AVENTURA,
    COMEDIA,
    DRAMA,
    FANTASIA,
    FIC

    ACAO,
    AVENTURA,
    COMEDIA,
    DRAMA,
    FANTASIA,

    ACAO,
    AVENTURA,
    COMEDIA,
    DRAMA,
   

    ACAO,
    AVENTURA,
    COMEDIA,
    DRAMA,

    ACAO,
    AVENTURA,
   

    ACAO,
   

    ACAO,
public abstract class Midia {
    
private String nome;
      
private Genero genero;
    private String idioma;
    
   
private int quantidadeReproducoes;
    
   
private List<String> generos;
    
   
private List<String> idiomas;
    
   
private BigDecimal avaliacaoMedia;
    
   
private Map<String, BigDecimal> avaliacoes;
    private boolean lancamento;  


public Midia(String nome, Genero genero, String idioma, boolean lancamento) {
        this.nome = nome;
        
       
this.genero = genero;
        
       
this.idioma = idioma;
        
       
this.quantidadeReproducoes = 0;
        
       
this.generos = new ArrayList<>();
        this.idiomas = new ArrayList<>();
        
       
this.avaliacaoMedia = BigDecimal.ZERO;
        this.avaliacoes = new HashMap<>();
        this.lancamento = lancamento;
    }

    
    }

   
public void incrementarReproducoes() {
        quantidadeReproducoes++;
    }

    
        quantidadeReproducoes++;
    }

   

       
public String convertToString() {
        
       
return "Nome: " + nome +
                
               
"\nGênero: " + genero +
                
               
"\nIdioma: " + idioma +
                
               
"\nQuantidade de Reproduções: " + quantidadeReproducoes +
                
               
"\nGêneros: " + generos +
                
               
"\nIdiomas: " + idiomas +
                "\nAvaliação Média: " + avaliacaoMedia +
                
               
"\nAvaliações: " + avaliacoes +
                "\nLançamento: " + lancamento;
    }

    public String getChave() {
        return nome + "-" + genero;
    }

    
    }

   
public void avaliar(int nota, String login, String comentario) {
        
       
BigDecimal notaDecimal = BigDecimal.valueOf(nota);
        avaliacoes.put(login, notaDecimal);
        atualizarAvaliacaoMedia();
    }

    
        avaliacoes.put(login, notaDecimal);
        atualizarAvaliacaoMedia();
    }


        avaliacoes.put(login, notaDecimal

        aval
public void calcularAvaliacaoMedia() {
        if (avaliacoes.isEmpty()) {
            avaliacaoMedia = BigDecimal.ZERO;
        } 
            avaliacaoMedia = BigDecimal.ZERO;
        }

            avaliacao
else {
            BigDecimal somaAvaliacoes = BigDecimal.ZERO;
            
           
for (BigDecimal nota : avaliacoes.values()) {
                somaAvaliacoes = somaAvaliacoes.add(nota);
            }
            avaliacaoMedia = somaAvaliacoes.divide(BigDecimal.valueOf(avaliacoes.size()), 
                somaAvaliacoes = somaAvaliacoes.add(nota);
            }
            avaliacaoMedia = somaAvaliacoes.divide(BigDecimal.valueOf(avaliacoes.size()),

                somaAvaliacoes = somaAvaliacoes.add(nota);
            }
            avaliacaoMedia = somaAvaliacoes.divide(BigDecimal.valueOf(avali

                somaAvaliacoes = somaAvaliacoes.add(nota);
            }
            avaliacaoMedia = somaAvaliac

                somaAvaliacoes = somaAvaliacoes.add(nota);
            }
            avaliacaoMedia

                somaAvaliacoes = somaAvaliacoes.add(nota);
            }
            aval

                somaAvaliacoes = somaAvaliacoes.add(nota);
            }
           

                somaAvaliacoes = somaAvaliacoes.add(nota);
            }

                somaAvaliacoes = somaAvaliacoes

                somaAvaliacoes

                soma
2, BigDecimal.ROUND_HALF_UP);
        }
    }

    
        }
    }

   

        }
    }

// Métodos getters e setters
   
public String getNome() {
        
       
return nome;
    }

    
    }

    }

public void setNome(String nome) {
        
       
this.nome = nome;
    }

    
    }

    }

public Genero getGenero() {
        return genero;
    }

    }

public void setGenero(Genero genero) {
        
       
this.genero = genero;
    }

    
    }

public String getIdioma() {
        return idioma;
    }

    
    }


   
public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    
    }

public int getQuantidadeReproducoes() {
        return quantidadeReproducoes;
    }

    public void setQuantidadeReproducoes(int quantidadeReproducoes) {
        
       
this.quantidadeReproducoes = quantidadeReproducoes;
    }

    }

public List<String> get

/* Classe para salvar dados*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerenciadorDados {
    private List<Cliente> clientes;
    private List<Filme> filmes;
    
   
private List<Serie> series;

    

public GerenciadorDados() {
        this.clientes = new ArrayList<>();
        this.filmes = new ArrayList<>();
        this.series = new ArrayList<>();
    }

    
    }

public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    
        clientes.add(client

        clientes
public void adicionarFilme(Filme filme) {
        filmes.add(filme);
    }

    
        filmes.add

        filmes
public void adicionarSerie(Serie serie) {
        series.add(serie);
    }

    
        series
public void salvarDados() {
        // Implemente aqui a lógica para salvar os dados em um arquivo, banco de dados ou qualquer outra forma de persistência
        System.out.println(
       
"Dados salvos com sucesso.");
    }

    
   
public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public List<Serie> getSeries() {
        return series;
    }

    
   
public static void main(String[] args) {
        // Exemplo de uso do GerenciadorDados

        

        Gerenciador


        Gerenci
GerenciadorDados gerenciador = new GerenciadorDados();

        // Criando objetos Cliente
        
       
Cliente cliente1 = new Cliente("cliente1", "senha1");
        
        Cliente cliente2

        Cliente
Cliente cliente2 = new Cliente("cliente2", "senha2");

        

       
// Adicionando clientes ao gerenciador
        gerenciador.adicionarCliente(cliente1);
        gerenciador.adicionarCliente(cliente2);

        
        gerenciador.adicionarCliente(cliente1);
        gerenciador.adicionarCliente(client

        gerenciador.adicionarCliente(cliente1);
        gerenciador.adicionar

        gerenciador.adicionarCliente(cliente1);
       

        gerenciador.adicionarCliente(cliente1);

        gerenciador.adicionarCliente(client
// Criando objetos Filme
        
       
Filme filme1 = new Filme("Filme 1", Genero.ACAO, "Português", true);
        Filme filme2 = new Filme("Filme 2", Genero.COMEDIA, "Inglês", false);

        

// Adicionando filmes ao gerenciador
        gerenciador.adicionarFilme(filme1);
        gerenciador.adicionarFilme(filme2);

        
        gerenciador.adicionarFilme(filme1);
        gerenciador.adicionarFilme(filme2);

       

        gerenciador.adicionarFilme(filme1);
        gerenciador.adicionarFilme

        gerenciador.adicionarFilme(filme1);
        gerenci

        gerenciador
// Criando objetos Série
        
       
Serie serie1 = new Serie("Série 1", Genero.DRAMA, "Português", true);
        
        Serie serie

       
Serie serie2 = new Serie("Série 2", Genero.FANTASIA, "Espanhol", false);

        // Adicionando séries ao gerenciador
        gerenciador.adicionarSerie(serie1);
        gerenciador.adicionarSerie(serie2);

        
        gerenciador.adicionarSerie(

        gerenci
// Salvando os dados
        gerenciador.salvarDados();
    }
}

        gerenciador.salvarDados
