import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.time.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.InputMismatchException;


public class Mobilidade {

    public Mobilidade(){}

   public static void main(String[] args) {

       ArrayList<String> listafaculdades = new ArrayList<>();

       Scanner sc = new Scanner(System.in);
       Boolean condicao = true;

       while(condicao) {
           System.out.println("1- Carregar Utilizador | 2 - Carregar veiculo | 3- Carregar Aluguer | 4- Criar Aluguer | 5- Listar Alugueres | 6- Terminar");

           int opc_principal ;
           try{
               opc_principal = sc.nextInt();
           }catch(InputMismatchException e){
               System.out.println("ERRO : Insira um numero valido ");
               sc.nextLine();
               continue;
           }
           sc.nextLine();

           File arq = new File("utilizadores.txt");
           File arq_veiculo = new File("veiculos.txt");
           switch (opc_principal) {

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



                       } catch (FileNotFoundException ex) {
                           System.out.println("Erro ao Abrir Ficheiro de texto Utilizador!");
                       } catch (IOException ex) {
                           System.out.println("Erro ao Ler Ficheiro de texto Utilizador!");
                       }
                   } else {
                       System.out.println("Nenhum arquivo Utilizador encontrado!");
                   }
                   break;


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
                   break;
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
                   break;


               case 4:

                   //Criar aluguer: aplicação deve solicitar o número mecanográfico do utilizador, o ID do
                   //veículo e os restantes dados do aluguer. No final, deve apresentar um resumo do aluguer,
                   //  incluindo o custo.
                   //Um aluguer associa um utilizador a um veículo, incluindo a data e hora de início e a
                   //data e hora de fim do aluguer.



                   try {
                       Aluguer a1 = new Aluguer();
                       Utilizador u = null;
                       //  while(opc){
                       System.out.println("Diga se é | 1 - Estudante | 2- Funcionário :\n");
                       int opcao = sc.nextInt();
                       sc.nextLine(); //limpar buffer
                       if (opcao == 1) {
                           Estudante estudante = new Estudante();
                           u = estudante;
                           System.out.println("Diga o seu Curso Frequentado : \n");
                           String curso = sc.nextLine();
                           ((Estudante) u).setCursoMatriculado(curso);
                           System.out.println("Diga o seu Polo Frequentado : \n");
                           String polo = sc.nextLine();
                           ((Estudante) u).setPoloMfrequentado(polo);
                       } else if (opcao == 2) {
                           System.out.println(" Diga se é |1 - Nao Docente | 2- Docente\n");
                           int opcao2 = sc.nextInt();
                           sc.nextLine();

                           if (opcao2 == 1) {
                               Ndocente ndocente = new Ndocente();
                               u = ndocente;
                               System.out.println("Diga o Ano em que o Contrato Expira : \n");
                               int contrato = sc.nextInt();
                               sc.nextLine();
                               ((Ndocente) u).setAnoContrato(contrato);
                               System.out.println("Diga  o Servico em que Frequenta : \n");
                               String servico = sc.nextLine();
                               ((Ndocente) u).setServico(servico);

                           } else if (opcao2 == 2) {
                               Docente docente = new Docente();
                               u = docente;
                               boolean op = true;
                               while (op) { // While para preencher veiculoalugado Lista de Faculades
                                   System.out.println("Diga as faculdades em que Leciona :  | 1 - Adicionar | 2 - Concluido |");
                                   String in2 = sc.nextLine();
                                   if (in2.equals("1")) {
                                       String f = sc.nextLine();
                                       ((Docente) u).listaFaculdades.add(f);

                                   } else if (in2.equals("2")) {
                                       op = false;
                                   } else {
                                       System.out.println("Opcao Invalida . \n ");

                                   }
                               }

                           } else {
                               System.out.println("Opcao invalida");
                               //opc = false;
                           }
                       }

                       if (u == null){
                           System.out.println("Erro na criacao do utilizador!. A voltar ao menu");
                           break;
                       }

                       System.out.println("Diga o seu Nome : \n");
                       u.setNome(sc.nextLine());
                       System.out.println("Diga o seu  numero mecanográfico : \n");
                       u.setId(sc.nextInt());
                       sc.nextLine();
                       System.out.println("Diga o seu metodo de pagamento : |1 - Cartao | 2- Referecia Multibanco | \n");
                       int pag = sc.nextInt();
                       if (pag == 1) {
                           u.setMetodopagamento("Cartao");
                       } else {
                           u.setMetodopagamento("Referencia Multibanco");
                       }


                       System.out.println("Diga o tipo de veiculo: | 1 - Bicicleta | 2 - Trotinete | 3 - Ebike \n");
                       int v_tipo = sc.nextInt();

                       VeiculoDeAluguer veiculoalugado = null;
                       if (v_tipo == 1) {
                           Bicicleta b = new Bicicleta();
                           veiculoalugado = b;
                           System.out.println("Diga o numero de assentos 1 - Um Assento | 2 - Dois Assentos  ");
                           int opc_assento = sc.nextInt();
                           sc.nextLine();

                           boolean assento;
                           if (opc_assento == 1) {
                               assento = true;
                           } else {
                               assento = false;
                           }
                           ((Bicicleta) veiculoalugado).setassentos(assento);

                       } else if (v_tipo == 2) {
                           Trotinete trotinete = new Trotinete();
                           veiculoalugado = trotinete;
                           System.out.println("Diga o tipo de LCD |1- LCD C MAPA | 2- LCD S MAPA |");
                           int opc_lcd = sc.nextInt();
                           sc.nextLine();
                           boolean lcd;
                           if (opc_lcd == 1) {
                               lcd = true;
                           } else {
                               lcd = false;
                           }


                       } else if (v_tipo == 3) {
                           Ebike bike = new Ebike();
                           veiculoalugado = bike;
                           System.out.println("Diga o tipo de bateria | 1 - Removivel | 2 - Fixa ");
                           int opc_bateria = sc.nextInt();

                           boolean tipobateria;
                           if (opc_bateria == 1) {
                               tipobateria = true;

                           } else {
                               tipobateria = false;
                           }
                           bike.setBateriaRemovivel(tipobateria);
                       }
                       if(veiculoalugado == null){
                           System.out.println("Veiculo Invalido ! Cancelando");
                           break;
                       }
                       System.out.println("Diga o id do veiculo  : \n");
                       int id_vc = sc.nextInt();
                       sc.nextLine();
                       veiculoalugado.setIdentificador(id_vc);


                       System.out.println("Diga data DIA|MES|ANO e hora e minuto de inicio: \n");
                       int dia = sc.nextInt();
                       int mes = sc.nextInt();
                       int ano = sc.nextInt();
                       int hora = sc.nextInt();
                       int minuto = sc.nextInt();


                       LocalDateTime data_inicio = LocalDateTime.of(ano, mes, dia, hora, minuto);
                       a1.setInicio(data_inicio);

                       System.out.println("Diga data DIA|MES|ANO e hora e minuto de fim: \n");
                       int dia_fim = sc.nextInt();
                       int mes_fim = sc.nextInt();
                       int ano_fim = sc.nextInt();
                       int hora_fim = sc.nextInt();
                       int minuto_fim = sc.nextInt();

                       LocalDateTime data_fim = LocalDateTime.of(ano_fim, mes_fim, dia_fim, hora_fim, minuto_fim);
                       a1.setFim(data_fim);
                       double precoHora = veiculoalugado.precoPara(u);
                       double totalAluguer = a1.valorTotalAluguer(veiculoalugado,u);
                       System.out.println("Preco por hora da viagem : " + precoHora + "€" + "\n" + "Valor Total do Aluguer : " + " " + totalAluguer + "€");
                       System.out.println("Informacao do Utilizador : ");
                       // u.preencherDadosEspecificos(sc);
                       System.out.println(u);

                       // PREENCHER ALUGUERES.txt
                       File f= new File("C:/Users/Administrador/Downloads/JAVA/alugueres.txt");
                       try (FileWriter fw = new FileWriter(f,true);
                            BufferedWriter bw = new BufferedWriter(fw)) {

                           bw.write("======================================");
                            bw.newLine();
                            bw.write("Novo Aluguer");
                            bw.newLine();
                            bw.write("Data-Hora de registo " +LocalDateTime.now());
                            bw.newLine();
                           // Utilizador

                            bw.write("Utilizador :");
                            bw.newLine();
                            bw.write("Nome :"+u.getNome());
                            bw.newLine();
                            bw.write("Nº Mecanográfico:"+u.getId());
                            bw.newLine();
                            bw.write("Metodo de Pagamento : "+ u.getMetodopagamento());
                            bw.newLine();
                            bw.write("Dados Especificos"+u.toString());
                            bw.newLine();

                           // Veiculo
                            bw.write("Veiculo");
                            bw.newLine();
                            bw.write("Identificador do Veiculo  "+veiculoalugado.getIdentificador());
                            bw.newLine();
                            bw.write("Preco Por Hora : "+precoHora +"€");
                            bw.newLine();

                           // Aluguer
                            bw.write("Aluguer");
                            bw.write("Inicio de Aluguer : "+a1.getinicio());
                            bw.write("Fim de Aluguer : "+a1.getFim());
                       bw.write("Valor Total do ALuguer :  "+totalAluguer +"€");
                            bw.write("================================================");
                            bw.newLine();
                       }catch (IOException e){
                           System.out.println("erro ao escrever o ficherio");

                       }

                   }catch (InputMismatchException e) {
                       System.out.println("ERRO: Inseriu um valor Invalido . Tente novamente");
                   }catch(DateTimeException e){System.out.println("ERRO na Data/ Hora : " + e.getMessage());}break;

               case 5 :
                   //Listar alugueres: apresentar a lista de todos os alugueres com as principais características
                   //de cada um e o respetivo custo. No final, apresentar o valor total dos alugueres.


           }
           //}
       }

   }}
