
public class Bicicleta extends VeiculoDeAluguer {
    private boolean assentos;

    public Bicicleta() {}

    public Bicicleta(int identificador, String localizador, int lugares) {
        super(identificador,
                localizador);
        this.assentos = lugares > 1;
    }

    public boolean setassentos(boolean assentos) {
       return this.assentos = assentos;
    }

    public boolean getassentos() {
        return assentos;
    }

    @Override
    public double precoPara(Utilizador u) {
        return u.precoPorHora(this);
    }

    public double precoPara(Estudante e) {
        return this.getassentos() ? 2.00 : 1;
    }
    public double precoPara(Funcionario f) {
        return this.getassentos() ? 2.00 : 3.00;
    }


    public String toString(){
        return "Bicicleta";
    }

        }





