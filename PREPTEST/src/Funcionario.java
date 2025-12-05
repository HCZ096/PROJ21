
abstract public class Funcionario extends Utilizador{
    protected int anoContrato;


    public Funcionario(){}

    public Funcionario(int id, String nome,String metodopagamento,int anoContrato) {
        super(id, nome,metodopagamento);
        this.anoContrato = anoContrato ;
    }

    public int getAnoContrato() {
        return anoContrato;
    }

    public void setAnoContrato(int anoContrato) {
        this.anoContrato = anoContrato;
    }


    public double precoPorHora(VeiculoDeAluguer v) {
        return v.precoPara(this);}


}
