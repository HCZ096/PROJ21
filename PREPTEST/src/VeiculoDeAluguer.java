public abstract class VeiculoDeAluguer extends Aluguer{

    private int identificador;
    private String localizador;

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

    public abstract double precoPara(Utilizador u);
    public abstract double precoPara(Estudante e);
    public abstract double precoPara(Funcionario f);

   // public abstract boolean setassentos(boolean assento);
}
