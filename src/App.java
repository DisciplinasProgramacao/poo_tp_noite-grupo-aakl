import java.util.*;

public class App {
    public static Scanner sc = new Scanner(System.in);
    private static Streaming plataforma;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        plataforma = new Streaming();
        int operacao;
        autenticacao();

        do{
            operacao = menu();
            executaOpcao(operacao);
        }while(operacao != 0);
        
   
        
    }

    private static void executaOpcao(int opcao) {

        switch(opcao) {
            case 1:
            addMidiaAlista(true);
                break;

            case 2: 
            addMidiaAlista(true);
                break;

            case 3: 
            buscarMidiaNaLista(true);
            break;

            case 4: 
            buscarMidiaNaLista(false);
            break;


        }
    }

    private static void buscarMidiaNaLista(boolean ehAssistida) {
        limpaBuffer();
        System.out.println("Informe o nome da mídia: ");
        String midia = sc.nextLine();
        try {
                Midia midiaSelecionada = plataforma.buscaMidiaNalista(midia, ehAssistida);
                System.out.printf("Resultado: %s \n", midiaSelecionada.toString());
            
        } catch (Exception e) {
            System.out.printf("Erro: %s", e.getMessage());
        }
    }

    private static void limpaBuffer() {
        sc.nextLine();
    }

    private static void addMidiaAlista(boolean jaAssistida) {
        limpaBuffer();
        System.out.println("Informe o nome da mídia: ");
        String midia = sc.nextLine();
        try {
                plataforma.addMidiaAlista(midia, jaAssistida);
            
            System.out.println("Operação realizada com sucesso!");
        } catch (Exception e) {
            System.out.printf("Erro: %s", e.getMessage());
        }
        
    }



    private static int menu() {
        System.out.println("******* Plataforma Streaming *********");
        System.out.println("1. Adicionar mídia assistida");
        System.out.println("2. Adicionar mídia à lista de interesses");
        System.out.println("3. Buscar mídia assistida");
        System.out.println("4. Busca mídia na lista de interesse");

        return sc.nextInt();
    }

    public static void autenticacao() throws Exception {
        System.out.println("Informe o login: ");
        String login = sc.nextLine();
        System.out.println("Informe a senha: ");
        String senha = sc.nextLine();
        
        if(plataforma.autenticacao(login, senha)) {
            System.out.println("Login realizado com sucesso!");
        }
        else {
            throw new Exception("Usuário ou senha inválidos");
        }
    }
}
