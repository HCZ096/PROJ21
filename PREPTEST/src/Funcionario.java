public class Funcionario extends Utilizador{
    protected int anoContrato;

    public Funcionario(){}
    public Funcionario(String nome, int id,int anoContrato) {
        super(id, nome);
        this.anoContrato = anoContrato ;
    }




    }

