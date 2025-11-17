
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

    public int tempodeutilizacao(){
        return 0;
    }
//para saber o preco por hora é necessario saber o tipo de veiculo, e saber se é com extras ou n
    public double precoviagem(double op){
      double t = tempodeutilizacao();
      double preco = op * t;//t tempo de horas que utilizador usufrui , op preco por hora
      return preco;
    }


    }



