
import java.time.LocalTime;

public class Aluguer extends Utilizador{
    private int data;
    private int dataInicio;
    private int datafim;


    public String servicoextra(){
        return " ";
    }

    public float Preco(Utilizador funcao){
        String serv = servicoextra();

        LocalTime inicio = LocalTime.now();
        int hora = inicio.getHour();
        int minuto = inicio.getMinute();
        int segundo = inicio.getSecond();
        int data = inicio.atDate();




        return 1;

    }

    public int custo_viagem(Utilizador pessoa){
        int saldo;
        int data_inicial;
        int data_fim;
        String info = pessoa.informacao();
        saldo =  data_fim-data_inicial;
        saldo *= ;
        return saldo;
    }/**/



}
