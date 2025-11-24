import java.util.ArrayList;
import java.util.Scanner;

public class Docente extends Funcionario {
    ArrayList<String> listaFaculdades = new ArrayList<>();


    public Docente() {
        this.listaFaculdades = new ArrayList<>();
    }

    public Docente(String nome, int id, int anoContrato) {
        super(nome, id, anoContrato);
    }


    public void preencherDadosEspecificos(Scanner sc,ArrayList <String> listafaculdades){//Teste
        boolean op = true;
        while (op) { // While para preencher a Lista de Faculades
            System.out.println("Diga as faculdades em que Leciona :  | 1 - Adicionar | 2 - Concluido |");
            String in2 = sc.nextLine();
            if (in2.equals("1")) {
                String f = sc.nextLine();
                this.listaFaculdades.add(f);

            } else if (in2.equals("2")) {
                op = false;
            } else {
                System.out.println("Opcao Invalida . \n ");

            }
        }

    }
}