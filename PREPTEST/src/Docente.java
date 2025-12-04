import java.util.ArrayList;

public class Docente extends Funcionario {
    ArrayList<String> listaFaculdades = new ArrayList<>();


    public Docente() {
        this.listaFaculdades = new ArrayList<>();
    }

    public Docente(String nome, int id,String metodopagamento, int anoContrato) {
        super(nome, id,metodopagamento, anoContrato);
    }

    public ArrayList<String> getListaFaculdades() {
       for(String s: listaFaculdades){
           System.out.println(s);
       }
        return listaFaculdades;
    }

    public String toString(){
        return "Nome : " +" " + getNome() +" \n"+
                "ID : " + getId() +"\n"+
                "Metodo Pagamento :" + getMetodopagamento() +" \n"+
                "Ano de Contrato : " + getAnoContrato() +"\n "+
                "Lista Faculdades : " + getListaFaculdades();
                 }
    }
