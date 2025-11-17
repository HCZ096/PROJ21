import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario extends Utilizador{
    protected int anoContrato;


    public Funcionario(String nome,int id,int anoContrato) {
        super(nome,id);
        this.anoContrato = anoContrato ;
    }

    public double descontoUtilizador() {
        return 0;
    }

