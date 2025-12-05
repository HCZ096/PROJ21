import java.util.Scanner;

public class Ndocente extends Funcionario{
    private String servico;
    public Ndocente(){}
    public Ndocente(String nome,int id,String metodopagamento,int anoContrato,String servico){
        super(nome,id,metodopagamento,anoContrato);
        this.servico = servico;
    }

    public String getServico() {
        return servico;
    }
    public String setServico(String servico) {
        return this.servico = servico;
    }

    @Override
    public double descontoUtilizador(double preco) {
        preco *= (50.0 / 100.0);
        return preco ;
    }

    public String toString(){
        return "Ano de Contrato : " + getAnoContrato() + "\n " +
                "Servico : " + getServico();
    }




}



