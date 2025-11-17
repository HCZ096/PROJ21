public class VeiculoAluguer {
    private int identificador;
    private String localizador;

    public VeiculoAluguer(){};

    public VeiculoAluguer(int identificador, String localizador){
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
}
