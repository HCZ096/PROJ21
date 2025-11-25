import java.io.Serializable;

public abstract class Utilizador {
    private int id;
    private String nome;


    public Utilizador() {}

    public Utilizador(int id,String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
            return id;
    }

    public void setId(int id) {
            this.id = id;
    }

    //Preco por hora determinado pelas suas classes
    public abstract double precoPorHora(Bicicleta b);
    public abstract double precoPorHora(Trotinete t);
    public abstract double precoPorHora(Ebike e);

    public boolean temDesconto50(){
        return false;
    }


    public String toString(){
        return "Utilizador " + nome + "(ID: " + id + ")";
    }


}




