import java.util.ArrayList;

public class Docente extends Funcionario {
    private ArrayList<String> listaFaculdades = new ArrayList<>();

    //public Docente() {};

    public Docente(String nome, int id, int anoContrato) {
        super(id, nome, anoContrato);
    }

    public double precoPorHora(Bicicleta b) {
        return b.isUmaPessoa() ? 2.00 : 3.00;
    }

    public double precoPorHora(Trotinete t) {
        return t.isComLcd() ? 2.60 : 2.50;
    }

    public double precoPorHora(Ebike e) {
        return e.isBateriaRemovivel()? 3.00 : 2.75;
    }

    public String toString(){
        return "Docente: " + getNome() + "| ID: " + getId() + "| Ano de Contrato: " +  getAnoContrato();
    }

}