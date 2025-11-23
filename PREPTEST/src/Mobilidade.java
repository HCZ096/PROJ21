import javax.imageio.stream.FileImageInputStream;
import java.io.*;
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

            case 1 :
                // ao iniciar, a aplicação deve carregar os utilizadores a partir de um
                //ficheiro de texto (utilizadores.txt)
                if(arq.exists() && arq.isFile() ){
                    try {
                        FileReader arq1 = new FileReader(arq);
                        BufferedReader br = new BufferedReader(arq1);
                        String line;
                    while((line = br.readLine()) != null)
                        System.out.println(line);
                    br.close();
                    }catch (FileNotFoundException ex){
                        System.out.println("Erro ao Abrir Ficheiro de texto Utilizador!");
                    }catch (IOException ex){
                        System.out.println("Erro ao Ler Ficheiro de texto Utilizador!");}
                }else{
                        System.out.println("Nenhum arquivo Utilizador encontrado!");}


            case 2 :
            // ao iniciar, a aplicação deve carregar os veículos a partir de um ficheiro
                //de texto (veículos.txt)
                if(arq_veiculo.exists() && arq_veiculo.isFile() ){
                    try {
                        FileReader arq1 = new FileReader(arq_veiculo);
                        BufferedReader br1 = new BufferedReader(arq1);
                        String line;
                        while((line = br1.readLine()) != null)
                            System.out.println(line);
                        br1.close();
                    }catch (FileNotFoundException ex){
                                System.out.println("Erro ao Abrir Ficheiro de texto veiculos!");
                    }catch(IOException ex){
                                        System.out.println("Erro ao Ler Ficheiro de texto veiculos!");}
                } else{
                    System.out.println("Nenhum arquivo veiculos encontrado!");}
            case 3 :
                    //ao iniciar, a aplicação deve carregar os alugueres a partir de um
                    //ficheiro de objetos (alugueres.obj), caso exista
                    File f_veiculo = new File("veiculos.obj");

                    try{
                        FileInputStream fis = new FileInputStream(f_veiculo);
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        Aluguer a = (Aluguer)ois.readObject();
                        System.out.println(a);
                        ois.close();
                    } catch (FileNotFoundException ex1) {
                        System.out.println("Erro a abrir ficheiro");
                    } catch (IOException ex1) {
                        System.out.println("Erro a ler ficheio");
                    }catch (ClassNotFoundException ex1) {
                        System.out.println("Erro a converter ficheiro");}




            case 4 :
                //Criar aluguer: aplicação deve solicitar o número mecanográfico do utilizador, o ID do
                //veículo e os restantes dados do aluguer. No final, deve apresentar um resumo do aluguer,
                //  incluindo o custo.
                    System.out.println("Diga se é | 1 - Estudante | 2- Funcionário :\n");
                    int opcao = sc.nextInt();
                    if (opcao == 1){
                       // Estudante estudante = new Estudante();


                    }else{
                        System.out.println(" Diga se é |1 - Nao Docente | 2- Docente\n");
                        int opcao2 = sc.nextInt();
                        if (opcao2 == 1){
                          //  Ndocente ndocente = new Ndocente();
                        }else{
                            //Docente docente = new Docente();
                        }

                    }
                    Aluguer a = new Aluguer();


                    System.out.println("Diga o seu  numero mecanográfico : \n");
                    int nrmec = sc.nextInt();
                    //u.setId(nrmec);
                    System.out.println("Diga o id do veiculo  : \n");
                    int id_vc = sc.nextInt();
                    //a.setIdentificador();
                    System.out.println("Diga hora inicio : \n");
                    int h = sc.nextInt();
                    int m = sc.nextInt();

                    LocalTime horainicio;
                    horainicio = LocalTime.of(h,m);

                    System.out.println("Diga hora final : \n");
                    h = sc.nextInt();
                    m = sc.nextInt();
                    LocalTime horafinal;
                    horafinal = LocalTime.of(h,m);



                    System.out.println("Informacao do Utilizador : ");
                System.out.println("Diga a seu cargo naqiu UC : 1 - Estudante | 2 - Funcionario");
                String info = sc.nextLine();


                if (info.equals("1")) {
                    System.out.println("Diga o seu Nome : \n");
                    String nome = sc.nextLine();
                    System.out.println("Diga o seu Curso Frequentado : \n");
                    String curso = sc.nextLine();
                    System.out.println("Diga o seu Polo Frequentado : \n");
                    String polo = sc.nextLine();
                    //Estudante estudante = new Estudante(nome, nrmec, curso, polo);
                } else if (info.equals("2")) {
                    System.out.println("1 - Docente | 2- Nao Docente \n");
                    int i = sc.nextInt();
                    System.out.println("Diga o seu Nome : \n");
                    String F_nome = sc.nextLine();
                    System.out.println("Diga o seu  numero mecanografico : \n");
                    int F_nrmec = sc.nextInt();
                    System.out.println("Ano de Contrato :  \n");
                    int F_anoC = sc.nextInt();
                    if (i == 2) {
                        System.out.println("Diga o seu Servico : \n");
                        String ser = sc.nextLine();
                        Ndocente ndocente = new Ndocente(F_nome, F_nrmec, F_anoC, ser);
                    } else if (i == 1) {
                        Docente docente = new Docente(F_nome, F_nrmec, F_anoC);// objeto criado
                        boolean op = true;
                        while (op) { // While para preencher a Lista de Faculades
                            System.out.println("Diga as faculdades em que Leciona :  | 1 - Adicionar | 2 - Concluido |");
                            String in2 = sc.nextLine();
                            if (in2.equals("1")) {
                                String f = sc.nextLine();
                               docente.listaFaculdades.add(f);

                            } else if (in2.equals("2")) {
                                op = false;
                            } else {
                                System.out.println("Opcao Invalida . \n ");

                            }

                        }

                        docente.listaFaculdades = listafaculdades;

                        System.out.println("Lista faculdades:\n");
                    }
                    for (String faculdade : listafaculdades) {
                        System.out.println(faculdade);
                    }
                } else {
                    System.out.println("Opcao Invalida . \n ");
                    condicao= false;
                }
            }if (opc_principal==2) {
        /* System.out.println("Servicos Extras \n");
        System.out.println("Escolha os servicos extras : | 0 -  Capacete | 1 - Luz\n");
        int a = sc.nextInt();
        double custo_servicoextra =  servicoextra(a);
        System.out.println(custo_servicoextra);
*/
//TESTE
// no ato de decidir qual veiculo o utilizador escolheu;'

        System.out.println("Diga o tipo de veicuilo: | 1 - Bicicleta | 2 - Trotinete | 3 - Ebike \n");
        String tipo = sc.nextLine();

        VeiculoDeAluguer aluguer;
        VeiculoEletrico eletrico;


        //if(aluguer.)

        if(tipo.equals("1")){
            Bicicleta bicicleta = new Bicicleta();
            System.out.println("Diga a numero de lugares da Bicicleta : | 1 - 1 Lugar | 2 - 2 Lugares \n");
            String opcao =  sc.nextLine();

            if("1".equals(opcao)){
                bicicleta.setDuaspessoas(false);
                // associar o objeto bicicleta a bicicleta com duas lugares

            }else if("2".equals(opcao)){
                 bicicleta.setDuaspessoas(true);
            }
            //System.out.println("Nr de Lugares da Bicicleta Alugada : " + bicicleta.getDuaspessoas());

        }

            }else {
            System.out.println("Opcao Invalida . \n ");
            condicao= false;}

            System.out.println("O preco da viagem ");


        }








}

}

