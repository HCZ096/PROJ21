
import java.time.LocalTime;

public class Aluguer extends Utilizador{
    private int data;
    private int dataInicio;
    private int datafim;


    public static double servicoextra(double op){
        double p_capacete = 5;
        double p_luz = 2.5;
        return op == 1 ? p_capacete : p_luz;
    }

    public float Preco(){
        //int h = hora() * ;
        //preco

        return 1;

    }


}
