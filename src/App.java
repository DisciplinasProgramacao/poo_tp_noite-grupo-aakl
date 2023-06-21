import java.util.*;
import java.util.concurrent.TimeUnit;

public class App {
    public static Scanner sc = new Scanner(System.in);
    private static Streaming plataforma;

    /**
     * Método para "limpar" tela console
     */
    public static void limparTela() {

        // System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void timer(int segundos) throws Exception
    {
        TimeUnit.SECONDS.sleep(segundos);
    }
    public static void main(String[] args) throws Exception {
        limparTela();
        plataforma = new Streaming();
        int operacao;
        autenticacao();

            limparTela();
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

            case 5: 
                limparTela();
                avaliarMidia();
            break;

            case 6:
            plataforma.relatoriosGerenciais();
            break;

            case 7:
            exibirListaMidia(true);
            break;

            case 8:
            exibirListaMidia(false);
            break;
        }
    }

    private static void avaliarMidia() {
        System.out.println("Informe o nome da mídia: ");
        String midia = sc.nextLine();
        try {
                Midia midiaSelecionada = plataforma.buscaMidiaNalista(midia, true);
                plataforma.avaliar(midiaSelecionada);
                System.out.println("Mídia avaliada com sucesso!");
            
        } catch (Exception e) {
            System.out.printf("Erro: %s", e.getMessage());
        }
    }

    private static void buscarMidiaNaLista(boolean ehAssistida) {
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
        try {
            int op = -1;
            do {
                System.out.println("******* Plataforma Streaming *********");
                System.out.println("1. Adicionar mídia assistida");
                System.out.println("2. Adicionar mídia à lista de interesses");
                System.out.println("3. Buscar mídia assistida");
                System.out.println("4. Busca mídia na lista de interesse");
                System.out.println("5. Avaliar");
                System.out.println("6. Relatórios Gerenciais");
                System.out.println("7. Exibir midias assistidas");
                System.out.println("8. Exibir midias de interesse");
                System.out.println("0. Sair");
                op = Integer.parseInt(sc.nextLine());

                if(op < 0 || op > 8)
                {
                    limparTela();
                    System.out.println("Opção informada não existe. Tente novamente");
                    timer(2);
                }

            } while (op < 0 || op > 8);
        
            return op;
        } catch (Exception e) {
            System.out.println("A opção '" + sc + "' não existe");
           return -1;
        }
    }

    public static void autenticacao() throws Exception {
        limparTela();
        System.out.print("Informe o login: ");
        String login = sc.nextLine();
        System.out.print("Informe a senha: ");
        String senha = sc.nextLine();
        
        if(plataforma.autenticacao(login, senha)) {
            System.out.println("Login realizado com sucesso!");
            return;
        }
        else {
            limparTela();
            System.out.println("Usuário ou senha inválidos. Tente novamente.");
            timer(2);
            autenticacao();
        }
    }

    private static void exibirListaMidia(boolean listaAssistida) {
        List<String> midias = plataforma.exibirListaMidia(listaAssistida);
        if(listaAssistida) {
            System.out.println("Midias assitidas: ");
        }
        else {
            System.out.println("Midias para assistir futuramente: ");
        }
        midias.forEach(midia -> System.out.printf("%s\n", midia));
    }
}
