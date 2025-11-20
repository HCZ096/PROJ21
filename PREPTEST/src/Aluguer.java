
import java.time.LocalTime;

public class Aluguer extends Utilizador{
    private int data;
    private int dataInicio;
    private int datafim;

    public double  tempodeutilizacao(int dataInicio, int datafim) {
      return datafim - dataInicio;
    }


    }



