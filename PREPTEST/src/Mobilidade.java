import java.util.ArrayList;
import java.util.Scanner;

public class Mobilidade extends Aluguer{

    public Mobilidade(){
        super();
    }


    public static void main(String[] args){
        ArrayList<String> ListaFaculdades = new ArrayList<>();
        String servico = null;


        Scanner sc = new Scanner(System.in);

        System.out.println("Diga sua funcao !! | 1 - Docente  | 2 - Nao Docente ");
        String input = sc.nextLine();


        if(input.equals("1")) { // DOCENTE
            System.out.println("Funcionario Docente !  \n ");

            boolean op = true;

            while (op) { // While para preencher a Lista de Faculades
                System.out.println("Diga as faculdades em que Leciona :  | 1 - Adicionar | 2 - Concluido |");
                String in2 = sc.nextLine();
                if (in2.equals("1")) {
                    String f = sc.nextLine();
                    ListaFaculdades.add(f);

                } else if (in2.equals("2")) {
                    op = false;
                } else {
                    System.out.println("Opcao Invalida . \n ");

                }

            }
        } else if(input.equals("2")){ // NAO DOCENTE


            System.out.println("Funcionario Nao Docente !  \n ");
            System.out.println("Indique o Servico onde trabalha \n ");
            servico = sc.nextLine();

        }
        else{
            System.out.println("Opcao Invalida . \n ");

        }
        if (input.equals("1")){
            System.out.println ("Docente nas faculdades : " + ListaFaculdades)  ;
        }
        else if (input.equals("2")){
            System.out.println ("Funcionario em Servico : " + servico);
        }
        else{
            System.out.println ("Opcao Invalida . \n ");
        }

        System.out.println("Servicos Extras \n");
        System.out.println("Escolha os servicos extras : | 0 -  Capacete | 1 - Luz\n");
        int a = sc.nextInt();
        double custo_servicoextra =  servicoextra(a);










    }

}

