
public class Bicicleta extends VeiculoDeAluguer {
    private boolean duaspessoas;

    public Bicicleta() {}
    public Bicicleta(boolean duaspessoas, int identificador, String localizador) {
        super(identificador, localizador);
        this.duaspessoas = duaspessoas;
    }

    public void setDuaspessoas(boolean duaspessoas) {
        this.duaspessoas = duaspessoas;
    }

    public boolean getDuaspessoas() {
        return duaspessoas;
    }

    public double precoPorHora(Utilizador utilizador) {
        return utilizador.precoPorHora(this);
    }


    public  String toString(){
        return"Bicicleta";
    }

        }






