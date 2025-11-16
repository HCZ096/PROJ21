import java.util.Scanner;

public class ServicoExtra extends Aluguer {

    public String servicoextra() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual o servico extra a adicionar (Trotinete)? | 1 - LCD C\ MAPA | 2 - LCD S\ MAPA");
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

}
