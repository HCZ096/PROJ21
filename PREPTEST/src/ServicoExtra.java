import java.util.Scanner;

public class ServicoExtra extends Aluguer {
    private double custoCapacete = 5.0;
    private double custoLuz = 2.0;

    public double servicoextra(double op){
        return op == 1 ? custoCapacete : custoLuz;
    }


}


