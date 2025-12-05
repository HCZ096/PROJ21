
public class Bicicleta extends VeiculoDeAluguer {
    private boolean assentos;



    public Bicicleta(int identificador, String localizador, boolean assentos) {
        super(identificador,
                localizador);
        this.assentos = assentos;
    }

    public boolean setassentos(boolean assentos) {
       return this.assentos = assentos;
    }

    public boolean getassentos() {
        return assentos;
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





