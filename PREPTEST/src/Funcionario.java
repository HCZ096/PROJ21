public class Funcionario extends Utilizador{
    private int anoContrato;

    //public Funcionario(){}
    public Funcionario(int id, String nome,  int anoContrato) {
        super(id, nome);
        this.anoContrato = anoContrato ;
    }

    public int getAnoContrato() {
        return anoContrato;
    }

    public void setAnoContrato(int anoContrato) {
        this.anoContrato = anoContrato;
    }

    public double precoPorHora(Bicicleta b) {
        return b.isUmaPessoa() ? 3.00 : 2.00;
    }

    public double precoPorHora(Trotinete t) {
        return t.isComLcd() ? 2.60 : 2.50;
    }


    public double precoPorHora(Ebike e) {
        return e.isBateriaRemovivel()? 3.0 : 2.75;
    }

    public String toString(){
        return "Funcionario: " + getNome() + "| ID: " + getId() + "| AnoContrato: " + getAnoContrato();
    }
}

