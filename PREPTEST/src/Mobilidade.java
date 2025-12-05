import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

    public class Mobilidade {

         // Listas para armazenamento em memória
    private static ArrayList<Utilizador> listaUtilizadores = new ArrayList<>();
    private static ArrayList<VeiculoDeAluguer> listaVeiculos = new ArrayList<>();
    private static ArrayList<Aluguer> listaAlugueres = new ArrayList<>();

    private static Scanner sc = new Scanner(System.in);

         //Formatador de data para input/output
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void main(String[] args) {
        System.out.println("=== A INICIAR SISTEMA DE MOBILIDADE UC ===");

        //  Carregar dados iniciais
        carregarUtilizadores();
        carregarVeiculos();
        carregarAlugueres();

        boolean sair = false;

        // Loop do Menu Principal
        while (!sair) {
            System.out.println("\n################ MENU ################");
            System.out.println("1. Criar Aluguer");
            System.out.println("2. Listar Alugueres");
            System.out.println("3. Terminar e Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        criarAluguer();
                        break;
                    case 2:
                        listarAlugueres();
                        break;

                    case 3:
                        guardarAlugueres();
                        sair = true;
                        break;
                    default:
                        System.out.println("Opção invalida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Insira um número inteiro.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        sc.close();
        System.out.println("Aplicacao terminada com sucesso.");
    }


    // MÉTODOS DE LEITURA DE FICHEIROS (TXT e OBJ)



    private static void carregarUtilizadores() {
        File file = new File("C:\\Users\\Administrador\\Downloads\\JAVA\\utilizadores.txt");
        if (!file.exists()) {
            System.out.println("Aviso: Ficheiro 'utilizadores.txt' não encontrado.");
            return;
        }

        try {FileReader fr  = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;

                String[] dados = linha.split(";");

                try {
                    String tipo = dados[0].toUpperCase();
                    int id = Integer.parseInt(dados[1].trim());
                    String nome = dados[2].trim();
                    String pagamento = dados[3].trim();

                    Utilizador u = null;


                    switch (tipo) {
                        case "ESTUDANTE":
                            String curso = dados[4].trim();
                            String polo = dados[5].trim();
                            u = new Estudante(id, nome, pagamento, curso, polo);
                            break;
                        case "DOCENTE":
                            int anoContratoD = Integer.parseInt(dados[4].trim());

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

    private static void carregarVeiculos() {
        File file = new File("C:\\Users\\Administrador\\Downloads\\JAVA\\veiculos.txt");
        if (!file.exists()) {
            System.out.println("Aviso: Ficheiro 'veiculos.txt' não encontrado.");
            return;
        }

        try {FileReader fr  = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String linha;

            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;

                String[] dados = linha.split(";");
                try {
                    String tipo = dados[0].toUpperCase();
                    int id = Integer.parseInt(dados[1].trim());
                    String gps = dados[2].trim();

                    VeiculoDeAluguer v = null;

                    switch (tipo) {
                        case "BICICLETA":
                            boolean lugares = Boolean.parseBoolean(dados[3].trim());
                            v = new Bicicleta(id, gps, lugares);
                            break;
                        case "TROTINETE":
                            int bateriaT = Integer.parseInt(dados[3].trim());
                            boolean temLCD = Boolean.parseBoolean(dados[4].trim());
                            v = new Trotinete(id, gps, bateriaT, temLCD);
                            break;
                        case "EBIKE":
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



    private static void carregarAlugueres() {
        File file = new File("C:\\Users\\Administrador\\Downloads\\JAVA\\alugueres.obj");
        if (!file.exists()) return;

        try {FileInputStream fos = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fos);

            listaAlugueres = (ArrayList<Aluguer>) ois.readObject();
            System.out.println("Histórico de alugueres carregado: " + listaAlugueres.size());
        } catch (IOException  e) {
            System.out.println("Erro ao carregar ficheiro de objetos" + ": " + e.getMessage());
        }catch (ClassNotFoundException e ){System.out.println("Erro nas Classes");}
    }


    // MÉTODOS DE LÓGICA DO MENU

    private static void criarAluguer() {
        System.out.println("\n--- NOVO ALUGUER ---");


        Utilizador u = null;
        while (u == null) {
            System.out.print("Insira o Nº Mecanográfico do Utilizador (ou 0 para cancelar): ");
            int idU = sc.nextInt();
            if (idU == 0) return;
            u = procurarUtilizador(idU);
            if (u == null) System.out.println("Utilizador não encontrado.");
        }
        System.out.println("Utilizador selecionado: " + u.getNome());


        VeiculoDeAluguer v = null;
        while (v == null) {
            System.out.print("Insira o ID do Veículo (ou 0 para cancelar): ");
            int idV = sc.nextInt();
            if (idV == 0) return;
            v = procurarVeiculo(idV);
            if (v == null) System.out.println("Veículo não encontrado.");
        }
        sc.nextLine();


        LocalDateTime inicio = lerData("Data de Início (dd/MM/yyyy HH:mm): ");
        LocalDateTime fim = lerData("Data de Fim (dd/MM/yyyy HH:mm): ");

        if (fim.isBefore(inicio)) {
            System.out.println("Erro: A data de fim tem de ser posterior a de início.");
            return;
        }


        System.out.print("Incluir Capacete? (S/N): ");
        boolean capacete = sc.nextLine().trim().equalsIgnoreCase("S");

        System.out.print("Incluir Luz? (S/N): ");
        boolean luz = sc.nextLine().trim().equalsIgnoreCase("S");

        Aluguer novoAluguer = new Aluguer(u, v, inicio, fim, capacete, luz);

        double custo = novoAluguer.calcularCusto();

        listaAlugueres.add(novoAluguer);

        System.out.println("\n=== RESUMO DO ALUGUER ===");
        System.out.println("Utilizador: " + u.getNome());
        System.out.println("Veículo:" + "(ID: " + v.getId() + ")");
        System.out.println("Duração: " + novoAluguer.getHoras().toHours() + " horas");
        System.out.printf("Custo Total: %.2f €\n", custo);
        System.out.println("=========================");
    }

    private static void listarAlugueres() {
        System.out.println("\n--- LISTA DE ALUGUERES ---");
        if (listaAlugueres.isEmpty()) {
            System.out.println("Não existem alugueres registados.");
            return;
        }

        double totalFaturado = 0.0;
        for (Aluguer a : listaAlugueres) {
            double custo = a.calcularCusto();
            System.out.println(a.toString());
            System.out.printf("Custo: " + custo + "€\n" );
            totalFaturado += custo;
            System.out.println("---------------------------");
        }
        System.out.println("---------------------------");
        System.out.printf("TOTAL FATURADO: %.2f €\n", totalFaturado);
        System.out.println("---------------------------");
    }

    private static void guardarAlugueres() {
        File file = new File("C:\\Users\\Administrador\\Downloads\\JAVA\\alugueres.obj");
        try {   FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos =  new ObjectOutputStream(fos);

            oos.writeObject(listaAlugueres);
            System.out.println("Alugueres exportados com sucesso para 'alugueres.obj'.");
        } catch (IOException e) {
            System.out.println("Erro ao guardar alugueres: " + e.getMessage());
        }
    }



    // METODOS AUXILIARES
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