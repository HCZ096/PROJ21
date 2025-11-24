
public class Bicicleta extends VeiculoDeAluguer {
    private boolean duaspessoas;

    public Bicicleta() {}
    public Bicicleta(boolean duaspessoas, int identificador, String localizador) {
        super(identificador, localizador);
        this.duaspessoas = duaspessoas;
    }

    public boolean setDuaspessoas(boolean duaspessoas) {
       return this.duaspessoas = duaspessoas;
    }

    public boolean getDuaspessoas() {
        return duaspessoas;
    }

    public double precoPara(Estudante e) {
        return this.getDuaspessoas() ? 2.00 : 1;
    }
    public double precoPara(Funcionario f) {
        return this.getDuaspessoas() ? 3.00 : 2.00;
    }


    public  String toString(){
        return "bicicleta";
    }

        }






