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

    public double descontoUtilizador() {
        //if(obj == Trotinete)
            // saber se o servico e com led ou nao
            //int preco = servicoextra(obj)
        return 0;


} }
