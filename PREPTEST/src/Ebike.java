import java.util.Scanner;

public class Ebike extends Aluguer{

    public String servicoextra() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o servico extra a adicionar (E-BIKE)? | 1 - Bateria Fixa | 2 - Bateria Removivel");
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

    }}
