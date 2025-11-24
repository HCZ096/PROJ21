import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;

public class Mobilidade {

    public Mobilidade(){}

   public static void main(String[] args){

        ArrayList<String> listafaculdades = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Boolean condicao = true;
        while(condicao){
            System.out.println("1- Carregar Utilizador | 2 - Carregar veiculo | 3- Carregar Aluguer | 4- Criar Aluguer | 5- Listar Alugueres | 6- Terminar");
            int opc_principal = sc.nextInt();
            sc.nextLine();
            File arq = new File("utilizadores.txt");
            File arq_veiculo = new File("veiculos.txt");
        switch(opc_principal) {

            case 1:
                // ao iniciar, a aplicação deve carregar os utilizadores a partir de um
                //ficheiro de texto (utilizadores.txt)
                if (arq.exists() && arq.isFile()) {
                    try {
                        FileReader arq1 = new FileReader(arq);
                        BufferedReader br = new BufferedReader(arq1);
                        String line;
                        while ((line = br.readLine()) != null)
                            System.out.println(line);
                        br.close();
                    } catch (FileNotFoundException ex) {
                        System.out.println("Erro ao Abrir Ficheiro de texto Utilizador!");
                    } catch (IOException ex) {
                        System.out.println("Erro ao Ler Ficheiro de texto Utilizador!");
                    }
                } else {
                    System.out.println("Nenhum arquivo Utilizador encontrado!");
                }


            case 2:
                // ao iniciar, a aplicação deve carregar os veículos a partir de um ficheiro
                //de texto (veículos.txt)
                if (arq_veiculo.exists() && arq_veiculo.isFile()) {
                    try {
                        FileReader arq1 = new FileReader(arq_veiculo);
                        BufferedReader br1 = new BufferedReader(arq1);
                        String line;
                        while ((line = br1.readLine()) != null)
                            System.out.println(line);
                        br1.close();
                    } catch (FileNotFoundException ex) {
                        System.out.println("Erro ao Abrir Ficheiro de texto veiculos!");
                    } catch (IOException ex) {
                        System.out.println("Erro ao Ler Ficheiro de texto veiculos!");
                    }
                } else {
                    System.out.println("Nenhum arquivo veiculos encontrado!");
                }
            case 3:
                //ao iniciar, a aplicação deve carregar os alugueres a partir de um
                //ficheiro de objetos (alugueres.obj), caso exista
                File f_veiculo = new File("veiculos.obj");

                try {
                    FileInputStream fis = new FileInputStream(f_veiculo);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Aluguer a = (Aluguer) ois.readObject();
                    System.out.println(a);
                    ois.close();
                } catch (FileNotFoundException ex1) {
                    System.out.println("Erro a abrir ficheiro");
                } catch (IOException ex1) {
                    System.out.println("Erro a ler ficheio");
                } catch (ClassNotFoundException ex1) {
                    System.out.println("Erro a converter ficheiro");
                }


            case 4:

                //Criar aluguer: aplicação deve solicitar o número mecanográfico do utilizador, o ID do
                //veículo e os restantes dados do aluguer. No final, deve apresentar um resumo do aluguer,
                //  incluindo o custo.
                //Um aluguer associa um utilizador a um veículo, incluindo a data e hora de início e a
                //data e hora de fim do aluguer.



                Ndocente u = new Ndocente("SHAYRON",2021243489,2030,"capacete");
                //Aluguer a = new Aluguer("19:30","18:30");
                Ebike v = new Ebike (20,false);

                LocalDateTime inicio = LocalDateTime.now();
                LocalDateTime fim = LocalDateTime.now().plusHours(2);
                System.out.println(v);
                System.out.println(u);
                Aluguer aluguer = new Aluguer(v,u,fim,inicio);
                double custo = aluguer.valorTotalAluguer(v,u);
                System.out.println("Custo Total da Viagem : " + custo);




                //                Utilizador u = null;
               // System.out.println("Diga se é | 1 - Estudante | 2- Funcionário :\n");
               // int opcao = sc.nextInt();
                //sc.nextLine(); //limpar buffer
//                if (opcao == 1) {
//                    u = new Estudante();
//                } else {
//                    System.out.println(" Diga se é |1 - Nao Docente | 2- Docente\n");
//                    int opcao2 = sc.nextInt();
//                    sc.nextLine();
//                    if (opcao2 == 1) {
//                        u = new Ndocente();
//                    } else {
//                        u = new Docente();
//                    }
//
//                }
//                VeiculoDeAluguer a = null;
//                System.out.println("Diga o seu Nome : \n");
//                u.setNome(sc.nextLine());
//                System.out.println("Diga o seu  numero mecanográfico : \n");
//                u.setId(sc.nextInt());
//                sc.nextLine();
//                System.out.println("Diga o tipo de veiculo: | 1 - Bicicleta | 2 - Trotinete | 3 - Ebike \n");
//                int v_tipo = sc.nextInt();
//                if (v_tipo == 1) {
//
//                    System.out.println("Diga o numero de assentos ");
//                    int  v_assento = sc.nextInt();
//                    sc.nextLine();
//                    a = new Bicicleta(v_assento,);
//
//                } else if (v_tipo == 2) {
//                    a = new Trotinete();
//                } else if (v_tipo == 3) {
//                    a = new Ebike();
//                }
//                System.out.println("Diga o id do veiculo  : \n");
//                int id_vc = sc.nextInt();
//                sc.nextLine();
//                a.setIdentificador(id_vc);
//                System.out.println("Diga hora inicio : \n");
//                int h = sc.nextInt();
//                int m = sc.nextInt();
//
//                Aluguer a1 = new Aluguer();
//
//                LocalTime horainicio;
//                horainicio = LocalTime.of(h, m);
//                a1.setDatainicio(horainicio);
//
//                System.out.println("Diga hora final : \n");
//                h = sc.nextInt();
//                m = sc.nextInt();
//
//                LocalTime horafinal;
//                horafinal = LocalTime.of(h, m);
//                a1.setDatafim(horafinal);
//
//                Bicicleta b = new Bicicleta();//teste
//                b.setDuaspessoas(false);
//                Duration tempoTotalAluguer = Duration.between(horafinal, horainicio);
//                double custo = a1.valorTotalAluguer();
//
//                System.out.println("preco por hora da viagem : " + b.precoPorHora(u)+ " " + "valor total do aluguer" + " " + a1.valorTotalAluguer(u,b));
//                System.out.println("Informacao do Utilizador : ");
//                u.preencherDadosEspecificos(sc);
//                System.out.println(u);
//
//
//printTESTE
// no ato de decidir qual veiculo o utilizador escolheu;'

//                 System.out.println("Diga o tipo de veicuilo: | 1 - Bicicleta | 2 - Trotinete | 3 - Ebike \n");
//                String tipo = sc.nextLine();

//                if(tipo.equals("1")){
//                 Bicicleta bicicleta = new Bicicleta();
//                 System.out.println("Diga a numero de lugares da Bicicleta : | 1 - 1 Lugar | 2 - 2 Lugares \n");
//                String opcao1 =  sc.nextLine();

//                 if("1".equals(opcao1)){
//                    bicicleta.setDuaspessoas(false);
//                 associar o objeto bicicleta a bicicleta com duas lugares

//                  }else if("2".equals(opcao1)){
//                bicicleta.setDuaspessoas(true);
//                  }
//                System.out.println("Nr de Lugares da Bicicleta Alugada : " + bicicleta.getDuaspessoas());

//                  }else {
//                    System.out.println("Opcao Invalida . \n ");
//                   condicao= false;}

//System.out.println("O preco da viagem ");}


//        }
//



//}
//
//}}
        }}}}