public abstract class VeiculoDeAluguer extends Aluguer{
    private int identificador;
    private String localizador;
    private Aluguer aluguer;

    public VeiculoDeAluguer(){};

    public VeiculoDeAluguer(int identificador, String localizador){
        this.identificador = identificador;
        this.localizador = localizador;
        this.aluguer = new Aluguer();
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

    public abstract double precoPorHora(Utilizador utilizador);
}
