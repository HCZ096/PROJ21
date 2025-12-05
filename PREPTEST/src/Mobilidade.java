import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe principal do projeto Mobilidade UC.
 * Responsável por carregar dados, gerir menus e persistir informações.
 */
public class Mobilidade {

    // Listas para armazenamento em memória
    private static ArrayList<Utilizador> listaUtilizadores = new ArrayList<>();
    private static ArrayList<VeiculoDeAluguer> listaVeiculos = new ArrayList<>();
    private static ArrayList<Aluguer> listaAlugueres = new ArrayList<>();

    // Scanner global para leitura de dados
    private static Scanner sc = new Scanner(System.in);

    // Formatador de data para input/output
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void main(String[] args) {
        System.out.println("=== A INICIAR SISTEMA DE MOBILIDADE UC ===");

        // 1. Carregar dados iniciais (Requisitos Funcionais)
        carregarUtilizadores(); // [cite: 37]
        carregarVeiculos();     // [cite: 38]
        carregarAlugueres();    // [cite: 39]

        boolean sair = false;

        // Loop do Menu Principal
        while (!sair) {
            System.out.println("\n################ MENU ################");
            System.out.println("1. Criar Aluguer");
            System.out.println("2. Listar Alugueres");
            System.out.println("3. Listar Veículos Disponíveis (Extra)");
            System.out.println("4. Terminar e Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = sc.nextInt();
                sc.nextLine(); // Limpar buffer

                switch (opcao) {
                    case 1:
                        criarAluguer(); // [cite: 40, 41]
                        break;
                    case 2:
                        listarAlugueres(); // [cite: 42, 43]
                        break;
                    case 3:
                        listarVeiculos();
                        break;
                    case 4:
                        guardarAlugueres(); // [cite: 44]
                        sair = true;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor insira um número inteiro.");
                sc.nextLine(); // Limpar buffer
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }

        sc.close();
        System.out.println("Aplicação terminada com sucesso.");
    }

    // ==========================================================
    // MÉTODOS DE LEITURA DE FICHEIROS (TXT e OBJ)
    // ==========================================================

    /**
     * Carrega utilizadores a partir de 'utilizadores.txt'.
     * Formato esperado (exemplo): TIPO;ID;NOME;PAGAMENTO;EXTRA1;EXTRA2...
     */
    private static void carregarUtilizadores() {
        File file = new File("utilizadores.txt");
        if (!file.exists()) {
            System.out.println("Aviso: Ficheiro 'utilizadores.txt' não encontrado.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;

                String[] dados = linha.split(";");
                // Factory simples baseada no tipo de utilizador para evitar instanceof posterior
                // Assumindo estrutura: Tipo;Mecanografico;Nome;MetodoPagamento;...
                try {
                    String tipo = dados[0].toUpperCase();
                    int id = Integer.parseInt(dados[1].trim());
                    String nome = dados[2].trim();
                    String pagamento = dados[3].trim(); // "Cartão" ou "Multibanco" [cite: 20]

                    Utilizador u = null;

                    // Lógica de instanciação baseada no enunciado [cite: 21, 22]
                    switch (tipo) {
                        case "ESTUDANTE":
                            String curso = dados[4].trim();
                            String polo = dados[5].trim();
                            u = new Estudante(id, nome, pagamento, curso, polo);
                            break;
                        case "DOCENTE":
                            int anoContratoD = Integer.parseInt(dados[4].trim());
                            // Assumindo que faculdades vêm separadas por vírgula no campo 5
                            String faculdades = dados[5].trim();
                            u = new Docente(id, nome, pagamento, anoContratoD, faculdades);
                            break;
                        case "NAODOCENTE":
                            int anoContratoND = Integer.parseInt(dados[4].trim());
                            String servico = dados[5].trim();
                            u = new Ndocente(id, nome, pagamento, anoContratoND, servico);
                            break;
                        default:
                            System.out.println("Tipo de utilizador desconhecido: " + tipo);
                    }

                    if (u != null) {
                        listaUtilizadores.add(u);
                    }
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    System.out.println("Erro ao processar linha de utilizador: " + linha);
                }
            }
            System.out.println("Utilizadores carregados: " + listaUtilizadores.size());
        } catch (IOException e) {
            System.out.println("Erro ao ler ficheiro de utilizadores: " + e.getMessage());
        }
    }

    /**
     * Carrega veículos a partir de 'veiculos.txt'.
     * Formato esperado (exemplo): TIPO;ID;GPS;EXTRA...
     */
    private static void carregarVeiculos() {
        File file = new File("veiculos.txt");
        if (!file.exists()) {
            System.out.println("Aviso: Ficheiro 'veiculos.txt' não encontrado.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;

                String[] dados = linha.split(";");
                try {
                    String tipo = dados[0].toUpperCase();
                    int id = Integer.parseInt(dados[1].trim());
                    String gps = dados[2].trim(); // [cite: 16]

                    VeiculoDeAluguer v = null;

                    // Lógica de instanciação baseada no enunciado [cite: 17, 18, 19]
                    switch (tipo) {
                        case "BICICLETA":
                            // Campo extra: numero de lugares (1 ou 2)
                            int lugares = Integer.parseInt(dados[3].trim());
                            v = new Bicicleta(id, gps, lugares);
                            break;
                        case "TROTINETE":
                            // Campo extra: bateria, temLCD (true/false)
                            int bateriaT = Integer.parseInt(dados[3].trim());
                            boolean temLCD = Boolean.parseBoolean(dados[4].trim());
                            v = new Trotinete(id, gps, bateriaT, temLCD);
                            break;
                        case "EBIKE":
                            // Campo extra: bateria, bateriaRemovivel (true/false)
                            int bateriaE = Integer.parseInt(dados[3].trim());
                            boolean batRemovivel = Boolean.parseBoolean(dados[4].trim());
                            v = new Ebike(id, gps, bateriaE, batRemovivel);
                            break;
                    }

                    if (v != null) {
                        listaVeiculos.add(v);
                    }
                } catch (Exception e) {
                    System.out.println("Erro ao processar linha de veículo: " + linha);
                }
            }
            System.out.println("Veículos carregados: " + listaVeiculos.size());
        } catch (IOException e) {
            System.out.println("Erro ao ler ficheiro de veículos: " + e.getMessage());
        }
    }

    /**
     * Carrega alugueres do ficheiro de objetos se existir[cite: 39].
     */
    @SuppressWarnings("unchecked")
    private static void carregarAlugueres() {
        File file = new File("alugueres.obj");
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            listaAlugueres = (ArrayList<Aluguer>) ois.readObject();
            System.out.println("Histórico de alugueres carregado: " + listaAlugueres.size());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar ficheiro de objetos: " + e.getMessage());
        }
    }

    // ==========================================================
    // MÉTODOS DE LÓGICA DO MENU
    // ==========================================================

    /**
     * Lógica para criar um novo aluguer[cite: 40].
     * Solicita IDs, valida existência, pede datas e extras.
     */
    private static void criarAluguer() {
        System.out.println("\n--- NOVO ALUGUER ---");

        // 1. Identificar Utilizador
        Utilizador u = null;
        while (u == null) {
            System.out.print("Insira o Nº Mecanográfico do Utilizador (ou 0 para cancelar): ");
            int idU = sc.nextInt();
            if (idU == 0) return;
            u = procurarUtilizador(idU);
            if (u == null) System.out.println("Utilizador não encontrado.");
        }
        System.out.println("Utilizador selecionado: " + u.getNome());

        // 2. Identificar Veículo
        VeiculoDeAluguer v = null;
        while (v == null) {
            System.out.print("Insira o ID do Veículo (ou 0 para cancelar): ");
            int idV = sc.nextInt();
            if (idV == 0) return;
            v = procurarVeiculo(idV);
            if (v == null) System.out.println("Veículo não encontrado.");
        }
        // Nota: Num sistema real verificariamos se o veículo já está alugado nessas datas.

        sc.nextLine(); // Limpar buffer

        // 3. Datas
        LocalDateTime inicio = lerData("Data de Início (dd/MM/yyyy HH:mm): ");
        LocalDateTime fim = lerData("Data de Fim (dd/MM/yyyy HH:mm): ");

        if (fim.isBefore(inicio)) {
            System.out.println("Erro: A data de fim tem de ser posterior à de início.");
            return;
        }

        // 4. Extras [cite: 26, 30]
        System.out.print("Incluir Capacete? (S/N): ");
        boolean capacete = sc.nextLine().trim().equalsIgnoreCase("S");

        System.out.print("Incluir Luz? (S/N): ");
        boolean luz = sc.nextLine().trim().equalsIgnoreCase("S");

        // 5. Instanciar e Adicionar
        // Assumindo que a classe Aluguer recebe (Utilizador, Veiculo, Inicio, Fim, Capacete, Luz)
        Aluguer novoAluguer = new Aluguer(u, v, inicio, fim, capacete, luz);

        // Calcular custo (Polimorfismo deve ser usado aqui internamente no método calcularCusto)
        double custo = novoAluguer.calcularCusto(); // [cite: 41]

        listaAlugueres.add(novoAluguer);

        // 6. Resumo [cite: 41]
        System.out.println("\n=== RESUMO DO ALUGUER ===");
        System.out.println("Utilizador: " + u.getNome() + " (" + u.getClass().getSimpleName() + ")");
        System.out.println("Veículo: " + v.getClass().getSimpleName() + " (ID: " + v.getId() + ")");
        System.out.println("Duração: " + novoAluguer.getHoras() + " horas");
        System.out.printf("Custo Total: %.2f €\n", custo);
        System.out.println("=========================");
    }

    /**
     * Lista todos os alugueres e o valor total faturado[cite: 42, 43].
     */
    private static void listarAlugueres() {
        System.out.println("\n--- LISTA DE ALUGUERES ---");
        if (listaAlugueres.isEmpty()) {
            System.out.println("Não existem alugueres registados.");
            return;
        }

        double totalFaturado = 0.0;

        for (Aluguer a : listaAlugueres) {
            // Assume-se que Aluguer.toString() imprime as características principais
            System.out.println(a.toString());
            System.out.printf("Custo: %.2f €\n", a.calcularCusto());
            System.out.println("---------------------------");
            totalFaturado += a.valorTotalAluguer();
        }

        System.out.printf("\nTOTAL FATURADO: %.2f €\n", totalFaturado); // [cite: 43]
    }

    /**
     * Guarda a lista de alugueres num ficheiro de objetos[cite: 44].
     */
    private static void guardarAlugueres() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("alugueres.obj"))) {
            oos.writeObject(listaAlugueres);
            System.out.println("Alugueres exportados com sucesso para 'alugueres.obj'.");
        } catch (IOException e) {
            System.out.println("Erro ao guardar alugueres: " + e.getMessage());
        }
    }

    // ==========================================================
    // MÉTODOS AUXILIARES
    // ==========================================================

    private static Utilizador procurarUtilizador(int id) {
        for (Utilizador u : listaUtilizadores) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    private static VeiculoDeAluguer procurarVeiculo(int id) {
        for (VeiculoDeAluguer v : listaVeiculos) {
            if (v.getId() == id) return v;
        }
        return null;
    }

    private static void listarVeiculos() {
        for (VeiculoDeAluguer v : listaVeiculos) {
            System.out.println(v.toString());
        }
    }

    private static LocalDateTime lerData(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String input = sc.nextLine();
            try {
                return LocalDateTime.parse(input, FORMATO_DATA);
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Use dd/MM/yyyy HH:mm (Ex: 05/12/2025 14:30)");
            }
        }
    }
}