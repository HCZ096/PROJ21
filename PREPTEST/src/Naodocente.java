public class Naodocente extends Funcionario{
    private String servico;

    public Naodocente(String nome,int id, int anoContrato, String servico){
        super(id, nome, anoContrato);
        this.servico = servico;
    }

    public String getServico() {
        return servico;
    }
    public void setServico(String servico) {
        this.servico = servico;
    }

    @Override
    public boolean temDesconto50() {
        return true;
    }

    public String toString(){
        return "| ID: " + getId() + "| Nome: " + getNome() + "| AnoContrato: " + getAnoContrato() +  "| Servico: " + getServico() ;
    }
}


