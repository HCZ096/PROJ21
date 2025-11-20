import java.util.ArrayList;
import java.util.Scanner;

public class Mobilidade extends Aluguer{

    public Mobilidade(){
        super();
    }


    public static void main(String[] args){

        ArrayList<String> listafaculdades = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Boolean condicao = true;
        while(condicao){
            System.out.println("1- Carregar Utilizador | 2 - Carregar veiculo | 3- Carregar Aluguer | 4- Criar Aluguer | 5- Listar Alugueres | 6- Terminar");
            int opc_principal = sc.nextInt();
            sc.nextLine();
            if(opc_principal==1) {

                System.out.println("Informacao do Utilizador : ");
                System.out.println("Diga a seu cargo na UC : 1 - Estudante | 2 - Funcionario");
                String info = sc.nextLine();


                if (info.equals("1")) {
                    System.out.println("Diga o seu Nome : \n");
                    String nome = sc.nextLine();
                    System.out.println("Diga o seu  numero mecanografico : \n");
                    int nrmec = sc.nextInt();
                    System.out.println("Diga o seu Curso Frequentado : \n");
                    String curso = sc.nextLine();
                    System.out.println("Diga o seu Polo Frequentado : \n");
                    String polo = sc.nextLine();
                    Estudante estudante = new Estudante(nome, nrmec, curso, polo);
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
            }else if (opc_principal==2) {
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

        if(tipo.equals("1")){
            Bicicleta bicicleta = new Bicicleta();
            System.out.println("Diga a numero de lugares da Bicicleta : | 1 - 1 Lugar | 2 - 2 Lugares \n");
            String opcao =  sc.nextLine();
            if("1".equals(opcao)){
                bicicleta.setLugar("1 Lugares ");
                // associar o objeto bicicleta a bicicleta com duas lugares

            }else if("2".equals(opcao)){
                bicicleta.setLugar("2 Lugares");
            }
            System.out.println("Nr de Lugares da Bicicleta Alugada : " + bicicleta.getLugar());

        }

            }else {
            System.out.println("Opcao Invalida . \n ");
            condicao= false;}

            System.out.println("O preco da viagem ");


        }








}

}

