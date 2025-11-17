public class Ndocente  extends Funcionario{

    private String servico;
    public Ndocente(String nome,int id,int anoContrato,String servico){
        super(nome,id,anoContrato);
        this.servico = servico;

    }

    public String getServico() {
        return servico;
    }
    public void setServico(String servico) {}

    public double descontoUtilizador(Aluguer veiculo) {
        Trotinete trotinete = new Trotinete();
        if(veiculo.equals(trotinete.lcd(1))) {
            return 1.50 * (50 / 100);

        }else if(veiculo.equals(trotinete.lcd(0))) {
            return 1.0*(50.0/100.0);
            }
        else{
            return 0.0;

        }
} }
