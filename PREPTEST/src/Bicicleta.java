
public class Bicicleta extends VeiculoDeAluguer {
    private boolean umaPessoa;

    //public Bicicleta() {};

    public Bicicleta(boolean umaPessoa, int id, String localizador) {
        super(id, localizador);
        this.umaPessoa = umaPessoa;
    }

    public boolean isUmaPessoa() {
        return umaPessoa;
    }

    public void setUmaPessoa(boolean umaPessoa) {
       this.umaPessoa = umaPessoa;
    }

    public double precoPorHoraPara(Utilizador u) {
        return u.precoPorHora(this);
    }


    public  String toString(){
        return"Bicicleta -- | ID: " + getId() + "| " + (umaPessoa ? "1 Pessoa" : "2 Pessoas") ;
    }
}






