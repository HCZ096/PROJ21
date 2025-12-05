import java.util.ArrayList;

public class Docente extends Funcionario {
    ArrayList<String> listaFaculdades = new ArrayList<>();

    public Docente(int id, String nome,String metodopagamento, int anoContrato, String faculdades) {
        super(id, nome,metodopagamento, anoContrato);
        if(faculdades != null && !faculdades.isEmpty()){
            for (String faculdade : faculdades.split(",")) {
                this.listaFaculdades.add(faculdade.trim());
            }
        }
    }

    public ArrayList<String> getListaFaculdades() {
       for(String s: listaFaculdades){
           System.out.println(s);
       }
        return listaFaculdades;
    }


    public String toString(){
        return "Ano de Contrato : " + getAnoContrato() +"\n "+
                "Lista Faculdades : " + getListaFaculdades();
                 }
    }
