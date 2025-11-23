import java.util.ArrayList;

public class Docente extends Funcionario {
    ArrayList<String> listaFaculdades = new ArrayList<>();


    public Docente() {
        this.listaFaculdades = new ArrayList<>();
    }

    public Docente(String nome, int id, int anoContrato) {
        super(nome, id, anoContrato);
    }

}