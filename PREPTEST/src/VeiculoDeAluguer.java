public abstract class VeiculoDeAluguer{
    private int id;
    private String localizador;
    private Aluguer aluguer;

    //public VeiculoDeAluguer(){};

    public VeiculoDeAluguer(int id, String localizador){
        this.id = id;
        this.localizador = localizador;
        //this.aluguer = new Aluguer();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalizador() {
        return localizador;
    }

    public void setLocalizador(String localizador) {
        this.localizador = localizador;
    }

    public abstract double precoPorHoraPara(Utilizador u);

    public String toString() {
        return "ID: " + getId() + ", Localizador: " + getLocalizador() +"\n";
    }
}
