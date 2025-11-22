abstract public class VeiculDeAluguer extends Aluguer{
    private int identificador;
    private String localizador;
    Aluguer aluguer = new Aluguer();
    public VeiculoDeAluguer(){};

    public VeiculoDeAluguer(int identificador, String localizador){
        this.identificador = identificador;
        this.localizador = localizador;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getLocalizador() {
        return localizador;
    }

    public void setLocalizador(String localizador) {
        this.localizador = localizador;
    }
    public double precophora(){
        return 0.0;
    }
}
