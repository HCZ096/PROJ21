import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario extends Utilizador{
    protected int anoContrato;

    public Funcionario(){}
    public Funcionario(String nome,int id,int anoContrato) {
        super(nome,id);
        this.anoContrato = anoContrato ;
    }


    }

