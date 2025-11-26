import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;


public class Mobilidade {
    public static void main(String[] args) {
        Mobilidade mobilidade = new Mobilidade();
        Scanner sc = new Scanner(System.in);

        ArrayList<Utilizador> utilizadores = new ArrayList<>();

        int opcao;

        do {
            System.out.println("--- Bem vindo ao Mobilidade ---");
            System.out.println("#1. Adicionar Utilizador");
            System.out.println("#2. Criar um novo Aluguer");
            System.out.println("#3. Listar todos os Aluguers");
            System.out.println("#4. Carregar os utilizadores");
            System.out.println("#5. Carregar os veiculos do ficheiro");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("#2. 1-Estudante 2-Funcionario");
                    int entrada = sc.nextInt();
                    if (entrada == 1) {
                        System.out.println("1- Qual o seu nome?");
                        String nome = sc.next();
                        sc.nextLine();

                        System.out.println("2- Qual o seu numero de estudante?");
                        int numeroEstudante = sc.nextInt();
                        sc.nextLine();

                        System.out.println("3- Qual o seu curso?");
                        String curso = sc.nextLine();

                        System.out.println("4- Qual o seu polo mais frequente?");
                        String polo = sc.nextLine();

                        Estudante estudante = new Estudante(nome, numeroEstudante, curso, polo);
                        utilizadores.add(estudante);
                        System.out.println("Lista de utilizadores: " + utilizadores);
                        System.out.println(estudante);
                    }
                    break;

                case 2:
                    System.out.println("#3. Nome do utilizador? ");
                    String nome = sc.next();
                    sc.nextLine();

                    System.out.println("#4. Nome do veiculo? ");
                    String nomeVeiculo = sc.nextLine();

                    System.out.println("#5. Hora de inicio? ");
                    LocalTime horainicio = LocalTime.parse(sc.next());

                    System.out.println("#5. Hora de final? ");
                    LocalTime horafinal = LocalTime.parse(sc.next());

                    System.out.println("#6. Tem capacete extra? Sim ou Nao ");
                    String sim = sc.nextLine();
                    boolean capacete = sim.equalsIgnoreCase("Sim");

                    System.out.println("#7. Tem Luz extra? ");
                    String luzextra = sc.nextLine();
                    boolean luz = luzextra.equalsIgnoreCase("Sim");

                    System.out.println("#8. Qual o Metodo Pagamento?  1-Carta 2-Referencia Multibanco");
                    String metPag = sc.nextLine();
                    //if(metPag == "cartao") {System.out.println("Cartao");}
                    //if(metPag == "referencia") {System.out.println("Referencia");}

                    System.out.println("O valor total de aluguer será de:");
                    Aluguer a = new Aluguer(  , nomeVeiculo,horainicio,horafinal,capacete,luz,metPag);
                    }

                case 0:
                    System.out.println("Encerrando");
                    break;


                default:
                    System.out.println("Opcao invalida");
            }
        } while (opcao != 0);
        sc.close();
    }
}

