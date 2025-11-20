import java.util.ArrayList;

public class Docente extends Funcionario{
    ArrayList<String> listaFaculdades = new ArrayList<>();


    public  Docente(){
        this.listaFaculdades = new ArrayList<>();
    }
    public  Docente(String nome,int id,int anoContrato){
        super(nome,id,anoContrato);
    }

    public double calcularprecobicicleta(Bicicleta b) {
        double preco;
        if (b.getLugar().equals("1 Lugares")) {
            preco = 2.0;
            return preco;

        } else if (b.getLugar().equals("2 lugares")) {
            preco = 3.0;
            return preco;
        } else {
            return 0.0;
        }
    }
    public double calcularprecotrotinete(Trotinete t){
        double precobase ;
        if(t.getComLcd() == true){
            precobase = 2.60;
            return precobase;}
        else{
            precobase = 2.50;
            return precobase;
        }

    }
    public double calcularprecoEbike(Ebike e){
        double precobike;
        if(e.getBateriaRemovivel() == true){
            precobike = 3.0;
        }else{
            precobike = 2.75;
        }
        return 0.0;
    }


}
