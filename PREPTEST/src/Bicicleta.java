import java.util.Scanner;

public class Bicicleta extends Aluguer{


    public Bicicleta(){}

    public String servicoextra() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o servico extra a adicionar (Bicicleta)? | 1 - Uma Pessoa | 2 - Duas Pessoas");
        String input = sc.nextLine();

        while(true){

        if (input == "1") {
            return input; //temporario

        }
        else if (input == "2") {
            return input; // temporario
        }
        else{
            System.out.println("Opcao invalida");


        }}

    }
}
